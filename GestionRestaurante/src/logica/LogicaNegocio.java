/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dto.Mesa;
import dto.Producto;
import dto.Producto.Categorias;
import dto.ProductoTicket;
import dto.Ticket;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sergio
 */
public class LogicaNegocio {

    //private final String FICHERO_MESAS = "mesas.csv";             //usados en métodos
    //private final String FICHERO_PRODUCTOS_CARTA = "productos.csv";     //cargarArchivo
    private List<Ticket> listaTickets;
    private List<Mesa> listaMesas = new LinkedList<>();
    private List<Producto> listaProductosCarta = new LinkedList<>();

    public LogicaNegocio() {
        leerArchivoMesas();
        leerArchivoProductosCarta();
    }

    // Extraído de proyecto Ficheros_Completo
    public void leerArchivoMesas() {

        File fichero = new File("mesas.csv");

        try {
            FileReader fr = new FileReader(fichero);

            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int idMesa = Integer.parseInt(datos[0]);    // borra el 0 inicial del identificador de la mesa ya que al parsear no existe ninǵun entero que empiece por 0   
                String localizacion = datos[1].trim();      // trim: método que elimina los caracteres blancos iniciales y finales de la cadena, devolviendo una copia de la misma
                int capacidad = Integer.parseInt(datos[2]);
                Mesa mesa = new Mesa(idMesa, localizacion, capacidad);
                listaMesas.add(mesa);

            }
            //System.out.println(listaMesas);       //comprobación en consola
        } catch (FileNotFoundException ex) {
            System.out.println("No se puede leer el archivo");
        } catch (IOException ex) {
            System.out.println("Error al leer la linea");
        }
        // TODO cerrar buffers en un finally
    }

    public List<Mesa> getListaMesas() {
        return listaMesas;
    }
    
    public void altaMesa(Mesa mesa) {
        listaMesas.add(mesa);
        //comprobación por consola
        System.out.println("Mesa añadida con éxito.");
        for (int i = 0; i < listaMesas.size(); i++) {
            System.out.println(listaMesas.get(i));
        }
        // TODO persistencia mesas añadidas y mostrar en tabla
    }

    public void leerArchivoProductosCarta() {

        File fichero = new File("productos.csv");

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");
                String nombre = datos[0].trim();
                float precio = Float.parseFloat(datos[1]);    // borra el 0 inicial del identificador de la mesa ya que al parsear no existe ninǵun entero que empiece por 0   

                String categoria = datos[2].trim();
                /*
                // TODO Parece innecesario para recoger datos de Enum Categorias
                if (categoria == "BEBIDAS"){
                    Categorias.valueOf("BEBIDAS");
                }
                if (categoria == "PRIMER_PLATO"){
                    Categorias.valueOf("PRIMER_PLATO");
                }
                if (categoria == "SEGUNDO_PLATO"){
                    Categorias.valueOf("SEGUNDO_PLATO");
                }
                if (categoria == "POSTRE"){
                    Categorias.valueOf("POSTRE");
                }
                if (categoria == "OTROS"){
                    Categorias.valueOf("OTROS");
                }
                 */
                Producto producto = new Producto(nombre, precio, Categorias.valueOf(categoria));
                listaProductosCarta.add(producto);

            }
            //System.out.println(listaMesas);
        } catch (FileNotFoundException ex) {
            System.out.println("No se puede leer el archivo");
        } catch (IOException ex) {
            System.out.println("Error al leer la linea");
        // NOTA: cerrar buffers en un finally
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ioe) {
                    System.out.println("Error de escritura.");
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ioe) {
                    System.out.println("Error de escritura.");
                }
            }
        }

    }

    public List<Producto> getListaProductosCarta() {
        return listaProductosCarta;
    }

    public void altaTicket(Ticket ticket) {
        listaTickets.add(ticket);
    }

    // TODO Incompleto, adaptar en caso de pedir alta por pantalla
    public void altaTicket2() {

        int numeroTicket;   //único
        Date fecha = null;  //fecha y hora del ticket
        boolean estado;     //cerrado=true abierto=false
        int idMesa;
        Mesa mesaTicket;
        List<ProductoTicket> listaProductosTicket;
        int numCategoria;
        Producto.Categorias categoria = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
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

}
