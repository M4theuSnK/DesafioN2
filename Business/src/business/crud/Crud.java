/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.crud;
import business.basis.FabricaRepositorio;
import comuns.crud.basis.Entidade;
import comuns.enums.EntidadesDisponiveis;
import dao.repositorio.basis.Repositorio;
/**
 *
 * @author vitorlupinetti
 */
public class Crud {
    public void Insere(Entidade E, EntidadesDisponiveis enumEntidade){
        Repositorio repositorio = FabricaRepositorio.Fabrica(); 
        repositorio.insere(E, enumEntidade);
    }
    public void Deleta(int id, EntidadesDisponiveis enumEntidade){
       Repositorio repositorio = FabricaRepositorio.Fabrica(); 
       repositorio.deleta(id, enumEntidade);

       
    }   
    public void lista(EntidadesDisponiveis enumEntidade) {
    	Repositorio repositorio = FabricaRepositorio.Fabrica();
    	repositorio.lista(enumEntidade);
    }
}
