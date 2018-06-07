/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.dao.DaoFuncionarioDiarista;
import br.com.dao.DaoFuncionario;
import br.com.model.FuncionarioDiarista;
import br.com.model.Funcionario;
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
@WebServlet(name = "DiaristaCadastro", urlPatterns = {"/cadastro-diarista"})
public class DiaristaCadastro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/FuncionarioDiarista/form-diarista-cadastro.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        DaoFuncionarioDiarista con = new DaoFuncionarioDiarista();
        DaoFuncionario daofunc = new DaoFuncionario();
        
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
        
        java.sql.Date data = null;
        java.sql.Date data1 = null;
        
        try {
            data = new java.sql.Date(format.parse(dtnascimento).getTime());
            data1 = new java.sql.Date(format.parse(dtadmissao).getTime());
        } catch (ParseException ex) {
            System.out.println("erro converter data");
        }
        
        FuncionarioDiarista dia = new FuncionarioDiarista();
        
        dia.setNome(nome);
        dia.setCPF(Integer.parseInt(CPF));
        dia.setDataNascimento(data);
        dia.setEndereco(endereco);
        dia.setTelefone(Integer.parseInt(telefone));
        dia.setDataAdmissao((java.sql.Date) data1);
        dia.setDepartamento(departamento);
        dia.setValorDiario(Double.parseDouble(valorDia));
        dia.setValorRefeicao(Double.parseDouble(valorRefeicao));
        dia.setValorTransporte(Double.parseDouble(valorTransporte));
        
        try {
            // pegar id departamento
            int idderp = daofunc.selectIdDepartamento(departamento);
            dia.setIdDepartamento(idderp);
            
            // incluir na table funcionario
            daofunc.cadastrar((Funcionario) dia);
            
            //pegar o id funcionario
            int idfun = daofunc.selectId(dia.getNome());
            dia.setIdFuncionario(idfun);
            //incluir na tabela clt
            con.cadastrar(dia);           
            
        } catch (Exception ex) {
            System.out.println("Erro no objeto");
        }
        
        request.setAttribute("diaCadastrado", dia);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/FuncionarioDiarista/resultadoCadastro.jsp");
        dispatcher.forward(request, response);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
