/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comuns.enums;

/**
 *
 * @author vitorlupinetti
 */
public enum EntidadesDisponiveis {
    FUNCIONARIO("funcionario"),

    PEDIDO("pedido"),

    PRODUTO("produto"),
    
    ITEM_PEDIDO("item_pedido"),
    
    CLIENTE("cliente");
 
    private String descricao;
 
    EntidadesDisponiveis(String descricao) {
        this.descricao = descricao;
    }
 
    public String getDescricao() {
        return descricao;
    }
}
