
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class GestorFichero {

    GestorCorredores gc;

    public GestorFichero(GestorCorredores gc) {
        this.gc = gc;
    }

    public void leerArchivo() {
        File fichero = new File ("corredores.csv");
        try {
            FileReader fr = new FileReader (fichero);
            BufferedReader br = new BufferedReader (fr);
            /*
            // adaptar a los atributos de corredores
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String nombre = datos[0].trim();        //trim: método que elimina los caracteres blancos iniciales y finales de la cadena, devolviendo una copia de la misma
                int edad = Integer.parseInt(datos[1]);
                Persona p = new Persona(nombre, edad);
                gp.addPersona(p);
                */
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestorFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
            
    public void escribirArchivo() {

        try {
            FileWriter fw = new FileWriter("corredores.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            List<Corredor> listaCorredores = gc.getListaCorredores();
            for (Corredor c : listaCorredores) {
                String linea = c.getNombre() + ";" + c.getDni() + ";" + c.getFechaNacimiento() + ";" + c.getDireccion() + ";" + c.getTelefonoContacto();
                pw.println(linea);

            }
            pw.close();
            gc.eliminarLista();     //vacía la lista para evitar información duplicada
        } catch (IOException ex) {
            System.out.println("No se puede crear el archivo");
        }
    }

}
