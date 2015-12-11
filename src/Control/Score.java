/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author emanuel
 */
@Entity
@Table(name = "Score")
@NamedQueries({
    @NamedQuery(name = "Score.findAll", query = "SELECT s FROM Score s")})
public class Score implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idScore")
    private Integer idScore;
    @Basic(optional = false)
    @Column(name = "dificuldade")
    private int dificuldade;
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
    private int pontos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idScore")
    private List<Player> playerList;

    public Score() {
    }

    public Score(Integer idScore) {
        this.idScore = idScore;
    }

    public Score(Integer idScore, int dificuldade, int tempo, int numTentativas, int acertoConsecutivo, int pontos) {
        this.idScore = idScore;
        this.dificuldade = dificuldade;
        this.tempo = tempo;
        this.numTentativas = numTentativas;
        this.acertoConsecutivo = acertoConsecutivo;
        this.pontos = pontos;
    }

    public Integer getIdScore() {
        return idScore;
    }

    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
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

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idScore != null ? idScore.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Score)) {
            return false;
        }
        Score other = (Score) object;
        if ((this.idScore == null && other.idScore != null) || (this.idScore != null && !this.idScore.equals(other.idScore))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Control.Score[ idScore=" + idScore + " ]";
    }
    
     public void addNumTentativas(){
            this.numTentativas ++;
        }
        
        public void addAcertoConsecutivo(){
            this.acertoConsecutivo++;
        }
        public int calcScore() {
		pontos = (( this.numTentativas)* (this.acertoConsecutivo)*1000)/this.tempo;
		return pontos;
	}

    
}
