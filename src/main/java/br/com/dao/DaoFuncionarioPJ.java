/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.interfaces.InterfaceDaoPJ;
import br.com.model.FuncionarioPJ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Guilherme
 */
public class DaoFuncionarioPJ implements InterfaceDaoPJ{

    @Override
    public void cadastrar(FuncionarioPJ pj) throws Exception, SQLException {
         try {
            Connection conn = SqlConnection.getConexao();
            String sql = "INSERT INTO FUNCIONARIO_PJ (id_funcionario, cnpj, valor_hora, quantidade_hora, tempo_contrato)"
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, pj.getIdFuncionario());
            stmt.setInt(2, pj.getCNPJ());
            stmt.setDouble(3, pj.getValorHora());
            stmt.setInt(4, pj.getQtdHora());
            stmt.setString(5, pj.getTempoContrato());
            
            stmt.execute();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void alterar(FuncionarioPJ pj) throws Exception, SQLException {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "UPDATE FUNCIONARIO_PJ SET"
                    + " cnpj = ?, valor_hora = ?, quantidade_hora = ?, tempo_contrato = ?"
                    + "where id_funcionario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, pj.getCNPJ());
            stmt.setDouble(2, pj.getValorHora());
            stmt.setInt(3, pj.getQtdHora());
            stmt.setString(4, pj.getTempoContrato());
            stmt.setInt(5, pj.getIdFuncionario());

            stmt.execute();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public FuncionarioPJ obter(int CPF) throws Exception, SQLException {
        try {
            FuncionarioPJ funcionario = new FuncionarioPJ();
            Connection conn = SqlConnection.getConexao();
            String sql = "select f.id_funcionario, f.id_departamento, f.departamento, f.nome, f.data_admissao, f.endereco, f.telefone"
                    + ",d.id_pj, d.cnpj, d.valor_hora, d.quantidade_hora, d.tempo_contrato"
                    + "FROM Funcionario f"
                    + "inner join funcionario_pj d "
                    + "on d.id_funcionario = f.id_funcionario"
                    + "WHERE d.CNPJ = " + CPF;
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, CPF);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                funcionario = new FuncionarioPJ(
                        rs.getInt("id_funcionario"),
                        rs.getInt("id_departamento"),
                        rs.getString("Departamento"),
                        rs.getString("nome"),
                        rs.getDate("data_admissao"),
                        rs.getString("endereco"),
                        rs.getInt("telefone"),
                        rs.getInt("id_pj"),
                        rs.getInt("CNPJ"),
                        rs.getDouble("valor_hora"),
                        rs.getInt("quantidade_hora"),
                        rs.getString("tempo_contrato "));
            }
            stmt.close();
            conn.close();
            
            return funcionario;
        } catch (Exception e) {
            throw e;
        }
        
        
    }

    @Override
    public ArrayList<FuncionarioPJ> obterList() throws Exception, SQLException {
        try {
            ArrayList<FuncionarioPJ> funcionarios = new ArrayList<FuncionarioPJ>();
            Connection conn = SqlConnection.getConexao();
            String sql = "select f.id_funcionario, f.id_departamento, f.departamento, f.nome, f.data_admissao, f.endereco, f.telefone"
                    + ",d.id_pj, d.cnpj, d.valor_hora, d.quantidade_hora, d.tempo_contrato"
                    + "FROM Funcionario f"
                    + "inner join funcionario_pj d "
                    + "on d.id_funcionario = f.id_funcionario";
            
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                funcionarios.add( new FuncionarioPJ(
                        rs.getInt("id_funcionario"),
                        rs.getInt("id_departamento"),
                        rs.getString("Departamento"),
                        rs.getString("nome"),
                        rs.getDate("data_admissao"),
                        rs.getString("endereco"),
                        rs.getInt("telefone"),
                        rs.getInt("id_pj"),
                        rs.getInt("CNPJ"),
                        rs.getDouble("valor_hora"),
                        rs.getInt("quantidade_hora"),                        
                        rs.getString("tempo_contrato")));
            }
            stmt.close();
            conn.close();

            return funcionarios;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deletar(int CPF) throws Exception, SQLException {
         try {
            Connection conn = SqlConnection.getConexao();
            String sql = "delete Funcionario_pj where CNPJ = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, CPF);
            stmt.execute();
            
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
}
