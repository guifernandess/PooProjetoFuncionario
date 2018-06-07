/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.dao.DaoFuncionario;
import br.com.dao.DaoFuncionarioPJ;
import br.com.model.Funcionario;
import br.com.model.FuncionarioPJ;
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
@WebServlet(name = "PJCadastro", urlPatterns = {"/cadastro-pj"})
public class PJCadastro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
        
        request.getRequestDispatcher("WEB-INF/FuncionarioPJ/form-pj-cadastro.jsp").forward(request, response);
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
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        DaoFuncionarioPJ con = new DaoFuncionarioPJ();
        DaoFuncionario daofunc = new DaoFuncionario();

        String nome = request.getParameter("nome");
        String CNPJ = request.getParameter("cnpj");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String dtadmissao = request.getParameter("dtadmissao");
        String departamento = request.getParameter("departamento");
        String valorHora = request.getParameter("valorHora");
        String qtdHora = request.getParameter("qtdHora");
        String tempoContrato = request.getParameter("tempoContrato");

        java.sql.Date data = null;
        
         try {
            data = new java.sql.Date(format.parse(dtadmissao).getTime());
        } catch (ParseException ex) {
            System.out.println("erro converter data");
        }
        
        FuncionarioPJ pj = new FuncionarioPJ();
        
        pj.setNome(nome);
        pj.setCNPJ(Integer.parseInt(CNPJ));
        pj.setEndereco(endereco);
        pj.setTelefone(Integer.parseInt(telefone));
        pj.setDataAdmissao((java.sql.Date) data);
        pj.setDepartamento(departamento);
        pj.setValorHora(Double.parseDouble(valorHora));
        pj.setQtdHora(Integer.parseInt(qtdHora));
        pj.setTempoContrato(tempoContrato);
        
        try {
            // pegar id departamento
            int idderp = daofunc.selectIdDepartamento(departamento);
            pj.setIdDepartamento(idderp);
        
            // incluir na table funcionario
            daofunc.cadastrar((Funcionario) pj);
            //pegar o id funcionario
            int idfun = daofunc.selectId(pj.getNome());
            pj.setIdFuncionario(idfun);
            //incluir na tabela clt
            con.cadastrar(pj);           
            
        } catch (Exception ex) {
            System.out.println("Erro no objeto");
        }
        
        request.setAttribute("pjCadastrado", pj);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/FuncionarioPJ/resultadoCadastro.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
