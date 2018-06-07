/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.model.FuncionarioCLT;
import br.com.dao.DaoFuncionarioCLT;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class FuncionarioCLTController {
    
    static DaoFuncionarioCLT dao = new DaoFuncionarioCLT();
    
    public  void cadastrar(FuncionarioCLT funcionario) throws Exception {
        try {
            validar(funcionario);
            dao.cadastrar(funcionario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public  void alterar(FuncionarioCLT funcionario) throws Exception {
        try {
            validar(funcionario);
            dao.alterar(funcionario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static FuncionarioCLT obter(int CPF) throws Exception {
        try {
            return dao.obter(CPF);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<FuncionarioCLT> listar() throws Exception {
        try {
            return dao.obterList();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void deletar(int id) throws Exception {
        try {
             dao.deletar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void validar(FuncionarioCLT funcionario) throws Exception {
        try {
            if (funcionario.getNome() == null || funcionario.getDepartamento().trim().isEmpty()) {
                throw new Exception("funcionario invalido");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
