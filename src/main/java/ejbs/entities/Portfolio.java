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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hecroesmo_wambano
 */
@Entity
@Table(catalog = "ucandb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Portfolio.findAll", query = "SELECT p FROM Portfolio p"),
    @NamedQuery(name = "Portfolio.findByPkPortfolio", query = "SELECT p FROM Portfolio p WHERE p.pkPortfolio = :pkPortfolio"),
    @NamedQuery(name = "Portfolio.findByDesignacao", query = "SELECT p FROM Portfolio p WHERE p.designacao = :designacao")})
public class Portfolio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "pk_portfolio", nullable = false, length = 2147483647)
    private String pkPortfolio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String designacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPortfolio")
    private List<Produto> produtoList;
    @OneToMany(mappedBy = "fkPortfolio")
    private List<Portfolio> portfolioList;
    @JoinColumn(name = "fk_portfolio", referencedColumnName = "pk_portfolio")
    @ManyToOne
    private Portfolio fkPortfolio;

    public Portfolio() {
    }

    public Portfolio(String pkPortfolio) {
        this.pkPortfolio = pkPortfolio;
    }

    public Portfolio(String pkPortfolio, String designacao) {
        this.pkPortfolio = pkPortfolio;
        this.designacao = designacao;
    }

    public String getPkPortfolio() {
        return pkPortfolio;
    }

    public void setPkPortfolio(String pkPortfolio) {
        this.pkPortfolio = pkPortfolio;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public List<Portfolio> getPortfolioList() {
        return portfolioList;
    }

    public void setPortfolioList(List<Portfolio> portfolioList) {
        this.portfolioList = portfolioList;
    }

    public Portfolio getFkPortfolio() {
        return fkPortfolio;
    }

    public void setFkPortfolio(Portfolio fkPortfolio) {
        this.fkPortfolio = fkPortfolio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkPortfolio != null ? pkPortfolio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Portfolio)) {
            return false;
        }
        Portfolio other = (Portfolio) object;
        if ((this.pkPortfolio == null && other.pkPortfolio != null) || (this.pkPortfolio != null && !this.pkPortfolio.equals(other.pkPortfolio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.Portfolio[ pkPortfolio=" + pkPortfolio + " ]";
    }
    
}
