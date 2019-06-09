package gui;

import dto.Producto;
import gui.tablemodels.TableModelProductosCarta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableRowSorter;
import logica.LogicaNegocio;

/**
 *
 * @author sergio
 */
public class GestionCarta extends javax.swing.JDialog {

    private PantallaPrincipal pantallaPrincipal;
    private LogicaNegocio logicaNegocio;
    private Producto productoModificar;

    // Almacenamos aquí esta propiedad para poder acceder a ella desde el botón
    // de filtrar
    private TableRowSorter<TableModelProductosCarta> sorter;

    /**
     * Creates new form GestionInventario
     */
    public GestionCarta(java.awt.Frame parent, boolean modal, LogicaNegocio logicaNegocio) {
        super(parent, modal);
        pantallaPrincipal = (PantallaPrincipal) parent;
        this.logicaNegocio = logicaNegocio;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("GESTIÓN CARTA");

        Collections.sort(logicaNegocio.getListaProductosCarta());   // TODO: ¿Redundante si ya lo hemos hecho en otros métodos?
        rellenarTablaProductosCarta();

    }

    // Utilizando un AbstractTableModel
    private void rellenarTablaProductosCarta() {
        TableModelProductosCarta tmpc = new TableModelProductosCarta(logicaNegocio.getListaProductosCarta());
        jTableProductosCarta.setModel(tmpc);
        /*
        // TODO: Eliminar si todo funciona correctamente
        // Añadimos la funcionalidad de ordenar
        sorter = new TableRowSorter<>(tmpc);            // TODO: Eliminar para que no de error
        jTableProductosCarta.setRowSorter(sorter);      // al seleccionar un item tras ordenar

        // Establecemos el orden por defecto
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelGestionCarta = new javax.swing.JLabel();
        jButtonAnhadirProductoCarta = new javax.swing.JButton();
        jButtonModificarProductoCarta = new javax.swing.JButton();
        jButtonEliminarProductoCarta = new javax.swing.JButton();
        jScrollPaneProductosCarta = new javax.swing.JScrollPane();
        jTableProductosCarta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelGestionCarta.setText("GESTIÓN CARTA");

        jButtonAnhadirProductoCarta.setText("Añadir producto");
        jButtonAnhadirProductoCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnhadirProductoCartaActionPerformed(evt);
            }
        });

        jButtonModificarProductoCarta.setText("Modificar producto");
        jButtonModificarProductoCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarProductoCartaActionPerformed(evt);
            }
        });

        jButtonEliminarProductoCarta.setText("Eliminar producto");
        jButtonEliminarProductoCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarProductoCartaActionPerformed(evt);
            }
        });

        jTableProductosCarta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneProductosCarta.setViewportView(jTableProductosCarta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonModificarProductoCarta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAnhadirProductoCarta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEliminarProductoCarta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelGestionCarta)
                    .addComponent(jScrollPaneProductosCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabelGestionCarta)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneProductosCarta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAnhadirProductoCarta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificarProductoCarta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminarProductoCarta)
                        .addGap(0, 124, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnhadirProductoCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnhadirProductoCartaActionPerformed

        AltaProducto dialogoAltaProducto = new AltaProducto(this, true, logicaNegocio);
        dialogoAltaProducto.setLocationRelativeTo(null);
        dialogoAltaProducto.setVisible(true);
        // El hilo se queda bloqueado en el setVisible porque el dialogo es modal.
        Collections.sort(logicaNegocio.getListaProductosCarta());    // ordenamos la lista
        rellenarTablaProductosCarta();   // actualiza la tabla añadiendo y mostrando la nueva mesa
        // ERROR: Sobra diálogo para mostrar mensaje de confirmación al añadir una mesa
        //JOptionPane.showMessageDialog(this, "Mesa añadida con éxito", "ALTA MESA", JOptionPane.INFORMATION_MESSAGE);

        // PERSISTENCIA DATOS EN CSV (adaptar a LogicaNegocio sin GestorFichero)
        // Creación del CSV
        //gf.escribirArchivo();
        // Lee el List con la nueva información (Productos añadidos)
        //gf.leerArchivo();
        logicaNegocio.listarProductosCarta();  // comprobación consola
    }//GEN-LAST:event_jButtonAnhadirProductoCartaActionPerformed

    private void jButtonModificarProductoCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarProductoCartaActionPerformed
        
        // obtenemos la posición real con respecto a la ordenación
        //int seleccionado = jTableProductosCarta.convertColumnIndexToModel(jTableProductosCarta.getSelectedRow());   // teniendo en cuenta que se ha utilizado el sorter (necesita más código)
        int seleccionado = jTableProductosCarta.getSelectedRow();        // no es válido en caso de usar sorter
        if (jTableProductosCarta.getSelectedRow() != -1) {
            Producto productoSeleccionado = logicaNegocio.getListaProductosCarta().get(seleccionado);
            AltaProducto dialogoModificarProducto = new AltaProducto(this, true, logicaNegocio, productoSeleccionado);
            dialogoModificarProducto.setLocationRelativeTo(null);
            dialogoModificarProducto.setVisible(true);
            // El hilo se queda bloqueado en el setVisible porque el dialogo es modal.
            Collections.sort(logicaNegocio.getListaProductosCarta());    // ordenamos la lista
            rellenarTablaProductosCarta();
            // Diálogo para mostrar mensaje de confirmación al añadir Producto
            //JOptionPane.showMessageDialog(this, "Producto modificado con éxito", "MODIFICACIÓN PRODUCTO", JOptionPane.INFORMATION_MESSAGE);

            // PERSISTENCIA DATOS EN CSV (adaptar a LogicaNegocio sin GestorFichero)
            // Creación del CSV
            //gf.escribirArchivo();
            // Lee el List con la nueva información (Productos añadidos)
            //gf.leerArchivo();
            logicaNegocio.listarProductosCarta();  // comprobación consola
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto de la tabla.", "ADVERTENCIA MODIFICACIÓN PRODUCTO", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButtonModificarProductoCartaActionPerformed

    private void jButtonEliminarProductoCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarProductoCartaActionPerformed
        int seleccionado = jTableProductosCarta.getSelectedRow();        // no es válido en caso de haber oredenado la tabla mediante sorter
        if (jTableProductosCarta.getSelectedRow() != -1) {
            Producto productoSeleccionado = logicaNegocio.getListaProductosCarta().get(seleccionado);
            logicaNegocio.getListaProductosCarta().remove(productoSeleccionado);
            Collections.sort(logicaNegocio.getListaProductosCarta());    // ordenamos la lista
            rellenarTablaProductosCarta();   // actualiza la tabla añadiendo y mostrando el nuevo producto
            //Diálogo para mostrar mensaje de confirmación al añadir corredor.
            JOptionPane.showMessageDialog(this, "Producto eliminado con éxito.", "ELIMINACIÓN PRODUCTO", JOptionPane.INFORMATION_MESSAGE);

            // PERSISTENCIA DATOS EN CSV (adaptar a LogicaNegocio sin GestorFichero)
            // Creación del CSV
            //gf.escribirArchivo();
            // Lee el List con la nueva información (productos añadidos)
            //gf.leerArchivo();
            logicaNegocio.listarProductosCarta();  // comprobación consola
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto de la tabla.", "ADVERTENCIA ELIMINACIÓN PRODUCTO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarProductoCartaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnhadirProductoCarta;
    private javax.swing.JButton jButtonEliminarProductoCarta;
    private javax.swing.JButton jButtonModificarProductoCarta;
    private javax.swing.JLabel jLabelGestionCarta;
    private javax.swing.JScrollPane jScrollPaneProductosCarta;
    private javax.swing.JTable jTableProductosCarta;
    // End of variables declaration//GEN-END:variables
}
