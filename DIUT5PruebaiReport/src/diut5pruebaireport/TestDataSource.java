package diut5pruebaireport;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sergio
 */
public class TestDataSource {

    public static List<Coche> listCoches() {

        List<Coche> listaCoches = new ArrayList<>();
        listaCoches.add(new Coche("Marca 1", "Modelo 1", "Matrícula 1"));
        listaCoches.add(new Coche("Marca 2", "Modelo 2", "Matrícula 2"));
        listaCoches.add(new Coche("Marca 3", "Modelo 3", "Matrícula 3"));
        listaCoches.add(new Coche("Marca 4", "Modelo 4", "Matrícula 4"));

        return listaCoches;
    }

}
