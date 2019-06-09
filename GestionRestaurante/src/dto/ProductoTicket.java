package dto;

import java.util.Objects;

/**
 *
 * @author sergio
 */
public class ProductoTicket implements Comparable<ProductoTicket> { 
    
    private int cantidad;
    private Producto producto;
    private double precioTotal;

    public ProductoTicket(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
        precioTotal = getPrecioTotal();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getPrecioTotal() {
        return precioTotal = cantidad * producto.getPrecio();     // No carga bien al rellenar TablaTickets
        //return precioTotal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.producto);
        return hash;
    }

    // TODO: Corregir método
    @Override
    public int compareTo(ProductoTicket productoTicket) {
        int resultado = this.producto.getCategoria().compareTo(productoTicket.getProducto().getCategoria());
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
        final ProductoTicket other = (ProductoTicket) obj;
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProductoTicket{" + "cantidad=" + cantidad + ", producto=" + producto + ", precioTotal=" + precioTotal + '}';
    }

}
