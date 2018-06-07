
package br.com.dao;

import br.com.model.Departamento;
import br.com.model.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class DaoDepartamento {

    public static void cadastrar(Departamento departamento) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "INSERT INTO DEPARTAMENTO (departamento)"
                    + "VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, departamento.getNome());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void atualizar(Departamento departamento) throws ClassNotFoundException, SQLException, Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "update Departamento SET"
                    + "departamento = ? "
                    + "where id_departamento = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, departamento.getNome());
            stmt.setInt(2, departamento.getIdDepartamento());

            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static Departamento obter(int idDepartamento) throws Exception {
        try {
            Departamento departamento = new Departamento();
            Connection conn = SqlConnection.getConexao();
            String sql = "select * FROM Departamento WHERE id_departamento = " + idDepartamento;
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idDepartamento);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                departamento = new Departamento(
                        rs.getInt("id_departamento"),
                        rs.getString("departamento"));
            }
            stmt.close();
            conn.close();

            return departamento;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Departamento> listar() throws Exception {
        try {
            ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
            Connection conn = SqlConnection.getConexao();
            String sql = "select * FROM departamento";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id_departamento = rs.getInt("id_departamento");
                String departamento = rs.getString("nome");

                Departamento d = new Departamento();

                d.setIdDepartamento(id_departamento);
                d.setNome(departamento);

                departamentos.add(d);

                System.out.println("Inseriu na lista!!!");
            }
            stmt.close();
            conn.close();

            return departamentos;
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean deletar(int id) throws Exception {
        boolean deletado = false;
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "delete Departamento where id_departamento = ?";
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
}
