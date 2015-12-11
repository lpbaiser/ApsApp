package Model;

import Control.Player;
import javax.persistence.Query;

/**
 * Document: PlayerDao
 * @author : Leonardo Baiser <lpbaiser@gmail.com>
 * @since : Dec 9, 2015, 9:00:53 PM
 */
public class PlayerDao extends GenericDao<Player>{
    
    public PlayerDao(){
        super(Player.class);
    }
    
    public String verificaPlayerExists(String namePlayer){
        Query q = em.createQuery("SELECT e.namePlayer FROM Player e WHERE e.namePlayer = :namePlayer");
        q.setParameter("namePlayer", namePlayer);
        
        try{
            return (String) q.getSingleResult();
        }catch (Exception ex){
            return null;
        }
    }
    
     public Player getPlayerByScore(int idScore){
        Query q = em.createQuery("SELECT e FROM Player e WHERE e.idScore.idScore = :idScore");
        q.setParameter("idScore", idScore);
        
        try{
            return (Player) q.getSingleResult();
        }catch (Exception ex){
            return null;
        }
    }

}
