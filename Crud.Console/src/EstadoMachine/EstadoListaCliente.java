/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoMachine;

import business.crud.Crud;
import comuns.enums.EntidadesDisponiveis;
import crud.console.CrudConsole;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class EstadoListaCliente extends EstadoMachine{

    Scanner scan = new Scanner(System.in);
    @Override
    public boolean Executa() {
        
        Crud crud = new Crud();
        crud.lista(EntidadesDisponiveis.CLIENTE);
        
        try{           
        	
            System.out.println("\n0 - Voltar ao menu\n1 - Cadastrar\n2 - Excluir");  
            int opcao = scan.nextInt();
            switch (opcao)
            {
                case 0:
                    CrudConsole.estadoConsole = EnumEstado.MenuFuncionario.getEstadoMaquina();
                    break;            
                case 1:
                    CrudConsole.estadoConsole = EnumEstado.CadastraCliente.getEstadoMaquina();
                    break;
                case 2:
                    CrudConsole.estadoConsole = EnumEstado.ExcluiCliente.getEstadoMaquina();
                    break;
            }            
        }
        catch(Exception e){
            System.out.println("\n\n *****!ENTRADA DE DADOS INVALIDA!*****\n\n");
            CrudConsole.estadoConsole = EnumEstado.MenuFuncionario.getEstadoMaquina();
        } 
       return false;
    }
    
}
