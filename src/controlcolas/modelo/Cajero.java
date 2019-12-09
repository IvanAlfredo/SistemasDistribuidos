/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package controlcolas.modelo;

import seguridad.modelo.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RDuran
 */
@Entity
@Table(name = "cajero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cajero.findAll", query = "SELECT c FROM Cajero c"),
    @NamedQuery(name = "Cajero.findById", query = "SELECT c FROM Cajero c WHERE c.id = :id"),
    @NamedQuery(name = "Cajero.findByNombre", query = "SELECT c FROM Cajero c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cajero.findByFechaAct", query = "SELECT c FROM Cajero c WHERE c.fechaAct = :fechaAct")})
public class Cajero implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_act")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAct;
    @OneToMany(mappedBy = "cajero")
    private List<Atencion> atencionList;
    @JoinColumn(name = "caja_id", referencedColumnName = "id")
    @ManyToOne
    private Caja caja;
      


    public Cajero() {
    }

    public Cajero(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    @XmlTransient
    public List<Atencion> getAtencionList() {
        return atencionList;
    }

    public void setAtencionList(List<Atencion> atencionList) {
        this.atencionList = atencionList;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cajero)) {
            return false;
        }
        Cajero other = (Cajero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controlcolas.modelo.Cajero[ id=" + id + " ]";
    }
    
}
