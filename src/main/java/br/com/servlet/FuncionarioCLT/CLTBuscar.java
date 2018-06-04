/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet.FuncionarioCLT;

import br.com.model.FuncionarioCLT;
import br.com.dao.DaoFuncionarioCLT;
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
@WebServlet(name = "CLTBuscar", urlPatterns = {"/clt-buscar"})
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
        String idFuncionario = request.getParameter("idFuncionario");
        
        int id = Integer.parseInt(idFuncionario.substring(1,2));
        
        DaoFuncionarioCLT con = new DaoFuncionarioCLT();
        FuncionarioCLT clt = new FuncionarioCLT();
        
        try {
            clt = con.obter(id);
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
        
        request.setAttribute("cltAtualizado", clt);
       
       request.getRequestDispatcher("WEB-INF/Departamento/form-clt-resultado.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idFuncionario = request.getParameter("idFuncionario");
        
        DaoFuncionarioCLT con = new DaoFuncionarioCLT();
        FuncionarioCLT clt = new FuncionarioCLT();
        
        try {
            clt = con.obter(Integer.parseInt(idFuncionario));
        } catch (Exception e) {
        }
        
        request.setAttribute("cltAtualizado", clt);
        
        request.getRequestDispatcher("WEB-INF/Departamento/form-departamento-resultado.jsp").forward(request, response);
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
