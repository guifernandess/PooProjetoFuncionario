/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.DaoDepartamento;
import br.com.dao.DaoPagamento;
import br.com.model.Pagamento;
/**
 *
 * @author Guilherme
 */
public class PagamentoController {
    
    public static void cadastrar(Pagamento pagamento) throws Exception {
        try {
            DaoPagamento.cadastrar(pagamento);
        } catch (Exception e) {
            throw e;
        }
    }
    /*
    public static Pagamento obterVenda(int idVenda) throws Exception {
        try {
            return DaoPagamento.obterVenda(idVenda);
        } catch (Exception e) {
            throw e;
        }
    } */
    
    private static void validar(Pagamento pagamento) throws Exception {
        try {
    
            if (pagamento.getFuncionario().getIdFuncionario() <= 0) {
                throw new Exception("Funcionario inválido");
            }
            if (pagamento.getDepartamento().getIdDepartamento()<= 0) {
                throw new Exception("Departamento inválido");
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
