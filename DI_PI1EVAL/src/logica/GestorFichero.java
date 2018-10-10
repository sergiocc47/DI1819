/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dto.Corredor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static utils.Utils.sdf;

/**
 *
 * @author SC
 */
public class GestorFichero {
    
    LogicaNegocio logicaNegocio;

    public GestorFichero(LogicaNegocio logicaNegocio) {
        this.logicaNegocio = logicaNegocio;
    }
    
    public void leerArchivo (){
        
        File fichero = new File("corredores.csv");
        
        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String nombre = datos[0];
                String dni = datos[1];
                try {
                    Date fechaNacimiento = sdf.parse(datos[2]);
                } catch (ParseException ex) {
                    Logger.getLogger(GestorFichero.class.getName()).log(Level.SEVERE, null, ex);
                }
                String dirección = datos[3];
                int telefonoContacto = Integer.parseInt(datos[4]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestorFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestorFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escribirArchivo(){
        
        try {
            FileWriter fw = new FileWriter ("corredores.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            List<Corredor> listaCorredores = logicaNegocio.getListaCorredores();
            for (Corredor c : logicaNegocio.getListaCorredores()){
                String linea = c.getNombre() + ";" + c.getDni() + ";" + c.getFechaNacimiento() + ";" + c.getDireccion() + ";" + c.getTelefonoContacto();
                pw.println(linea);
            }
            
            pw.close();
            logicaNegocio.eliminarLista();     //vacía la lista para evitar información duplicada
            
        } catch (IOException ex) {
            Logger.getLogger(GestorFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
