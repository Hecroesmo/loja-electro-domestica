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
import javax.validation.constraints.NotNull;

/**
 *
 * @author hecroesmo_wambano
 */
@Entity
@Table(name = "item_venda", catalog = "ucandb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ItemVenda.findAll", query = "SELECT i FROM ItemVenda i"),
    @NamedQuery(name = "ItemVenda.findByQuantidade", query = "SELECT i FROM ItemVenda i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "ItemVenda.findByPkItemVenda", query = "SELECT i FROM ItemVenda i WHERE i.pkItemVenda = :pkItemVenda")})
public class ItemVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int quantidade;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_item_venda", nullable = false)
    private Integer pkItemVenda;
    @JoinColumn(name = "fk_produto", referencedColumnName = "pk_produto", nullable = false)
    @ManyToOne(optional = false)
    private Produto fkProduto;
    @JoinColumn(name = "fk_venda", referencedColumnName = "pk_venda", nullable = false)
    @ManyToOne(optional = false)
    private Venda fkVenda;

    public ItemVenda() {
    }

    public ItemVenda(Integer pkItemVenda) {
        this.pkItemVenda = pkItemVenda;
    }

    public ItemVenda(Integer pkItemVenda, int quantidade) {
        this.pkItemVenda = pkItemVenda;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getPkItemVenda() {
        return pkItemVenda;
    }

    public void setPkItemVenda(Integer pkItemVenda) {
        this.pkItemVenda = pkItemVenda;
    }

    public Produto getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(Produto fkProduto) {
        this.fkProduto = fkProduto;
    }

    public Venda getFkVenda() {
        return fkVenda;
    }

    public void setFkVenda(Venda fkVenda) {
        this.fkVenda = fkVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkItemVenda != null ? pkItemVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemVenda)) {
            return false;
        }
        ItemVenda other = (ItemVenda) object;
        if ((this.pkItemVenda == null && other.pkItemVenda != null) || (this.pkItemVenda != null && !this.pkItemVenda.equals(other.pkItemVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.ItemVenda[ pkItemVenda=" + pkItemVenda + " ]";
    }
    
}
