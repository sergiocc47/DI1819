/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dto.Carrera;
import dto.Corredor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author SC
 */
public class LogicaNegocio {

    private List<Corredor> listaCorredores;
    
    private List<Carrera> listaCarreras;

    public LogicaNegocio() {
        listaCorredores = new ArrayList<Corredor>();
        listaCarreras = new ArrayList<Carrera>();
    }

    public void altaCorredor(Corredor corredor) {
        listaCorredores.add(corredor);
    }
    
    public void borrarCorredor(Corredor corredor){
        listaCorredores.remove(corredor);
    }

    public List<Corredor> getListaCorredores() {
        return listaCorredores;
    }

    public void listarCorredores() {
        System.out.println("LISTA CORREDORES:");
        Iterator it = listaCorredores.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("----------------------------------------------");
    }

    public void eliminarListaCorredores() {
        listaCorredores.clear();
    }
    
    public void altaCarrera(Carrera carrera){
        listaCarreras.add(carrera);
    }

    public void borrarCarrera (Carrera carrera){
        listaCarreras.remove(carrera);
    }

    public List<Carrera> getListaCarreras() {
        return listaCarreras;
    }
    
    public void listarCarreras(){
        System.out.println("LISTA CARRERAS:");
        Iterator it = listaCarreras.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("----------------------------------------------");
    }
    
    public void eliminarListaCarreras(){
        listaCarreras.clear();
    }
}
