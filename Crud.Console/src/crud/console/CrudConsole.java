/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.console;

//import br.com.comuns.crud.ec6.enums.TipoRepositorio;
import business.config.Config;
import EstadoMachine.EstadoMachine;
import EstadoMachine.EnumEstado;
import comuns.enums.TipoRepositorio;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 082170017 082120032
 */
public class CrudConsole {

    public static EstadoMachine estadoConsole;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Config.getInstance().setDatabase(TipoRepositorio.TEXTO);
        estadoConsole = EnumEstado.Inicio.getEstadoMaquina();
        Boolean saida = false;
        try {	
            System.out.printf("%s - Início da Execução de Thread com interface Runnable!\n", 	
                    Instant.now().toString());	
            Thread.sleep(1000);	
            
        } catch (InterruptedException ex) {	
            Logger.getLogger(ThreadSampleClass.class.getName()).log(	
                    Level.SEVERE, null, ex);	
        }    
        while (!saida){
            saida = estadoConsole.Executa();
        }
        System.out.printf("%s - Fim da Execução da Thread com interface Runnable!\n", 
                    Instant.now().toString());
    }   
}
