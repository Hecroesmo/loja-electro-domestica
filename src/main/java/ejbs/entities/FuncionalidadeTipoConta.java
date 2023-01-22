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
@Table(name = "funcionalidade_tipo_conta", catalog = "ucandb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "FuncionalidadeTipoConta.findAll", query = "SELECT f FROM FuncionalidadeTipoConta f"),
    @NamedQuery(name = "FuncionalidadeTipoConta.findByPkFuncionalidadeTipoConta", query = "SELECT f FROM FuncionalidadeTipoConta f WHERE f.pkFuncionalidadeTipoConta = :pkFuncionalidadeTipoConta")})
public class FuncionalidadeTipoConta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_funcionalidade_tipo_conta", nullable = false)
    private Integer pkFuncionalidadeTipoConta;
    @JoinColumn(name = "fk_funcionalidade", referencedColumnName = "pk_funcionalidade", nullable = false)
    @ManyToOne(optional = false)
    private Funcionalidade fkFuncionalidade;
    @JoinColumn(name = "fk_tipo_conta", referencedColumnName = "pk_tipo_conta", nullable = false)
    @ManyToOne(optional = false)
    private TipoConta fkTipoConta;

    public FuncionalidadeTipoConta() {
    }

    public FuncionalidadeTipoConta(Integer pkFuncionalidadeTipoConta) {
        this.pkFuncionalidadeTipoConta = pkFuncionalidadeTipoConta;
    }

    public Integer getPkFuncionalidadeTipoConta() {
        return pkFuncionalidadeTipoConta;
    }

    public void setPkFuncionalidadeTipoConta(Integer pkFuncionalidadeTipoConta) {
        this.pkFuncionalidadeTipoConta = pkFuncionalidadeTipoConta;
    }

    public Funcionalidade getFkFuncionalidade() {
        return fkFuncionalidade;
    }

    public void setFkFuncionalidade(Funcionalidade fkFuncionalidade) {
        this.fkFuncionalidade = fkFuncionalidade;
    }

    public TipoConta getFkTipoConta() {
        return fkTipoConta;
    }

    public void setFkTipoConta(TipoConta fkTipoConta) {
        this.fkTipoConta = fkTipoConta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkFuncionalidadeTipoConta != null ? pkFuncionalidadeTipoConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionalidadeTipoConta)) {
            return false;
        }
        FuncionalidadeTipoConta other = (FuncionalidadeTipoConta) object;
        if ((this.pkFuncionalidadeTipoConta == null && other.pkFuncionalidadeTipoConta != null) || (this.pkFuncionalidadeTipoConta != null && !this.pkFuncionalidadeTipoConta.equals(other.pkFuncionalidadeTipoConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbs.entities.FuncionalidadeTipoConta[ pkFuncionalidadeTipoConta=" + pkFuncionalidadeTipoConta + " ]";
    }
    
}
