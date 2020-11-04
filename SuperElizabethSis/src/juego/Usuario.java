package juego;

import entorno.Entorno;

public class Usuario {
	Entorno entorno; 
	private int score;
	
	public Usuario(Entorno e) {
		this.entorno = e;
		score=0; 
	}
	
	public boolean derecha() {
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			return true;
		}
		return false;
	}
	
	public boolean izquierda() {
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			return true;
		}
		return false;
	}
	
	public boolean arriba() {
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			return true;
		}
		return false;
	}
	
	public boolean space() {
		if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
			return true;
		}
		return false;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}

	public boolean enter() {
		if (entorno.sePresiono(entorno.TECLA_ESPACIO))
			return true;
		return false;
	}

}
