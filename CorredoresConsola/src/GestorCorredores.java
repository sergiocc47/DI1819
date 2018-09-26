
import java.util.ArrayList;
import java.util.List;


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

    List<Corredor> listaCorredores = new ArrayList<Corredor>();

    public List<Corredor> getListaCorredores() {
        return listaCorredores;
    }
    
    public void addCorredor(Corredor c){
        listaCorredores.add(c);
    }
    
    public void listarCorredores(){
        for (Corredor c : listaCorredores){
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

    public void eliminarLista() {
        listaCorredores.clear();
    }
    
}
