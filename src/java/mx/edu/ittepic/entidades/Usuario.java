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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "Usuario.findByNombreusuario", query = "SELECT u FROM Usuario u WHERE u.nombreusuario = :nombreusuario")
    , @NamedQuery(name = "Usuario.findByCorreoelectronico", query = "SELECT u FROM Usuario u WHERE u.correoelectronico = :correoelectronico")
    , @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private Integer idusuario;
    @Size(max = 60)
    @Column(name = "nombreusuario")
    private String nombreusuario;
    @Size(max = 255)
    @Column(name = "correoelectronico")
    private String correoelectronico;
    @Size(max = 15)
    @Column(name = "contrasena")
    private String contrasena;
    @JoinColumn(name = "pais_idpais", referencedColumnName = "idpais")
    @ManyToOne(optional = false)
    private Pais paisIdpais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdusuario")
    private List<Visita> visitaList;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Pais getPaisIdpais() {
        return paisIdpais;
    }

    public void setPaisIdpais(Pais paisIdpais) {
        this.paisIdpais = paisIdpais;
    }

    @XmlTransient
    public List<Visita> getVisitaList() {
        return visitaList;
    }

    public void setVisitaList(List<Visita> visitaList) {
        this.visitaList = visitaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
