/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author SC
 */
public class Carrera implements Comparable<Carrera> {

    /*
    Gestión de carreras. Cada carrera tendrá una lista de participantes. Se
    almacenarán además los siguientes datos:
    ◦ Nombre de la carrera.
    ◦ Fecha de la carrera.
    ◦ Lugar de la carrera.
    ◦ Número máximo de participantes.
    ◦ Lista de corredores y dorsal asociado al corredor.
     */
    private String nombreCarrera;
    private Date fechaCarrera;
    private String lugar;
    private int numMaxParticipantes;
    private Corredor[] listaCorredoresInscritos;
    private TreeMap<Integer, Corredor> listaCorredoresDorsales;

    public Carrera(String nombreCarrera, Date fechaCarrera, String lugar, int numMaxParticipantes) {
        this.nombreCarrera = nombreCarrera;
        this.fechaCarrera = fechaCarrera;
        this.lugar = lugar;
        this.numMaxParticipantes = numMaxParticipantes;
        this.listaCorredoresInscritos = new Corredor[numMaxParticipantes];
        this.listaCorredoresDorsales = new TreeMap<Integer, Corredor>();
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public Date getFechaCarrera() {
        return fechaCarrera;
    }

    public String getLugar() {
        return lugar;
    }

    public int getNumMaxParticipantes() {
        return numMaxParticipantes;
    }

    public Corredor[] getListaCorredoresInscritos() {
        return listaCorredoresInscritos;
    }

    public TreeMap<Integer, Corredor> getListaCorredoresDorsales() {
        return listaCorredoresDorsales;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public void setFechaCarrera(Date fechaCarrera) {
        this.fechaCarrera = fechaCarrera;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setNumMaxParticipantes(int numMaxParticipantes) {
        this.numMaxParticipantes = numMaxParticipantes;
    }

    public void setListaCorredoresInscritos(Corredor[] listaCorredoresInscritos) {
        this.listaCorredoresInscritos = listaCorredoresInscritos;
    }

    public void setListaCorredoresDorsales(TreeMap<Integer, Corredor> listaCorredoresDorsales) {
        this.listaCorredoresDorsales = listaCorredoresDorsales;
    }

    @Override
    public String toString() {
        return "Carrera{" + "nombreCarrera=" + nombreCarrera + ", lugar=" + lugar + '}';
    }

    // modificar (método innecesario si no implementa Comparable)
    @Override
    public int compareTo(Carrera t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
