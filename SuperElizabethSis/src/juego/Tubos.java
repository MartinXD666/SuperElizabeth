package juego;

import java.awt.Image;
import java.awt.Rectangle;

import entorno.Entorno;

public class Tubos {
	private int FrameRate;
	private Image Sprite;
	private float x;
	private float y;
	private int ancho;
	private int alto;
	private float velocidad;
	private Rectangle tubo;
	private float x_inicial; 
	
	public Tubos(float x, float y, int alto, float v) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = 32;
		this.velocidad = v;
		this.x_inicial = x;
		
		tubo = new Rectangle((int)x, (int)y, ancho, alto);
	}
	
	void tick(Imagen hoja) {
		this.FrameRate++;
		if (this.FrameRate == 32)
			this.FrameRate = 0;
		this.x -= this.velocidad;
		this.Sprite=hoja.cambioSprite(hoja.tubo, this.FrameRate);
		tubo.setLocation((int)this.x,(int) this.y-20);
		if (this.x <= -150) {
			this.x = this.x_inicial;
			tubo.setLocation((int)this.x,(int) this.y-20);
		}
	}
	
	public void dibujarse(Entorno entorno)
	{
		entorno.dibujarImagen(this.Sprite,x, y, 0);
		
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
	
	public Rectangle getTubo() {
		return tubo;
	}

	public void setTubo(Rectangle tubo) {
		this.tubo = tubo;
	}

}
