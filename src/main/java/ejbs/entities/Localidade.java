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
    @NamedQuery(name = "Localidade.findAll", query = "SELECT l FROM Localidade l"),
    @NamedQuery(name = "Localidade.findByPkLocalidade", query = "SELECT l FROM Localidade l WHERE l.pkLocalidade = :pkLocalidade"),
    @NamedQuery(name = "Localidade.findByDesignacao", query = "SELECT l FROM Localidade l WHERE l.designacao = :designacao"),
    @NamedQuery(name = "Localidade.findByEhComuna", query = "SELECT l FROM Localidade l WHERE l.ehComuna = :ehComuna")})
public class Localidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "pk_localidade", nullable = false, length = 2147483647)
    private String pkLocalidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String designacao;
    @Column(name = "eh_comuna")
    private Boolean ehComuna;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkNacionalidade")
    private List<Pessoa> pessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkLocalidade")
    private List<Endereco> enderecoList;
    @OneToMany(mappedBy = "fkLocalidade")
    private List<Localidade> localidadeList;
    @JoinColumn(name = "fk_localidade", referencedColumnName = "pk_localidade")
    @ManyToOne
    private Localidade fkLocalidade;

    public Localidade() {
    }

    public Localidade(String pkLocalidade) {
        this.pkLocalidade = pkLocalidade;
    }

    public Localidade(String pkLocalidade, String designacao) {
        this.pkLocalidade = pkLocalidade;
        this.designacao = designacao;
    }

    public String getPkLocalidade() {
        return pkLocalidade;
    }

    public void setPkLocalidade(String pkLocalidade) {
        this.pkLocalidade = pkLocalidade;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public Boolean getEhComuna() {
        return ehComuna;
    }

    public void setEhComuna(Boolean ehComuna) {
        this.ehComuna = ehComuna;
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    public List<Localidade> getLocalidadeList() {
        return localidadeList;
    }

    public void setLocalidadeList(List<Localidade> localidadeList) {
        this.localidadeList = localidadeList;
    }

    public Localidade getFkLocalidade() {
        return fkLocalidade;
    }

    public void setFkLocalidade(Localidade fkLocalidade) {
        this.fkLocalidade = fkLocalidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkLocalidade != null ? pkLocalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidade)) {
            return false;
        }
        Localidade other = (Localidade) object;
        if ((this.pkLocalidade == null && other.pkLocalidade != null) || (this.pkLocalidade != null && !this.pkLocalidade.equals(other.pkLocalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.Localidade[ pkLocalidade=" + pkLocalidade + " ]";
    }
    
}
