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
    
    public int verificaPlayerExists(int idPlayer){
        Query q = em.createQuery("SELECT e.idPlayer FROM Player e WHERE e.categoria = :categoria");
        q.setParameter("idPlayer", idPlayer);
        
        try{
            return (int) q.getSingleResult();
        }catch (Exception ex){
            return -1;
        }
    }

}
