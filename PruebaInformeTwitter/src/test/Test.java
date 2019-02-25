/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import logica.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import logica.Tweet;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author sergio
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Tweet> listaTweetsUsuario1;
        List<Tweet> listaTweetsUsuario2;
        
        //Usuario usuario1 = new Usuario ("Mariano Rajoy", listaTweetsUsuario1);
        //Usuario usuario2 = new Usuario ("José María Aznar", listaTweetsUsuario2);
        
        List<Usuario> listaUsuarios;
        
        listaTweetsUsuario1 = new ArrayList<>();
        listaTweetsUsuario1.add(new Tweet("A veces la mejor decisión es no tomar ninguna decisión, que también es tomar una decisión."));
        listaTweetsUsuario1.add(new Tweet("Como decía Galileo, el movimiento siempre se acelera cuando se va a detener."));
        listaTweetsUsuario1.add(new Tweet("Cuanto peor mejor para todos y cuanto peor para todos mejor, mejor para mí el suyo, beneficio político."));
        listaTweetsUsuario1.add(new Tweet("Es el vecino el que elige al alcalde y es el alcalde el que quiere que sean los vecinos el alcalde."));
        listaTweetsUsuario1.add(new Tweet("España es un gran país que hace cosas importantes y tiene españoles."));
        
        listaTweetsUsuario2 = new ArrayList<>();
        listaTweetsUsuario2.add(new Tweet("España va bien."));
        listaTweetsUsuario2.add(new Tweet("¡Váyase señor González, váyase!"));
        listaTweetsUsuario2.add(new Tweet("Yo también hablo catalán en la intimidad."));
        listaTweetsUsuario2.add(new Tweet("A mí no me gusta que me digan: no puede ir usted a más de tanta velocidad, no puede usted comer hamburguesas de tanto, debe usted evitar esto y además a usted le prohíbo beber vino."));
        listaTweetsUsuario2.add(new Tweet("O gobierna el PP o habrá un riesgo real para el futuro de España con una coalición de pancarteros, comunistas e independentistas que todas las mañanas desayunan galletas de rencor y de odio y quieren romper España."));
        
        Usuario usuario1 = new Usuario ("Mariano Rajoy", listaTweetsUsuario1);
        Usuario usuario2 = new Usuario ("José María Aznar", listaTweetsUsuario2);
        
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        
        try {
            //List<Tweet> listaRajoy = listaTweetsUsuario1;
            //List<Tweet> listaAznar = listaTweetsUsuario2;
            String nombreUsuario;
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduzca un nombre de usuario: ");
            nombreUsuario = sc.nextLine();
            int indice = -1;
            for (Iterator<Usuario> it = listaUsuarios.iterator(); it.hasNext();) {
                Usuario usuario = it.next();
                if (usuario.getNameUser().equalsIgnoreCase(nombreUsuario)) {
                    indice = listaUsuarios.indexOf(usuario);
                    break;
                }
            }
            List<Tweet> listaTweetsUsuario = listaUsuarios.get(indice).getListaTweets(); 
            //La encapsulamos en el objeto adecuado
            JRDataSource dataSource = new JRBeanCollectionDataSource(listaTweetsUsuario);
            //Creamos el map para los parámetros
            Map parametros = new HashMap();
            parametros.put("NOMBRE_USUARIO", nombreUsuario);       // Si no metemos esta línea el map va sin parametros (vacío)
            JasperPrint print = JasperFillManager.fillReport("informes/prueba_informe_twitter.jasper", parametros, dataSource);
            JasperExportManager.exportReportToPdfFile(print, "informes/prueba_informe_twitter.pdf");
        } catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println("El informe ha sido generado satisfactoriamente.");
    }
    
        
}
