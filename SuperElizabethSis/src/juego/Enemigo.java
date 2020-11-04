package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

import entorno.Entorno;

public class Enemigo {
	private int FrameRate;
	private Image Sprite;
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private Rectangle enemigo;
	private float velocidad;
	private int x_inicial;
	
	public Enemigo(int x, int y,int alto, float v ) {
		
		this.x = x;
		this.y = y;
		this.x_inicial = x;
		this.ancho = 32;
		this.alto = alto;
		this.velocidad = v;
		enemigo = new Rectangle(x, y, ancho, alto);
	}

	public void tick(Imagen hoja) {
		this.FrameRate++;
		if (this.FrameRate == 32)
			this.FrameRate = 0;
		this.x -= velocidad;
		this.Sprite=hoja.cambioSprite(hoja.enemigo2, this.FrameRate);
		enemigo.setLocation((int)this.x,(int) this.y - 20);
		if (this.x <= -100) {
			this.x = this.x_inicial;
			enemigo.setLocation((int)this.x,(int) this.y - 20);
		}
	}
	
	public void dibujarse(Entorno entorno)
	{
		entorno.dibujarImagen(this.Sprite,x,y,0);

	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
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

	public float getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
	
	public Rectangle getEnemigo() {
		return enemigo;
	}

	public void setEnemigo(Rectangle enemigo) {
		this.enemigo = enemigo;
	}
	
}
