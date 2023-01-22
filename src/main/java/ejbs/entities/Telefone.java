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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hecroesmo_wambano
 */
@Entity
@Table(catalog = "ucandb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Telefone.findAll", query = "SELECT t FROM Telefone t"),
    @NamedQuery(name = "Telefone.findByPkTelefone", query = "SELECT t FROM Telefone t WHERE t.pkTelefone = :pkTelefone"),
    @NamedQuery(name = "Telefone.findByContacto", query = "SELECT t FROM Telefone t WHERE t.contacto = :contacto")})
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_telefone", nullable = false)
    private Integer pkTelefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String contacto;
    @JoinColumn(name = "fk_pessoa", referencedColumnName = "pk_pessoa", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa fkPessoa;

    public Telefone() {
    }

    public Telefone(Integer pkTelefone) {
        this.pkTelefone = pkTelefone;
    }

    public Telefone(Integer pkTelefone, String contacto) {
        this.pkTelefone = pkTelefone;
        this.contacto = contacto;
    }

    public Integer getPkTelefone() {
        return pkTelefone;
    }

    public void setPkTelefone(Integer pkTelefone) {
        this.pkTelefone = pkTelefone;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
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
        hash += (pkTelefone != null ? pkTelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        if ((this.pkTelefone == null && other.pkTelefone != null) || (this.pkTelefone != null && !this.pkTelefone.equals(other.pkTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.Telefone[ pkTelefone=" + pkTelefone + " ]";
    }
    
}
