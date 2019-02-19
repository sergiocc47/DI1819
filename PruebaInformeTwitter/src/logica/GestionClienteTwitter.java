/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergio
 */
public class GestionClienteTwitter {

    //TODO listaSiguiendo y listaSeguidores
    private static Usuario queridoAntonio = new Usuario("Alberto González");
    private static Usuario usuario01 = new Usuario("Little Richard");
    private static Usuario usuario02 = new Usuario("Chuck Berry");
    private static Usuario usuario03 = new Usuario("James Brown");
    private static Usuario usuario04 = new Usuario("Stevie Wonder");
    private static Usuario usuario05 = new Usuario("Otis Redding");
    private static Usuario usuario06 = new Usuario("Little Richard");
    private static Usuario usuario07 = new Usuario("Marvin Gaye");
    private static Usuario usuario08 = new Usuario("John Lennon");
    private static Usuario usuario09 = new Usuario("Sam Cooke");
    private static Usuario usuario10 = new Usuario("Elvis Presley");
    
   
    public static List<Tweet> listaTweets() {
        
        List<Tweet> listaTweets = new ArrayList<>();
        listaTweets.add(new Tweet(queridoAntonio.getNombre(), "06/01/2019", "Oído en el metro: “VOX no es un partido político: es un movimiento poético”"));
        listaTweets.add(new Tweet(queridoAntonio.getNombre(), "25/12/2018", "Idea para patente. Un smartphone con unos electrodos a través de los cuales el usuario reciba descargas eléctricas como castigo por manifestaciones inapropiadas en redes sociales. Si la ofensa es grave y el número de reproches alto, el usuario puede llegar a morir electrocutado"));
        listaTweets.add(new Tweet(queridoAntonio.getNombre(), "14/12/2018", "En Saber y Ganar acaba de ser pronunciada la siguiente frase: “George Clooney no sólo me gusta como actor, sino también como persona y como gentleman”"));
        listaTweets.add(new Tweet(queridoAntonio.getNombre(), "28/10/2018", "Un atentado simultáneo contra el Big Ben de Londres y el reloj de la Puerta del Sol de Madrid marca el inicio de la Tercera Guerra Mundial. La mayor parte de las grandes ciudades son destruidas por las bombas de hidrógeno"));
        listaTweets.add(new Tweet(queridoAntonio.getNombre(), "10/09/2018", "Al margen del peligro de que un potencial presidente de gobierno haga razonamientos delirantes, esto es un espectáculo. Es bello y trágico al mismo tiempo. Igual que contemplar un incendio"));
        
        return listaTweets;
    }
    
}
