package Jogo;

import Cenario.Dificuldade;


public class Jogo {

	private Player player;
	private Dificuldade dificuldade;
	
	private Player getPlayer() {
		return player;
	}
	private void setPlayer(Player player) {
		this.player = player;
	}
	public Dificuldade getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}
	
	
}
