/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.GestionClienteTwitter;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 *
 * @author Mario
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            //CONEXION            
            Twitter twitter = TwitterFactory.getSingleton();

            twitter.setOAuthConsumer("HkM0LS2MQLnh2c4ECo40HHYmP", "uPhHLyAJahCC4ui9nC2AHvzYZEEGDnNyoshKsXIL845C3MVFWG"); //poco seguro

            RequestToken request = twitter.getOAuthRequestToken();

            Desktop.getDesktop().browse(new URI(request.getAuthorizationURL()));
            String pin = JOptionPane.showInputDialog("introduce pin");

            AccessToken access = twitter.getOAuthAccessToken(request, pin);
            twitter.setOAuthAccessToken(access);

            //LISTAS

            //Lista de usuarios seguidos
            for (User usuarioSeguido : GestionClienteTwitter.listadoFollows(twitter)) {
                System.out.println(usuarioSeguido.getName() + " @" + usuarioSeguido.getScreenName());
            }            
            //Lista de seguidores
            for (User usuarioSeguidor : GestionClienteTwitter.listadoFollows(twitter)) {
                System.out.println(usuarioSeguidor.getName() + " @" + usuarioSeguidor.getScreenName());
            }            
            //Lista de tweets
            for (Status usuarioSeguidor : GestionClienteTwitter.listarTimeLineUsuario(twitter)) {
                //IF para filtrar por fecha
                System.out.println(usuarioSeguidor.getText());
            }

        } catch (TwitterException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
