/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sergio
 */
public class Tweet {
    
    private String nombreUsuario;
    private String fechaPublicacion;
    private String texto;

    public Tweet(String nombreUsuario, String fechaPublicacion, String texto) {
        this.nombreUsuario = nombreUsuario;
        this.fechaPublicacion = fechaPublicacion;
        this.texto = texto;
    }

    public String getUsuario() {
        return nombreUsuario;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getTexto() {
        return texto;
    }
    
    
}
