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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Cartao.findAll", query = "SELECT c FROM Cartao c"),
    @NamedQuery(name = "Cartao.findByDesignacao", query = "SELECT c FROM Cartao c WHERE c.designacao = :designacao"),
    @NamedQuery(name = "Cartao.findByPkCartao", query = "SELECT c FROM Cartao c WHERE c.pkCartao = :pkCartao")})
public class Cartao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String designacao;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cartao", nullable = false)
    private Integer pkCartao;

    public Cartao() {
    }

    public Cartao(Integer pkCartao) {
        this.pkCartao = pkCartao;
    }

    public Cartao(Integer pkCartao, String designacao) {
        this.pkCartao = pkCartao;
        this.designacao = designacao;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public Integer getPkCartao() {
        return pkCartao;
    }

    public void setPkCartao(Integer pkCartao) {
        this.pkCartao = pkCartao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCartao != null ? pkCartao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartao)) {
            return false;
        }
        Cartao other = (Cartao) object;
        if ((this.pkCartao == null && other.pkCartao != null) || (this.pkCartao != null && !this.pkCartao.equals(other.pkCartao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.Cartao[ pkCartao=" + pkCartao + " ]";
    }
    
}
