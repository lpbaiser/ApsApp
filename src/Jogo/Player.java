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
    
}
