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
    
    private String nameUser;
    //private List<Usuario> listaFollows;
    //private List<Usuario> listaFollowers;
    private List<Tweet> listaTweets;
    /*private List<String> listaFollows;
    private List<String> listaFollowers;
    private List<String> listaTweets;*/

    public Usuario(String nameUser, List<Tweet> listaTweets) {
        this.nameUser = nameUser;
        this.listaTweets = listaTweets;
    }
    
    /*public Usuario(String nameUser) {
        this.nameUser = nameUser;
    }
    
    public Usuario(String nameUser, List<Usuario> listaFollows, List<Usuario> listaFollowers) {
        this.nameUser = nameUser;
        this.listaFollows = listaFollows;
        this.listaFollowers = listaFollowers;
    }*/

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    /*public List<Usuario> getListaFollows() {
        return listaFollows;
    }

    public void setListaFollows(List<Usuario> listaFollows) {
        this.listaFollows = listaFollows;
    }

    public List<Usuario> getListaFollowers() {
        return listaFollowers;
    }

    public void setListaFollowers(List<Usuario> listaFollowers) {
        this.listaFollowers = listaFollowers;
    }*/

    public List<Tweet> getListaTweets() {
        return listaTweets;
    }

    public void setListaTweets(List<Tweet> listaTweets) {
        this.listaTweets = listaTweets;
    }
 
    
}
