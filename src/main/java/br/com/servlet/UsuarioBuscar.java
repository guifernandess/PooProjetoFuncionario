/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.controller.UsuarioController;
import br.com.model.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
@WebServlet(name = "UsuarioBuscar", urlPatterns = {"/buscar-usario"})
public class UsuarioBuscar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idusuario = request.getParameter("idusuario");
        
        int id = Integer.parseInt(idusuario.substring(1, 2));
        
        UsuarioController con1 = new UsuarioController();
        Usuario usu = new Usuario();
        
         try {
            usu = con1.obter(id);
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }

        request.setAttribute("UsuarioAtualizado", usu);

        request.getRequestDispatcher("WEB-INF/Usuario/form-usuario-resultado.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
