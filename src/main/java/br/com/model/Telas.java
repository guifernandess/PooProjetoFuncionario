/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author Guilherme
 */
public class Telas {

    String departamento, pagamento, relatorio, funcionarioCLT, funcionarioDiarista, funcionarioPJ;

    public Telas() {
        this.departamento = "WEB-INF/departamento.jsp";
        this.pagamento = "WEB-INF/pagamento.jsp";
        this.relatorio = "WEB-INF/relatorio.jsp";
        this.funcionarioCLT = "WEB-INF/funcionarioCLT.jsp";
        this.funcionarioDiarista = "WEB-INF/funcionarioDiarista.jsp";
        this.funcionarioPJ = "WEB-INF/funcionarioPJ.jsp";
    }

    public String getDepartamentoScreen() {
        return departamento;
    }

    public String getPagamentoScreen() {
        return pagamento;
    }

    public String getRelatorioScreen() {
        return relatorio;
    }

    public String getFuncionarioCLTScreen() {
        return funcionarioCLT;
    }

    public String getFuncionarioDiaristaScreen() {
        return funcionarioDiarista;
    }

    public String getFuncionarioPJScreen() {
        return funcionarioPJ;
    }

}
