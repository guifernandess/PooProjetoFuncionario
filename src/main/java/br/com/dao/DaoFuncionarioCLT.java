/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.interfaces.InterfaceDaoClt;
import br.com.model.Funcionario;
import br.com.model.FuncionarioCLT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DaoFuncionarioCLT implements InterfaceDaoClt{

    private FuncionarioCLT funcionario;
    
    @Override
    public void cadastrar(FuncionarioCLT funcionario) throws Exception {
        
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "INSERT INTO FUNCIONARIO_CLT (id_funcionario, cpf, valor_refeicao, valor_transporte, data_nascimento, salario)"
                    + "VALUES (?,?,?,?,?,?)";
               PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.setInt(2, funcionario.getCPF());
            stmt.setDouble(3, funcionario.getValorRefeicao());
            stmt.setDouble(4, funcionario.getValortransporte());
            stmt.setDate(5, funcionario.getDataNascimento());
            stmt.setDouble(6, funcionario.getSalario());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public void alterar(FuncionarioCLT funcionario) throws Exception, SQLException {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "UPDATE FUNCIONARIO_CLT SET"
                    + "cpf = ?, valor_refeicao = ?, valor_transporte = ?, data_nascimento = ?, salario = ?"
                    + "where id_funcionario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, funcionario.getCPF());
            stmt.setDouble(2, funcionario.getValorRefeicao());
            stmt.setDouble(3, funcionario.getValortransporte());
            stmt.setDate(4, funcionario.getDataNascimento());
            stmt.setDouble(5, funcionario.getSalario());
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
    public FuncionarioCLT obter(int CPF) throws Exception {
        try {
            FuncionarioCLT funcionario = new FuncionarioCLT();
            Connection conn = SqlConnection.getConexao();
            String sql = "select f.id_funcionario, f.id_departamento, f.departamento, f.nome, f.data_nascimento, f.endereco, f.telefone"
                    + ",c.id_clt, c.cpf, c.valor_Refeicao, c.valor_transporte, c.data_nascimento, c.salario  "
                    + "FROM Funcionario f"
                    + "inner join funcionario_clt c "
                    + "on c.id_funcionario = f.id_funcionario"
                    + "WHERE c.CPF = " + CPF;
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, CPF);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                funcionario = new FuncionarioCLT(
                        rs.getInt("id_funcionario"),
                        rs.getInt("id_departamento"),
                        rs.getString("Departamento"),
                        rs.getString("nome"),
                        rs.getDate("data_nascimento"),
                        rs.getString("endereco"),
                        rs.getInt("telefone"),
                        rs.getInt("idclt"),
                        rs.getInt("CPF"),
                        rs.getDouble("Valor_Refeicao"),
                        rs.getDouble("Valor_Transporte"),
                        rs.getDate("data_nascimento"),
                        rs.getDouble("salario"));

            }
            stmt.close();
            conn.close();
            
            return funcionario;
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    @Override
    public ArrayList<FuncionarioCLT> obterList() throws Exception {
        try {
            ArrayList<FuncionarioCLT> funcionarios = new ArrayList<FuncionarioCLT>();
            Connection conn = SqlConnection.getConexao();
            String sql = "select f.id_funcionario, f.id_departamento, f.departamento, f.nome, f.data_nascimento, f.endereco, f.telefone"
                    + ",c.id_clt, c.cpf, c.valor_Refeicao, c.valor_transporte, c.data_nascimento, c.salario  "
                    + "FROM Funcionario f"
                    + "inner join funcionario_clt c "
                    + "on c.id_funcionario = f.id_funcionario";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                funcionarios.add( new FuncionarioCLT(
                        rs.getInt("id_funcionario"),
                        rs.getInt("id_departamento"),
                        rs.getString("Departamento"),
                        rs.getString("nome"),
                        rs.getDate("data_nascimento"),
                        rs.getString("endereco"),
                        rs.getInt("telefone"),
                        rs.getInt("idclt"),
                        rs.getInt("CPF"),
                        rs.getDouble("Valor_Refeicao"),
                        rs.getDouble("Valor_Transporte"),
                        rs.getDate("data_nascimento"),
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
    public void deletar(int CPF) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "delete Funcionario_CLT where CPF = ?";
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