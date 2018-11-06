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
 * @author pc
 */
@Entity
@Table(name = "cont_division", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContDivision.findAll", query = "SELECT c FROM ContDivision c")
    , @NamedQuery(name = "ContDivision.findByIdDivision", query = "SELECT c FROM ContDivision c WHERE c.idDivision = :idDivision")
    , @NamedQuery(name = "ContDivision.findByCuenta", query = "SELECT c FROM ContDivision c WHERE c.cuenta = :cuenta")
    , @NamedQuery(name = "ContDivision.findByDescripcion", query = "SELECT c FROM ContDivision c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "ContDivision.findByEstado", query = "SELECT c FROM ContDivision c WHERE c.estado = :estado")})
public class ContDivision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDivision", nullable = false)
    private Integer idDivision;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDivision")
    private Collection<ContSubdivCuenta> contSubdivCuentaCollection;
    @JoinColumn(name = "idSubCuenta", referencedColumnName = "idSubCuenta", nullable = false)
    @ManyToOne(optional = false)
    private ContSubCuenta idSubCuenta;

    public ContDivision() {
    }

    public ContDivision(Integer idDivision) {
        this.idDivision = idDivision;
    }

    public ContDivision(Integer idDivision, String cuenta, String descripcion, String estado) {
        this.idDivision = idDivision;
        this.cuenta = cuenta;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Integer idDivision) {
        this.idDivision = idDivision;
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
    public Collection<ContSubdivCuenta> getContSubdivCuentaCollection() {
        return contSubdivCuentaCollection;
    }

    public void setContSubdivCuentaCollection(Collection<ContSubdivCuenta> contSubdivCuentaCollection) {
        this.contSubdivCuentaCollection = contSubdivCuentaCollection;
    }

    public ContSubCuenta getIdSubCuenta() {
        return idSubCuenta;
    }

    public void setIdSubCuenta(ContSubCuenta idSubCuenta) {
        this.idSubCuenta = idSubCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDivision != null ? idDivision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContDivision)) {
            return false;
        }
        ContDivision other = (ContDivision) object;
        if ((this.idDivision == null && other.idDivision != null) || (this.idDivision != null && !this.idDivision.equals(other.idDivision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.ContDivision[ idDivision=" + idDivision + " ]";
    }
    
}
