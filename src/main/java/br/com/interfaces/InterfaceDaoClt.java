/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.model.FuncionarioCLT;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public interface InterfaceDaoClt {
    public void cadastrar(FuncionarioCLT funcionario)throws Exception, SQLException;
    public void alterar(FuncionarioCLT funcionario)throws Exception, SQLException;
    public FuncionarioCLT obter(int CPF)throws Exception, SQLException;
    public ArrayList<FuncionarioCLT> obterList() throws Exception, SQLException;
    public void deletar(int CPF)throws Exception, SQLException;
}
