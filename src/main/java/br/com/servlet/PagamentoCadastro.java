/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;


import br.com.controller.PagamentoController;
import br.com.model.Pagamento;
import java.util.ArrayList;
import java.util.List;
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

@WebServlet(name = "PagamentoCadastro", urlPatterns = {"/PagamentoCadastro"})
public class PagamentoCadastro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PagamentoController pagamento = new PagamentoController();
        List<Pagamento> resultados = new ArrayList<Pagamento>();
        
        try {
            resultados = pagamento.listar();
            
            request.setAttribute("pagamento", resultados);
            
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("ListarPagamento.jsp");
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
            System.out.println("Verifique o objeto");
        }
        
    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
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
