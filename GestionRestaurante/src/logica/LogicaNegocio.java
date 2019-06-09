package logica;

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
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.openide.util.Exceptions;
import utils.Utils;

/**
 *
 * @author sergio
 */
public class LogicaNegocio {

    //private final String FICHERO_MESAS = "mesas.csv";                         // usados en métodos
    //private final String FICHERO_PRODUCTOS_CARTA = "productos_carta.csv";     // cargarArchivo
    //private final String FICHERO_TICKETS = "tickets.csv";
    // TODO: ¿No podrían ser todas las listas ArrayLists?
    private List<Mesa> listaMesas = new LinkedList<>();                 // TODO: ¿Cambiar a HashSet?
    private List<Producto> listaProductosCarta = new LinkedList<>();    // TODO: ¿Por qué LinkedList (en todas las listas)? ¿Valdría ArrayList?
    private List<ProductoTicket> listaProductosTicket = new LinkedList<>();     // TODO: ¿Es necesario?
    private List<Ticket> listaTickets = new LinkedList<>();             // TODO: Debería ser un HashSet por necesitar un identificador único (pero falla en TableModel)
    private List<Ticket> listaTicketsFiltradoMesa = new ArrayList<>();
    private List<Ticket> listaTicketsFiltradoFecha = new ArrayList<>();
    private Mesa mesaFiltradoTicket;
    private Date fechaInicioFiltradoTicket;
    private Date fechaFinFiltradoTicket;
    //private List<ProductoTicket> listaProductosCurrentTicket = new ArrayList<>();     // TODO: Borrar si no se utiliza
    private Ticket currentTicket;

    public LogicaNegocio() {
        leerArchivoMesas();
        leerArchivoProductosCarta();
        leerArchivoTickets();
    }

    public Ticket getCurrentTicket() {
        return currentTicket;
    }

    public void setCurrentTicket(Ticket currentTicket) {
        this.currentTicket = currentTicket;
    }

    // Extraído de proyecto Ficheros_Completo
    public void leerArchivoMesas() {

        File fichero = new File("mesas.csv");

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int idMesa = Integer.parseInt(datos[0]);    // borra el 0 inicial del identificador de la mesa ya que al parsear no existe ninǵun entero que empiece por 0   
                String localizacion = datos[1].trim();      // trim: método que elimina los caracteres blancos iniciales y finales de la cadena, devolviendo una copia de la misma
                int capacidad = Integer.parseInt(datos[2]);
                Mesa mesa = new Mesa(idMesa, localizacion, capacidad);
                listaMesas.add(mesa);
            }
            //System.out.println(listaMesas);       // TODO (borrar): Comprobación en consola
        } catch (FileNotFoundException ex) {
            System.out.println("No se puede leer el archivo.");
        } catch (IOException ex) {
            System.out.println("Error al leer la línea.");
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

    public List<Mesa> getListaMesas() {
        return listaMesas;
    }

    // MÉTODO COMPROBACIÓN CONSOLA
    public void listarMesas() {
        int cont = 0;
        System.out.println("LISTA MESAS:");
        // NOTA: Método más correcto para recorrer una lista
        Iterator it = listaMesas.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            cont++;
        }
        System.out.println("----------------------------------------------");
        System.out.println("Número de mesas: " + cont);
        System.out.println("----------------------------------------------");
    }

    // Válido para List (en este caso LinkedList)
    public void altaMesa(Mesa mesa) {
        if (!listaMesas.contains(mesa)) {
            listaMesas.add(mesa);
            Collections.sort(listaMesas);
            System.out.println("Mesa añadida con éxito.");      // TODO (borrar): Comprobación por consola
        } else {
            // TODO (borrar): Comprobación por consola
            for (int i = 0; i < listaMesas.size(); i++) {
                System.out.println(listaMesas.get(i));
            }
        }
    }

    // TODO (borrar): Si no se utiliza
    // Método similar a altaMesa (crea la mesa en vez de recibirla como parámetro)
    public void anhadirMesa(int idMesa, String localizacion, int capacidad) {
        Mesa mesa = new Mesa(idMesa, localizacion, capacidad);
        if (!listaMesas.contains(mesa)) {
            listaMesas.add(mesa);
            Collections.sort(listaMesas);
            System.out.println("Mesa añadida con éxito.");      // TODO (borrar): Comprobación por consola
        }
        // TODO (borrar): Comprobación por consola
        for (int i = 0; i < listaMesas.size(); i++) {
            System.out.println(listaMesas.get(i));
        }
    }

    public boolean existeMesa(Mesa mesa) {
        return listaMesas.contains(mesa);
        /*
        Método equivalente (aunque no recomendado a la hora de comparar ya que es menos eficiente)
        for (Mesa m : listaMesas) {
        if (mesa.equals(m){
        }*/
    }

    public void leerArchivoProductosCarta() {

        File fichero = new File("productos_carta.csv");

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0].trim();
                double precio = Double.parseDouble(datos[1]);
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
                Producto producto = new Producto(nombre, precio, categoria);
                //Producto producto = new Producto(nombre, precio, Categorias.valueOf(categoria));  // en caso de utilizar enumeración
                listaProductosCarta.add(producto);

            }
            //System.out.println(listaProductosCarta);   // TODO (borrar): Comprobación por consola
        } catch (FileNotFoundException ex) {
            System.out.println("No se puede leer el archivo.");
        } catch (IOException ex) {
            System.out.println("Error al leer la línea.");
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

    // MÉTODO COMPROBACIÓN CONSOLA
    public void listarProductosCarta() {
        int cont = 0;
        System.out.println("LISTA PRODUCTOS CARTA:");
        // NOTA: Método más correcto para recorrer una lista
        Iterator it = listaProductosCarta.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            cont++;
        }
        System.out.println("----------------------------------------------");
        System.out.println("Número de productos de la carta: " + cont);
        System.out.println("----------------------------------------------");
    }

    // Válido para List (en este caso LinkedList)
    public void altaProductoCarta(Producto producto) {
        if (!listaProductosCarta.contains(producto)) {
            listaProductosCarta.add(producto);
            Collections.sort(listaProductosCarta);
            System.out.println("Producto añadido con éxito.");      // TODO (borrar): Comprobación por consola
        } else {
            // TODO (borrar): Comprobación por consola
            for (int i = 0; i < listaProductosCarta.size(); i++) {
                System.out.println(listaProductosCarta.get(i));
            }
        }
    }

    public boolean existeProductoCarta(Producto producto) {
        return listaProductosCarta.contains(producto);
    }

    public void leerArchivoTickets() {

        File fichero = new File("tickets.csv");

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int numeroTicket = Integer.parseInt(datos[0]);
                Ticket ticketCSV = null;
                // Lo funcional es tener una variable de tipo ticket
                // Si numeroTicket no existe en la lista de tickets, creas uno nuevo
                Date fecha = Utils.sdf.parse(datos[1]);             // TODO (fail): Formatear correctamente a "dd/MM/yyyy HH:mm:ss"
                boolean cerrado = Boolean.parseBoolean(datos[2]);
                int numMesa = Integer.parseInt(datos[3]);
                int cantidad = Integer.parseInt(datos[4]);
                String nombreProducto = datos[5];
                /*
                // Mi propuesta (menos correcta al usar un 'for' normal)
                for (int i = 0; i < listaMesas.size(); i++) {
                    if(listaMesas.get(i).getIdMesa()==numMesa){
                        mesaTicket = listaMesas.get(i);
                    }
                }
                 */
                Mesa mesaTicketCSV = null;
                for (Mesa mesa : listaMesas) {
                    if (mesa.getIdMesa() == numMesa) {
                        mesaTicketCSV = mesa;
                    }
                }

                // Si ya existe el ticket, lo obtenemos de la colección y simplemente añadir el producto
                for (Ticket ticket : listaTickets) {
                    // Si ticket tiene el mismo Id que viene del CSV ticketCSV = ticket
                    if (ticket.getNumeroTicket() == numeroTicket) {
                        ticketCSV = ticket;
                        break;
                    }
                }

                if (ticketCSV == null) {
                    ticketCSV = new Ticket(numeroTicket, fecha, cerrado, mesaTicketCSV, this);
                    listaTickets.add(ticketCSV);
                }

                Producto productoCarta;
                for (Producto producto : listaProductosCarta) {
                    if (producto.getNombre().equals(nombreProducto)) {
                        productoCarta = producto;
                        ProductoTicket productoTicketCSV = new ProductoTicket(cantidad, productoCarta);
                        ticketCSV.getListaProductosTicket().add(productoTicketCSV);
                    }
                }
            }
            //System.out.println(listaTickets);   // TODO (borrar): Comprobación consola
        } catch (FileNotFoundException ex) {
            System.out.println("No se puede leer el archivo");
        } catch (IOException ex) {
            System.out.println("Error al leer la linea");
            // NOTA: cerrar buffers en un finally
        } catch (ParseException ex) {
            Exceptions.printStackTrace(ex);
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

    public void altaTicket(Ticket ticket) {
        listaTickets.add(ticket);
    }

    public boolean existeTicket(Ticket ticket) {
        return listaTickets.contains(ticket);
    }

    /*
    // TODO: Incompleto, adaptar en caso de pedir alta por pantalla
    public void altaTicket2(int numeroTicket, Date fecha, boolean estado, int idMesa, List<ProductoTicket> listaProductosTicket, String categoria) {
        
        int numeroTicket;   //único
        Date fecha = null;  //fecha y hora del ticket
        boolean estado;     //cerrado=true abierto=false
        int idMesa;
        Mesa mesaTicket;
        List<ProductoTicket> listaProductosTicket;
        String numCategoria;
        //Producto.Categorias categoria = null;     // en caso de utilizar enumeración
        
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
        
        // COMENTADO DESDE AQUÍ
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
        // COMENTADO HASTA AQUÍ
    
        //TODO ¿Mesa como clase o sólo idMesa?
        //Ticket ticket = new Ticket(numeroTicket, fecha, estado, mesaTicket, listaProductosTicket);
        //listaTickets.add(ticket);
    }
    */
    
    public List<Ticket> getListaTickets() {
        return listaTickets;
    }

    public void borrarTicket(Ticket ticket) {
        listaTickets.remove(ticket);
    }

    // MÉTODO COMPROBACIÓN CONSOLA
    public void listarTickets() {
        int cont = 0;
        System.out.println("LISTA TICKETS:");
        // NOTA: Método más correcto para recorrer una lista
        Iterator it = listaTickets.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            cont++;
        }
        System.out.println("----------------------------------------------");
        System.out.println("Número de tickets: " + cont);
        System.out.println("----------------------------------------------");
    }

    // Método comprobación por consola
    public void mostrarListaTickets() {
        for (Ticket ticket : listaTickets) {
            System.out.println(ticket);
        }
    }

    public Mesa getMesaFiltradoTicket() {
        return mesaFiltradoTicket;
    }

    public void setMesaFiltradoTicket(Mesa mesaFiltradoTicket) {
        this.mesaFiltradoTicket = mesaFiltradoTicket;
    }

    // TODO (fail): Corregir que siempre coja el ticket nº 4 (de la mesa 1) y lo añada dos veces
    public List<Ticket> getListaTicketsFiltradoMesa(Mesa mesaFiltrado) {
        for (Ticket ticket : listaTickets) {
            if (ticket.getMesaTicket() == mesaFiltrado) {
                listaTicketsFiltradoMesa.add(ticket);
            }
        }
        return listaTicketsFiltradoMesa;
    }

    // TODO (fail): Corregir método ¿Necesarios getter y setter fechas filtrado?
    public List<Ticket> getListaTicketsFiltradoFecha(Date fechaInicioFiltradoTicket, Date fechaFinFiltradoTicket) {
        /*for (Ticket ticket : listaTickets) {
            //if (ticket.getFecha().compareTo(fechaFinFiltradoTicket)...)
                //Return value is 0 if both dates are equal.
                //Return value is greater than 0 , if Date is after the date argument.
                //Return value is less than 0, if Date is before the date argument.
            
            if (ticket.getFecha() >= fechaInicioFiltradoTicket && ticket.getFecha() <= fechaFinFiltradoTicket){
                listaTicketsFiltradoFecha.add(ticket);
            }
        }*/
        return listaTicketsFiltradoFecha;
    }

    /*
    // TODO: ¿Necesarios todos los métodos relacionados con listaProductosTicket?
    // ¿No debería ser sólo accesible desde el ticket que contenga esa listaProductosTicket?
    // Más correcto (y claro) si lo hacemos con referencia a  listaProductosCurrentTicket
    public void leerlistaProductosCurrentTicket(){
        listaProductosCurrentTicket = getCurrentTicket().getListaProductosTicket();
    }
     */
    // TODO (fail): Corregir añadido por duplicado al modificar ¿tal vez por usar producto ticket en vez de producto.nombre?
    public void altaProductoTicket(ProductoTicket productoTicket) {
        if (!getCurrentTicket().getListaProductosTicket().contains(productoTicket)) {
            getCurrentTicket().getListaProductosTicket().add(productoTicket);
            Collections.sort(getCurrentTicket().getListaProductosTicket());
            System.out.println("Producto añadido al ticket con éxito.");      // TODO (borrar): Comprobación por consola
        } else {
            // TODO (borrar): Comprobación por consola
            //System.out.println("Producto NO añadido al ticket.");    // lo muestra siempre que haya modificación porque no le llega productoTicketModificar
            for (int i = 0; i < getCurrentTicket().getListaProductosTicket().size(); i++) {
                System.out.println(getCurrentTicket().getListaProductosTicket().get(i));
            }
        }
    }

    public List<ProductoTicket> getListaProductosTicket(Ticket ticket) {
        return listaProductosTicket = getCurrentTicket().getListaProductosTicket();
    }

    public void existeProductoTicket(ProductoTicket productoTicket) {
        getCurrentTicket().getListaProductosTicket().contains(productoTicket);
    }

    public void borrarProductoTicket(ProductoTicket productoTicket) {
        getCurrentTicket().getListaProductosTicket().remove(productoTicket);
    }

    // TODO (borrar/posible fail): MÉTODO COMPROBACIÓN CONSOLA
    public void listarProductosTicket(Ticket currentTicket) {
        int cont = 0;
        System.out.println("LISTA PRODUCTOS TICKET:");
        // NOTA: Método más correcto para recorrer una lista
        Iterator it = getListaProductosTicket(currentTicket).iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            cont++;
        }
        System.out.println("----------------------------------------------");
        System.out.println("Número de productos en el ticket: " + cont);
        System.out.println("----------------------------------------------");
    }

    // TODO (borrar): Método comprobación por consola
    public void mostrarListaProductosTicket() {
        for (ProductoTicket productoTicket : getCurrentTicket().getListaProductosTicket()) {
            System.out.println(productoTicket);
        }
    }

}
