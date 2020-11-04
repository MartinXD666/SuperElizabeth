package juego;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	private Entorno entorno;

	
	Escenario ren;
	Usuario player;
	private boolean tutorial;
	private boolean jugando;
	private boolean inicio; 
	Image ganaste;
	Image perdiste;
	Image iniciar;
	Image tuto;
	Interfaz dibujarse; 
	
	Juego()
	{	
		try {
			Herramientas.loop("musicaescenario.wav");
			ganaste = ImageIO.read(new File("imagenes/youwin.png"));
			perdiste = ImageIO.read(new File("imagenes/gameover.png"));
			iniciar = ImageIO.read(new File("imagenes/intro.png"));
			tuto = ImageIO.read(new File("imagenes/tuto.png"));
			dibujarse= new Interfaz();
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.entorno = new Entorno(this, "Super Elizabeth Sis - Grupo ... - v1", 985, 440);
		ren = new Escenario();
		player = new Usuario(entorno);
		this.entorno.iniciar();
		tutorial= false;
		jugando = false;
		inicio = false;
	}
	
	public void tick()
	{
		
		if (!inicio) {
			inicio();
			
		}
		else {
			jugando = true;
			if (!perdio() && !gano()) {
				this.input();
				ren.tick(player);
				
			}
			if (perdio() || gano()) {
				ren.getDatos().gameOver(entorno, player, ren.getPrincesa());
			}
		}
		this.dibujar();	
	}
	
	private void inicio() {
		if(player.enter())
			if(tutorial == false)
				tutorial = true;
			else 
			inicio = true;
	}

	public void dibujar() {
		
		if(inicio && jugando) {
			if (!perdio() && !gano()) {
				
				ren.dibujar(entorno,player);
		 }
		 else if(gano()) {
		 	entorno.dibujarImagen(ganaste, 495, 225, 0);
		 	dibujarse.gameOver(entorno, player, ren.getPrincesa());
		 }
		 else
		 {
			entorno.dibujarImagen(perdiste, 495,225, 0);
			interfaz();
			dibujarse.gameOver(entorno,player, ren.getPrincesa());
			
				 }
		}
		else {
			if (tutorial) {
				entorno.dibujarImagen(tuto, 495, 225, 0);
			}
			else {
				entorno.dibujarImagen(iniciar, 495, 225, 0);
			}
		}
	}

	
	private void interfaz() {
		// TODO Auto-generated method stub
		
	}

	public void input() {
		if(player.derecha())
			ren.getPrincesa().moverAdelante();
		
		else if(player.izquierda())
			ren.getPrincesa().moverAtras();
			
		
		if(player.arriba())
			ren.getPrincesa().saltar();
		if(!player.arriba() && ren.getPrincesa().estaSaltando())
			ren.getPrincesa().setCayendo(true);
		
		if(player.space())
			ren.getPrincesa().disparo();
	}

	public boolean perdio() {
		if(ren.getPrincesa().getVidas()<1)
			return true;
		return false;
	}
	public boolean gano() {
		if(player.getScore() == 500 || ren.movMapa < -5850)
			return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
