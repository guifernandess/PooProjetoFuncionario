
package br.com.controller;


import br.com.dao.DaoPagamento;
import br.com.model.Pagamento;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class PagamentoController {
    public static void cadastrar(Pagamento pagamento) throws Exception {
        try {
            validar(pagamento);
            DaoPagamento.cadastrar(pagamento);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void alterar(Pagamento pagamento) throws Exception {
        try {
            validar(pagamento);
            DaoPagamento.atualizar(pagamento);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Pagamento obter(int idDepartamento) throws Exception {
        try {
            return DaoPagamento.obterPagamento(idDepartamento);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<Pagamento> listar() throws Exception  {
        try {
            return (ArrayList<Pagamento>) DaoPagamento.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static boolean deletar(int id) throws Exception {
        try {
            return DaoPagamento.excluir(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void validar(Pagamento pagamento) throws Exception {
        try {
            if (pagamento.getValorPagamento()== 0) {
                throw new Exception("pagametento zerado");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
