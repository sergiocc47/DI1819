/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaztablemodels;

import dto.Carrera;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SC
 */
public class TableModelCarreras extends AbstractTableModel {

    private final List<Carrera> listaCarreras;
    private final String[] columnas = {"Nombre", "Fecha", "Lugar", "Nº máximo participantes"};

    public TableModelCarreras(List<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    @Override
    public int getRowCount() {
        return listaCarreras.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Carrera r = listaCarreras.get(fila);
        switch (columna) {
            case 0:
                return r.getNombreCarrera();
            case 1:
                return utils.Utils.sdf.format(r.getFechaCarrera());
            case 2:
                return r.getLugar();
            case 3:
                return r.getListaCorredoresDorsales().size();   // devuelve el tamaño del TreeMap
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i];
    }

}
