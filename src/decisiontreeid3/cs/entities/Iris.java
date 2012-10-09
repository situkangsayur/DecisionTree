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
@Table(name = "iris")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iris.findAll", query = "SELECT i FROM Iris i"),
    @NamedQuery(name = "Iris.findByNo", query = "SELECT i FROM Iris i WHERE i.no = :no"),
    @NamedQuery(name = "Iris.findBySepallength", query = "SELECT i FROM Iris i WHERE i.sepallength = :sepallength"),
    @NamedQuery(name = "Iris.findBySepalwidth", query = "SELECT i FROM Iris i WHERE i.sepalwidth = :sepalwidth"),
    @NamedQuery(name = "Iris.findByPetallength", query = "SELECT i FROM Iris i WHERE i.petallength = :petallength"),
    @NamedQuery(name = "Iris.findByPetalwidth", query = "SELECT i FROM Iris i WHERE i.petalwidth = :petalwidth"),
    @NamedQuery(name = "Iris.findByResult", query = "SELECT i FROM Iris i WHERE i.result = :result")})
public class Iris implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "no")
    private Integer no;
    @Basic(optional = false)
    @Column(name = "sepallength")
    private float sepallength;
    @Basic(optional = false)
    @Column(name = "sepalwidth")
    private float sepalwidth;
    @Basic(optional = false)
    @Column(name = "petallength")
    private float petallength;
    @Basic(optional = false)
    @Column(name = "petalwidth")
    private float petalwidth;
    @Basic(optional = false)
    @Column(name = "result")
    private String result;

    public Iris() {
    }

    public Iris(Integer no) {
        this.no = no;
    }

    public Iris(Integer no, float sepallength, float sepalwidth, float petallength, float petalwidth, String result) {
        this.no = no;
        this.sepallength = sepallength;
        this.sepalwidth = sepalwidth;
        this.petallength = petallength;
        this.petalwidth = petalwidth;
        this.result = result;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public float getSepallength() {
        return sepallength;
    }

    public void setSepallength(float sepallength) {
        this.sepallength = sepallength;
    }

    public float getSepalwidth() {
        return sepalwidth;
    }

    public void setSepalwidth(float sepalwidth) {
        this.sepalwidth = sepalwidth;
    }

    public float getPetallength() {
        return petallength;
    }

    public void setPetallength(float petallength) {
        this.petallength = petallength;
    }

    public float getPetalwidth() {
        return petalwidth;
    }

    public void setPetalwidth(float petalwidth) {
        this.petalwidth = petalwidth;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iris)) {
            return false;
        }
        Iris other = (Iris) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "decisiontreeid3.cs.entities.Iris[ no=" + no + " ]";
    }
    
}
