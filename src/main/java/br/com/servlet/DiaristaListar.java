/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.model.Funcionario;
import br.com.model.FuncionarioDiarista;
import br.com.dao.DaoFuncionario;
import br.com.dao.DaoFuncionarioDiarista;
import br.com.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
@WebServlet(name = "DiaristaListar", urlPatterns = {"/DiaristaListar"})
public class DiaristaListar extends HttpServlet {

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
        
        DaoFuncionarioDiarista conn = new DaoFuncionarioDiarista();
        List<FuncionarioDiarista> lista = new ArrayList<FuncionarioDiarista>();
        
        try {

            lista = conn.obterList();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            //validar erro
            System.out.println(ex);
        }
        
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("WEB-INF/FuncionarioDiarista/ListarDiarista.jsp").forward(request, response);
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
