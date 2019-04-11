/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import com.opencsv.CSVReader;
import dto.Mesa;
import dto.Producto;
import dto.ProductoTicket;
import dto.Ticket;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class LogicaNegocioFail {

    //private final String FICHERO_MESAS = "mesas.csv";             //usados en métodos
    //private final String FICHERO_PRODUCTOS_CARTA = "productos.csv";     //cargarArchivo
    private List<Ticket> listaTickets;
    private List<Mesa> listaMesas = new LinkedList<>();
    private List<Producto> listaProductosCarta = new LinkedList<>();

    public LogicaNegocioFail() {
        //cargarFicheroProductos();
        //cargarFicheroMesas();
        //cargarCSVMesas();

    }

    /*
    // TODO No válido puesto que no recibe información binaria si no de texto (además da fallo NullPointerException)
    private void cargarFicheroProductos() {
        File file = new File(FICHERO_PRODUCTOS_CARTA);
        if (file.exists()) {
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            LinkedList<Producto> llp = null;

            try {

                fis = new FileInputStream(FICHERO_PRODUCTOS_CARTA);
                ois = new ObjectInputStream(fis);
                llp = (LinkedList<Producto>) ois.readObject();
                listaProductosCarta = llp;

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                //System.out.println("No se puede leer el archivo");
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
                //System.out.println("Error al leer la linea");
            } finally {
                try {
                    ois.close();
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(ObjectInput.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    }
     */
 /*
    private void cargarFicheroMesas() {
        File file = new File(FICHERO_MESAS);
        if (file.exists()) {
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            LinkedList<Mesa> llm = null;

            try {

                fis = new FileInputStream(FICHERO_MESAS);
                ois = new ObjectInputStream(fis);
                llm = (LinkedList<Mesa>) ois.readObject();
                listaMesas = llm;

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ObjectInput.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
    }
     */
    // TODO Cargar librería apache (ERROR NoClassDefFoundError: org/apache/commons/lang3/ObjectUtils)
    public void cargarCSVMesas() {
        try {
            CSVReader reader = new CSVReader(new FileReader("mesas.csv"), ',');
            String[] nextLine;
            List<Mesa> listaMesas = new ArrayList<Mesa>();
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {

                int idMesa = Integer.parseInt(nextLine[0]);
                String localizacion = nextLine[1];
                int capacidad = Integer.parseInt(nextLine[2]);
                /*
                int idMesa = -1;        // damos un valor que no sea coherente para este atributo y luego lo controlo con un if (ej. media, si no hay valor que no lo contabilice para su cálculo)
                if (!"".equals(nextLine[0])) {
                    idMesa = Integer.parseInt(nextLine[0]);
                }
                
                
                String localizacion = null;
                if (!"".equals(nextLine[1])) {
                    localizacion = nextLine[1];
                }
                

                int capacidad = -1;
                if (!"".equals(nextLine[2])) {
                    capacidad = Integer.parseInt(nextLine[2]);
                }
                 */
                listaMesas.add(new Mesa(idMesa, localizacion, capacidad));
            }
            System.out.println(listaMesas);
        } catch (Throwable ex) {
            ex.printStackTrace();
            Logger.getLogger(LogicaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //------------------------------------------------------------------------------------
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
