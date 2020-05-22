/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.basis;
import business.config.Config;
import dao.repositorio.basis.Repositorio;
import comuns.enums.TipoRepositorio;
import dao.repositorio.texto.RepositorioTexto;
/**
 *
 * @author vitorlupinetti
 */
public class FabricaRepositorio {
    public static Repositorio Fabrica() {
        if (Config.getInstance().getTipoRepositorio() == TipoRepositorio.TEXTO)
            return new RepositorioTexto();
        
        return null;
    }
}
