/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class Pagamento {

    private int idPagamento;
    private Funcionario funcionario;
    private Date dataPagamento;
    private Departamento departamento;

public Pagamento(int idPagamento, Funcionario funcionario,Date dataPagamento, Departamento departamento) {
        this.idPagamento = idPagamento;
        this.funcionario = funcionario;
        this.dataPagamento = dataPagamento;
        this.departamento = departamento;
    }

    public Pagamento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
}
