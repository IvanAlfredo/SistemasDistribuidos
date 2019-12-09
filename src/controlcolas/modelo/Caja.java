/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlcolas.modelo;
 
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RDuran
 */
@Entity
@Table(name = "caja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caja.findAll", query = "SELECT c FROM Caja c"),
    @NamedQuery(name = "Caja.findById", query = "SELECT c FROM Caja c WHERE c.id = :id"),
    @NamedQuery(name = "Caja.findByNombre", query = "SELECT c FROM Caja c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Caja.findByFechaAct", query = "SELECT c FROM Caja c WHERE c.fechaAct = :fechaAct"),
    @NamedQuery(name = "Caja.findByAtendidos", query = "SELECT c FROM Caja c WHERE c.atendidos = :atendidos")})
public class Caja implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
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
    @Column(name = "atendidos")
    private Integer atendidos;
    @OneToMany(mappedBy = "caja")
    private List<Atencion> atencionList;
    @OneToMany(mappedBy = "caja")
    private List<Cajero> cajeroList;

    public Caja() {
    }

    public Caja(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        Date oldFechaAct = this.fechaAct;
        this.fechaAct = fechaAct;
        changeSupport.firePropertyChange("fechaAct", oldFechaAct, fechaAct);
    }

    public Integer getAtendidos() {
        return atendidos;
    }

    public void setAtendidos(Integer atendidos) {
        Integer oldAtendidos = this.atendidos;
        this.atendidos = atendidos;
        changeSupport.firePropertyChange("atendidos", oldAtendidos, atendidos);
    }

    @XmlTransient
    public List<Atencion> getAtencionList() {
        return atencionList;
    }

    public void setAtencionList(List<Atencion> atencionList) {
        this.atencionList = atencionList;
    }

    @XmlTransient
    public List<Cajero> getCajeroList() {
        return cajeroList;
    }

    public void setCajeroList(List<Cajero> cajeroList) {
        this.cajeroList = cajeroList;
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
        if (!(object instanceof Caja)) {
            return false;
        }
        Caja other = (Caja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controlcolas.modelo.Caja[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
