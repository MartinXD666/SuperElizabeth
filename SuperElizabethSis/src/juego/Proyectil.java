package juego;

import java.awt.Image;
import java.awt.Rectangle;

import entorno.Entorno;
import entorno.Herramientas;

public class Proyectil {
	private Image Sprite;
	private float x;
	private float y;
	private int ancho;
	private int alto;
	private float velocidad;
	private Rectangle proyectil;
	 
	public Proyectil(float x, float y, int alto, float v) {
		Herramientas.play("disparop.wav");
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = 4;
		this.velocidad = v;
		proyectil = new Rectangle((int)x, (int)y, ancho, alto);
	}
	

	void tick(Imagen hoja) {
			this.x += this.velocidad;
			proyectil.setLocation((int)this.x,(int) this.y);
			this.Sprite=hoja.proyectil;
	}
	
	public void dibujarse(Entorno entorno)
	{
		entorno.dibujarImagen(this.Sprite,x,y,0);
	}
	
	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	public Rectangle getProyectil() {
		return proyectil;
	}

	public void setProyectil(Rectangle proyectil) {
		this.proyectil = proyectil;
	}
	
}
