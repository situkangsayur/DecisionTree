/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontreeid3.cs.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hendri
 */
@Entity
@Table(name = "training_set")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrainingSet.findAll", query = "SELECT t FROM TrainingSet t"),
    @NamedQuery(name = "TrainingSet.findByDay", query = "SELECT t FROM TrainingSet t WHERE t.day = :day"),
    @NamedQuery(name = "TrainingSet.findByOutLook", query = "SELECT t FROM TrainingSet t WHERE t.outLook = :outLook"),
    @NamedQuery(name = "TrainingSet.findByTemperatur", query = "SELECT t FROM TrainingSet t WHERE t.temperatur = :temperatur"),
    @NamedQuery(name = "TrainingSet.findByHumadity", query = "SELECT t FROM TrainingSet t WHERE t.humadity = :humadity"),
    @NamedQuery(name = "TrainingSet.findByWind", query = "SELECT t FROM TrainingSet t WHERE t.wind = :wind"),
    @NamedQuery(name = "TrainingSet.findByPlayTennis", query = "SELECT t FROM TrainingSet t WHERE t.playTennis = :playTennis")})
public class TrainingSet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "day")
    private String day;
    @Column(name = "out_look")
    private String outLook;
    @Column(name = "temperatur")
    private String temperatur;
    @Column(name = "humadity")
    private String humadity;
    @Column(name = "wind")
    private String wind;
    @Column(name = "playTennis")
    private String playTennis;

    public TrainingSet() {
    }

    public TrainingSet(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOutLook() {
        return outLook;
    }

    public void setOutLook(String outLook) {
        this.outLook = outLook;
    }

    public String getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(String temperatur) {
        this.temperatur = temperatur;
    }

    public String getHumadity() {
        return humadity;
    }

    public void setHumadity(String humadity) {
        this.humadity = humadity;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getPlayTennis() {
        return playTennis;
    }

    public void setPlayTennis(String playTennis) {
        this.playTennis = playTennis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (day != null ? day.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainingSet)) {
            return false;
        }
        TrainingSet other = (TrainingSet) object;
        if ((this.day == null && other.day != null) || (this.day != null && !this.day.equals(other.day))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "decisiontreeid3.cs.entities.TrainingSet[ day=" + day + " ]";
    }
    
}
