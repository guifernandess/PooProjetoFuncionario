/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.dao.DaoFuncionarioPJ;
import br.com.dao.DaoFuncionario;
import br.com.model.FuncionarioPJ;
import br.com.model.Funcionario;
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
@WebServlet(name = "PJBuscar", urlPatterns = {"/buscar-funcionariopj"})
public class PJBuscar extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String idpj = request.getParameter("idPj");
        
        int id = Integer.parseInt(idpj.substring(1,2));
        
        DaoFuncionarioPJ con1 = new DaoFuncionarioPJ();
        FuncionarioPJ pj = new FuncionarioPJ();
        
        try {
            pj = con1.obter(id);
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
        
        request.setAttribute("pjAtualizado", pj);
       
       request.getRequestDispatcher("WEB-INF/FuncionarioPJ/form-pj-resultado.jsp").forward(request, response);
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
