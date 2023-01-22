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
    @NamedQuery(name = "Funcionalidade.findAll", query = "SELECT f FROM Funcionalidade f"),
    @NamedQuery(name = "Funcionalidade.findByPkFuncionalidade", query = "SELECT f FROM Funcionalidade f WHERE f.pkFuncionalidade = :pkFuncionalidade"),
    @NamedQuery(name = "Funcionalidade.findByDesignacao", query = "SELECT f FROM Funcionalidade f WHERE f.designacao = :designacao")})
public class Funcionalidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_funcionalidade", nullable = false)
    private Integer pkFuncionalidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String designacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkFuncionalidade")
    private List<FuncionalidadeTipoConta> funcionalidadeTipoContaList;

    public Funcionalidade() {
    }

    public Funcionalidade(Integer pkFuncionalidade) {
        this.pkFuncionalidade = pkFuncionalidade;
    }

    public Funcionalidade(Integer pkFuncionalidade, String designacao) {
        this.pkFuncionalidade = pkFuncionalidade;
        this.designacao = designacao;
    }

    public Integer getPkFuncionalidade() {
        return pkFuncionalidade;
    }

    public void setPkFuncionalidade(Integer pkFuncionalidade) {
        this.pkFuncionalidade = pkFuncionalidade;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public List<FuncionalidadeTipoConta> getFuncionalidadeTipoContaList() {
        return funcionalidadeTipoContaList;
    }

    public void setFuncionalidadeTipoContaList(List<FuncionalidadeTipoConta> funcionalidadeTipoContaList) {
        this.funcionalidadeTipoContaList = funcionalidadeTipoContaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkFuncionalidade != null ? pkFuncionalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionalidade)) {
            return false;
        }
        Funcionalidade other = (Funcionalidade) object;
        if ((this.pkFuncionalidade == null && other.pkFuncionalidade != null) || (this.pkFuncionalidade != null && !this.pkFuncionalidade.equals(other.pkFuncionalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.Funcionalidade[ pkFuncionalidade=" + pkFuncionalidade + " ]";
    }
    
}
