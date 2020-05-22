/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.repositorio.texto;
import comuns.crud.basis.Entidade;
import comuns.enums.EntidadesDisponiveis;
import comuns.enums.TipoRepositorio;
import dao.DAO;
import dao.FabricaDAOs;
import dao.repositorio.basis.Repositorio;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitorlupinetti
 */
public class RepositorioTexto extends Repositorio {

    @Override
    public void insere(Entidade entidade, EntidadesDisponiveis tipoEntidade) {
        DAO dao = FabricaDAOs.Fabrica(tipoEntidade, TipoRepositorio.TEXTO);
        
        dao.insere(entidade, tipoEntidade);        
    }

    @Override
    public void deleta(int id, EntidadesDisponiveis tipoEntidade) {
        DAO dao = FabricaDAOs.Fabrica(tipoEntidade, TipoRepositorio.TEXTO);
        dao.deleta(id , tipoEntidade);
    }

    @Override
    public Entidade seleciona(Entidade entidade, EntidadesDisponiveis tipoEntidade) {
        DAO dao = FabricaDAOs.Fabrica(tipoEntidade, TipoRepositorio.TEXTO);
        
        Entidade retorno = null;
        try {
            retorno = dao.seleciona(entidade, tipoEntidade);
           
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    @Override
    public void lista(EntidadesDisponiveis tipoEntidades){
    	DAO dao = FabricaDAOs.Fabrica(tipoEntidades, TipoRepositorio.TEXTO);
        try {
            dao.lista(tipoEntidades);
        } 
        catch (IOException ex) {
            Logger.getLogger(RepositorioTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
    	
    }
    
    
}
