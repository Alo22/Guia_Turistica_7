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
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByIdrol", query = "SELECT r FROM Rol r WHERE r.idrol = :idrol")
    , @NamedQuery(name = "Rol.findByNombrerol", query = "SELECT r FROM Rol r WHERE r.nombrerol = :nombrerol")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrol")
    private Integer idrol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombrerol")
    private String nombrerol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolIdrol")
    private List<Usuariosistema> usuariosistemaList;

    public Rol() {
    }

    public Rol(Integer idrol) {
        this.idrol = idrol;
    }

    public Rol(Integer idrol, String nombrerol) {
        this.idrol = idrol;
        this.nombrerol = nombrerol;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    @XmlTransient
    public List<Usuariosistema> getUsuariosistemaList() {
        return usuariosistemaList;
    }

    public void setUsuariosistemaList(List<Usuariosistema> usuariosistemaList) {
        this.usuariosistemaList = usuariosistemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Rol[ idrol=" + idrol + " ]";
    }
    
}
