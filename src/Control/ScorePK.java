package Control;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Document: ScorePK
 *
 * @author : Leonardo Baiser <lpbaiser@gmail.com>
 * @since : Dec 10, 2015, 9:55:29 PM
 */
@Embeddable
public class ScorePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "tempo")
    private int tempo;
    @Basic(optional = false)
    @Column(name = "numTentativas")
    private int numTentativas;
    @Basic(optional = false)
    @Column(name = "acertoConsecutivo")
    private int acertoConsecutivo;
    @Basic(optional = false)
    @Column(name = "pontos")
    private float pontos;

    public ScorePK() {
    }

    public ScorePK(int tempo, int numTentativas, int acertoConsecutivo, float pontos) {
        this.tempo = tempo;
        this.numTentativas = numTentativas;
        this.acertoConsecutivo = acertoConsecutivo;
        this.pontos = pontos;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getNumTentativas() {
        return numTentativas;
    }

    public void setNumTentativas(int numTentativas) {
        this.numTentativas = numTentativas;
    }

    public int getAcertoConsecutivo() {
        return acertoConsecutivo;
    }

    public void setAcertoConsecutivo(int acertoConsecutivo) {
        this.acertoConsecutivo = acertoConsecutivo;
    }

    public float getPontos() {
        return pontos;
    }

    public void setPontos(float pontos) {
        this.pontos = pontos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tempo;
        hash += (int) numTentativas;
        hash += (int) acertoConsecutivo;
        hash += (int) pontos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScorePK)) {
            return false;
        }
        ScorePK other = (ScorePK) object;
        if (this.tempo != other.tempo) {
            return false;
        }
        if (this.numTentativas != other.numTentativas) {
            return false;
        }
        if (this.acertoConsecutivo != other.acertoConsecutivo) {
            return false;
        }
        if (this.pontos != other.pontos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Control.ScorePK[ tempo=" + tempo + ", numTentativas=" + numTentativas + ", acertoConsecutivo=" + acertoConsecutivo + ", pontos=" + pontos + " ]";
    }

    public float calcScore() {
        pontos = ((this.tempo / this.numTentativas) * (this.acertoConsecutivo) * 1000);
        return pontos;
    }

    public void addNumTentativas() {
        this.numTentativas++;
    }

    public void addAcertoConsecutivo() {
        this.acertoConsecutivo++;
    }

}
