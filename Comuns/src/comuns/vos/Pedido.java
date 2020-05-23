/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comuns.vos;
import comuns.crud.basis.Entidade;
/**
 *
 * @author vitorlupinetti
 */
public class Pedido extends Entidade {
    
    
    private String clienteNome;
    private String vendedor;
    private String[] produtos;
    private int qtdProdutos;

   
    /**
     * @return the clienteId
     */
    public String getClienteNome() {
        return clienteNome;
    }

    /**
     * @param clienteId the clienteId to set
     */
    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    /**
     * @return the vendedorId
     */
    public String getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedorId the vendedorId to set
     */
    public void setVendedor(String vendedorId) {
        this.vendedor = vendedorId;
    }


    /**
     * @return the qtdProdutos
     */
    public int getQtdProdutos() {
        return qtdProdutos;
    }

    /**
     * @param qtdProdutos the qtdProdutos to set
     */
    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }

    /**
     * @return the produtos
     */
    public String getProdutos() {
        String retorno ="";
        int tamanho = produtos.length;
                for (int i = 0; i < tamanho; i++) {
                    retorno = retorno + produtos[i] + ";";
                }
        
        return retorno;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(String[] produtos) {
        this.produtos = produtos;
    }
}
