package testes;

import Control.Player;
import Control.Score;
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
        p.setNamePlayer("leozim");
        
        Score sPk = new Score();
       
        sPk.setAcertoConsecutivo(21);
        sPk.setNumTentativas(101);
        sPk.setPontos(52);
        sPk.setTempo(10);
      
        
      
        
        Persistencia persist = new Persistencia();
        persist.gravaPlayerScore(p,sPk);
        
    }

}
