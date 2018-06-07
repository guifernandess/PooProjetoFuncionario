/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Departamento;
import br.com.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class DaoUsuario {

    public static void cadastrar(Usuario usuario) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "INSERT INTO Usuario (nome, login, senha, hierarquia, Cargo)"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getHierarquia());
            stmt.setString(5, usuario.getCargo());

            stmt.execute();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            throw e;
        }
    }

    public void atualizar(Usuario usuario) throws ClassNotFoundException, SQLException, Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "update Departamento SET"
                    + "nome = ?, login = ?, senha = ?, hierarquia = ?, Cargo = ? "
                    + "where id_usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getHierarquia());
            stmt.setString(5, usuario.getCargo());
            stmt.setInt(6, usuario.getIdUsuario());

            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static Usuario obter(int idUsuario) throws Exception {
        try {
            Usuario usuario = new Usuario();
            Connection conn = SqlConnection.getConexao();
            String sql = "select * FROM Usuario WHERE id_usuario = " + idUsuario;
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idUsuario);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getInt("hierarquia"),
                        rs.getString("departamento"));
            }
            stmt.close();
            conn.close();

            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Usuario> listar() throws Exception {
        try {
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            Connection conn = SqlConnection.getConexao();
            String sql = "select * FROM usuario";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String nome = rs.getString("nome");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                int hierarquia = rs.getInt("hierarquia");
                String cargo = rs.getString("cargo");
                
                

                Usuario d = new Usuario();

                d.setIdUsuario(id_usuario);
                d.setNome(nome);
                d.setLogin(login);
                d.setSenha(senha);
                d.setHierarquia(hierarquia);
                d.setCargo(cargo);

                usuarios.add(d);

                System.out.println("Inseriu na lista!!!");
            }
            stmt.close();
            conn.close();

            return usuarios;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public int selectId(String login) throws ClassNotFoundException, SQLException, Exception {
        
        Usuario usuario = new Usuario();
        
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "SELECT id_usuario"
                    + "FROM usuario"
                    + "where login = " + login;
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet resultados = stmt.executeQuery();
            while (resultados.next()) {
                int idP = resultados.getInt("id_usuario");
                System.out.println("Esse é o id: " + idP);
                usuario.setIdUsuario(idP);

            }
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return usuario.getIdUsuario();
    }
    
    public static boolean deletar(int id) throws Exception {
        boolean deletado = false;
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "delete Usuario where id_usuario = ?";
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

