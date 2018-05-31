/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.model.FuncionarioPJ;
import br.com.dao.DaoFuncionarioPJ;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class FuncionarioPJController {
    public  void cadastrar(FuncionarioPJ funcionario) throws Exception {
        try {
            validar(funcionario);
            DaoFuncionarioPJ.cadastrar(funcionario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public  void alterar(FuncionarioPJ funcionario) throws Exception {
        try {
            validar(funcionario);
            DaoFuncionarioPJ.alterar(funcionario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static FuncionarioPJ obter(int CPF) throws Exception {
        try {
            return DaoFuncionarioPJ.obter(CPF);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<FuncionarioPJ> listar() throws Exception {
        try {
            return DaoFuncionarioPJ.obterList();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void deletar(int id) throws Exception {
        try {
             DaoFuncionarioPJ.deletar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void validar(FuncionarioPJ funcionario) throws Exception {
        try {
            if (funcionario.getNome() == null || funcionario.getDepartamento().trim().isEmpty()) {
                throw new Exception("funcionario invalido");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
