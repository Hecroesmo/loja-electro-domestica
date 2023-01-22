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
@Table(name = "fornecedor_produto", catalog = "ucandb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "FornecedorProduto.findAll", query = "SELECT f FROM FornecedorProduto f"),
    @NamedQuery(name = "FornecedorProduto.findByPkFornecedorProduto", query = "SELECT f FROM FornecedorProduto f WHERE f.pkFornecedorProduto = :pkFornecedorProduto")})
public class FornecedorProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_fornecedor_produto", nullable = false)
    private Integer pkFornecedorProduto;
    @JoinColumn(name = "fk_fornecedor", referencedColumnName = "pk_fornecedor", nullable = false)
    @ManyToOne(optional = false)
    private Fornecedor fkFornecedor;
    @JoinColumn(name = "fk_produto", referencedColumnName = "pk_produto", nullable = false)
    @ManyToOne(optional = false)
    private Produto fkProduto;

    public FornecedorProduto() {
    }

    public FornecedorProduto(Integer pkFornecedorProduto) {
        this.pkFornecedorProduto = pkFornecedorProduto;
    }

    public Integer getPkFornecedorProduto() {
        return pkFornecedorProduto;
    }

    public void setPkFornecedorProduto(Integer pkFornecedorProduto) {
        this.pkFornecedorProduto = pkFornecedorProduto;
    }

    public Fornecedor getFkFornecedor() {
        return fkFornecedor;
    }

    public void setFkFornecedor(Fornecedor fkFornecedor) {
        this.fkFornecedor = fkFornecedor;
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
        hash += (pkFornecedorProduto != null ? pkFornecedorProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FornecedorProduto)) {
            return false;
        }
        FornecedorProduto other = (FornecedorProduto) object;
        if ((this.pkFornecedorProduto == null && other.pkFornecedorProduto != null) || (this.pkFornecedorProduto != null && !this.pkFornecedorProduto.equals(other.pkFornecedorProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.FornecedorProduto[ pkFornecedorProduto=" + pkFornecedorProduto + " ]";
    }
    
}
