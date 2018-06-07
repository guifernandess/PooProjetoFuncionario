/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.DaoFuncionarioDiarista;
import br.com.model.FuncionarioDiarista;
import java.util.ArrayList;
/**
 *
 * @author Guilherme
 */
public class FuncionarioDiaristaController {
    
    static DaoFuncionarioDiarista dao = new DaoFuncionarioDiarista();
    public  void cadastrar(FuncionarioDiarista funcionario) throws Exception {
        try {
            validar(funcionario);
            dao.cadastrar(funcionario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public  void alterar(FuncionarioDiarista funcionario) throws Exception {
        try {
            validar(funcionario);
            dao.alterar(funcionario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static FuncionarioDiarista obter(int CPF) throws Exception {
        try {
            return dao.obter(CPF);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<FuncionarioDiarista> listar() throws Exception {
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
    
    private static void validar(FuncionarioDiarista funcionario) throws Exception {
        try {
            if (funcionario.getNome() == null || funcionario.getDepartamento().trim().isEmpty()) {
                throw new Exception("funcionario invalido");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
