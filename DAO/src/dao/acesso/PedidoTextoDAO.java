/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.acesso;

import comuns.crud.basis.Entidade;
import comuns.enums.EntidadesDisponiveis;
import comuns.vos.Pedido;
import dao.DAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 082170017
 */
public class PedidoTextoDAO extends DAO{
    public PedidoTextoDAO ()
    {
        super(Pedido.class);
    }
    public String path = "C:/DesafioN2/DesafioN2/DAO/src/dao/acesso/pedido.txt";
    
    public static void escritor(String caminho, Entidade entidade) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminho,true));
        String linha = "";
        Pedido p = (Pedido)entidade;
        linha = p.getClienteNome() + ";" + p.getVendedor()+ ";" + p.getQtdProdutos()+ ";" + p.getProdutos();

        buffWrite.append(linha + "\n");
        buffWrite.close();
        
        System.out.println("Pedido cadastrado.");
    }

    @Override
    public Entidade seleciona(Entidade entidade, EntidadesDisponiveis enumEntidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insere(Entidade entidade, EntidadesDisponiveis enumEntidade) {
        
        try {
             escritor(path, entidade);
           } catch (IOException ex) {
               Logger.getLogger(PedidoTextoDAO.class.getName()).log(Level.SEVERE, null, ex);
           }   
    }

    @Override
    public void deleta(int id, EntidadesDisponiveis enumEntidade)throws IOException {
        String texto="";
        String linha="";        
        int IdContador = 1;
        BufferedReader buffRead = new BufferedReader(new FileReader(path));                  
        while (true) {
            linha = buffRead.readLine();
            if(linha == null){
                if(id > IdContador){
                    System.out.println("Codigo do pedido não encontrado");
                    return;
                }
                break;   
            }
            if(id != IdContador){
              texto = texto + linha + "\n"; 
            }   
            IdContador++; 
        }       
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path,false));
        buffWrite.write(texto);
        buffWrite.close();
        System.out.println("Pedido excluido com sucesso");
    }

    @Override
    public void lista(EntidadesDisponiveis enumEntidade) throws IOException {
        String vetor [];
                
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
                  
        String linha = "";
        int IdContador =1;
        while (true) {
            linha = buffRead.readLine();
            if(linha == null){
                break;        
            }                
            vetor = linha.split(";");            
            System.out.print("\nCodigo do Pedido: " + IdContador +", Cliente: " + vetor[0] +", Vendedor: " + vetor[1]);
            for(int i = 0; i< Integer.parseInt(vetor[2]);i++){
                System.out.print(", Produto "+ (i+1) +": "+ vetor[i+3]);
            } 
            IdContador++;
        }
        buffRead.close();
        
    }
    
}
