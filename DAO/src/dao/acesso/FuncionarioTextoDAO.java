/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.acesso;

import comuns.crud.basis.Entidade;
import comuns.enums.EntidadesDisponiveis;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;
import comuns.vos.Funcionario;
import dao.DAO;
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
public class FuncionarioTextoDAO extends DAO {
    
    private final ConcurrentHashMap<String, Funcionario> funcionarios = new ConcurrentHashMap<>();
    
    public FuncionarioTextoDAO()    { 
        super(Funcionario.class);        
    }
    
    public  String path = "C:/DesafioN2/DesafioN2/DAO/src/dao/acesso/funcionario.txt";
    
    public static Funcionario leitor(String caminho, Entidade entidade) throws IOException {
        String vetor [];
        Funcionario f = (Funcionario)entidade;
        Funcionario retorno = null;
        BufferedReader buffRead = new BufferedReader(new FileReader(caminho));
        String linha = "";
        
        while (true) {

            linha = buffRead.readLine();
            
            if(linha == null)
                break;           
            
            vetor = linha.split(";");

            if(vetor[1].equals(f.getUsername()))
            {
                retorno = new Funcionario();
                retorno.setNome(vetor[0]);
                retorno.setUsername(vetor[1]);
                retorno.setSenha(vetor[2]);
                retorno.setAcesso(vetor[3]);
                return retorno;
            }
        }
        buffRead.close();
        return retorno;
    }
    
     public static void escritor(String path, Entidade entidade) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path,true));
        String linha = "";
        Funcionario f = (Funcionario)entidade;
        linha = f.getNome() + ";" + f.getUsername() + ";" + f.getSenha() + ";" + f.getAcesso();

        buffWrite.append(linha + "\n");
        buffWrite.close();
        
        System.out.println("Funcionario cadastrado.");
    }
 
    @Override
    public void insere(Entidade entidade, EntidadesDisponiveis enumEntidade) {
       
        try {
             escritor(path, entidade);
           } catch (IOException ex) {
               Logger.getLogger(FuncionarioTextoDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    @Override
    public Entidade seleciona(Entidade entidade, EntidadesDisponiveis enumEntidade) throws SQLException {
        Funcionario entidadeRetorno = new Funcionario();
        
           try {
                entidadeRetorno = leitor(path, entidade);
           } catch (IOException ex) {
               Logger.getLogger(FuncionarioTextoDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           return entidadeRetorno;
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
                    System.out.println("Codigo do Funcionario não encontrado");
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
        System.out.println("Funcionario excluido com sucesso");
    }

    @Override
    public void lista(EntidadesDisponiveis enumEntidade)throws IOException{    	
    	String vetor [];                
        BufferedReader buffRead = new BufferedReader(new FileReader(path));                  
        String linha = "";
        int IdContador = 1;
        while (true) {
            linha = buffRead.readLine();
            if(linha == null)
                break;                        
            vetor = linha.split(";");
            
            System.out.print("Codigo do Funcionario: " + IdContador +", Nome:" + vetor[0] +", UserName: " + vetor[1]);
            if(vetor[3].equals("1")){
            	System.out.println(", Gerente");
            }
            else{
            	System.out.println(", Vendedor");
            }
            IdContador ++;
        }
        buffRead.close();
    }
}
        

