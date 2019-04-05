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
public class Producto implements Serializable {

    private String nombre;
    private float precio;
    private Categorias categoria;   //si no nos queremos complicar con la enumeración podemos utilizar un String

    public enum Categorias {
        BEBIDAS, PRIMER_PLATO, SEGUNDO_PLATO, POSTRE, OTROS
    };   //más correcto: enumeración que debería meterse como una inner class

    public Producto(String nombre, float precio, Categorias categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria + '}';
    }

}
