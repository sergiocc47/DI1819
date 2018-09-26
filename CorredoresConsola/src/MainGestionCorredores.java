
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SC
 */

/*
La aplicación permitirá dar de alta, baja, modificar y consultar corredores. Todos los
formularios estarán validados. Los corredores estarán registrados en la aplicación y
podrán ser dados de alta en cualquiera de las carreras. Existirá también la posibilidad
de dar de alta corredores cuando se está creando una carrera.
Los corredores se podrán importar también un archivo CSV en el que vendrán los
datos de corredores, uno por cada linea.
 */
public class MainGestionCorredores {

    /**
     * @param args the command line arguments
     */
    GestorCorredores gc = new GestorCorredores();
    GestorFichero gf = new GestorFichero(gc);

    Scanner sc = new Scanner(System.in);

    public MainGestionCorredores() {

        int opcion;

        do {
            menu();
            opcion = tramitarOpcion();
        } while (opcion != 0);

    }

    public void menu() {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("1.- Dar de alta a un corredor");
        System.out.println("2.- Dar de baja a un corredor");
        System.out.println("3.- Modificar datos de un corredor");
        System.out.println("4.- Consultar la lista de corredores");     //¿¿o buscar individualmente??
        System.out.println("5.- Crear archivo CSV con los datos de los corredores");
        System.out.println("0.- Salir");
        System.out.println("----------------------------------------------------------------------------------------------");       
        System.out.println("Introduzca la opción: ");
    }

    public int tramitarOpcion() {
        int opcion;

        opcion = sc.nextInt();
        switch (opcion) {

            case 1:
                System.out.println("Introduzca el nombre del corredor: ");
                String nombre = sc.next();
                System.out.println("Introduzca el dni del corredor: ");
                String dni = sc.next();
                sc.nextLine();  //vacía el buffer
                System.out.println("Introduzca la fecha de nacimiento del corredor: ");
                String fechaComoTexto = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaNacimiento;
        try {
            fechaNacimiento = sdf.parse(fechaComoTexto);
        } catch (ParseException ex) {
            Logger.getLogger(MainGestionCorredores.class.getName()).log(Level.SEVERE, null, ex);
        }
                System.out.println("Introduzca la direccion del corredor: ");
                String direccion = sc.nextLine();
                System.out.println("Introduzca el teléfono de contacto del corredor: ");
                int telefonoContacto = sc.nextInt();
                Corredor c = new Corredor(nombre, dni, fechaNacimiento, direccion, telefonoContacto);
                gc.addCorredor(c);
                System.out.println("Corredor añadido con éxito");
                break;

            case 2:
                System.out.println("Introduzca el dni del corredor que desee borrar: ");
                dni = sc.next();
                int indice = gc.buscarCorredor(dni);
                if (indice != -1) {
                    gc.eliminarCorredor(indice);
                    System.out.println("Corredor eliminado con éxito");
                } else {
                    System.out.println("EL corredor no existe en la colección");
                }
                break;

            case 3:

                break;

            case 4:
                gc.mostrarCorredores();
                break;

            case 5:
                gf.escribirArchivo();
                System.out.println("CSV creado con éxito");
                break;

            case 0:
                System.out.println("Fin programa");
                break;
                
            default:
                System.out.println("La opción seleccionada no existe");
        }

        return opcion;
    }

    public static void main(String[] args) {
        new MainGestionCorredores();
    }

}
