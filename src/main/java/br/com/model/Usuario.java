/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author guilherme.frocha6
 */
public class Usuario {
    private int idUsuario;
    private String login;
    private String nome;
    private String senha;
    private int hierarquia;
    private String Cargo;

    public Usuario(int idUsuario, String login, String nome, String senha, int hierarquia, String Cargo) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.hierarquia = hierarquia;
        this.Cargo = Cargo;
    }

    

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    
    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getHierarquia() {
        return hierarquia;
    }

    public void setHierarquia(int hierarquia) {
        this.hierarquia = hierarquia;
    }
    
    
    
}
