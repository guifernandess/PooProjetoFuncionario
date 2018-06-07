/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.dao.DaoFuncionarioCLT;
import br.com.dao.DaoFuncionario;
import br.com.model.FuncionarioCLT;
import br.com.model.Funcionario;
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
@WebServlet(name = "FuncionarioCLTBuscar", urlPatterns = {"/buscar-funcionarioclt"})
public class CLTBuscar extends HttpServlet {

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

        String idclt = request.getParameter("idClt");

        int id = Integer.parseInt(idclt.substring(1, 2));

        DaoFuncionarioCLT con1 = new DaoFuncionarioCLT();
        FuncionarioCLT clt = new FuncionarioCLT();

        try {
            clt = con1.obter(id);
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }

        request.setAttribute("cltAtualizado", clt);

        request.getRequestDispatcher("WEB-INF/FuncionarioCLT/form-clt-resultado.jsp").forward(request, response);
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
