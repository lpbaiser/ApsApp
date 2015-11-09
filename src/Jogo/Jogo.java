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
    
    
    /* Método utilizado para mostrar o ranking dos jogadores
        separados pela dificuldade na hora de jogar
    */
    public ArrayList<ArrayList<Jogo>> ranking() {
        Persistencia p = new Persistencia();
        /*  Um ArrayList de ArrayList recebe o retorno da função 
            lista que retorna uma ArrayList com 3 arrayLists
            cada posição representando certa dificuldade(12,24,36)
        */
        ArrayList<ArrayList<Jogo>> jog = p.lista();
        ArrayList<Jogo> jogo12 = ordena(jog.get(0));//O ArrayList jogo chama o metodo ordena, para todas dificuldades
        ArrayList<Jogo> jogo24 = ordena(jog.get(1));
        ArrayList<Jogo> jogo36 = ordena(jog.get(2));
        ArrayList<ArrayList<Jogo>> rank = new ArrayList<>();
        rank.add(jogo12);
        rank.add(jogo24);
        rank.add(jogo36);
        return rank;//o rank é retornado com todas os players ordenados em suas dificuldades

    }
    
//  Metodo ordena, responsavel por ordernar um arrayList(utilizado metodo Bubble sort)
//  Ordena os players por pontuação    
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
