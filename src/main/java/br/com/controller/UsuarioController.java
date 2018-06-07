/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.model.Departamento;
import br.com.dao.DaoDepartamento;
import br.com.dao.DaoUsuario;
import br.com.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class UsuarioController {
    
    static DaoUsuario dao = new DaoUsuario();
    
    public  void cadastrar(Usuario usuario) throws Exception {
        try {
            validar(usuario);
            dao.cadastrar(usuario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public  void alterar(Usuario usuario) throws Exception {
        try {
            validar(usuario);
            dao.atualizar(usuario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public  Usuario obter(int idUsuario) throws Exception {
        try {
            return dao.obter(idUsuario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<Usuario> listar() throws Exception {
        try {
            return dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static boolean deletar(int id) throws Exception {
        try {
            return dao.deletar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public  int selectId (String login) throws Exception {
        try {
            return dao.selectId(login);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void validar(Usuario usuario) throws Exception {
        try {
            if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
                throw new Exception("usuario vazio");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
