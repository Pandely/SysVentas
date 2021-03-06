/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "vent_salida_diversa", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentSalidaDiversa.findAll", query = "SELECT v FROM VentSalidaDiversa v")
    , @NamedQuery(name = "VentSalidaDiversa.findByIdSalidaDiversa", query = "SELECT v FROM VentSalidaDiversa v WHERE v.idSalidaDiversa = :idSalidaDiversa")
    , @NamedQuery(name = "VentSalidaDiversa.findByFechaSalida", query = "SELECT v FROM VentSalidaDiversa v WHERE v.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "VentSalidaDiversa.findByMotivo", query = "SELECT v FROM VentSalidaDiversa v WHERE v.motivo = :motivo")
    , @NamedQuery(name = "VentSalidaDiversa.findBySerie", query = "SELECT v FROM VentSalidaDiversa v WHERE v.serie = :serie")
    , @NamedQuery(name = "VentSalidaDiversa.findByNumdoc", query = "SELECT v FROM VentSalidaDiversa v WHERE v.numdoc = :numdoc")
    , @NamedQuery(name = "VentSalidaDiversa.findByEstado", query = "SELECT v FROM VentSalidaDiversa v WHERE v.estado = :estado")})
public class VentSalidaDiversa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSalidaDiversa", nullable = false)
    private Integer idSalidaDiversa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_salida", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "motivo", nullable = false, length = 100)
    private String motivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "serie", nullable = false, length = 10)
    private String serie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numdoc", nullable = false, length = 15)
    private String numdoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private int estado;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    @ManyToOne(optional = false)
    private GloUsuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSalidaDiversa")
    private Collection<VentSalidadivDetalles> ventSalidadivDetallesCollection;

    public VentSalidaDiversa() {
    }

    public VentSalidaDiversa(Integer idSalidaDiversa) {
        this.idSalidaDiversa = idSalidaDiversa;
    }

    public VentSalidaDiversa(Integer idSalidaDiversa, Date fechaSalida, String motivo, String serie, String numdoc, int estado) {
        this.idSalidaDiversa = idSalidaDiversa;
        this.fechaSalida = fechaSalida;
        this.motivo = motivo;
        this.serie = serie;
        this.numdoc = numdoc;
        this.estado = estado;
    }

    public Integer getIdSalidaDiversa() {
        return idSalidaDiversa;
    }

    public void setIdSalidaDiversa(Integer idSalidaDiversa) {
        this.idSalidaDiversa = idSalidaDiversa;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public GloUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(GloUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<VentSalidadivDetalles> getVentSalidadivDetallesCollection() {
        return ventSalidadivDetallesCollection;
    }

    public void setVentSalidadivDetallesCollection(Collection<VentSalidadivDetalles> ventSalidadivDetallesCollection) {
        this.ventSalidadivDetallesCollection = ventSalidadivDetallesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalidaDiversa != null ? idSalidaDiversa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentSalidaDiversa)) {
            return false;
        }
        VentSalidaDiversa other = (VentSalidaDiversa) object;
        if ((this.idSalidaDiversa == null && other.idSalidaDiversa != null) || (this.idSalidaDiversa != null && !this.idSalidaDiversa.equals(other.idSalidaDiversa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.VentSalidaDiversa[ idSalidaDiversa=" + idSalidaDiversa + " ]";
    }
    
}
