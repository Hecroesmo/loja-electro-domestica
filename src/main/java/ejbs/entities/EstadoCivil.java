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
@Table(name = "estado_civil", catalog = "ucandb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e"),
    @NamedQuery(name = "EstadoCivil.findByPkEstadoCivil", query = "SELECT e FROM EstadoCivil e WHERE e.pkEstadoCivil = :pkEstadoCivil"),
    @NamedQuery(name = "EstadoCivil.findByDesignacao", query = "SELECT e FROM EstadoCivil e WHERE e.designacao = :designacao")})
public class EstadoCivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_estado_civil", nullable = false)
    private Integer pkEstadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String designacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEstadoCivil")
    private List<Pessoa> pessoaList;

    public EstadoCivil() {
    }

    public EstadoCivil(Integer pkEstadoCivil) {
        this.pkEstadoCivil = pkEstadoCivil;
    }

    public EstadoCivil(Integer pkEstadoCivil, String designacao) {
        this.pkEstadoCivil = pkEstadoCivil;
        this.designacao = designacao;
    }

    public Integer getPkEstadoCivil() {
        return pkEstadoCivil;
    }

    public void setPkEstadoCivil(Integer pkEstadoCivil) {
        this.pkEstadoCivil = pkEstadoCivil;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkEstadoCivil != null ? pkEstadoCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.pkEstadoCivil == null && other.pkEstadoCivil != null) || (this.pkEstadoCivil != null && !this.pkEstadoCivil.equals(other.pkEstadoCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.EstadoCivil[ pkEstadoCivil=" + pkEstadoCivil + " ]";
    }
    
}
