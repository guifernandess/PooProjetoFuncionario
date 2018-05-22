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
public class Funcionario {
    private int idFuncionario;
    private int idDepartamento;
    private String Departamento;
    private String nome;
    private Date dataAdmissao;
    private String endereco;
    private int telefone;
    
    public Funcionario(int idFuncionario, int idDepartamento, String Departamento, String nome, Date dataAdmissao, String endereco, int telefone) {
        this.idFuncionario = idFuncionario;
        this.idDepartamento = idDepartamento;
        this.Departamento = Departamento;
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.endereco = endereco;
        this.telefone = telefone;
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

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }    
}
