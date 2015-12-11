package Model;

import Control.Score;

/**
 * Document: ScoreDao
 * @author : Leonardo Baiser <lpbaiser@gmail.com>
 * @since : Dec 9, 2015, 9:01:00 PM
 */
public class ScoreDao extends GenericDao<Score>{
    
    public ScoreDao(){
        super (Score.class);
    }

}
