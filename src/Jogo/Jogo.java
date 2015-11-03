package Jogo;

/**
 *
 * @author Emanuel Mazzer & Leonardo Baiser 
 * @version 1.0
 * @since 19/10/2015
 */

import java.util.ArrayList;

import javax.swing.JButton;

import Cenario.GUI;

public class Jogo {

    private Player player;
    // private Cenario cenario;
    private Dificuldade dificuldade;
    private GUI gui;
    ArrayList<Integer> numeros;
    JButton[][] vBtn;

    public Jogo() {
	

	gui = new GUI();

	// cenario = new Cenario();
    }

    private Player getPlayer() {
	return player;
    }

    private void setPlayer(Player player) {
	this.player = player;
    }

}
