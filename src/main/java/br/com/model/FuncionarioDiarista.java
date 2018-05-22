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

    public FuncionarioDiarista(int idFuncionario, int idDepartamento, String Departamento, String nome, Date dataAdmissao, String endereco, int telefone) {
        super(idFuncionario, idDepartamento, Departamento, nome, dataAdmissao, endereco, telefone);
    }

    public Double calcVR(int qtdDias, FuncionarioDiarista funcionario) {
        return qtdDias * this.valorRefeicao;
    }

    public Double calcVT(int qtdDias, FuncionarioDiarista funcionario) {
        return qtdDias * this.valorTransporte;
    }
}
