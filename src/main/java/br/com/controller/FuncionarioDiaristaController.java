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
    public  void cadastrar(FuncionarioDiarista funcionario) throws Exception {
        try {
            validar(funcionario);
            DaoFuncionarioDiarista.cadastrar(funcionario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public  void alterar(FuncionarioDiarista funcionario) throws Exception {
        try {
            validar(funcionario);
            DaoFuncionarioDiarista.alterar(funcionario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static FuncionarioDiarista obter(int CPF) throws Exception {
        try {
            return DaoFuncionarioDiarista.obter(CPF);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<FuncionarioDiarista> listar() throws Exception {
        try {
            return DaoFuncionarioDiarista.obterList();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void deletar(int id) throws Exception {
        try {
             DaoFuncionarioDiarista.deletar(id);
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
