package gui.tablemodels;

import dto.ProductoTicket;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sergio
 */
public class TableModelProductosTicket extends AbstractTableModel {

    private final List<ProductoTicket> listaProductosTicket;
    private final String[] columnas = {"Unidades", "Producto", "Categoría", "Subtotal"};

    public TableModelProductosTicket(List<ProductoTicket> listaProductosTicket) {
        this.listaProductosTicket = listaProductosTicket;
    }

    @Override
    public int getRowCount() {
    return listaProductosTicket.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    // Devuelve la columna correspondiente al índice
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    // Método que trata la información como un entero en una columna determinada (útil a la hora de ser ordenada la lista)
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Integer.class;
        } else {
            return String.class;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaProductosTicket.get(rowIndex).getCantidad();
            case 1:
                return listaProductosTicket.get(rowIndex).getProducto().getNombre();
            case 2:
                return listaProductosTicket.get(rowIndex).getProducto().getCategoria();
            case 3:
                return listaProductosTicket.get(rowIndex).getPrecioTotal();
        }
        return null;
    }
}
