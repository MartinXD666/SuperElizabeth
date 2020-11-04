package juego;

import java.awt.Color;

import entorno.Entorno;
  
public class Interfaz {
	
	public void dibujarse(Entorno entorno, Princesa elizabeth, Usuario player) {
		entorno.cambiarFont("ka1.ttf", 24, Color.BLACK);
		entorno.escribirTexto("Vidas: " + elizabeth.getVidas(), 600, 50);
		entorno.escribirTexto("Puntajes: " + player.getScore(), 100, 50);
	}

	public void gameOver(Entorno entorno, Usuario player, Princesa elizabeth){
		entorno.cambiarFont("Arial",28, Color.BLACK);
		entorno.escribirTexto("Game Over", 300, 220 ); 
		entorno.escribirTexto("Su Puntaje: "+ player.getScore(), 300,250 );
		entorno.escribirTexto("Vidas: " + elizabeth.getVidas(), 300, 280);
		entorno.escribirTexto("Puntaje Final: " + (player.getScore()+(elizabeth.getVidas() *100)), 300, 310);
	}	

}
