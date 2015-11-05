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
    private int dif;

    public int getDif() {
        return dif;
    }

    public void setDif(int dif) {
        this.dif = dif;
    }
    ArrayList<Integer> numeros;
    JButton[][] vBtn;

    public Jogo() {
	

	gui = new GUI();

	// cenario = new Cenario();
    }

    public Player getPlayer() {
	return player;
    }

    public void setPlayer(Player player) {
	this.player = player;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public GUI getGui() {
        return gui;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public ArrayList<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }

    public JButton[][] getvBtn() {
        return vBtn;
    }

    public void setvBtn(JButton[][] vBtn) {
        this.vBtn = vBtn;
    }
    
    public ArrayList<Jogo>[] ranking() {
        Persistencia p = new Persistencia();
        ArrayList<Jogo> jog[] = p.lista();
        ArrayList<Jogo> jogo12 = ordena(jog[1]);
        ArrayList<Jogo> jogo24 = ordena(jog[2]);
        ArrayList<Jogo> jogo36 = ordena(jog[3]);
        ArrayList<Jogo> rank[] = null;
        rank[1] = jogo12;
        rank[2] = jogo24;
        rank[3] = jogo36;
        return rank;

    }

    public ArrayList<Jogo> ordena(ArrayList<Jogo> jogo) {
        for (int i = jogo.size(); i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (jogo.get(j - 1).getPlayer().getScore().getPontos() < jogo.get(j).getPlayer().getScore().getPontos()) {
                    Jogo aux = jogo.get(j);
                    jogo.set(j, jogo.get(j - 1));
                    jogo.set(j - 1, aux);
                }
            }
        }

        return jogo;
    }

}
