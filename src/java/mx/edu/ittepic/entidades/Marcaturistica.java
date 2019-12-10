/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.entidades;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alon_
 */
@Entity
@Table(name = "marcaturistica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marcaturistica.findAll", query = "SELECT m FROM Marcaturistica m")
    , @NamedQuery(name = "Marcaturistica.findByIdmarcaturistica", query = "SELECT m FROM Marcaturistica m WHERE m.idmarcaturistica = :idmarcaturistica")
    , @NamedQuery(name = "Marcaturistica.findByMarcaturistica", query = "SELECT m FROM Marcaturistica m WHERE m.marcaturistica = :marcaturistica")})
public class Marcaturistica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmarcaturistica")
    private Integer idmarcaturistica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "marcaturistica")
    private String marcaturistica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marcaturisticaIdmarcaturistica")
    private List<Poblacion> poblacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marcaturisticaIdmarcaturistica")
    private List<Lugarturistico> lugarturisticoList;

    public Marcaturistica() {
    }

    public Marcaturistica(Integer idmarcaturistica) {
        this.idmarcaturistica = idmarcaturistica;
    }

    public Marcaturistica(Integer idmarcaturistica, String marcaturistica) {
        this.idmarcaturistica = idmarcaturistica;
        this.marcaturistica = marcaturistica;
    }

    public Integer getIdmarcaturistica() {
        return idmarcaturistica;
    }

    public void setIdmarcaturistica(Integer idmarcaturistica) {
        this.idmarcaturistica = idmarcaturistica;
    }

    public String getMarcaturistica() {
        return marcaturistica;
    }

    public void setMarcaturistica(String marcaturistica) {
        this.marcaturistica = marcaturistica;
    }

    @XmlTransient
    public List<Poblacion> getPoblacionList() {
        return poblacionList;
    }

    public void setPoblacionList(List<Poblacion> poblacionList) {
        this.poblacionList = poblacionList;
    }

    @XmlTransient
    public List<Lugarturistico> getLugarturisticoList() {
        return lugarturisticoList;
    }

    public void setLugarturisticoList(List<Lugarturistico> lugarturisticoList) {
        this.lugarturisticoList = lugarturisticoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmarcaturistica != null ? idmarcaturistica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcaturistica)) {
            return false;
        }
        Marcaturistica other = (Marcaturistica) object;
        if ((this.idmarcaturistica == null && other.idmarcaturistica != null) || (this.idmarcaturistica != null && !this.idmarcaturistica.equals(other.idmarcaturistica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Marcaturistica[ idmarcaturistica=" + idmarcaturistica + " ]";
    }
    
}
