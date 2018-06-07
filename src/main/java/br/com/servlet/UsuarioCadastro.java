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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
@WebServlet(name = "UsuarioCadastro", urlPatterns = {"/cadastro-usuario"})
public class UsuarioCadastro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        if (usuario == null) {
            response.sendRedirect("index.jsp");
        } else {
            if (usuario.getHierarquia() < 1) {
                response.sendRedirect("index.jsp");
            }
        }
        
        request.getRequestDispatcher("WEB-INF/Usuario/form-usuario-cadastro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        if (usuario == null) {
            response.sendRedirect("index.jsp");
        } else {
            if (usuario.getHierarquia() < 1) {
                response.sendRedirect("index.jsp");
            }
        }
        
        UsuarioController con = new UsuarioController();
        
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String hierarquia = request.getParameter("hierarquia");
        String cargo = request.getParameter("cargo");
        
        Usuario usu = new Usuario();
        usu.setNome(nome);
        usu.setLogin(login);
        usu.setSenha(senha);
        usu.setHierarquia(Integer.parseInt(hierarquia));
        usu.setCargo(cargo);
        
        try {
            
            con.cadastrar(usu);   
            
        } catch (Exception ex) {
            System.out.println("Erro no objeto");
        }
        
        request.setAttribute("UsuarioCadastrado", usu);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/Usuario/resultadoCadastro.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
