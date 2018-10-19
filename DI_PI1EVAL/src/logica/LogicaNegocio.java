/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dto.Corredor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author SC
 */
public class LogicaNegocio {

    private List<Corredor> listaCorredores;

    public LogicaNegocio() {
        listaCorredores = new ArrayList<Corredor>();
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

    public void eliminarLista() {
        listaCorredores.clear();
    }

}
