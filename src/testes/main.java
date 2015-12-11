package testes;

import Control.Player;
import Control.Score;
import Control.ScorePK;
import Model.Persistencia;
import java.util.ArrayList;
import java.util.List;

/**
 * Document: main
 *
 * @author : Leonardo Baiser <lpbaiser@gmail.com>
 * @since : Dec 9, 2015, 9:15:34 PM
 */
public class main {

    public static void main(String[] args) {
        Player p = new Player();
        p.setNamePlayer("Leonardo");
        
        Score s = new Score();
        ScorePK  sPk = new ScorePK();
        sPk.setAcertoConsecutivo(3);
        sPk.setNumTentativas(10);
        sPk.setPontos(500);
        sPk.setTempo(50);
        s.setScorePK(sPk);
        
        List<Score> listScore = new ArrayList<>();
        listScore.add(s);
        
        p.setScoreList(listScore);
        
        Persistencia persist = new Persistencia();
        persist.gravaPlayerScore(p);
        
    }

}
