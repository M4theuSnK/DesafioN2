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
public class Cliente extends Entidade{
    
    private String nome;
    private int telefone;
    private String Endereço;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the Endereço
     */
    public String getEndereço() {
        return Endereço;
    }

    /**
     * @param Endereço the Endereço to set
     */
    public void setEndereço(String Endereço) {
        this.Endereço = Endereço;
    }
}
