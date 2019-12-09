/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlcolas.modelo; 

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RDuran
 */
@Entity
@Table(name = "cola")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cola.findAll", query = "SELECT c FROM Cola c"),
    @NamedQuery(name = "Cola.findById", query = "SELECT c FROM Cola c WHERE c.id = :id"),
    @NamedQuery(name = "Cola.findByNombre", query = "SELECT c FROM Cola c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cola.findByFichasEmitidas", query = "SELECT c FROM Cola c WHERE c.fichasEmitidas = :fichasEmitidas"),
    @NamedQuery(name = "Cola.findByFichaActual", query = "SELECT c FROM Cola c WHERE c.fichaActual = :fichaActual")})
public class Cola implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer id;
    @Column(name = "sigla")
    private String sigla;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fichas_emitidas")
    private Integer fichasEmitidas;
    @Column(name = "ficha_actual")
    private Integer fichaActual;
    @OneToMany(mappedBy = "cola")
    private List<Ficha> fichaList;

    public Cola() {
    }

    public Cola(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFichasEmitidas() {
        return fichasEmitidas;
    }

    public void setFichasEmitidas(Integer fichasEmitidas) {
        this.fichasEmitidas = fichasEmitidas;
    }

    public Integer getFichaActual() {
        return fichaActual;
    }

    public void setFichaActual(Integer fichaActual) {
        this.fichaActual = fichaActual;
    }

    @XmlTransient
    public List<Ficha> getFichaList() {
        return fichaList;
    }

    public void setFichaList(List<Ficha> fichaList) {
        this.fichaList = fichaList;
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
        if (!(object instanceof Cola)) {
            return false;
        }
        Cola other = (Cola) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controlcolas.modelo.Cola[ id=" + id + " ]";
    }
    
}
