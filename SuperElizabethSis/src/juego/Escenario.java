package juego;


import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entorno.Entorno;
import entorno.Herramientas;

public class Escenario {

	private ArrayList<Enemigo> soldaditos;
	private ArrayList<Tubos> obstaculos;
	private Princesa elizabeth;
	private Interfaz datos;
	float movMapa;
	float movFondo;
	Image fondo;
	Image mapa;
	Imagen hoja;

	public Escenario() {
		try
		{ 
			fondo= ImageIO.read(new File("imagenes/fondo.png"));
			mapa = ImageIO.read(new File("imagenes/escenario.png"));
			
		}
		catch (IOException ex)
		{
			ex.printStackTrace(); 
		}
		movMapa = 1700;
		movFondo = 1700;
		hoja = new Imagen ("imagenes/sprites.png");
		this.soldaditos = new ArrayList<Enemigo>();
		this.obstaculos = new ArrayList<Tubos>();
		this.elizabeth = new Princesa(150, 300);
		this.datos = new Interfaz();
		this.ejercito();
		this.tubitos();
	}

	public void tick(Usuario player) {
		if(elizabeth.getVidas()>0) {
			colisiones(player);
			elizabeth.tick(player,hoja);
			for (Enemigo s : soldaditos) {
				s.tick(hoja);
			}
			for (Tubos t : obstaculos) {
				t.tick(hoja);
			}
		}
	}

	public void dibujar(Entorno entorno,Usuario player)
	{
		this.movMapa-= 1.0f;
		this.movFondo-= 0.7f;
		entorno.dibujarImagen(fondo,this.movFondo,220,0,1.8);
		entorno.dibujarImagen(mapa,this.movMapa ,300,0,2.0);
		elizabeth.dibujarse(entorno,hoja);
		datos.dibujarse(entorno, elizabeth, player);
		for (Tubos t : obstaculos) {
			t.dibujarse(entorno);
	
			for (Enemigo s : soldaditos) {
				s.dibujarse(entorno);
			}
		}
	}

	void ejercito() {
		soldaditos.add(new Enemigo(1000, 300, 64, 2.0f));
		soldaditos.add(new Enemigo(1200, 300, 64, 2.0f));
		soldaditos.add(new Enemigo(1500, 300, 64, 2.0f));
	}

	void tubitos() {
		obstaculos.add(new Tubos(1000, 300, 64, 1));
		obstaculos.add(new Tubos(1500, 300, 64, 1));
		obstaculos.add(new Tubos(2000, 300, 64, 1));
	}

	void colisiones(Usuario player) {
		colisionPrincesaEnemigo();

		colisionEnemigoProyectil(player);

		colisionPrincesaTubo();

		colisionTuboProyectil();
	}

	void colisionPrincesaEnemigo(){
		if (!elizabeth.esInmune()) {
			for(Enemigo e: soldaditos){
				if (elizabeth.getPrincesa().intersects(e.getEnemigo())) {
					System.out.println("colicion con pricesa");
					elizabeth.quitarVida();
					elizabeth.setInmune(true, 200);
				}
			}
		}
	}

	void colisionPrincesaTubo(){
		if (!elizabeth.esInmune()) {
			for(Tubos t: obstaculos){
				if(elizabeth.getPrincesa().intersects(t.getTubo())){
					elizabeth.quitarVida();
					elizabeth.setInmune(true, 200);
				}
			}
		}
	}

	void colisionEnemigoProyectil(Usuario player){
		for(int i=0; i<soldaditos.size(); i++){

			for(Proyectil p: elizabeth.getProyectiles()){
				if(p.getProyectil().intersects(soldaditos.get(i).getEnemigo())) {
					Herramientas.play("muertene.wav");
					soldaditos.remove(i);
					player.setScore(5);
					if(i==0) {soldaditos.add(new Enemigo(1500, 300, 64, 2.0f));
					}
					else {
						if(soldaditos.get(i-1).getX()<1200){									
							soldaditos.add(new Enemigo(1200, 300, 64, 2.0f));
						}
					}
					elizabeth.getProyectiles().remove(p);
					break;
				}
			}
		}
	}


	void colisionTuboProyectil() {
		for(Tubos t: obstaculos){
			for( int i=0; i < elizabeth.getProyectiles().size(); i++) {
				if(elizabeth.getProyectiles().get(i).getProyectil().intersects(t.getTubo())) {
					elizabeth.getProyectiles().remove(i);
					continue;
				}
			}
		}
	}

	public Princesa getPrincesa() {
		return this.elizabeth;
	}
	public Interfaz getDatos() {
		return datos;
	}

}