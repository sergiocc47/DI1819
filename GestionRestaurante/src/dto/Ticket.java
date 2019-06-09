package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import logica.LogicaNegocio;
import utils.Utils;

/**
 *
 * @author sergio
 */
public class Ticket implements Comparable<Ticket> {

    private int numeroTicket;   // único
    private Date fecha;         // fecha y hora del ticket
    private boolean cerrado;    // si lo hiciesemos con estado tendríamos que settear valor en TablaTickets según true o false (bucle if)
    private Mesa mesaTicket;
    private List<ProductoTicket> listaProductosTicket;
    //private List<ProductoTicket> listaProductosTicketBackup;      // necesario para que no se reflejen cambios en caso de cerrar la ventana con la 'x'
    private LogicaNegocio logicaNegocio;

    // TODO: Eliminar si no se utiliza
    public Ticket() {
    }

    public Ticket(int numeroTicket, Mesa mesaTicket) {
        this.numeroTicket = numeroTicket;
        this.mesaTicket = mesaTicket;
        fecha = new Date();
        cerrado = false;
        listaProductosTicket = new LinkedList<ProductoTicket>();

    }

    public Ticket(int numeroTicket, Date fecha, boolean cerrado, Mesa mesaTicket, LogicaNegocio logicaNegocio) {
        this.numeroTicket = numeroTicket;
        this.fecha = fecha;
        this.cerrado = cerrado;
        this.mesaTicket = mesaTicket;
        listaProductosTicket = new LinkedList<>();
        this.logicaNegocio = logicaNegocio;
    }

    public Ticket(int numeroTicket, Date fecha, boolean cerrado, Mesa mesaTicket, List<ProductoTicket> listaProductosTicket) {
        this.numeroTicket = numeroTicket;
        this.fecha = fecha;
        this.cerrado = cerrado;
        this.mesaTicket = mesaTicket;
        this.listaProductosTicket = listaProductosTicket;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isCerrado() {
        return cerrado;
    }

    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }

    public Mesa getMesaTicket() {
        return mesaTicket;
    }

    public void setMesaTicket(Mesa mesaTicket) {
        this.mesaTicket = mesaTicket;
    }

    public List<ProductoTicket> getListaProductosTicket() {
        return listaProductosTicket;
    }

    public void setListaProductosTicket(List<ProductoTicket> listaProductosTicket) {
        this.listaProductosTicket = listaProductosTicket;
    }

    public double calcularTotalTicket(){
        double totalTicket = 0;
        for (ProductoTicket productoTicket : listaProductosTicket) {
            double totalProductoTicket = productoTicket.getPrecioTotal();
            totalTicket += totalProductoTicket;
        }
        return totalTicket;
    }
    
    @Override
    public int compareTo(Ticket ticket) {
        if (this.numeroTicket < ((Ticket) ticket).numeroTicket) {
            return -1;
        } else if (this.numeroTicket == ((Ticket) ticket).numeroTicket) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.numeroTicket;
        return hash;
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
        final Ticket other = (Ticket) obj;
        if (this.numeroTicket != other.numeroTicket) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ticket{" + "numeroTicket=" + numeroTicket + ", fecha=" + Utils.sdf.format(fecha) + ", estado=" + cerrado + ", mesaTicket=" + mesaTicket + ", listaProductosTicket=" + listaProductosTicket + '}';
    }

}
