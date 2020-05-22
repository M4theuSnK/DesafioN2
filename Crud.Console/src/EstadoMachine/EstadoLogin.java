/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoMachine;

import crud.console.CrudConsole;
import java.util.Scanner;
import business.acesso.Acesso;
import business.config.Config;
import comuns.vos.Funcionario;
 /*
 * @author joao-
 */
public class EstadoLogin extends EstadoMachine{
    
    @Override
    public boolean Executa() {
        boolean sair = false;
        Funcionario funcionario;
        try{
            Scanner scan = new Scanner(System.in);
            System.out.println("\n**** LOGIN ****");
            System.out.println("Digite seu usuário:");
            String login = scan.nextLine().trim();
            System.out.println("Digite sua senha:");
            String senha = scan.nextLine().trim();
            // TODO - Validação de senha
            Acesso acesso = new Acesso(); 
            funcionario = acesso.validaFuncionario(login, senha);
            if(funcionario != null){
                Config.getInstance().setUsuarioLogado(funcionario);
                CrudConsole.estadoConsole = EnumEstado.MenuFuncionario.getEstadoMaquina();
            }
            else {
                    System.out.println("Usuario ou senha incorretos!");
                }
        }
        catch(Exception e){
            System.out.println("\n\n *****!ENTRADA DE DADOS INVALIDA!*****\n\n");
            CrudConsole.estadoConsole = EnumEstado.Login.getEstadoMaquina();
        } 
        return sair;
    }
}
