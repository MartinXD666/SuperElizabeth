package juego;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import entorno.Entorno;

public class Princesa {

	//Variables de instancia
	private int FrameRate;
	private Image Sprite;
	private float x;
	private float y;
	@SuppressWarnings("unused")
	private double x_inicial;
	private double y_inicial;
	private int ancho;
	private int alto;
	private int velocidad;
	private Rectangle princesa;
	private int vidas;
	Image img;
	ArrayList<Proyectil> proyectiles;
	private boolean saltando;
	private boolean cayendo;
	private int temporizador;
	private boolean inmune;
	private int x_colision;
	private int y_colision;

	//Constructor del personaje
 
	public Princesa(int x, int y) {

		this.x = x;
		this.y = y;
		this.velocidad = 2;
		proyectiles = new ArrayList<Proyectil>();
		this.ancho = 32;
		this.alto = 64;
		this.x_inicial = x;
		this.y_inicial = y;
		this.saltando = false;
		this.cayendo = false;
		this.princesa = new Rectangle((int) this.x,(int) this.y, this.ancho, this.alto);
		this.x_colision = ancho / 2;
		this.y_colision = alto / 2;
		this.temporizador = 0;
		this.inmune = false;
		this.vidas = 3;

	}

 
void tick(Usuario usuario, Imagen hoja) {
		
		this.FrameRate++;
		
		if (this.temporizador != 0)
			this.temporizador--;		
		if (this.FrameRate == 32)
			this.FrameRate = 0;
		if (this.temporizador <= 0)
			this.inmune = false;
			this.gravedad();
		
			for (Proyectil p : proyectiles) {
				p.tick(hoja);
			}
		}
		
	
	public float getY() {
		return y;
	}


	public double getY_inicial() {
		return y_inicial;
	}


	public void disparo() {
		proyectiles.add(new Proyectil(this.x+28, this.y+5, 4, 4.0f));
	}

	void dibujarse(Entorno entorno, Imagen hoja) {
		if (!saltando && !cayendo || this.vidas>0) 
		{
			if (inmune)
			{
				this.Sprite=hoja.cambioSprite(hoja.princesaInv, this.FrameRate);
			}
			else
			{
				this.Sprite=hoja.cambioSprite(hoja.princesaDer,this.FrameRate);
				}
		}	
		if (this.saltando) {
			if(this.inmune)
				this.Sprite=hoja.princesaSaltoInv[0];
		
			else 
				this.Sprite=hoja.princesaSalto[0];
		}
		if (this.cayendo) {
			if(this.inmune)
				this.Sprite=hoja.princesaSaltoInv[1];
		
			else 
				this.Sprite=hoja.princesaSalto[1];
		}
		
		if (this.temporizador % 2 == 0)
			entorno.dibujarImagen(this.Sprite, this.x, this.y, 0);
		for (Proyectil p : proyectiles) {
			p.dibujarse(entorno);
		}
	}
	void moverAdelante() {
		if (this.x < 300) {
			this.x+=velocidad;
			princesa.setLocation((int)this.x - this.x_colision,(int) this.y - this.y_colision);
		}	
	}

	void moverAtras() {
		if (this.x > 30)	{
			this.x-=velocidad;
			princesa.setLocation((int)this.x - this.x_colision,(int) this.y - this.y_colision);
		}
	}

	void saltar() {
		if (this.y > 170 && !cayendo) {
			saltando = true;
		}
		if (saltando || !cayendo) {
			this.y-=3;
			princesa.setLocation((int)this.x - this.x_colision,(int) this.y - this.y_colision);
		}
	}

	void gravedad() {
		if (this.y <= 170 || cayendo==true ) {
			this.y+=3;
			saltando = false;
			cayendo = true;
			princesa.setLocation((int)this.x,(int) this.y - this.y_colision);
		}
		if (this.y == y_inicial) {
			cayendo = false;
		}
	}

	public int getVidas() {
		return vidas;
	}

	public ArrayList<Proyectil> getProyectiles() {
		return proyectiles;
	}


	public void setProyectiles(ArrayList<Proyectil> proyectiles) {
		this.proyectiles = proyectiles;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public Rectangle getPrincesa() {
		return princesa;
	}

	public void setPrincesa(Rectangle princesa) {
		this.princesa = princesa;
	}

	public boolean esInmune() {
		return inmune;
	}

	public boolean estaSaltando() {
		if (this.y < this.y_inicial)
			return true;
		else
			return false;
	}
	
	public void setInmune(boolean inmune, int tiempo) {
		this.inmune = inmune;
		this.temporizador = tiempo;
	}


	public void quitarVida() {

		this.vidas --;
		System.out.println("Perdiste 1 una vida");
		if (this.vidas == 0) {
			System.out.println("Perdiste!");
		}
	}


	public void setCayendo(boolean cayendo) {
		this.cayendo = cayendo;
		
	}
}
