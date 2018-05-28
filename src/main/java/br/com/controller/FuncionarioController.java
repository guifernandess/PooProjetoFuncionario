/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.DaoFuncionario;
import br.com.model.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class FuncionarioController {
    public void cadastrar(Funcionario funcionario) throws Exception {
        try {
            validar(funcionario);
            DaoFuncionario.cadastrar(funcionario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void alterar(Funcionario funcionario) throws Exception {
        try {
            validar(funcionario);
            DaoFuncionario.alterar(funcionario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Funcionario obter(int idFuncionario) throws Exception {
        try {
            return DaoFuncionario.obter(idFuncionario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<Funcionario> listar() throws Exception {
        try {
            return DaoFuncionario.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static boolean deletar(int id) throws Exception {
        try {
            return DaoFuncionario.deletar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void validar(Funcionario funcionario) throws Exception {
        try {
            if (funcionario.getNome() == null || funcionario.getDepartamento().trim().isEmpty()) {
                throw new Exception("funcionario invalido");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
