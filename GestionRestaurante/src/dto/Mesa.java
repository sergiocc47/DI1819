/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author sergio
 */
public class Mesa implements Serializable {

    private int idMesa;
    private String localizacion;
    private int capacidad;

    public Mesa(int idMesa, String localizacion, int capacidad) {
        this.idMesa = idMesa;
        this.localizacion = localizacion;
        this.capacidad = capacidad;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    // Método para crear array de strings con los datos del objeto mesa para ser
    // añadidos en una nueva fila de una DefaultTableModel
    public String[] toArrayString() {
        String[] s = new String[2];
        s[0] = Integer.toString(idMesa);
        s[1] = localizacion;
        s[2] = Integer.toString(capacidad);
        return s;
    }

    @Override
    public String toString() {
        return "Mesa{" + "idMesa=" + idMesa + ", localizacion=" + localizacion + ", capacidad=" + capacidad + '}';
    }

}
