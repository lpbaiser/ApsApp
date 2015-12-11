package Model;

import Control.Score;
import static Model.GenericDao.em;
import java.util.List;
import javax.persistence.Query;

/**
 * Document: ScoreDao
 * @author : Leonardo Baiser <lpbaiser@gmail.com>
 * @since : Dec 9, 2015, 9:01:00 PM
 */
public class ScoreDao extends GenericDao<Score>{
    
    public ScoreDao(){
        super (Score.class);
    }

     public long  contaScore(){
        Query q = em.createQuery("SELECT COUNT(e) FROM Score e");
        
        try{
            return (long) q.getSingleResult();
        }catch (Exception ex){
            System.out.println("ERRO: "+ex.getMessage());
            return -1;
        }
    }
     
     public List<Score> ranking(){
         Query q = em.createQuery("SELECT e FROM Score e ORDER BY(e.pontos)");
         List<Score> scores;
         try {
             scores=(List<Score>) q.getResultList();
             return scores;
         } catch (Exception ex) {
             System.out.println("Erro: "+ex.getMessage());
             return null;
         }
     }
    
    
}
