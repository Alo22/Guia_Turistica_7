/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.entidades;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alon_
 */
@Entity
@Table(name = "usuariosistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariosistema.findAll", query = "SELECT u FROM Usuariosistema u")
    , @NamedQuery(name = "Usuariosistema.findByIdusuariosistema", query = "SELECT u FROM Usuariosistema u WHERE u.idusuariosistema = :idusuariosistema")
    , @NamedQuery(name = "Usuariosistema.findByNombreusuariosistema", query = "SELECT u FROM Usuariosistema u WHERE u.nombreusuariosistema = :nombreusuariosistema")
    , @NamedQuery(name = "Usuariosistema.findByNombrecompleto", query = "SELECT u FROM Usuariosistema u WHERE u.nombrecompleto = :nombrecompleto")
    , @NamedQuery(name = "Usuariosistema.findByVigente", query = "SELECT u FROM Usuariosistema u WHERE u.vigente = :vigente")
    , @NamedQuery(name = "Usuariosistema.findByContra", query = "SELECT u FROM Usuariosistema u WHERE u.contra = :contra")})
public class Usuariosistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuariosistema")
    private Integer idusuariosistema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombreusuariosistema")
    private String nombreusuariosistema;
    @Size(max = 60)
    @Column(name = "nombrecompleto")
    private String nombrecompleto;
    @Column(name = "vigente")
    private Character vigente;
    @Size(max = 15)
    @Column(name = "contra")
    private String contra;
    @JoinColumn(name = "rol_idrol", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    private Rol rolIdrol;

    public Usuariosistema() {
    }

    public Usuariosistema(Integer idusuariosistema) {
        this.idusuariosistema = idusuariosistema;
    }

    public Usuariosistema(Integer idusuariosistema, String nombreusuariosistema) {
        this.idusuariosistema = idusuariosistema;
        this.nombreusuariosistema = nombreusuariosistema;
    }

    public Integer getIdusuariosistema() {
        return idusuariosistema;
    }

    public void setIdusuariosistema(Integer idusuariosistema) {
        this.idusuariosistema = idusuariosistema;
    }

    public String getNombreusuariosistema() {
        return nombreusuariosistema;
    }

    public void setNombreusuariosistema(String nombreusuariosistema) {
        this.nombreusuariosistema = nombreusuariosistema;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public Character getVigente() {
        return vigente;
    }

    public void setVigente(Character vigente) {
        this.vigente = vigente;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Rol getRolIdrol() {
        return rolIdrol;
    }

    public void setRolIdrol(Rol rolIdrol) {
        this.rolIdrol = rolIdrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuariosistema != null ? idusuariosistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariosistema)) {
            return false;
        }
        Usuariosistema other = (Usuariosistema) object;
        if ((this.idusuariosistema == null && other.idusuariosistema != null) || (this.idusuariosistema != null && !this.idusuariosistema.equals(other.idusuariosistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Usuariosistema[ idusuariosistema=" + idusuariosistema + " ]";
    }
    
}
