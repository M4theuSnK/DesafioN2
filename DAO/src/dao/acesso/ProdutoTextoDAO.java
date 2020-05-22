/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.acesso;

import comuns.crud.basis.Entidade;
import comuns.enums.EntidadesDisponiveis;
import dao.DAO;
import java.sql.SQLException;
import comuns.vos.Produto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitorlupinetti
 */
public class ProdutoTextoDAO extends DAO {

    public ProdutoTextoDAO(){
        super(Produto.class);
    }
    public static String path = "C:/DesafioN2/DesafioN2/DAO/src/dao/acesso/produto.txt";
    
    public static void escritor( Entidade entidade) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path,true));
        String linha = "";
        Produto p = (Produto)entidade;
        linha = p.getDescricao() + ";" + p.getCategoria() + ";" + p.getValor() + ";";

        buffWrite.append(linha + "\n");
        buffWrite.close();
        
        System.out.println("Produto cadastrado.");
    }
    @Override
    public Entidade seleciona(Entidade entidade, EntidadesDisponiveis enumEntidade) throws SQLException {
        return null;
    }

    @Override
    public void insere(Entidade entidade, EntidadesDisponiveis enumEntidade) {        
        try {
             escritor( entidade);
           } catch (IOException ex) {
               Logger.getLogger(FuncionarioTextoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    System.out.println("Codigo do Produto não encontrado");
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
        System.out.println("Produto excluido com sucesso");
    }

    @Override
    public void lista(EntidadesDisponiveis enumEntidade) throws IOException {
        String vetor [];                
        BufferedReader buffRead = new BufferedReader(new FileReader(path));                  
        String linha = "";
        int IdContador = 1;
        while (true) {
            linha = buffRead.readLine();
            if(linha == null){
                break;        
            }                
            vetor = linha.split(";");            
            System.out.println("Codigo do Produto: " + IdContador +", Produto: " + vetor[0] +", Categoria: " + vetor[1] + ", Preço: $" + vetor[2]);
            IdContador++;            
        }
        buffRead.close();
    }
    
}
