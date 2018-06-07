/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.dao.DaoUsuario;
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
@WebServlet(name = "AutenticarUsuario", urlPatterns = {"/Autenticar"})
public class AutenticarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        request.removeAttribute("msg");

        try {

            String login = request.getParameter("login");
            String senha = request.getParameter("senha");

            Usuario usu = DaoUsuario.logar(login, senha);
            int id = usu.getIdUsuario();

            System.out.println("Id Usuario: " + id);
            if (id > 0) {
                request.getSession().setAttribute("usuario", usu);
                request.getRequestDispatcher("WEB-INF/HomePage.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Usuário e Senha Inválidos");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.err.println("Error --> " + e);
            request.setAttribute("msg", "Algo de Errado Ocorreu: " + e);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
