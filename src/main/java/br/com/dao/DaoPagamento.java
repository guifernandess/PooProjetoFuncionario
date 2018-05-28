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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class DaoPagamento {

    public static void cadastrar(Pagamento pagamento) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "INSERT INTO PAGAMENTO (Id_funcionario, id_departamento, data_pagamento, valor_pagamento)"
                    + "VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, pagamento.getIdFuncionario());
            stmt.setInt(2, pagamento.getIdDepartamento());
            stmt.setDate(3, pagamento.getDataPagamento());
            stmt.setDouble(4, pagamento.getValorPagamento());

            stmt.executeUpdate();
            conn.close();

            stmt.close();
            conn.close();

        } catch (Exception e) {
            throw e;
        }
    }

    public static Pagamento obterPagamento(int idPagamento) throws Exception {
        try {
            Pagamento pagamento = null;
            Connection conn = SqlConnection.getConexao();
            String sql = "select * FROM PAGAMENTO WHERE id = " + idPagamento;
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idPagamento);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pagamento = new Pagamento(
                        rs.getInt("id_pagamento"),
                        rs.getInt("Id_funcionario"),
                        rs.getDate("data_pagamento"),
                        rs.getInt("id_departamento"),
                        rs.getDouble("valor_pagamento"));
            }
            stmt.close();
            conn.close();

            return pagamento;
        } catch (Exception e) {
            throw e;
        }
    }

    public static List<Pagamento> listar() throws Exception {

        List<Pagamento> lista = new ArrayList<Pagamento>();
        try {
            Pagamento pagamento = null;
            Connection conn = SqlConnection.getConexao();
            String sql = "select * FROM PAGAMENTO";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idPagamento = rs.getInt("id_pagamento");
                int idFuncionario = rs.getInt("Id_funcionario");
                Date dataPagamento = rs.getDate("data_pagamento");
                int idDepartamento = rs.getInt("id_departamento");
                double valorPagamento = rs.getDouble("valor_pagamento");

                Pagamento p = new Pagamento();

                p.setIdPagamento(idPagamento);
                p.setIdFuncionario(idFuncionario);
                p.setDataPagamento((java.sql.Date) dataPagamento);
                p.setIdDepartamento(idDepartamento);
                p.setValorPagamento(valorPagamento);

                lista.add(p);

                System.out.println("Inseriu na lista!!!");
            }
            stmt.close();
            conn.close();

            return lista;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void atualizar (Pagamento p) throws ClassNotFoundException, SQLException, Exception {
        try {
           Connection conn = SqlConnection.getConexao();
           PreparedStatement stmt = conn.prepareStatement("update Pagamento SET"
                   + "data_pagamento = ?, valor_pagamento = ?"
                   + "where id_pagamento = ? ");
           
           stmt.setDate(1, p.getDataPagamento());
           stmt.setDouble(2, p.getValorPagamento());
           stmt.setInt(3, p.getIdPagamento());
           
           stmt.executeUpdate();
           
           conn.close();
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public static boolean excluir(int id) throws ClassNotFoundException, SQLException, Exception {
        boolean deletado = false;
        try {
           Connection conn = SqlConnection.getConexao();
           PreparedStatement stmt = conn.prepareStatement(
                   "DELETE Pagamento WHERE = ?");
       
           stmt.setInt(1, id);
           
           stmt.executeUpdate();
           deletado = true;
           conn.close();           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return deletado;
    }
    
}
