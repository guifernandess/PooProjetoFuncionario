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
public class FuncionarioCLT extends Funcionario {

    private int idCLT;
    private int CPF;
    private double valorRefeicao;
    private double valortransporte;
    private Date dataNascimento;
    private double salario;

    public FuncionarioCLT(int idFuncionario, int idDepartamento, String Departamento, String nome, Date dataAdmissao, String endereco, int telefone
                         ,int idCLT, int CPF, double valorRefeicao, double valortransporte, Date dataNascimento, double salario  ) {
        super(idFuncionario, idDepartamento, Departamento, nome, dataAdmissao, endereco, telefone);
        
    }

    public FuncionarioCLT(int idCLT, int CPF, double valorRefeicao, double valortransporte, Date dataNascimento, double salario, int idFuncionario, int idDepartamento, String Departamento, String nome, Date dataAdmissao, String endereco, int telefone) {
        super(idFuncionario, idDepartamento, Departamento, nome, dataAdmissao, endereco, telefone);
        this.idCLT = idCLT;
        this.CPF = CPF;
        this.valorRefeicao = valorRefeicao;
        this.valortransporte = valortransporte;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
    }

    public FuncionarioCLT() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Double calcValorFalta(int qtdFalta, FuncionarioCLT clt) {
        double auxValorDia = this.salario / 30;
        return qtdFalta * auxValorDia;
    }

    public int getIdCLT() {
        return idCLT;
    }

    public void setIdCLT(int idCLT) {
        this.idCLT = idCLT;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public double getValorRefeicao() {
        return valorRefeicao;
    }

    public void setValorRefeicao(double valorRefeicao) {
        this.valorRefeicao = valorRefeicao;
    }

    public double getValortransporte() {
        return valortransporte;
    }

    public void setValortransporte(double valortransporte) {
        this.valortransporte = valortransporte;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
