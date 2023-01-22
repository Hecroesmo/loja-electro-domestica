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
import javax.validation.constraints.Size;

/**
 *
 * @author hecroesmo_wambano
 */
@Entity
@Table(catalog = "ucandb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByPkProduto", query = "SELECT p FROM Produto p WHERE p.pkProduto = :pkProduto"),
    @NamedQuery(name = "Produto.findByImagem", query = "SELECT p FROM Produto p WHERE p.imagem = :imagem")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_produto", nullable = false)
    private Integer pkProduto;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String imagem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProduto")
    private List<Preco> precoList;
    @JoinColumn(name = "fk_portfolio", referencedColumnName = "pk_portfolio", nullable = false)
    @ManyToOne(optional = false)
    private Portfolio fkPortfolio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProduto")
    private List<FornecedorProduto> fornecedorProdutoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProduto")
    private List<ItemVenda> itemVendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProduto")
    private List<Stock> stockList;

    public Produto() {
    }

    public Produto(Integer pkProduto) {
        this.pkProduto = pkProduto;
    }

    public Integer getPkProduto() {
        return pkProduto;
    }

    public void setPkProduto(Integer pkProduto) {
        this.pkProduto = pkProduto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public List<Preco> getPrecoList() {
        return precoList;
    }

    public void setPrecoList(List<Preco> precoList) {
        this.precoList = precoList;
    }

    public Portfolio getFkPortfolio() {
        return fkPortfolio;
    }

    public void setFkPortfolio(Portfolio fkPortfolio) {
        this.fkPortfolio = fkPortfolio;
    }

    public List<FornecedorProduto> getFornecedorProdutoList() {
        return fornecedorProdutoList;
    }

    public void setFornecedorProdutoList(List<FornecedorProduto> fornecedorProdutoList) {
        this.fornecedorProdutoList = fornecedorProdutoList;
    }

    public List<ItemVenda> getItemVendaList() {
        return itemVendaList;
    }

    public void setItemVendaList(List<ItemVenda> itemVendaList) {
        this.itemVendaList = itemVendaList;
    }

    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProduto != null ? pkProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.pkProduto == null && other.pkProduto != null) || (this.pkProduto != null && !this.pkProduto.equals(other.pkProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.Produto[ pkProduto=" + pkProduto + " ]";
    }
    
}
