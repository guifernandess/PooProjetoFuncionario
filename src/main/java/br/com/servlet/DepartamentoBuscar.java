/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;


import br.com.dao.DaoDepartamento;
import br.com.model.Departamento;
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
@WebServlet(name = "DepartamentoBuscar", urlPatterns = {"/buscar-departamento"})
public class DepartamentoBuscar extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String idDepartamento = request.getParameter("idDepartamento");
       
       int id = Integer.parseInt(idDepartamento.substring(1,2));
       
       DaoDepartamento con = new DaoDepartamento();
       Departamento departamento = new Departamento();
       
        try {
            departamento = con.obter(id);
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
       
       request.setAttribute("departamentoAtualizado", departamento);
       
       request.getRequestDispatcher("WEB-INF/Departamento/form-departamento-resultado.jsp").forward(request, response);
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idDepartamento = request.getParameter("idDepartamento");
        
        DaoDepartamento con = new DaoDepartamento();
        
        Departamento departamento = new Departamento();
        
        try {
            departamento = con.obter(Integer.parseInt(idDepartamento));
        } catch (Exception e) {
        }
        
        request.setAttribute("departamentoAtualizado", departamento);
        
        request.getRequestDispatcher("WEB-INF/Departamento/form-departamento-resultado.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
