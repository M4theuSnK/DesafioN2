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
import comuns.vos.Cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 082170017
 */
public class ClienteTextoDAO extends DAO{
    
    public ClienteTextoDAO(){
        super(Cliente.class);
    }
    
    public String path = "C:/DesafioN2/DesafioN2/DAO/src/dao/acesso/cliente.txt"; 
    
    public static void escritor(String caminho, Entidade entidade) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminho,true));
        String linha = "";
        Cliente c = (Cliente)entidade;
        linha = c.getNome() + ";" + c.getEndereço()+ ";" + c.getTelefone();

        buffWrite.append(linha + "\n");
        buffWrite.close();
        
        System.out.println("Cliente cadastrado.");
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
               Logger.getLogger(ClienteTextoDAO.class.getName()).log(Level.SEVERE, null, ex);
           }   
    }

    @Override
    public void deleta(int id, EntidadesDisponiveis enumEntidade) throws IOException{
        String texto="";
        String linha="";        
        int IdContador = 1;
        BufferedReader buffRead = new BufferedReader(new FileReader(path));                  
        while (true) {
            linha = buffRead.readLine();
            if(linha == null){
                if(id > IdContador){
                    System.out.println("Codigo do Cliente não encontrado");
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
        System.out.println("Cliente excluido com sucesso");
    }

    @Override
    public void lista(EntidadesDisponiveis enumEntidade)throws IOException  {
        String vetor [];                
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        int IdContador = 1;         
        String linha = "";
        
        while (true) {
            linha = buffRead.readLine();
            if(linha == null){
                break; 
            }
            vetor = linha.split(";");            
            System.out.println("Codigo do Cliente: " + IdContador +", Cliente: " + vetor[0] +", Endereço: " + vetor[1] + ", Telefone: " + vetor[2]);            
            IdContador++;
        }
        buffRead.close();
    }
    
}
