/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoMachine;

import business.config.Config;
import business.crud.Crud;
import comuns.enums.EntidadesDisponiveis;
import comuns.vos.Pedido;
import crud.console.CrudConsole;
import java.time.Instant;
import java.util.Scanner;
import simulacaodesafiothreads.GerenciadorAuditoria;
/**
 *
 * @author 082170017
 */
public class EstadoCadastraPedido extends EstadoMachine{

    Scanner scan = new Scanner(System.in);
    @Override
    public boolean Executa() {
        Pedido pedido = new Pedido();
        try{
            System.out.println("Digite o nome do cliente da venda: ");
            pedido.setClienteNome(scan.nextLine().trim());
            System.out.println("Digite a quantidade de produtos da venda: ");
            pedido.setQtdProdutos(scan.nextInt());
            String[] produtos = new String[pedido.getQtdProdutos()];

            for (int i = 0; i < pedido.getQtdProdutos(); i++) {
                System.out.println("Digite o Nome do produto " + i + " :");
                scan = new Scanner(System.in);
                produtos[i] = scan.nextLine().trim();
            }
            pedido.setProdutos(produtos);
            pedido.setVendedor(Config.getInstance().getUsuarioLogado().getNome());
            GerenciadorAuditoria.getInstancia().adicionaMsgAuditoria("Dados Cadastrados \nNome do Cliente: " + pedido.getClienteNome()+ "\nQuantidade de Produtos: " + pedido.getQtdProdutos()+ "\nProduto: " + pedido.getProdutos());
            Thread.sleep(2000);
            
            System.out.printf("%s - Final do reporte de mensagens\n", Instant.now().toString());   
            Crud crud = new Crud();        
            crud.Insere(pedido, EntidadesDisponiveis.PEDIDO);

            CrudConsole.estadoConsole = EnumEstado.MenuFuncionario.getEstadoMaquina();
        }
        catch(Exception e){
            System.out.println("\n\n *****!ENTRADA DE DADOS INVALIDA!*****\n\n");
            CrudConsole.estadoConsole = EnumEstado.CadastraPedido.getEstadoMaquina();;
        } 
        return false;
    }
}
