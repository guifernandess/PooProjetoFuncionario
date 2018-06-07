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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
@WebServlet(name = "UsuarioAtualizar", urlPatterns = {"/UsuarioAtualizar"})
public class UsuarioAtualizar extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        
        String idUsuario = request.getParameter("idUsuario");
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String hierarquia = request.getParameter("hierarquia");
        String cargo = request.getParameter("cargo");
        
        String metodo = request.getParameter("metodo");
        
        Usuario usu = new Usuario();
        usu.setIdUsuario(Integer.parseInt(idUsuario));
        usu.setNome(nome);
        usu.setLogin(login);
        usu.setSenha(senha);
        usu.setHierarquia(Integer.parseInt(hierarquia));
        usu.setCargo(cargo);
        
        UsuarioController con = new UsuarioController();
        
        try {
            if (metodo.equals("atualizar")) {
                con.alterar(usu);
        
                request.setAttribute("UsuarioUpdate", usu);
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("WEB-INF/Usuario/resultadoAtualizarUsuario.jsp");
                dispatcher.forward(request, response);

            } else if (metodo.equals("deletar")) {
                con.deletar(usu.getIdUsuario());

                request.setAttribute("UsuarioUpdate", usu);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Usuario/resultadoDeleteUsuario.jsp");
                dispatcher.forward(request, response);

            }

        } catch (Exception e) {
            System.out.println("Vefique o objeto");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
