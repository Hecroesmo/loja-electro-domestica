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
import javax.validation.constraints.Size;

/**
 *
 * @author hecroesmo_wambano
 */
@Entity
@Table(catalog = "ucandb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findByPkEndereco", query = "SELECT e FROM Endereco e WHERE e.pkEndereco = :pkEndereco"),
    @NamedQuery(name = "Endereco.findByBairro", query = "SELECT e FROM Endereco e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "Endereco.findByCasa", query = "SELECT e FROM Endereco e WHERE e.casa = :casa"),
    @NamedQuery(name = "Endereco.findByRua", query = "SELECT e FROM Endereco e WHERE e.rua = :rua")})
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_endereco", nullable = false)
    private Integer pkEndereco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int casa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String rua;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEndereco")
    private List<Pessoa> pessoaList;
    @JoinColumn(name = "fk_localidade", referencedColumnName = "pk_localidade", nullable = false)
    @ManyToOne(optional = false)
    private Localidade fkLocalidade;

    public Endereco() {
    }

    public Endereco(Integer pkEndereco) {
        this.pkEndereco = pkEndereco;
    }

    public Endereco(Integer pkEndereco, String bairro, int casa, String rua) {
        this.pkEndereco = pkEndereco;
        this.bairro = bairro;
        this.casa = casa;
        this.rua = rua;
    }

    public Integer getPkEndereco() {
        return pkEndereco;
    }

    public void setPkEndereco(Integer pkEndereco) {
        this.pkEndereco = pkEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCasa() {
        return casa;
    }

    public void setCasa(int casa) {
        this.casa = casa;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
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
        hash += (pkEndereco != null ? pkEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.pkEndereco == null && other.pkEndereco != null) || (this.pkEndereco != null && !this.pkEndereco.equals(other.pkEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.Endereco[ pkEndereco=" + pkEndereco + " ]";
    }
    
}
