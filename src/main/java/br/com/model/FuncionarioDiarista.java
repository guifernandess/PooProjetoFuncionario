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
public class FuncionarioDiarista extends Funcionario {

    private int idDiarista;
    private int CPF;
    private Date dataNascimento;
    private double valorRefeicao;
    private double valorTransporte;
    private double valorDiario;
    private int qtdDias;

    public FuncionarioDiarista(int idFuncionario, int idDepartamento, String Departamento, String nome, Date dataAdmissao, String endereco, int telefone) {
        super(idFuncionario, idDepartamento, Departamento, nome, dataAdmissao, endereco, telefone);
    }

    public FuncionarioDiarista(int aInt, int aInt0, String string, String string0, Date date, String string1, int aInt1, int aInt2, int aInt3, Date date0, double aDouble, double aDouble0, double aDouble1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public FuncionarioDiarista (){
    }
    
    public FuncionarioDiarista(int idDiarista, int CPF, Date dataNascimento, double valorRefeicao, double valorTransporte, double valorDiario, int idFuncionario, int idDepartamento, String Departamento, String nome, Date dataAdmissao, String endereco, int telefone) {
        super(idFuncionario, idDepartamento, Departamento, nome, dataAdmissao, endereco, telefone);
        this.idDiarista = idDiarista;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.valorRefeicao = valorRefeicao;
        this.valorTransporte = valorTransporte;
        this.valorDiario = valorDiario;
    }

    public FuncionarioDiarista(int idDiarista, int CPF, Date dataNascimento, double valorRefeicao, double valorTransporte, double valorDiario) {
        this.idDiarista = idDiarista;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.valorRefeicao = valorRefeicao;
        this.valorTransporte = valorTransporte;
        this.valorDiario = valorDiario;
    }
    
    

    public int getIdDiarista() {
        return idDiarista;
    }

    public void setIdDiarista(int idDiarista) {
        this.idDiarista = idDiarista;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getValorRefeicao() {
        return valorRefeicao;
    }

    public void setValorRefeicao(double valorRefeicao) {
        this.valorRefeicao = valorRefeicao;
    }

    public double getValorTransporte() {
        return valorTransporte;
    }

    public void setValorTransporte(double valorTransporte) {
        this.valorTransporte = valorTransporte;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }

    public int getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(int qtdDias) {
        this.qtdDias = qtdDias;
    }
    
    
    public Double calcVR() {
       return getQtdDias() * getValorRefeicao();
    }

    public Double calcVT() {
        return getQtdDias() * getValorTransporte();
    }
    
    public Double calcValor() {
        return getQtdDias() * getValorDiario();
    }
    
    @Override
    public Double calcPagamento () {
        double aux = calcValor() + calcVR() + calcVT();
        return aux;
    }
    
}
