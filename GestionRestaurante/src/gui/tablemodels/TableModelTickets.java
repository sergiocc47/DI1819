/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tablemodels;

import dto.Ticket;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sergio
 */
public class TableModelTickets  extends AbstractTableModel {

    private final List<Ticket> listaTickets;
    private final String[] columnas = {"Nº ticket", "Fecha", "Cerrado", "Mesa"};

    public TableModelTickets(List<Ticket> listaTickets) {
        this.listaTickets = listaTickets;
    }

    // Devuelve el número de filas que tendrá nuestra tabla. Depende del
    // tamaño de la lista
    @Override
    public int getRowCount() {
        return listaTickets.size();
    }

    // Devuelve el número de columnas
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    // Devuelve la columna correspondiente al índice
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    // Este método se llamará una vez por cada una de las celdas que tenga la tabla.
    // Evidentemente el número de llamadas a este método depende de lo que haya
    // devuelto la clase en getRowCount y getColumnCount.
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaTickets.get(rowIndex).getNumeroTicket();
            case 1:
                return listaTickets.get(rowIndex).getFecha();
            case 2:
                return listaTickets.get(rowIndex).isCerrado();
            case 3:
                return listaTickets.get(rowIndex).getMesaTicket().getIdMesa();
        }
        return null;
    }

}
