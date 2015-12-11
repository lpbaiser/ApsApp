/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author emanuel
 */
@Entity
@Table(name = "Player")
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p")})
public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "namePlayer")
    private String namePlayer;
    @JoinColumn(name = "idScore", referencedColumnName = "idScore")
    @ManyToOne(optional = false)
    private Score idScore;

    public Player() {
    }

    public Player(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public Score getIdScore() {
        return idScore;
    }

    public void setIdScore(Score idScore) {
        this.idScore = idScore;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (namePlayer != null ? namePlayer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.namePlayer == null && other.namePlayer != null) || (this.namePlayer != null && !this.namePlayer.equals(other.namePlayer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Control.Player[ namePlayer=" + namePlayer + " ]";
    }
    
}
