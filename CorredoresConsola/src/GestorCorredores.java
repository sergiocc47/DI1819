
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SC
 */
public class GestorCorredores {

    Set<Corredor> setCorredores;
    List<Corredor> listaCorredores = new ArrayList<Corredor>(setCorredores);

    public List<Corredor> getListaCorredores() {
        return listaCorredores;
    }

    public void addCorredor(Corredor c) {
        listaCorredores.add(c);
    }

    public void listarCorredores() {
        for (Corredor c : listaCorredores) {
            System.out.println(c);
        }
    }

    public void mostrarCorredores() {
        System.out.println("Lista de corredores: ");
        int i = 0;
        for (Corredor c : listaCorredores) {
            System.out.println(c);
            i++;
        }
    }

    // for each no es lo más correcto porque al eliminar un corredor 
    public int buscarCorredor(String dni) {
        int indice = 0;
        for (Corredor c : listaCorredores) {
            if (c.getDni().equals(dni)) {
                return indice;
            }
            indice++;
        }
        return -1;  // indice que no está en la lista (objeto no existe)
    }

    public void eliminarCorredor(int indice) {
        listaCorredores.remove(indice);
    }
    
    public void ordernarCorredores()
    {
        Collections.sort (listaCorredores,  new Comparator <Corredor>() {
            @Override
            public int compare(Corredor c1, Corredor c2) {
                return c1.getNombre().compareTo(c2.getNombre());
            }
        });
    }

    public void eliminarLista() {
        listaCorredores.clear();
    }

}
