/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.dao.DaoFuncionarioCLT;
import br.com.dao.DaoFuncionario;
import br.com.model.FuncionarioCLT;
import br.com.model.Funcionario;
import br.com.model.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "CLTCadastro", urlPatterns = {"/cadastro-clt"})
public class CLTCadastro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
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
        request.getRequestDispatcher("WEB-INF/FuncionarioCLT/form-clt-cadastro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario usuario = (Usuario)  request.getSession().getAttribute("usuario");
        if (usuario == null) {
            response.sendRedirect("index.jsp");
        } else {
            if(usuario.getHierarquia() < 1){
                response.sendRedirect("index.jsp");
            }
        }
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        DaoFuncionarioCLT con = new DaoFuncionarioCLT();
        DaoFuncionario daofunc = new DaoFuncionario();

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

        java.sql.Date data = null;
        java.sql.Date data1 = null;

        try {
            data = new java.sql.Date(format.parse(dtnascimento).getTime());
            data1 = new java.sql.Date(format.parse(dtadmissao).getTime());
        } catch (ParseException ex) {
            System.out.println("erro converter data");
        }

        FuncionarioCLT clt = new FuncionarioCLT();

        clt.setNome(nome);
        clt.setCPF(Integer.parseInt(CPF));
        clt.setDataNascimento((java.sql.Date) data);
        clt.setEndereco(endereco);
        clt.setTelefone(Integer.parseInt(telefone));
        clt.setDataAdmissao((java.sql.Date) data1);
        clt.setDepartamento(departamento);
        clt.setSalario(Double.parseDouble(salario));
        clt.setValorRefeicao(Double.parseDouble(valorRefeicao));
        clt.setValortransporte(Double.parseDouble(valorTransporte));

        try {
            // pegar id departamento
            int idderp = daofunc.selectIdDepartamento(departamento);
            clt.setIdDepartamento(idderp);

            // incluir na table funcionario
            daofunc.cadastrar((Funcionario) clt);
            //pegar o id funcionario
            int idfun = daofunc.selectId(clt.getNome());
            clt.setIdFuncionario(idfun);
            //incluir na tabela clt
            con.cadastrar(clt);

        } catch (Exception ex) {
            System.out.println("Erro no objeto");
        }

        request.setAttribute("cltCadastrado", clt);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/FuncionarioCLT/resultadoCadastro.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
