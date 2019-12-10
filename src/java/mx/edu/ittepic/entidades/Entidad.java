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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "entidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidad.findAll", query = "SELECT e FROM Entidad e")
    , @NamedQuery(name = "Entidad.findByIdentidad", query = "SELECT e FROM Entidad e WHERE e.identidad = :identidad")
    , @NamedQuery(name = "Entidad.findByNombreentidad", query = "SELECT e FROM Entidad e WHERE e.nombreentidad = :nombreentidad")})
public class Entidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "identidad")
    private Integer identidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombreentidad")
    private String nombreentidad;
    @JoinColumn(name = "pais_idpais", referencedColumnName = "idpais")
    @ManyToOne(optional = false)
    private Pais paisIdpais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidadIdentidad")
    private List<Poblacion> poblacionList;

    public Entidad() {
    }

    public Entidad(Integer identidad) {
        this.identidad = identidad;
    }

    public Entidad(Integer identidad, String nombreentidad) {
        this.identidad = identidad;
        this.nombreentidad = nombreentidad;
    }

    public Integer getIdentidad() {
        return identidad;
    }

    public void setIdentidad(Integer identidad) {
        this.identidad = identidad;
    }

    public String getNombreentidad() {
        return nombreentidad;
    }

    public void setNombreentidad(String nombreentidad) {
        this.nombreentidad = nombreentidad;
    }

    public Pais getPaisIdpais() {
        return paisIdpais;
    }

    public void setPaisIdpais(Pais paisIdpais) {
        this.paisIdpais = paisIdpais;
    }

    @XmlTransient
    public List<Poblacion> getPoblacionList() {
        return poblacionList;
    }

    public void setPoblacionList(List<Poblacion> poblacionList) {
        this.poblacionList = poblacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identidad != null ? identidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidad)) {
            return false;
        }
        Entidad other = (Entidad) object;
        if ((this.identidad == null && other.identidad != null) || (this.identidad != null && !this.identidad.equals(other.identidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Entidad[ identidad=" + identidad + " ]";
    }
    
}
