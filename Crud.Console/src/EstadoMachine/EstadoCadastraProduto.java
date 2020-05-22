/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoMachine;

import comuns.vos.Produto;
import crud.console.CrudConsole;
import java.util.Scanner;
import business.crud.Crud;
import comuns.enums.EntidadesDisponiveis;
import java.time.Instant;
import simulacaodesafiothreads.GerenciadorAuditoria;
/**
 *
 * @author Administrador
 */
public class EstadoCadastraProduto extends EstadoMachine{
    Scanner scan = new Scanner(System.in);
    @Override
    public boolean Executa() {
        Produto produto = new Produto();
        try
        {
            System.out.println("Digite o nome do produto: ");
            produto.setDescricao(scan.nextLine().trim());
            System.out.println("Digite a categoria: ");
            produto.setCategoria(scan.nextLine().trim());
            System.out.println("Digite o valor: ");
            produto.setValor(Double.parseDouble(scan.nextLine().trim()));

            Crud crud = new Crud();
            crud.Insere(produto, EntidadesDisponiveis.PRODUTO);
            
            
            GerenciadorAuditoria.getInstancia().adicionaMsgAuditoria("Dados Cadastrados \nNome do Produto: " + produto.getDescricao()+ "\nCategoria: " + produto.getCategoria()+ "\nValor: " + produto.getValor());
            Thread.sleep(2000);
            
            System.out.printf("%s - Final do reporte de mensagens\n", Instant.now().toString());
            CrudConsole.estadoConsole = EnumEstado.MenuFuncionario.getEstadoMaquina();
        }
        catch(Exception e){
            System.out.println("\n\n *****!ENTRADA DE DADOS INVALIDA!*****\n\n");
            CrudConsole.estadoConsole = EnumEstado.CadastraProduto.getEstadoMaquina();;
        } 
        return false;
    }
}
