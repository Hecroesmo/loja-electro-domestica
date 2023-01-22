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
@Table(catalog = "ucandb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByPkFuncionario", query = "SELECT f FROM Funcionario f WHERE f.pkFuncionario = :pkFuncionario")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_funcionario", nullable = false)
    private Integer pkFuncionario;
    @JoinColumn(name = "fk_pessoa", referencedColumnName = "pk_pessoa", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa fkPessoa;

    public Funcionario() {
    }

    public Funcionario(Integer pkFuncionario) {
        this.pkFuncionario = pkFuncionario;
    }

    public Integer getPkFuncionario() {
        return pkFuncionario;
    }

    public void setPkFuncionario(Integer pkFuncionario) {
        this.pkFuncionario = pkFuncionario;
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
        hash += (pkFuncionario != null ? pkFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.pkFuncionario == null && other.pkFuncionario != null) || (this.pkFuncionario != null && !this.pkFuncionario.equals(other.pkFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.Funcionario[ pkFuncionario=" + pkFuncionario + " ]";
    }
    
}
