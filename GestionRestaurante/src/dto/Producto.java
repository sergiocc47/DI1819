package dto;

import java.util.Objects;

/**
 *
 * @author sergio
 */
public class Producto implements Comparable<Producto> {

    private String nombre;
    private double precio;
    //private Categorias categoria;     // si no nos queremos complicar con la enumeración podemos utilizar un String
    private String categoria;

    /*
    public enum Categorias {
        BEBIDAS, PRIMER_PLATO, SEGUNDO_PLATO, POSTRE, OTROS
    };  //más correcto: enumeración que debería meterse como una inner class
     */

    public Producto(String nombre, double precio, String categoria) {
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public int compareTo(Producto producto) {
        int resultado = this.nombre.compareToIgnoreCase(producto.nombre);
        /*
        Returns: the value 0 if the argument string is equal to this string; a 
        value less than 0 if this string is lexicographically less than the 
        string argument; and a value greater than 0 if this string is 
        lexicographically greater than the string argument.
         */
        if (resultado < 0) {
            return -1;
        } else if (resultado == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    // TODO: Comparación ignoreCase
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return true;
    }

    /*
    // Método código propio
    @Override
    public boolean equals(Object object) {
        if (this.nombre.equalsIgnoreCase(((Producto) object).nombre) && this.categoria.equalsIgnoreCase(((Producto) object).categoria)) {
            return true;
        } else {
            return false;
        }
    }
     */
    @Override
    public String toString() {
        //return "Producto{" + "nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria + '}';        // solución cutre pero de momento válida ya que solamente
        return nombre;      // TODO: No es necesario, metemos el getter en el setItem del ComboBox                  // usamos el nombre (para mostrar en el ComboBox)
    }

}
