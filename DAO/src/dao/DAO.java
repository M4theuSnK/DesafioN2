/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import comuns.crud.basis.Entidade;
import comuns.enums.EntidadesDisponiveis;
import java.io.IOException;
/**
 *
 * @author vitorlupinetti
 */
public abstract class DAO <E extends Entidade> {
    
    protected Class<E> entityClass;

    public DAO(Class<E> entityClass){
        this.entityClass = entityClass;
    }
    
    public abstract E seleciona(Entidade entidade, EntidadesDisponiveis enumEntidade)throws SQLException;
    public abstract void insere(Entidade entidade, EntidadesDisponiveis enumEntidade);
    public abstract void deleta(int id, EntidadesDisponiveis enumEntidade)throws IOException;
    public abstract void lista(EntidadesDisponiveis enumEntidade)throws IOException;
    
    
    protected E getInstanceOfE()
    {
        try
        {
            return entityClass.newInstance();
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            // Oops, no default constructor
            throw new RuntimeException(e);
        }
    }
}

