/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Departamento;
import br.com.model.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Guilherme
 */
public class DaoDepartamento {
    public static void cadastrar(Departamento departamento) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call cadastrar_departamento(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, departamento.getNome());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void alterar(Departamento departamento) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call alterar_filial(?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, departamento.getIdDepartamento());
            stmt.setString(2, departamento.getNome());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Departamento obter(int idDepartamento) throws Exception {
        try {
            Departamento departamento = new Departamento();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_departamento(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idDepartamento);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                departamento = new Departamento(
                        rs.getInt("id_departamento"),
                        rs.getString("nome"));
            }
            stmt.close();
            conn.close();

            return departamento;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<Departamento> obter() throws Exception {
        try {
            ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_departamentos()";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                departamentos.add(new Departamento(
                        rs.getInt("id_departamento"),
                        rs.getString("nome")));
            }
            stmt.close();
            conn.close();

            return departamentos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void deletar(int id) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call remover_departamento(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    
}
