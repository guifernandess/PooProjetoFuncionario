/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.model.Pagamento;

/**
 *
 * @author Guilherme
 */
public class DaoPagamento {
    public static void cadastrar(Pagamento pagamento) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call cadastrar_pagamento (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, pagamento.getFuncionario().getIdFuncionario());
            stmt.setInt(2, pagamento.getDepartamento().getIdDepartamento());

            ResultSet rs = stmt.executeQuery();
            rs.last();
            pagamento.setIdPagamento(rs.getInt(1));

            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            throw e;
        }
    }
    /*
    public static Pagamento obterVenda(int idPagamento) throws Exception {
        try {
            Pagamento pagamento = new Pagamento();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_pagamento(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idPagamento);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pagamento = new Pagamento(
                        rs.getInt("id_pagamento"),
                        DaoFuncionario.obter(rs.getInt("id_funcionario")),
                        DaoFilial.obter(rs.getInt("id_filial")),
                        rs.getDate("data_venda"),
                        DaoItemVenda.obter(idVenda));
            }
            stmt.close();
            conn.close();

            return venda;
        } catch (Exception e) {
            throw e;
        }
    }*/
}
