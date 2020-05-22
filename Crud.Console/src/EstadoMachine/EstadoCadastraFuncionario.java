/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoMachine;
import crud.console.CrudConsole;
import java.util.Scanner;
import business.crud.Crud;
import comuns.enums.EntidadesDisponiveis;
import comuns.vos.Funcionario;
/**
 *
 * @author 082170017
 */
public class EstadoCadastraFuncionario extends EstadoMachine{

    Scanner scan = new Scanner(System.in);
    @Override
    public boolean Executa() {
        Funcionario func = new Funcionario();
        try
        {
            System.out.println("Digite o nome do funcionario: ");
            func.setNome(scan.nextLine().trim());
            System.out.println("Digite o username: ");
            func.setUsername(scan.nextLine().trim());
            System.out.println("Digite a senha: ");
            func.setSenha(scan.nextLine().trim());
            System.out.println("Digite 0 para vendedor ou 1 para gerente: ");
            func.setAcesso(scan.nextLine().trim());

            Crud crud = new Crud();
            crud.Insere(func, EntidadesDisponiveis.FUNCIONARIO);

            CrudConsole.estadoConsole = EnumEstado.MenuGerente.getEstadoMaquina();
        }
        catch(Exception e){
            System.out.println("\n\n *****!ENTRADA DE DADOS INVALIDA!*****\n\n");
            CrudConsole.estadoConsole = EnumEstado.CadastroFuncionario.getEstadoMaquina();;
        } 
        return false;        
    }
    
}
