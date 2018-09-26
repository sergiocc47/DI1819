
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SC
 */
public class Corredor {
    /*
    Gestión de una lista de corredores. De cada corredor se almacenarán los
    siguientes datos:
    ◦ Nombre
    ◦ DNI
    ◦ Fecha de nacimiento
    ◦ Dirección
    ◦ Teléfono de contacto
    */
    private String nombre;
    private String dni;
    private Date fechaNacimiento;     
    private String direccion;
    private int telefonoContacto;

    public Corredor() {
    }

    public Corredor(String nombre, String dni, Date fechaNacimiento, String direccion, int telefonoContacto) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefonoContacto = telefonoContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public int getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefonoContacto(int telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @Override
    public String toString() {
        return "Corredor{" + "nombre=" + nombre + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", telefonoContacto=" + telefonoContacto + '}';
    }
    
    
            
}
