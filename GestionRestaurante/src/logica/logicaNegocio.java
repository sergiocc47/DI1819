/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dto.Ticket;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sergio
 */
public class logicaNegocio {
    
    private List<Ticket> listaTickets;

    public logicaNegocio(List<Ticket> listaTickets) {
        this.listaTickets = listaTickets;
    }
    
    public void altaTicket(Ticket ticket){
        listaTickets.add(ticket);
    }
    
    public void altaTicket2(){
        
        /*
        private int numeroTicket;   //único
        private Date fecha;         //fecha y hora del ticket
        private boolean estado;     //cerrado=true abierto=false
        private Mesa mesaTicket;
        private List<ProductoTicket> listaProductosTicket;
        */

        Scanner sc = new Scanner(System.in);    //crear un objeto Scanner
        // Declaración de variables y entrada datos
        System.out.println("Introduzca el número del ticket: ");
        int numeroTicket= sc.nextInt();
        System.out.println("Introduzca la fecha del ticket (formato dd-MM-yy): ");
        String fechaTicket= sc.nextLine();
        System.out.println("Introduzca el estado del ticket (abierto=false o cerrado=true): ");
        boolean estado= sc.nextBoolean();
        //TODO ¿Mesa como clase o sólo idMesa?
        //System.out.println("Introduzca la división a la que pertenecen los equipos (a elegir entre Primera, Segunda y Tercera): ");
        //division= sc.nextLine();
        //System.out.println("Introduzca el resultado del partido (formato número-número): ");
        //resultado= sc.nextLine();
        
        
        //Ticket ticket = new Ticket(equipoLocal, equipoVisitante, resultado, fecha);
        //listaTickets.add(ticket);
    }
    
    public void mostrarListaPartidos(){
        for (Ticket ticket : listaTickets) {
            System.out.println(ticket);
        }
    }
    
    public void borrarPartido(Ticket ticket){
        listaTickets.remove(ticket);
    }
}
