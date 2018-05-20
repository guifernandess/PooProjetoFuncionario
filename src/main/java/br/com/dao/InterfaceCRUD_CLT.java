/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Funcionario;

/**
 *
 * @author Guilherme
 */
public interface InterfaceCRUD_CLT {
    void cadastrar(Funcionario funcionario)throws Exception;
    void alterar(Funcionario funcionario)throws Exception;
    Object obter(int idFuncionario)throws Exception;
    void deletar(Funcionario funcionario)throws Exception;
  
}
