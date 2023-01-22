/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbs.entities;

import java.io.Serializable;
import java.util.List;
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

/**
 *
 * @author hecroesmo_wambano
 */
@Entity
@Table(catalog = "ucandb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByPkStock", query = "SELECT s FROM Stock s WHERE s.pkStock = :pkStock"),
    @NamedQuery(name = "Stock.findByQuantidade", query = "SELECT s FROM Stock s WHERE s.quantidade = :quantidade"),
    @NamedQuery(name = "Stock.findByLimiteMaximo", query = "SELECT s FROM Stock s WHERE s.limiteMaximo = :limiteMaximo")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_stock", nullable = false)
    private Integer pkStock;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int quantidade;
    @Column(name = "limite_maximo")
    private Integer limiteMaximo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkStock")
    private List<Montra> montraList;
    @JoinColumn(name = "fk_produto", referencedColumnName = "pk_produto", nullable = false)
    @ManyToOne(optional = false)
    private Produto fkProduto;

    public Stock() {
    }

    public Stock(Integer pkStock) {
        this.pkStock = pkStock;
    }

    public Stock(Integer pkStock, int quantidade) {
        this.pkStock = pkStock;
        this.quantidade = quantidade;
    }

    public Integer getPkStock() {
        return pkStock;
    }

    public void setPkStock(Integer pkStock) {
        this.pkStock = pkStock;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getLimiteMaximo() {
        return limiteMaximo;
    }

    public void setLimiteMaximo(Integer limiteMaximo) {
        this.limiteMaximo = limiteMaximo;
    }

    public List<Montra> getMontraList() {
        return montraList;
    }

    public void setMontraList(List<Montra> montraList) {
        this.montraList = montraList;
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
        hash += (pkStock != null ? pkStock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.pkStock == null && other.pkStock != null) || (this.pkStock != null && !this.pkStock.equals(other.pkStock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.Stock[ pkStock=" + pkStock + " ]";
    }
    
}
