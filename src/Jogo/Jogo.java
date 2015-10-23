package Jogo;

import Cenario.Cenario;

public class Jogo {

	private Player player;
	private Cenario cenario;
	private int dificuldade;
	
	private Player getPlayer() {
		return player;
	}
	private void setPlayer(Player player) {
		this.player = player;
	}
	private Cenario getCenario() {
		return cenario;
	}
	private void setCenario(Cenario cenario) {
		this.cenario = cenario;
	}
	private int getDificuldade() {
		return dificuldade;
	}
	private void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}
	
}
