package juego;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagen
{
	BufferedImage  hoja;
	
	public Image[] princesaDer = new BufferedImage[8];
	public Image[] princesaInv=new BufferedImage[8];
	public Image[] princesaSalto=new BufferedImage[2];
	public Image[] princesaItem=new BufferedImage[8];
	public Image[] princesaSaltoItem=new BufferedImage[2];
	
	public Image[] princesaSaltoInv=new BufferedImage[2];
	
	
	public Image[] enemigo1=new BufferedImage[5];
	public Image[] enemigo2=new BufferedImage[5];
	public Image[] tubo=new BufferedImage[5];
	public Image proyectil;
	public Image impacto;


	
	Imagen(String ruta)
	{ 
		try {
		this.hoja = ImageIO.read(new File(ruta));
		cargarSprites();
		}catch (IOException ex)
			{
				ex.printStackTrace();
	        }	
	}
	
	Image getSprite(int x, int y, int ancho, int alto)
	{
		BufferedImage sprite = hoja.getSubimage(x, y, ancho, alto);
		return sprite;
	}
	void cargarSprites()

	{
		proyectil=getSprite(512,192,64,64);
		impacto  =getSprite(320,192,64,64);
		princesaDer[0] = getSprite(0,0,64,64);
		princesaDer[1] = getSprite(64,0,64,64);
		princesaDer[2] = getSprite(128,0,64,64);
		princesaDer[3] = getSprite(192,0,64,64);
		princesaDer[4] = getSprite(256,0,64,64);
		princesaDer[5] = getSprite(320,0,64,64);
		princesaDer[6] = getSprite(384,0,64,64);
		princesaDer[7] = getSprite(448,0,64,64);
		
		
		princesaSalto[0] =getSprite(512,0,64,64);
		princesaSalto[1] = getSprite(128,0,64,64);

		princesaItem[0] = getSprite(0,64,64,64);
		princesaItem[1] = getSprite(64,64,64,64);
		princesaItem[2] = getSprite(128,64,64,64);
		princesaItem[3] = getSprite(192,64,64,64);
		princesaItem[4] = getSprite(256,64,64,64);
		princesaItem[5] = getSprite(320,64,64,64);
		princesaItem[6] = getSprite(384,64,64,64);
		princesaItem[7] = getSprite(448,64,64,64);
		
		princesaSaltoItem[0] =getSprite(512,64,64,64);
		princesaSaltoItem[1] = getSprite(128,64,64,64);
		
		princesaInv[0]= getSprite(0,128,64,64);
		princesaInv[1]= getSprite(64,128,64,64);
		princesaInv[2]= getSprite(128,128,64,64);
		princesaInv[3]= getSprite(192,128,64,64);
		princesaInv[4]= getSprite(256,128,64,64);
		princesaInv[5]= getSprite(320,128,64,64);
		princesaInv[6]= getSprite(384,128,64,64);
		princesaInv[7]= getSprite(448,128,64,64);
		
		princesaSaltoInv[0] =getSprite(512,128,64,64);
		princesaSaltoInv[1] = getSprite(128,128,64,64);
		
		enemigo1[0] = getSprite(0,192,64,64);
		enemigo1[1] = getSprite(64,192,64,64);
		enemigo1[2] = getSprite(128,192,64,64);
		enemigo1[3] = getSprite(192,192,64,64);
		enemigo1[4] = getSprite(256,192,64,64);
		
		
		enemigo2[0] = getSprite(0,256,64,64);
		enemigo2[1] = getSprite(64,256,64,64);
		enemigo2[2] = getSprite(128,256,64,64);
		enemigo2[3] = getSprite(192,256,64,64);
		enemigo2[4] = getSprite(256,256,64,64);
		
		tubo[0] = getSprite(0,320,64,64);
		tubo[1] = getSprite(64,320,64,64);
		tubo[2] = getSprite(128,320,64,64);
		tubo[3] = getSprite(192,320,64,64);
		tubo[4] = getSprite(256,320,64,64);
		
		
	}
	Image cambioSprite(Image[] sprite, int framerate)
	{
		
		if (framerate > 4 && framerate < 9) return sprite[1];
		if (framerate > 9 && framerate < 18) return sprite[2];
		if (framerate > 18 && framerate < 36) return sprite[3];
		if (framerate > 36 && framerate < 72) return sprite[4];
		if (framerate > 72 && framerate < 144) return sprite[5];


		
		else return sprite[0];

	}
	
}