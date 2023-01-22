/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbs.entities;

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
import javax.validation.constraints.NotNull;

/**
 *
 * @author hecroesmo_wambano
 */
@Entity
@Table(catalog = "ucandb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Preco.findAll", query = "SELECT p FROM Preco p"),
    @NamedQuery(name = "Preco.findByDataUpdatePreco", query = "SELECT p FROM Preco p WHERE p.dataUpdatePreco = :dataUpdatePreco"),
    @NamedQuery(name = "Preco.findByValor", query = "SELECT p FROM Preco p WHERE p.valor = :valor"),
    @NamedQuery(name = "Preco.findByPkPreco", query = "SELECT p FROM Preco p WHERE p.pkPreco = :pkPreco")})
public class Preco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_update_preco", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataUpdatePreco;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double valor;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_preco", nullable = false)
    private Integer pkPreco;
    @JoinColumn(name = "fk_produto", referencedColumnName = "pk_produto", nullable = false)
    @ManyToOne(optional = false)
    private Produto fkProduto;

    public Preco() {
    }

    public Preco(Integer pkPreco) {
        this.pkPreco = pkPreco;
    }

    public Preco(Integer pkPreco, Date dataUpdatePreco, double valor) {
        this.pkPreco = pkPreco;
        this.dataUpdatePreco = dataUpdatePreco;
        this.valor = valor;
    }

    public Date getDataUpdatePreco() {
        return dataUpdatePreco;
    }

    public void setDataUpdatePreco(Date dataUpdatePreco) {
        this.dataUpdatePreco = dataUpdatePreco;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getPkPreco() {
        return pkPreco;
    }

    public void setPkPreco(Integer pkPreco) {
        this.pkPreco = pkPreco;
    }

    public Produto getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(Produto fkProduto) {
        this.fkProduto = fkProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkPreco != null ? pkPreco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preco)) {
            return false;
        }
        Preco other = (Preco) object;
        if ((this.pkPreco == null && other.pkPreco != null) || (this.pkPreco != null && !this.pkPreco.equals(other.pkPreco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.Preco[ pkPreco=" + pkPreco + " ]";
    }
    
}
