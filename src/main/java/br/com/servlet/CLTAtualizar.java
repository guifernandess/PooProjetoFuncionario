/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.model.Usuario;
import br.com.model.FuncionarioCLT;
import br.com.dao.DaoFuncionarioCLT;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "CLTAtualizar", urlPatterns = {"/CLTAtualizar"})
public class CLTAtualizar extends HttpServlet {

    
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
        String idClt = request.getParameter("idClt");
        String nome = request.getParameter("nome");
        String CPF = request.getParameter("cpf");
        String dtnascimento = request.getParameter("dtnascimento");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String dtadmissao = request.getParameter("dtadmissao");
        String departamento = request.getParameter("departamento");
        String salario = request.getParameter("salario");
        String valorRefeicao = request.getParameter("valorrefeicao");
        String valorTransporte = request.getParameter("valortransporte");
        
        String metodo = request.getParameter("metodo");
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date data = null;
        java.sql.Date data1 = null;
        
        
        try {
            data = new java.sql.Date(format.parse(dtnascimento).getTime());
            data1 = new java.sql.Date(format.parse(dtadmissao).getTime());
        } catch (ParseException ex) {
            System.out.println("erro converter data");
        }
        
        
        FuncionarioCLT clt = new FuncionarioCLT();
        clt.setIdFuncionario(Integer.parseInt(idFuncionario));
        clt.setIdDepartamento(Integer.parseInt(idDepartamento));
        clt.setIdCLT(Integer.parseInt(idClt));
        clt.setNome(nome);
        clt.setCPF(Integer.parseInt(CPF));
        clt.setDataNascimento(data);
        clt.setEndereco(endereco);
        clt.setTelefone(Integer.parseInt(telefone));
        clt.setDataAdmissao(data1);
        clt.setDepartamento(departamento);
        clt.setSalario(Double.parseDouble(salario));
        clt.setValorRefeicao(Double.parseDouble(valorRefeicao));
        clt.setValortransporte(Double.parseDouble(valorTransporte));
        
        
        
        DaoFuncionarioCLT con = new DaoFuncionarioCLT();
        
        try {
            if (metodo.equals("atualizar")) {
                con.alterar(clt);
        
                request.setAttribute("cltUpdate", clt);
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("WEB-INF/FuncionarioCLT/resultadoAtualizarFuncClt.jsp");
                dispatcher.forward(request, response);

            } else if (metodo.equals("deletar")) {
                con.deletar(clt.getCPF());

                request.setAttribute("cltUpdate", clt);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/FuncionarioCLT/resultadoDeleteFuncCLT.jsp");
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
