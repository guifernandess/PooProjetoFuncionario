/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.model.Departamento;
import br.com.dao.DaoDepartamento;
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
@WebServlet(name = "DepartamentoAtualizar", urlPatterns = {"/DepartamentoAtualizar"})
public class DepartamentoAtualizar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idDepartamento = request.getParameter("idDepartamento");
        String departamento = request.getParameter("departamento");
        String metodo = request.getParameter("metodo");

        Departamento d1 = new Departamento(Integer.parseInt(idDepartamento), departamento);

        DaoDepartamento con = new DaoDepartamento();

        try {
            if (metodo.equals("atualizar")) {

                con.atualizar(d1);

                request.setAttribute("departamentoUpdate", d1);
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("WEB-INF/Departamento/resultadoAtualizar.jsp");
                dispatcher.forward(request, response);
            } else if (metodo.equals("deletar")) {
                con.deletar(d1.getIdDepartamento());
                
                request.setAttribute("departamentoUpdate", d1);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Departamento/resultadoDelete.jsp");
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
