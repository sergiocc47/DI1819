/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaztablemodels;

import dto.Corredor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SC
 */
public class TableModelCorredores extends AbstractTableModel {

    private final List<Corredor> listaCorredores;
    private final String[] columnas = {"Nombre", "DNI", "Fecha de nacimiento", "Dirección", "Teléfono de contacto"};

    public TableModelCorredores(List<Corredor> listaCorredores) {
        this.listaCorredores = listaCorredores;
    }

    //Devuelve el número de filas que va a tener nuestra tabla (depende del 
    //tamaño de nuestra lista).
    @Override
    public int getRowCount() {
        return listaCorredores.size();
    }

    //Devuelve el número de columnas.
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    //Devuelve la columna correspondiente al índice.
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    //Llama una vez por cada una de las celdas que tenga la tabla. Depende de lo 
    //que haya devuelto la clase en getRowCount y getColumnCount.
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaCorredores.get(rowIndex).getNombre();
            case 1:
                return listaCorredores.get(rowIndex).getDni();
            case 2:
                return utils.Utils.sdf.format(listaCorredores.get(rowIndex).getFechaNacimiento());
            case 3:
                return listaCorredores.get(rowIndex).getDireccion();
            case 4:
                return listaCorredores.get(rowIndex).getTelefonoContacto();
        }
        return null;
    }
    
    /*
    //Otra forma
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex == 0) {
            return listaCorredores.get(rowIndex).getNombre();
        } else if (rowIndex == 1) {
            return listaCorredores.get(rowIndex).getDni();
        } else if (rowIndex == 2) {
            return listaCorredores.get(rowIndex).getFechaNacimiento();
        } else if (rowIndex == 3) {
            return listaCorredores.get(rowIndex).getDireccion();
        } else if (rowIndex == 4) {
            return listaCorredores.get(rowIndex).getTelefonoContacto();
        }
        return null;
    }
    */
}
