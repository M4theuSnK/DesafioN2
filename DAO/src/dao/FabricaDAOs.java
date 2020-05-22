/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import comuns.enums.EntidadesDisponiveis;
import comuns.enums.TipoRepositorio;
import dao.acesso.ClienteTextoDAO;
import dao.acesso.FuncionarioTextoDAO;
import dao.acesso.PedidoTextoDAO;
import dao.acesso.ProdutoTextoDAO;
/**
 *
 * @author vitorlupinetti
 */
public class FabricaDAOs {
    public static DAO Fabrica(EntidadesDisponiveis enumEntidade, TipoRepositorio repositorio) {
        switch (repositorio)
        {
            case TEXTO:
                return montaDAOTexto(enumEntidade);
            default:
                return null;
        }
       
    }

    private static DAO montaDAOTexto(EntidadesDisponiveis enumEntidade) {
        DAO retorno = null;
        switch (enumEntidade)
        {
            case FUNCIONARIO:
                retorno = new FuncionarioTextoDAO();
                break;  
            case PRODUTO:
                retorno = new ProdutoTextoDAO();
                break;  
            case PEDIDO:
                retorno = new PedidoTextoDAO();
                break;  
            case CLIENTE:
                retorno = new ClienteTextoDAO();
                break;
            default:
                retorno = null;
                break;
        }
        return retorno;
    }
}
