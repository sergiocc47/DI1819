/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primercomponente;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import javax.swing.JButton;

/**
 *
 * @author SC
 */
public class PrimerComponente extends JButton implements Serializable {

    //public static final 
    private Date momentoPulsacion;
    private File registroPulsacion;
    //private ruta
    
    public PrimerComponente() {
        super();
        setText("Registrar pulsación");

    }

    public Date getMomentoPulsacion() {
        return momentoPulsacion;
    }

    public File getRegistroPulsacion() {
        return registroPulsacion;
    }

    public void setMomentoPulsacion(Date momentoPulsacion) {
        this.momentoPulsacion = momentoPulsacion;
    }

    public void setRegistroPulsacion(File registroPulsacion) {
        this.registroPulsacion = registroPulsacion;
    }

    

}
