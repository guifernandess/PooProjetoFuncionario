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

/**
 *
 * @author Guilherme
 */
/**
public class DaoFuncionarioCLT implements InterfaceCRUD_CLT{

    @Override
    public void cadastrar(Funcionario funcionario) throws Exception{
        // cadastrar Funcionario CLT
        try {          
            Connection conn = SqlConnection.getConexao();
            String sql = "call cadastrar_funcionario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, funcionario.getIdDepartamento());
            stmt.setString(2, funcionario.getDepartamento());
            stmt.setString(3, funcionario.getNome());
            stmt.setDate(4, funcionario.getDataAdmissao());
            stmt.setString(5, funcionario.getEndereco());
            stmt.setInt(6, funcionario.getTelefone());
            stmt.setString(7, funcionario.getFrequencia());
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

    @Override
    public void alterar(Funcionario funcionario) throws Exception{
        try {    
            Connection conn = SqlConnection.getConexao();
            String sql = "call cadastrar_funcionario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.setInt(2, funcionario.getIdDepartamento());
            stmt.setString(3, funcionario.getDepartamento());
            stmt.setString(4, funcionario.getNome());
            stmt.setDate(5, funcionario.getDataAdmissao());
            stmt.setString(6, funcionario.getEndereco());
            stmt.setInt(7, funcionario.getTelefone());
            stmt.setString(8, funcionario.getFrequencia());
            stmt.setInt(9, funcionario.getIdCLT());
            stmt.setInt(10, funcionario.getCPF());
            stmt.setDouble(11, funcionario.getValorRefeicao());
            stmt.setDouble(12, funcionario.getValortransporte());
            stmt.setDate(13, funcionario.getDataNascimento());
            stmt.setInt(14, funcionario.getCTPS());
            stmt.setDouble(15, funcionario.getSalario());            

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Funcionario obter(int idFuncionario) throws Exception{
//            try {
//            FuncionarioCLT funcionario = new FuncionarioCLT();
//            Connection conn = SqlConnection.getConexao();
//            String sql = "call obter_funcionario(?)";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//
//            stmt.setInt(1, idFuncionario);
//
//            ResultSet rs = stmt.executeQuery();
//             while (rs.next()) {
//                funcionario = new Funcionario(
//                        rs.getInt("id_funcionario"),
//                        rs.getInt("id_departamento"),
//                        rs.getString("Departamento"),
//                        rs.getString("nome"), 
//                        rs.getDate("data_nascimento"),
//                        rs.getDate("data_admissao"),
//                        rs.getString("endereco"),
//                        rs.getInt("telefone"),
//                        rs.getString("frequencia"),
//                        rs.getInt("idclt"),
//                        rs.getInt("CPF"),
//                        rs.getDouble("Valor_Refeicao"),
//                        rs.getDouble("Valor_Transporte"),
//                        rs.getDate("data_nascimento"),
//                        rs.getInt("CTPS"),
//                        rs.getDouble("salario"));
//                        
//            }
//            stmt.close();
//            conn.close();
            Funcionario e = new Funcionario();
            return ;
//        } catch (Exception e) {
//            throw e;
//        }
    }

    @Override
    public void deletar(FuncionarioCLT funcionario)throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
*/ 