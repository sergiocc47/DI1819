/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dto.Mesa;
import dto.Producto;
import dto.ProductoTicket;
import dto.Ticket;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class logicaNegocio {

    private final String FICHERO_MESAS = "mesas.csv";
    private final String FICHERO_PRODUCTOS = "productos.csv";
    private List<Ticket> listaTickets;

    public logicaNegocio() {
        cargarFicheroProductos();
    }

    public void altaTicket(Ticket ticket) {
        listaTickets.add(ticket);
    }

    public void altaTicket2() {

        int numeroTicket;   //único
        Date fecha = null;  //fecha y hora del ticket
        boolean estado;     //cerrado=true abierto=false
        int idMesa;
        Mesa mesaTicket;
        List<ProductoTicket> listaProductosTicket;
        int numCategoria;
        Producto.Categorias categoria = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);    //crear un objeto Scanner
        // Declaración de variables y entrada datos
        System.out.println("Introduzca el número del ticket: ");
        numeroTicket = sc.nextInt();
        System.out.println("Introduce una fecha... FORMATO dd/mm/yyyy  HH:mm:ss");
        String fechaTexto = sc.nextLine();
        {
            try {
                fecha = sdf.parse(fechaTexto);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Introduzca el estado del ticket (abierto=false o cerrado=true): ");
        estado = sc.nextBoolean();
        System.out.println("Introduzca el identificador de la mesa");
        idMesa = sc.nextInt();
        
        /*
        System.out.println("CATEGORIAS A ELEGIR:\n1- BEBIDAS, \n2- PRIMER_PLATO, \n3- SEGUNDO_PLATO, \n4- POSTRE, \n5- OTROS");
        System.out.println("Introduce la Categoría: ");
        numCategoria = Integer.parseInt(sc.nextLine());

        switch (numCategoria) {
            case 1:
                categoria = Producto.Categorias.BEBIDAS;
                break;
            case 2:
                categoria = Producto.Categorias.PRIMER_PLATO;
                break;
            case 3:
                categoria = Producto.Categorias.SEGUNDO_PLATO;
                break;
            case 4:
                categoria = Producto.Categorias.POSTRE;
                break;
            case 5:
                categoria = Producto.Categorias.OTROS;
                break;
        }
        */
        
        //TODO ¿Mesa como clase o sólo idMesa?

        //Ticket ticket = new Ticket(numeroTicket, fecha, estado, mesaTicket, listaProductosTicket);
        //listaTickets.add(ticket);
    }

    public void mostrarListaTickets() {
        for (Ticket ticket : listaTickets) {
            System.out.println(ticket);
        }
    }

    public void borrarTicket(Ticket ticket) {
        listaTickets.remove(ticket);
    }

    //TODO adaptar
    /*
    private void cargarFicheroProductos() {
        File file = new File(FICHERO_PRODUCTOS);
        if (file.exists()) {
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            LinkedList<Producto> lps = null;

            try {

                fis = new FileInputStream(FICHERO_PRODUCTOS);
                ois = new ObjectInputStream(fis);
                lps = (LinkedList<Producto>) ois.readObject();
                listaProductos = lps;

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    ois.close();
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(ObjectInput.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }*/
}
