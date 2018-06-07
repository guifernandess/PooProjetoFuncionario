/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.interfaces.InterfaceDaoDiarista;
import br.com.model.FuncionarioDiarista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class DaoFuncionarioDiarista implements InterfaceDaoDiarista{
   
    @Override
    public void cadastrar(FuncionarioDiarista funcionario) throws Exception, SQLException {

        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "INSERT INTO FUNCIONARIO_DIARISTA (id_funcionario, cpf, valor_refeicao, valor_transporte, data_nascimento, valor_dia)"
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.setInt(2, funcionario.getCPF());
            stmt.setDouble(3, funcionario.getValorRefeicao());
            stmt.setDouble(4, funcionario.getValorTransporte());
            stmt.setDate(5, funcionario.getDataNascimento());
            stmt.setDouble(6, funcionario.getValorDiario());

            stmt.execute();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void alterar(FuncionarioDiarista funcionario) throws Exception, SQLException {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "UPDATE FUNCIONARIO_DIARISTA SET"
                    + "cpf = ?, valor_refeicao = ?, valor_transporte = ?, data_nascimento = ?, valor_dia = ?"
                    + "where id_funcionario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, funcionario.getCPF());
            stmt.setDouble(2, funcionario.getValorRefeicao());
            stmt.setDouble(3, funcionario.getValorTransporte());
            stmt.setDate(4, funcionario.getDataNascimento());
            stmt.setDouble(5, funcionario.getValorDiario());
            stmt.setInt(6, funcionario.getIdFuncionario());

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
    public FuncionarioDiarista obter(int CPF) throws Exception, SQLException {
        try {
            FuncionarioDiarista funcionario = new FuncionarioDiarista();
            Connection conn = SqlConnection.getConexao();
            String sql = "select f.id_funcionario, f.id_departamento, f.departamento, f.nome, f.data_nascimento, f.endereco, f.telefone"
                    + ",d.id_diarista, d.cpf, d.valor_Refeicao, d.valor_transporte, d.data_nascimento, d.valor_dia"
                    + "FROM Funcionario f"
                    + "inner join funcionario_diarista d "
                    + "on d.id_funcionario = f.id_funcionario"
                    + "WHERE d.CPF = " + CPF;
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, CPF);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                funcionario = new FuncionarioDiarista(
                        rs.getInt("id_funcionario"),
                        rs.getInt("id_departamento"),
                        rs.getString("Departamento"),
                        rs.getString("nome"),
                        rs.getDate("data_admissao"),
                        rs.getString("endereco"),
                        rs.getInt("telefone"),
                        rs.getInt("id_diarista"),
                        rs.getInt("CPF"),
                        rs.getDate("data_nascimento"),
                        rs.getDouble("Valor_Refeicao"),
                        rs.getDouble("Valor_Transporte"),
                        rs.getDouble("valor_dia "));
            }
            stmt.close();
            conn.close();
            
            return funcionario;
        } catch (Exception e) {
            throw e;
        }
        
        
    }

    @Override
    public ArrayList<FuncionarioDiarista> obterList() throws Exception, SQLException {
        try {
            ArrayList<FuncionarioDiarista> funcionarios = new ArrayList<FuncionarioDiarista>();
            Connection conn = SqlConnection.getConexao();
            String sql = "select f.id_funcionario, f.id_departamento, f.departamento, f.nome, f.data_nascimento, f.endereco, f.telefone"
                    + ",d.id_diarista, d.cpf, d.valor_Refeicao, d.valor_transporte, d.data_nascimento, d.valor_dia"
                    + "FROM Funcionario f"
                    + "inner join funcionario_diarista d "
                    + "on d.id_funcionario = f.id_funcionario";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                funcionarios.add( new FuncionarioDiarista(
                        rs.getInt("id_funcionario"),
                        rs.getInt("id_departamento"),
                        rs.getString("Departamento"),
                        rs.getString("nome"),
                        rs.getDate("data_nascimento"),
                        rs.getString("endereco"),
                        rs.getInt("telefone"),
                        rs.getInt("id_diarista"),
                        rs.getInt("CPF"),
                        rs.getDate("data_nascimento"),
                        rs.getDouble("valor_refeicao"),
                        rs.getDouble("Valor_Transporte"),                        
                        rs.getDouble("salario")));
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
            String sql = "delete Funcionario_diarista where CPF = ?";
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
