/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.dao.DaoDepartamento;
import java.io.IOException;
import java.io.PrintWriter;
import br.com.model.FuncionarioCLT;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author guilherme.frocha6
 */
@WebServlet(name = "CadastroCLT", urlPatterns = {"/CadastroCLT"})
public class CadastroCLT extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroCLT</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastroCLT at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        FuncionarioCLT funcionario = (FuncionarioCLT) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        }
        
        
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
        /*
        FuncionarioCLT clt = new FuncionarioCLT();
        
        
        
        
        
        
        produto.setProduto(request.getParameter("produto"));
        produto.setPreco(Double.parseDouble(request.getParameter("preco")));
        produto.setTipoProduto(TipoProdutoController.obter(Integer.parseInt(request.getParameter("tipo_produto"))));
        produto.setCombustivel(Boolean.parseBoolean(request.getParameter("combustivel")));
        produto.setEstocavel(Boolean.parseBoolean(request.getParameter("estocavel")));
        ProdutoController.cadastrar(produto);

        request.getRequestDispatcher("./ProdutoListar").forward(request, response);
*/
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
