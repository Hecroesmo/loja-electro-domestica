/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbs.entities;

import java.io.Serializable;
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

/**
 *
 * @author hecroesmo_wambano
 */
@Entity
@Table(catalog = "ucandb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Montra.findAll", query = "SELECT m FROM Montra m"),
    @NamedQuery(name = "Montra.findByPkMontra", query = "SELECT m FROM Montra m WHERE m.pkMontra = :pkMontra")})
public class Montra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_montra", nullable = false)
    private Integer pkMontra;
    @JoinColumn(name = "fk_stock", referencedColumnName = "pk_stock", nullable = false)
    @ManyToOne(optional = false)
    private Stock fkStock;

    public Montra() {
    }

    public Montra(Integer pkMontra) {
        this.pkMontra = pkMontra;
    }

    public Integer getPkMontra() {
        return pkMontra;
    }

    public void setPkMontra(Integer pkMontra) {
        this.pkMontra = pkMontra;
    }

    public Stock getFkStock() {
        return fkStock;
    }

    public void setFkStock(Stock fkStock) {
        this.fkStock = fkStock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkMontra != null ? pkMontra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Montra)) {
            return false;
        }
        Montra other = (Montra) object;
        if ((this.pkMontra == null && other.pkMontra != null) || (this.pkMontra != null && !this.pkMontra.equals(other.pkMontra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.Montra[ pkMontra=" + pkMontra + " ]";
    }
    
}
