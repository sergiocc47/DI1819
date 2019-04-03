/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import java.util.List;
import utils.Utils;

/**
 *
 * @author sergio
 */
public class Ticket {

    private int numeroTicket;   //único
    private Date fecha;         //fecha y hora del ticket
    private boolean estado;     //cerrado=true abierto=false
    private Mesa mesaTicket;    //TODO ¿Mesa o int?
    private List<ProductoTicket> listaProductosTicket;

    public Ticket(int numeroTicket, Date fecha, boolean estado, Mesa mesaTicket, List<ProductoTicket> listaProductosTicket) {
        this.numeroTicket = numeroTicket;
        this.fecha = fecha;
        this.estado = estado;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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

    @Override
    public String toString() {
        return "Ticket{" + "numeroTicket=" + numeroTicket + ", fecha=" +  Utils.sdf.format(fecha) + ", estado=" + estado + ", mesaTicket=" + mesaTicket + ", listaProductosTicket=" + listaProductosTicket + '}';
    }

}
