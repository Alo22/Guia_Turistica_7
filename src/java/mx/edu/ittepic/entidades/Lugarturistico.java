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
@Table(name = "lugarturistico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lugarturistico.findAll", query = "SELECT l FROM Lugarturistico l")
    , @NamedQuery(name = "Lugarturistico.findByIdlugarturistico", query = "SELECT l FROM Lugarturistico l WHERE l.idlugarturistico = :idlugarturistico")
    , @NamedQuery(name = "Lugarturistico.findByNombrelugar", query = "SELECT l FROM Lugarturistico l WHERE l.nombrelugar = :nombrelugar")
    , @NamedQuery(name = "Lugarturistico.findByTipolugar", query = "SELECT l FROM Lugarturistico l WHERE l.tipolugar = :tipolugar")
    , @NamedQuery(name = "Lugarturistico.findByDescripcion", query = "SELECT l FROM Lugarturistico l WHERE l.descripcion = :descripcion")
    , @NamedQuery(name = "Lugarturistico.findByCodigoqr", query = "SELECT l FROM Lugarturistico l WHERE l.codigoqr = :codigoqr")})
public class Lugarturistico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlugarturistico")
    private Integer idlugarturistico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombrelugar")
    private String nombrelugar;
    @Column(name = "tipolugar")
    private Character tipolugar;
    @Size(max = 800)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 2147483647)
    @Column(name = "codigoqr")
    private String codigoqr;
    @JoinColumn(name = "marcaturistica_idmarcaturistica", referencedColumnName = "idmarcaturistica")
    @ManyToOne(optional = false)
    private Marcaturistica marcaturisticaIdmarcaturistica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lugarturisticoIdlugarturistico")
    private List<Visita> visitaList;

    public Lugarturistico() {
    }

    public Lugarturistico(Integer idlugarturistico) {
        this.idlugarturistico = idlugarturistico;
    }

    public Lugarturistico(Integer idlugarturistico, String nombrelugar) {
        this.idlugarturistico = idlugarturistico;
        this.nombrelugar = nombrelugar;
    }

    public Integer getIdlugarturistico() {
        return idlugarturistico;
    }

    public void setIdlugarturistico(Integer idlugarturistico) {
        this.idlugarturistico = idlugarturistico;
    }

    public String getNombrelugar() {
        return nombrelugar;
    }

    public void setNombrelugar(String nombrelugar) {
        this.nombrelugar = nombrelugar;
    }

    public Character getTipolugar() {
        return tipolugar;
    }

    public void setTipolugar(Character tipolugar) {
        this.tipolugar = tipolugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoqr() {
        return codigoqr;
    }

    public void setCodigoqr(String codigoqr) {
        this.codigoqr = codigoqr;
    }

    public Marcaturistica getMarcaturisticaIdmarcaturistica() {
        return marcaturisticaIdmarcaturistica;
    }

    public void setMarcaturisticaIdmarcaturistica(Marcaturistica marcaturisticaIdmarcaturistica) {
        this.marcaturisticaIdmarcaturistica = marcaturisticaIdmarcaturistica;
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
        hash += (idlugarturistico != null ? idlugarturistico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lugarturistico)) {
            return false;
        }
        Lugarturistico other = (Lugarturistico) object;
        if ((this.idlugarturistico == null && other.idlugarturistico != null) || (this.idlugarturistico != null && !this.idlugarturistico.equals(other.idlugarturistico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Lugarturistico[ idlugarturistico=" + idlugarturistico + " ]";
    }
    
}
