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

/**
 *
 * @author hecroesmo_wambano
 */
@Entity
@Table(catalog = "ucandb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByPkFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.pkFornecedor = :pkFornecedor")})
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_fornecedor", nullable = false)
    private Integer pkFornecedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkFornecedor")
    private List<FornecedorProduto> fornecedorProdutoList;
    @JoinColumn(name = "fk_pessoa", referencedColumnName = "pk_pessoa", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa fkPessoa;

    public Fornecedor() {
    }

    public Fornecedor(Integer pkFornecedor) {
        this.pkFornecedor = pkFornecedor;
    }

    public Integer getPkFornecedor() {
        return pkFornecedor;
    }

    public void setPkFornecedor(Integer pkFornecedor) {
        this.pkFornecedor = pkFornecedor;
    }

    public List<FornecedorProduto> getFornecedorProdutoList() {
        return fornecedorProdutoList;
    }

    public void setFornecedorProdutoList(List<FornecedorProduto> fornecedorProdutoList) {
        this.fornecedorProdutoList = fornecedorProdutoList;
    }

    public Pessoa getFkPessoa() {
        return fkPessoa;
    }

    public void setFkPessoa(Pessoa fkPessoa) {
        this.fkPessoa = fkPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkFornecedor != null ? pkFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.pkFornecedor == null && other.pkFornecedor != null) || (this.pkFornecedor != null && !this.pkFornecedor.equals(other.pkFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.Fornecedor[ pkFornecedor=" + pkFornecedor + " ]";
    }
    
}
