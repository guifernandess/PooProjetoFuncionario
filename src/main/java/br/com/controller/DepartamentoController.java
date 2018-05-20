/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.model.Departamento;
import br.com.dao.DaoDepartamento;
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
            DaoDepartamento.alterar(departamento);
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

    public static ArrayList<Departamento> obter() throws Exception {
        try {
            return DaoDepartamento.obter();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void deletar(int id) throws Exception {
        try {
            DaoDepartamento.deletar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void validar(Departamento departamento) throws Exception {
        try {
            if (departamento.getNome()== null || departamento.getNome().trim().isEmpty()) {
                throw new Exception("Nome do Departamento está vazio");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
