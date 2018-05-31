/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.model.FuncionarioDiarista;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Guilherme
 */
public interface  InterfaceDaoDiarista {
    public void cadastrar(FuncionarioDiarista funcionario)throws Exception, SQLException;
    public void alterar(FuncionarioDiarista funcionario)throws Exception, SQLException;
    public FuncionarioDiarista obter(int CPF)throws Exception, SQLException;
    public ArrayList<FuncionarioDiarista> obterList() throws Exception, SQLException;
    public void deletar(int CPF)throws Exception, SQLException;
}
