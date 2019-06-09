package pruebas;

import dto.Mesa;
import java.util.List;
import logica.LogicaNegocio;

/**
 *
 * @author sergio
 */
public class MainPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LogicaNegocio logicaNegocio = new LogicaNegocio();

        //logicaNegocio.getListaProductos();
        List<Mesa> listaMesas  = logicaNegocio.getListaMesas();      //Esta línea y la siguiente las metemos porque 
        System.out.println(listaMesas);                         //el sout está comentado en el método
        
    }
    
}
