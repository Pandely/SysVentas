/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author pc
 */
@Entity
@Table(name = "cont_elemento", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContElemento.findAll", query = "SELECT c FROM ContElemento c")
    , @NamedQuery(name = "ContElemento.findByIdElemento", query = "SELECT c FROM ContElemento c WHERE c.idElemento = :idElemento")
    , @NamedQuery(name = "ContElemento.findByCuenta", query = "SELECT c FROM ContElemento c WHERE c.cuenta = :cuenta")
    , @NamedQuery(name = "ContElemento.findByDescripcion", query = "SELECT c FROM ContElemento c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "ContElemento.findByEstado", query = "SELECT c FROM ContElemento c WHERE c.estado = :estado")})
public class ContElemento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idElemento", nullable = false)
    private Integer idElemento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "cuenta", nullable = false, length = 12)
    private String cuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado", nullable = false, length = 5)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idElemento")
    private Collection<ContCuenta> contCuentaCollection;

    public ContElemento() {
    }

    public ContElemento(Integer idElemento) {
        this.idElemento = idElemento;
    }

    public ContElemento(Integer idElemento, String cuenta, String descripcion, String estado) {
        this.idElemento = idElemento;
        this.cuenta = cuenta;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Integer idElemento) {
        this.idElemento = idElemento;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<ContCuenta> getContCuentaCollection() {
        return contCuentaCollection;
    }

    public void setContCuentaCollection(Collection<ContCuenta> contCuentaCollection) {
        this.contCuentaCollection = contCuentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idElemento != null ? idElemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContElemento)) {
            return false;
        }
        ContElemento other = (ContElemento) object;
        if ((this.idElemento == null && other.idElemento != null) || (this.idElemento != null && !this.idElemento.equals(other.idElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.ContElemento[ idElemento=" + idElemento + " ]";
    }
    
}
