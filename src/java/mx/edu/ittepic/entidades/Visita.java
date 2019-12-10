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
@Table(name = "visita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visita.findAll", query = "SELECT v FROM Visita v")
    , @NamedQuery(name = "Visita.findByFechavisita", query = "SELECT v FROM Visita v WHERE v.fechavisita = :fechavisita")
    , @NamedQuery(name = "Visita.findByComentarios", query = "SELECT v FROM Visita v WHERE v.comentarios = :comentarios")})
public class Visita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechavisita")
    private Integer fechavisita;
    @Size(max = 45)
    @Column(name = "comentarios")
    private String comentarios;
    @JoinColumn(name = "lugarturistico_idlugarturistico", referencedColumnName = "idlugarturistico")
    @ManyToOne(optional = false)
    private Lugarturistico lugarturisticoIdlugarturistico;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIdusuario;

    public Visita() {
    }

    public Visita(Integer fechavisita) {
        this.fechavisita = fechavisita;
    }

    public Integer getFechavisita() {
        return fechavisita;
    }

    public void setFechavisita(Integer fechavisita) {
        this.fechavisita = fechavisita;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Lugarturistico getLugarturisticoIdlugarturistico() {
        return lugarturisticoIdlugarturistico;
    }

    public void setLugarturisticoIdlugarturistico(Lugarturistico lugarturisticoIdlugarturistico) {
        this.lugarturisticoIdlugarturistico = lugarturisticoIdlugarturistico;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechavisita != null ? fechavisita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visita)) {
            return false;
        }
        Visita other = (Visita) object;
        if ((this.fechavisita == null && other.fechavisita != null) || (this.fechavisita != null && !this.fechavisita.equals(other.fechavisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Visita[ fechavisita=" + fechavisita + " ]";
    }
    
}
