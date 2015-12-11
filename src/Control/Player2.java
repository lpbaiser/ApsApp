package Control;

import java.util.ArrayList;

/**
 *
 * @author Emanuel Mazzer & Leonardo Baiser
 * @version 1.0
 * @since 19/10/2015
 */
public class Player2 {

    private String nome;
    private Score2 score;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Score2 getScore() {
        return score;
    }

    public void setScore(Score2 score) {
        this.score = score;
    }

    public void setPontos(float pontos) {
        this.score.setScore(pontos);
    }
    
}
