package Jogo;

import java.util.ArrayList;

/**
 *
 * @author Emanuel Mazzer & Leonardo Baiser
 * @version 1.0
 * @since 19/10/2015
 */
public class Player {

    private String nome;
    private Score score;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setPontos(float pontos) {
        this.score.setScore(pontos);
    }
    
  

    public ArrayList<Jogo>[] ranking() {
        Persistencia p = new Persistencia();
        ArrayList<ArrayList<Jogo>> jog = p.lista();
        ArrayList<Jogo> jogo12 = ordena(jog.get(0));
        ArrayList<Jogo> jogo24 = ordena(jog.get(1));
        ArrayList<Jogo> jogo36 = ordena(jog.get(2));
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
