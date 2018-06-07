/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.dao.DaoDepartamento;
import br.com.model.Departamento;
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
@WebServlet(name = "DepartamentoCadastro", urlPatterns = {"/cadastro-departamento"})
public class DepartamentoCadastro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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

        request.getRequestDispatcher("WEB-INF/Carro/form-carro-cadastro.jsp").forward(request, response);

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

        String idDepartamento = request.getParameter("idDepartamento");
        String departamento = request.getParameter("departamento");

        Departamento d1 = new Departamento(Integer.parseInt(idDepartamento), departamento);
        DaoDepartamento con = new DaoDepartamento();

        try {
            con.cadastrar(d1);
            System.out.println("Departamento add " + d1.getNome());
        } catch (Exception e) {

        }

        request.setAttribute("departamentoCadastrado", d1);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/Departamento/resultadoCadastro.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
