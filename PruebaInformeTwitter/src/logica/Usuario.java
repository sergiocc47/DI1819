/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;

/**
 *
 * @author sergio
 */
public class Usuario {
    
    private String nombre;
    private List<Tweet> tweets;
    private List<Usuario> siguiendo;
    private List<Usuario> seguidores;

    public Usuario(String nombre, List<Tweet> tweets, List<Usuario> siguiendo, List<Usuario> seguidores) {
        this.nombre = nombre;
        this.tweets = tweets;
        this.siguiendo = siguiendo;
        this.seguidores = seguidores;
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public List<Usuario> getSiguiendo() {
        return siguiendo;
    }

    public List<Usuario> getSeguidores() {
        return seguidores;
    }
    
    
}
