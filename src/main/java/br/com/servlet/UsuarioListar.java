/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.model.Usuario;
import br.com.controller.UsuarioController;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
@WebServlet(name = "UsuarioListar", urlPatterns = {"/UsuarioListar"})
public class UsuarioListar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsuarioController conn = new UsuarioController();
        List<Usuario> lista = new ArrayList<Usuario>();
        
        try {

            lista = conn.listar();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            //validar erro
            System.out.println(ex);
        }
        
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("WEB-INF/Usuario/ListarUsuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
