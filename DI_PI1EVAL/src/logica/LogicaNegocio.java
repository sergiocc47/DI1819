/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dto.Corredor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SC
 */
public class LogicaNegocio {
    private List<Corredor> listaCorredores;
    
    public LogicaNegocio()
    {
        listaCorredores = new ArrayList<Corredor>();
    }
    
    public void altaPersona(Corredor corredor)
    {
        listaCorredores.add(corredor);
    }

    public List<Corredor> getListaCorredores() {
        return listaCorredores;
    }
    
}
