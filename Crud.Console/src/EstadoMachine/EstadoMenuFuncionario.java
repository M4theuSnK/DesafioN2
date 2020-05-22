/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoMachine;

import business.config.Config;
import crud.console.CrudConsole;

/**
 *
 * @author vitorlupinetti
 */
public class EstadoMenuFuncionario extends EstadoMachine {

    @Override
    public boolean Executa() {

        if (Config.getInstance().getUsuarioLogado().getAcesso().equals("1"))
        {
            CrudConsole.estadoConsole = EnumEstado.MenuGerente.getEstadoMaquina();
        }
        else
        {
            CrudConsole.estadoConsole = EnumEstado.MenuVendedor.getEstadoMaquina();
        }        
        return false;
    }
    
}
