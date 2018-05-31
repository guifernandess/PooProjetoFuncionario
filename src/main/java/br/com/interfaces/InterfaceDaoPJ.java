/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.model.FuncionarioCLT;
import br.com.model.FuncionarioPJ;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Guilherme
 */
public interface InterfaceDaoPJ {
    void cadastrar(FuncionarioPJ pj)throws Exception, SQLException;
    void alterar(FuncionarioPJ pj)throws Exception, SQLException;
    FuncionarioPJ obter(int CPF)throws Exception, SQLException;
    ArrayList<FuncionarioPJ> obterList() throws Exception, SQLException;
    void deletar(int CPF)throws Exception, SQLException;
}
