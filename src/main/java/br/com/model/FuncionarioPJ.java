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
    
    public FuncionarioPJ(int idFuncionario, int idDepartamento, String Departamento, String nome, Date dataAdmissao, String endereco, int telefone, String frequencia) {
        super(idFuncionario, idDepartamento, Departamento, nome, dataAdmissao, endereco, telefone, frequencia);
    }
    
    public Double calcValorTotalHora(FuncionarioPJ pj){
        return this.qtdHora * this.valorHora;
    }
}
