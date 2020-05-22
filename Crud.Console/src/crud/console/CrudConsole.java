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
        while (!saida){
            saida = estadoConsole.Executa();
        }
    }   
}
