/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;
import br.com.dao.DaoFuncionarioCLT;
import br.com.model.FuncionarioCLT;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
/**
 *
 * @author Guilherme
 */
public class FuncionarioCLTController {
    
    public  static void cadastrar (FuncionarioCLT funcionario) throws Exception{
       try {
            validar(funcionario);
            cadastrar(funcionario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void deletar(int id) throws Exception {
       /* try {
            DaoFuncionario.deletar(id);
        } catch (Exception e) {
            throw e;
        }*/
    }
    
    private static void validar(FuncionarioCLT funcionario) throws Exception {
        try {
            if (funcionario.getNome() == null || funcionario.getNome().trim().isEmpty()) {
                throw new Exception("Campo Nome vazio");
            }
            validarCPF(funcionario.getCPF());

            if (funcionario.getIdDepartamento() <= 0){
                throw new Exception("Departamento inválido");
            }
            
        } catch (Exception e) {
            throw e;
        }
    }

    private static void validarCPF(int CPF) throws Exception {
        try {
            if (!(Integer.toString(CPF).length() == 11)) {
                throw new Exception("CPF inválido");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
