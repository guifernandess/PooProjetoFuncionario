/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.sql.Date;

/**
 *
 * @author Guilherme
 */
public class FuncionarioPJ extends Funcionario{
    private int idPJ;
    private int CNPJ;
    private double valorHora;
    private int qtdHora;
    private String tempoContrato;
    
    public FuncionarioPJ(int idFuncionario, int idDepartamento, String Departamento, String nome, Date dataAdmissao, String endereco, int telefone) {
        super(idFuncionario, idDepartamento, Departamento, nome, dataAdmissao, endereco, telefone);

        this.idPJ = idPJ;
        this.CNPJ = CNPJ;
        this.valorHora = valorHora;
        this.qtdHora = qtdHora;
        this.tempoContrato = tempoContrato;
        
    }

    public FuncionarioPJ() {     
    }

    public FuncionarioPJ(int aInt, int aInt0, String string, String string0, Date date, String string1, int aInt1, int aInt2, int aInt3, double aDouble, int aInt4, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    

    public int getIdPJ() {
        return idPJ;
    }

    public void setIdPJ(int idPJ) {
        this.idPJ = idPJ;
    }

    public int getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(int CNPJ) {
        this.CNPJ = CNPJ;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getQtdHora() {
        return qtdHora;
    }

    public void setQtdHora(int qtdHora) {
        this.qtdHora = qtdHora;
    }

    public String getTempoContrato() {
        return tempoContrato;
    }

    public void setTempoContrato(String tempoContrato) {
        this.tempoContrato = tempoContrato;
    }
    
    public Double calcValorTotalHora(FuncionarioPJ pj){
        return this.qtdHora * this.valorHora;
    }
}
