/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbs.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hecroesmo_wambano
 */
@Entity
@Table(catalog = "ucandb", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"bi"})})
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email"),
    @NamedQuery(name = "Pessoa.findByDataNascimento", query = "SELECT p FROM Pessoa p WHERE p.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Pessoa.findByDataCadastro", query = "SELECT p FROM Pessoa p WHERE p.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Pessoa.findByPkPessoa", query = "SELECT p FROM Pessoa p WHERE p.pkPessoa = :pkPessoa"),
    @NamedQuery(name = "Pessoa.findByBi", query = "SELECT p FROM Pessoa p WHERE p.bi = :bi")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cadastro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_pessoa", nullable = false)
    private Integer pkPessoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String bi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPessoa")
    private List<Telefone> telefoneList;
    @JoinColumn(name = "fk_endereco", referencedColumnName = "pk_endereco", nullable = false)
    @ManyToOne(optional = false)
    private Endereco fkEndereco;
    @JoinColumn(name = "fk_estado_civil", referencedColumnName = "pk_estado_civil", nullable = false)
    @ManyToOne(optional = false)
    private EstadoCivil fkEstadoCivil;
    @JoinColumn(name = "fk_nacionalidade", referencedColumnName = "pk_localidade", nullable = false)
    @ManyToOne(optional = false)
    private Localidade fkNacionalidade;
    @JoinColumn(name = "fk_sexo", referencedColumnName = "pk_sexo", nullable = false)
    @ManyToOne(optional = false)
    private Sexo fkSexo;
    @OneToMany(mappedBy = "fkPessoa")
    private List<Conta> contaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPessoa")
    private List<Cliente> clienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPessoa")
    private List<Fornecedor> fornecedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPessoa")
    private List<Funcionario> funcionarioList;

    public Pessoa() {
    }

    public Pessoa(Integer pkPessoa) {
        this.pkPessoa = pkPessoa;
    }

    public Pessoa(Integer pkPessoa, String nome, String email, Date dataNascimento, Date dataCadastro, String bi) {
        this.pkPessoa = pkPessoa;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.bi = bi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getPkPessoa() {
        return pkPessoa;
    }

    public void setPkPessoa(Integer pkPessoa) {
        this.pkPessoa = pkPessoa;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public List<Telefone> getTelefoneList() {
        return telefoneList;
    }

    public void setTelefoneList(List<Telefone> telefoneList) {
        this.telefoneList = telefoneList;
    }

    public Endereco getFkEndereco() {
        return fkEndereco;
    }

    public void setFkEndereco(Endereco fkEndereco) {
        this.fkEndereco = fkEndereco;
    }

    public EstadoCivil getFkEstadoCivil() {
        return fkEstadoCivil;
    }

    public void setFkEstadoCivil(EstadoCivil fkEstadoCivil) {
        this.fkEstadoCivil = fkEstadoCivil;
    }

    public Localidade getFkNacionalidade() {
        return fkNacionalidade;
    }

    public void setFkNacionalidade(Localidade fkNacionalidade) {
        this.fkNacionalidade = fkNacionalidade;
    }

    public Sexo getFkSexo() {
        return fkSexo;
    }

    public void setFkSexo(Sexo fkSexo) {
        this.fkSexo = fkSexo;
    }

    public List<Conta> getContaList() {
        return contaList;
    }

    public void setContaList(List<Conta> contaList) {
        this.contaList = contaList;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public List<Fornecedor> getFornecedorList() {
        return fornecedorList;
    }

    public void setFornecedorList(List<Fornecedor> fornecedorList) {
        this.fornecedorList = fornecedorList;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkPessoa != null ? pkPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.pkPessoa == null && other.pkPessoa != null) || (this.pkPessoa != null && !this.pkPessoa.equals(other.pkPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.Pessoa[ pkPessoa=" + pkPessoa + " ]";
    }
    
}
