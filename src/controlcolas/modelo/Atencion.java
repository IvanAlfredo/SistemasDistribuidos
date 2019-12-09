/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlcolas.modelo; 

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RDuran
 */
@Entity
@Table(name = "atencion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atencion.findAll", query = "SELECT a FROM Atencion a"),
    @NamedQuery(name = "Atencion.findById", query = "SELECT a FROM Atencion a WHERE a.id = :id"),
    @NamedQuery(name = "Atencion.findByFecha", query = "SELECT a FROM Atencion a WHERE a.fecha = :fecha")})
public class Atencion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    private Integer id;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "caja_id", referencedColumnName = "id")
    @ManyToOne
    private Caja caja;
    @JoinColumn(name = "cajero_id", referencedColumnName = "id")
    @ManyToOne
    private Cajero cajero;
    @JoinColumn(name = "ficha_id", referencedColumnName = "id")
    @ManyToOne
    private Ficha ficha;

    public Atencion() {
    }

    public Atencion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
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
        if (!(object instanceof Atencion)) {
            return false;
        }
        Atencion other = (Atencion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controlcolas.modelo.Atencion[ id=" + id + " ]";
    }
    
}
