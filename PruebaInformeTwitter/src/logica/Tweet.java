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
    private Date fechaPublicacion;
    private String texto;

    public Tweet(String texto) {
        this.fechaPublicacion = new Date();     // así coge la fecha de hoy (no nos preocupamos del formato)
        this.texto = texto;
    }

    public String getUsuario() {
        return nombreUsuario;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getTexto() {
        return texto;
    }
    
    
}
