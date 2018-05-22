/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Funcionario;
import br.com.model.FuncionarioCLT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */

public class DaoFuncionarioCLT {

    private FuncionarioCLT funcionario;

    public void cadastrar(FuncionarioCLT funcionario) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call cadastrar_funcionario(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, funcionario.getIdDepartamento());
            stmt.setString(2, funcionario.getDepartamento());
            stmt.setString(3, funcionario.getNome());
            stmt.setDate(4, funcionario.getDataAdmissao());
            stmt.setString(5, funcionario.getEndereco());
            stmt.setInt(6, funcionario.getTelefone());
            stmt.setInt(7, funcionario.getIdCLT());
            stmt.setInt(8, funcionario.getCPF());
            stmt.setDouble(9, funcionario.getValorRefeicao());
            stmt.setDouble(10, funcionario.getValortransporte());
            stmt.setDate(10, funcionario.getDataNascimento());
            stmt.setInt(12, funcionario.getCTPS());
            stmt.setDouble(13, funcionario.getSalario());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public void alterar(FuncionarioCLT funcionario) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call cadastrar_funcionario(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.setInt(2, funcionario.getIdDepartamento());
            stmt.setString(3, funcionario.getDepartamento());
            stmt.setString(4, funcionario.getNome());
            stmt.setDate(5, funcionario.getDataAdmissao());
            stmt.setString(6, funcionario.getEndereco());
            stmt.setInt(7, funcionario.getTelefone());
            stmt.setInt(8, funcionario.getIdCLT());
            stmt.setInt(9, funcionario.getCPF());
            stmt.setDouble(10, funcionario.getValorRefeicao());
            stmt.setDouble(11, funcionario.getValortransporte());
            stmt.setDate(12, funcionario.getDataNascimento());
            stmt.setInt(13, funcionario.getCTPS());
            stmt.setDouble(14, funcionario.getSalario());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public FuncionarioCLT obter(int CPF) throws Exception {
        try {
            FuncionarioCLT funcionario;
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_funcionarioCLT(?)";
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
                        rs.getInt("CTPS"),
                        rs.getDouble("salario"));

            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            throw e;
        }
        return funcionario;
    }
    
    public static ArrayList<FuncionarioCLT> obterList() throws Exception {
        try {
            ArrayList<FuncionarioCLT> funcionarios = new ArrayList<FuncionarioCLT>();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_funcionariosCLTs()";
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
                        rs.getInt("CTPS"),
                        rs.getDouble("salario")));
            }
            stmt.close();
            conn.close();

            return funcionarios;
        } catch (Exception e) {
            throw e;
        }
    }


    public void deletar(int id) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call remover_funcionario(?)";
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