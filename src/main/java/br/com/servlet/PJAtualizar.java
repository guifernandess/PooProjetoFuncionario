/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.model.FuncionarioPJ;
import br.com.dao.DaoFuncionarioPJ;
import br.com.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "PJAtualizar", urlPatterns = {"/PJAtualizar"})
public class PJAtualizar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        if (usuario == null) {
            response.sendRedirect("index.jsp");
        } else {
            if (usuario.getHierarquia() < 1) {
                response.sendRedirect("index.jsp");
            }
        }
        
        String idFuncionario = request.getParameter("idFuncionario");
        String idDepartamento = request.getParameter("idDepartamento");
        String idPj = request.getParameter("idPj");
        String nome = request.getParameter("nome");
        String CNPJ = request.getParameter("cnpj");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String dtadmissao = request.getParameter("dtadmissao");
        String departamento = request.getParameter("departamento");
        String valorHora = request.getParameter("valorHora");
        String qtdHora = request.getParameter("qtdHora");
        String tempoContrato = request.getParameter("tempoContrato");
        
        String metodo = request.getParameter("metodo");
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date data = null;
         
        try {
            data = new java.sql.Date(format.parse(dtadmissao).getTime());
        } catch (ParseException ex) {
            System.out.println("erro converter data");
        }
        
        FuncionarioPJ pj = new FuncionarioPJ();
        pj.setIdFuncionario(Integer.parseInt(idFuncionario));
        pj.setIdDepartamento(Integer.parseInt(idDepartamento));
        pj.setIdPJ(Integer.parseInt(idPj));
        pj.setNome(nome);
        pj.setCNPJ(Integer.parseInt(CNPJ));
        pj.setEndereco(endereco);
        pj.setTelefone(Integer.parseInt(telefone));
        pj.setDataAdmissao(data);
        pj.setDepartamento(departamento);
        pj.setValorHora(Double.parseDouble(valorHora));
        pj.setQtdHora(Integer.parseInt(qtdHora));
        pj.setTempoContrato(tempoContrato);
                
        
        DaoFuncionarioPJ con = new DaoFuncionarioPJ();
        
        try {
            if (metodo.equals("atualizar")) {
                con.alterar(pj);
        
                request.setAttribute("pjUpdate", pj);
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("WEB-INF/FuncionarioPJ/resultadoAtualizarFuncPj.jsp");
                dispatcher.forward(request, response);

            } else if (metodo.equals("deletar")) {
                con.deletar(pj.getCNPJ());

                request.setAttribute("pjUpdate", pj);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/FuncionarioPJ/resultadoDeleteFuncPJ.jsp");
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
