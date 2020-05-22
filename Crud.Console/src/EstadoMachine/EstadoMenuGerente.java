/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoMachine;

import crud.console.CrudConsole;
import java.util.Scanner;

/*
 * 
 *
 * @author 082170017
 */
public class EstadoMenuGerente extends EstadoMachine {

    @Override
    public boolean Executa() {
        try
        {
            System.out.println("\n ---Menu Principal---");
            Scanner scan = new Scanner(System.in);
            System.out.println("0 - Sair");        
            System.out.println("1 - Cadastrar Pedido \n2 - Listar Pedido");
            System.out.println("3 - Cadastrar Produto \n4 - Listar Produto");
            System.out.println("5 - Cadastrar Cliente \n6 - Listar Cliente");
            System.out.println("7 - Cadastrar Funcionario \n8 - Listar Funcionario");

            int opcao = scan.nextInt();
            switch (opcao)
            {
                case 0:
                    CrudConsole.estadoConsole = EnumEstado.Inicio.getEstadoMaquina();
                    break;            
                case 1:
                    CrudConsole.estadoConsole = EnumEstado.CadastraPedido.getEstadoMaquina();
                    break;
                case 2:
                    CrudConsole.estadoConsole = EnumEstado.ListaPedido.getEstadoMaquina();
                    break;
                case 3:
                    CrudConsole.estadoConsole = EnumEstado.CadastraProduto.getEstadoMaquina();
                    break;
                case 4:
                    CrudConsole.estadoConsole = EnumEstado.ListaProduto.getEstadoMaquina();
                    break;
                case 5:
                    CrudConsole.estadoConsole = EnumEstado.CadastraCliente.getEstadoMaquina();
                    break;
                case 6:
                    CrudConsole.estadoConsole = EnumEstado.ListaCliente.getEstadoMaquina();
                    break;
                case 7:
                    CrudConsole.estadoConsole = EnumEstado.CadastroFuncionario.getEstadoMaquina();
                    break;
                case 8:
                    CrudConsole.estadoConsole = EnumEstado.ListaFuncionario.getEstadoMaquina();
                    break;
            }
        }
        catch(Exception e){
            System.out.println("\n\n *****!ENTRADA DE DADOS INVALIDA!*****\n\n");
            CrudConsole.estadoConsole = EnumEstado.MenuGerente.getEstadoMaquina();;
        } 
        return false;
    }
    
}
