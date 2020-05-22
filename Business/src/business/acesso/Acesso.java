/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.acesso;
import business.basis.FabricaRepositorio;
import business.config.Config;
import comuns.vos.Funcionario;
import comuns.enums.EntidadesDisponiveis;
import dao.repositorio.basis.Repositorio;

/**
 *
 * @author vitorlupinetti
 */
public class Acesso {
    private boolean validaSenha(String senhaRepositorio, String senhaDigitada){
        return (senhaRepositorio.equals(senhaDigitada)); 
    }
    
    public Funcionario validaFuncionario(String login, String senha) {
        boolean valido = false;
        Repositorio repositorio = FabricaRepositorio.Fabrica();   
        Funcionario acesso = new Funcionario();
        acesso.setUsername(login);
        acesso.setSenha(senha);
        Funcionario funcionario = new Funcionario();
        funcionario = (Funcionario)repositorio.seleciona(acesso, EntidadesDisponiveis.FUNCIONARIO);
        if (funcionario != null)
        {
            valido = validaSenha(funcionario.getSenha(), senha);
        }
        else{
            
            return null;
        }
        if(valido)
            return funcionario;
        else
            return null;
    }
    
   
}
