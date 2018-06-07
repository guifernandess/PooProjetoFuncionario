/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.model.FuncionarioDiarista;
import br.com.dao.DaoFuncionarioDiarista;
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
@WebServlet(name = "DiaristaAtualizar", urlPatterns = {"/DiaristaAtualizar"})
public class DiaristaAtualizar extends HttpServlet {

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
       
        String idFuncionario = request.getParameter("idFuncionario");
        String idDepartamento = request.getParameter("idDepartamento");
        String idDiarista = request.getParameter("idDiarista");
        String nome = request.getParameter("nome");
        String CPF = request.getParameter("cpf");
        String dtnascimento = request.getParameter("dtnascimento");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String dtadmissao = request.getParameter("dtadmissao");
        String departamento = request.getParameter("departamento");
        String valorDia = request.getParameter("valorDia");
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
        
        FuncionarioDiarista dia = new FuncionarioDiarista();
        dia.setIdFuncionario(Integer.parseInt(idFuncionario));
        dia.setIdDepartamento(Integer.parseInt(idDepartamento));
        dia.setIdDiarista(Integer.parseInt(idDiarista));
        dia.setNome(nome);
        dia.setCPF(Integer.parseInt(CPF));
        dia.setDataNascimento(data);
        dia.setEndereco(endereco);
        dia.setTelefone(Integer.parseInt(telefone));
        dia.setDataAdmissao(data1);
        dia.setDepartamento(departamento);
        dia.setValorDiario(Double.parseDouble(valorDia));
        dia.setValorRefeicao(Double.parseDouble(valorRefeicao));
        dia.setValorTransporte(Double.parseDouble(valorTransporte));
        
        DaoFuncionarioDiarista con = new DaoFuncionarioDiarista();
        
        try {
            if (metodo.equals("atualizar")) {
                con.alterar(dia);
        
                request.setAttribute("diaUpdate", dia);
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("WEB-INF/FuncionarioDiarista/resultadoAtualizarFuncDiarista.jsp");
                dispatcher.forward(request, response);

            } else if (metodo.equals("deletar")) {
                con.deletar(dia.getCPF());

                request.setAttribute("diaUpdate", dia);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/FuncionarioDiarista/resultadoDeleteFuncDiarista.jsp");
                dispatcher.forward(request, response);

            }

        } catch (Exception e) {
            System.out.println("Vefique o objeto");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
