/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.DaoDepartamento;
import br.com.dao.DaoFuncionario;
import br.com.model.Departamento;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class DepartamentoController {

    public static void cadastrar(Departamento departamento) throws Exception {
        try {
            validar(departamento);
            DaoDepartamento.cadastrar(departamento);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void alterar(Departamento departamento) throws Exception {
        try {
            validar(departamento);
            DaoDepartamento.atualizar(departamento);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Departamento obter(int idDepartamento) throws Exception {
        try {
            return DaoDepartamento.obter(idDepartamento);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<Departamento> listar() throws Exception {
        try {
            return DaoDepartamento.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static boolean deletar(int id) throws Exception {
        try {
            return DaoDepartamento.deletar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static int selectId (String nome) throws Exception {
        try {
            return DaoFuncionario.selectId(nome);
        } catch (Exception e) {
            throw e;
        }
    }
            
    
    private static void validar(Departamento departamento) throws Exception {
        try {
            if (departamento.getNome() == null || departamento.getNome().trim().isEmpty()) {
                throw new Exception("departamento vazio");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
