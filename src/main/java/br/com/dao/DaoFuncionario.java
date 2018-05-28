
package br.com.dao;

import br.com.model.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class DaoFuncionario {

    public static void cadastrar(Funcionario funcionario) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "INSERT INTO FUNCIONARIO(ID_DEPARTAMENTO, DEPARTAMENTO, NOME, DATA_ADMISSAO,ENDERECO, TELEFONE)"
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, funcionario.getIdDepartamento());
            stmt.setString(2, funcionario.getDepartamento());
            stmt.setString(3, funcionario.getNome());
            stmt.setDate(4, funcionario.getDataAdmissao());
            stmt.setString(5, funcionario.getEndereco());
            stmt.setInt(6, funcionario.getTelefone());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterar(Funcionario funcionario) throws Exception, SQLException {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "UPDATE FUNCIONARIO SET"
                    + "ID_DEPARTAMENTO = ?, DEPARTAMENTO = ?, NOME = ?, DATA_ADMISSAO = ?,ENDERECO = ?, TELEFONE = ?"
                    + "WHERE ID_FUNCIONARIO = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, funcionario.getIdDepartamento());
            stmt.setString(2, funcionario.getDepartamento());
            stmt.setString(3, funcionario.getNome());
            stmt.setDate(4, funcionario.getDataAdmissao());
            stmt.setString(5, funcionario.getEndereco());
            stmt.setInt(6, funcionario.getTelefone());
            stmt.setInt(7, funcionario.getIdFuncionario());

            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static Funcionario obter(int idFuncionario) throws Exception {
        try {
            Funcionario funcionario = new Funcionario();
            Connection conn = SqlConnection.getConexao();
            String sql = "select * FROM Funcionario WHERE id_funcionario = " + idFuncionario;

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idFuncionario);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                funcionario = new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getInt("id_departamento"),
                        rs.getString("Departamento"),
                        rs.getString("Nome"),
                        rs.getDate("data_admissao"),
                        rs.getString("endereco"),
                        rs.getInt("telefone"));
            }
            stmt.close();
            conn.close();

            return funcionario;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Funcionario> listar() throws Exception {
        try {
            ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
            Connection conn = SqlConnection.getConexao();
            String sql = "select * FROM funcionario";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id_funcionario = rs.getInt("id_funcionario");
                int id_departamento = rs.getInt("id_departamento");
                String departamento = rs.getString("Departamento");
                String nome = rs.getString("Nome");
                Date data_admissao = rs.getDate("data_admissao");
                String endereco = rs.getString("endereco");
                int telefone = rs.getInt("telefone");

                Funcionario f = new Funcionario();

                f.setIdFuncionario(id_funcionario);
                f.setIdDepartamento(id_departamento);
                f.setDepartamento(departamento);
                f.setNome(nome);
                f.setDataAdmissao(data_admissao);
                f.setEndereco(endereco);
                f.setTelefone(telefone);

                funcionarios.add(f);

                System.out.println("Inseriu na lista..");
            }
            stmt.close();
            conn.close();

            return funcionarios;
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean deletar(int id) throws Exception {
        boolean deletado = false;
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "delete Funcionario where id_funcionario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

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

    public static int selectId(String nome) throws ClassNotFoundException, SQLException, Exception {

        Funcionario funcionario = new Funcionario();

        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "SELECT id_funcionario"
                    + "FROM Funcionario"
                    + "where nome = " + nome;
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet resultados = stmt.executeQuery();
            while (resultados.next()) {
                int idP = resultados.getInt("id_funcionario");
                System.out.println("Esse é o id: " + idP);
                funcionario.setIdFuncionario(idP);

            }
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return funcionario.getIdFuncionario();
    }
}
