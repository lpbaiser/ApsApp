package Jogo;

/**
*
* @author Emanuel Mazzer & Leonardo Baiser 
* @version 1.0
* @since 19/10/2015
*/

import Cenario.Cenario;


public class Jogo {

	private Player player;
	private Cenario dificuldade;
	
	private Player getPlayer() {
		return player;
	}
	private void setPlayer(Player player) {
		this.player = player;
	}
	public Cenario getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(Cenario dificuldade) {
		this.dificuldade = dificuldade;
	}
	
	
}
