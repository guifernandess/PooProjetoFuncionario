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
    private int idFuncionario;
    private int idDepartamento;
    private Date dataPagamento;
    private double valorPagamento;

    public Pagamento(int idPagamento, int funcionario, Date dataPagamento, int departamento, double valorPagamento) {
        this.idPagamento = idPagamento;
        this.idFuncionario = funcionario;
        this.dataPagamento = dataPagamento;
        this.idDepartamento = departamento;
        this.valorPagamento = valorPagamento;
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

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    
    
}
