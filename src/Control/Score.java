package Control;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Document: Score
 * @author : Leonardo Baiser <lpbaiser@gmail.com>
 * @since : Dec 10, 2015, 9:55:29 PM
 */
@Entity
@Table(name = "Score")
@NamedQueries({
    @NamedQuery(name = "Score.findAll", query = "SELECT s FROM Score s")})
public class Score implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ScorePK scorePK;
    @JoinColumn(name = "idPlayer", referencedColumnName = "idPlayer")
    @ManyToOne(optional = false)
    private Player idPlayer;

    public Score() {
    }

    public Score(ScorePK scorePK) {
        this.scorePK = scorePK;
    }

    public Score(int tempo, int numTentativas, int acertoConsecutivo, float pontos) {
        this.scorePK = new ScorePK(tempo, numTentativas, acertoConsecutivo, pontos);
    }

    public ScorePK getScorePK() {
        return scorePK;
    }

    public void setScorePK(ScorePK scorePK) {
        this.scorePK = scorePK;
    }

    public Player getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Player idPlayer) {
        this.idPlayer = idPlayer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scorePK != null ? scorePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Score)) {
            return false;
        }
        Score other = (Score) object;
        if ((this.scorePK == null && other.scorePK != null) || (this.scorePK != null && !this.scorePK.equals(other.scorePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Control.Score[ scorePK=" + scorePK + " ]";
    }

}
