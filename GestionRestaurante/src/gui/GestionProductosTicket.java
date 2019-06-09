package gui;

import dto.Producto;
import dto.ProductoTicket;
import dto.Ticket;
import gui.tablemodels.TableModelProductosTicket;
import java.util.Collections;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.TableRowSorter;
import logica.LogicaNegocio;

/**
 *
 * @author sergio
 */
public class GestionProductosTicket extends javax.swing.JDialog {

    private PantallaPrincipal pantallaPrincipal;
    private AperturaTicket aperturaTicket;
    private CantidadesProducto cantidadesProducto;
    private LogicaNegocio logicaNegocio;
    Ticket ticketReapertura = null;
    Ticket currentTicket;
    ProductoTicket productoTicketModificar;

    // Almacenamos aquí esta propiedad para poder acceder a ella desde el botón
    // de filtrar
    private TableRowSorter<TableModelProductosTicket> sorter;     // TODO: Eliminar atributo o corregir error selección tras filtrado

    /**
     * Creates new form GestionTicket
     */
    // Será una apertura si el valor de ticketModificar es null 
    // y será una reapertura si tiene un valor
    // Constructor Apertura
    public GestionProductosTicket(java.awt.Dialog parent, boolean modal, LogicaNegocio logicaNegocio) {
        super(parent, modal);
        //pantallaPrincipal = (PantallaPrincipal) parent;     // TODO: ¿Eliminar? Debería recibir AperturaTicket ya que la apertura viene de dicho diálogo
        aperturaTicket = (AperturaTicket) parent;
        this.logicaNegocio = logicaNegocio;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FORMULARIO APERTURA TICKET");
        //logicaNegocio.setCurrentTicket(ticketReapertura);     // Sobra ya que convierte currentTicket a null
        rellenarTablaProductosTicket();

        // Recogemos numeroTicket e idMesa
        jLabelNumeroTicket.setText("Nº ticket: " + Integer.toString(logicaNegocio.getCurrentTicket().getNumeroTicket()));
        jLabelIdMesa.setText("Mesa: " + Integer.toString(logicaNegocio.getCurrentTicket().getMesaTicket().getIdMesa()));
        //jTextFieldTotal.setText(Double.toString(currentTicket.calcularTotalTicket()));    // TODO: ¿Por qué no funciona?
        jTextFieldTotal.setText(Double.toString(logicaNegocio.getCurrentTicket().calcularTotalTicket()));       // TODO: Corregir problema redondeo
    }

    // TODO: Seguir aquí y comprobar si funcionan ambos constructores
    // Constructor Modificar
    public GestionProductosTicket(java.awt.Frame parent, boolean modal, LogicaNegocio logicaNegocio, Ticket ticketReapertura) {
        super(parent, modal);
        pantallaPrincipal = (PantallaPrincipal) parent;
        this.logicaNegocio = logicaNegocio;
        this.ticketReapertura = ticketReapertura;       // TODO: Comprobar si la falta de esto era el problema
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FORMULARIO REAPERTURA TICKET");

        jLabelNumeroTicket.setText("Nº ticket: " + Integer.toString(ticketReapertura.getNumeroTicket()));
        jLabelIdMesa.setText("Mesa: " + Integer.toString(ticketReapertura.getMesaTicket().getIdMesa()));
        logicaNegocio.setCurrentTicket(ticketReapertura);
        //jTextFieldTotal.setText(Double.toString(currentTicket.calcularTotalTicket()));    // TODO: ¿Por qué no funciona?
        jTextFieldTotal.setText(Double.toString(logicaNegocio.getCurrentTicket().calcularTotalTicket()));
        Collections.sort(logicaNegocio.getCurrentTicket().getListaProductosTicket());   // TODO: ¿Redundante si ya lo hemos hecho en otros métodos?
        rellenarTablaProductosTicket();     // TODO: ¿Necesario? Actualizar tabla al hacer algun cambio en listaProductosTicket

        /*
        // No es necesario en el nuevo enfoque del Dialog
        ValidationGroup group = validationPanelAperturaTicket.getValidationGroup();
        group.add(jTextFieldIdTicket, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER);
        group.add(jTextFieldIdMesa, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER);
        
        validationPanelAperturaTicket.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
        if (validationPanelAperturaTicket.getProblem() == null) {
        jButtonEliminarProductoTicket.setEnabled(true);
        } else {
        jButtonEliminarProductoTicket.setEnabled(false);
        }
        }
        });*/
    }

    // Utilizando un AbstractTableModel
    public void rellenarTablaProductosTicket() {    // NOTA: cambiado a public para poder acceder desde CantidadesProducto
        //TableModelProductosTicket tmpt = new TableModelProductosTicket(logicaNegocio.getListaProductosTicket());
        TableModelProductosTicket tmpt = new TableModelProductosTicket(logicaNegocio.getCurrentTicket().getListaProductosTicket());
        jTableProductosTicket.setModel(tmpt);

        /*
        // TODO: Eliminar si todo funciona correctamente
        // Añadimos la funcionalidad de ordenar
        sorter = new TableRowSorter<>(tmpt);            // TODO: Eliminar para que no de error
        jTableProductosTicket.setRowSorter(sorter);     // al seleccionar un item tras ordenar

        // Establecemos el orden por defecto
        List<SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
         */
    }

    // TODO: Debe permitir tener más de un ticket abierto a la vez (pero solo uno por mesa)
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelGestionProductosTicket = new javax.swing.JLabel();
        jLabelNumeroTicket = new javax.swing.JLabel();
        jLabelIdMesa = new javax.swing.JLabel();
        jButtonAnhadirProductoTicket = new javax.swing.JButton();
        jButtonModificarCantidadProductoTicket = new javax.swing.JButton();
        jButtonEliminarProductoTicket = new javax.swing.JButton();
        jButtonGuardarCambiosTicket = new javax.swing.JButton();
        jScrollPaneProductosTicket = new javax.swing.JScrollPane();
        jTableProductosTicket = new javax.swing.JTable();
        jLabelTotal = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jButtonCerrarTicket = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabelGestionProductosTicket.setText("GESTIÓN PRODUCTOS TICKET");

        jLabelNumeroTicket.setText("IdTicketValue");

        jLabelIdMesa.setText("IdMesaValue");

        jButtonAnhadirProductoTicket.setText("Añadir producto");
        jButtonAnhadirProductoTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnhadirProductoTicketActionPerformed(evt);
            }
        });

        jButtonModificarCantidadProductoTicket.setText("Modificar cantidad");
        jButtonModificarCantidadProductoTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarCantidadProductoTicketActionPerformed(evt);
            }
        });

        jButtonEliminarProductoTicket.setText("Eliminar producto");
        jButtonEliminarProductoTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarProductoTicketActionPerformed(evt);
            }
        });

        jButtonGuardarCambiosTicket.setText("Guardar cambios");
        jButtonGuardarCambiosTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarCambiosTicketActionPerformed(evt);
            }
        });

        jTableProductosTicket.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneProductosTicket.setViewportView(jTableProductosTicket);

        jLabelTotal.setText("TOTAL");

        jButtonCerrarTicket.setText("Cerrar ticket");
        jButtonCerrarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonEliminarProductoTicket, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonModificarCantidadProductoTicket, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAnhadirProductoTicket, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGuardarCambiosTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelGestionProductosTicket)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelTotal)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelNumeroTicket)
                                .addGap(29, 29, 29)
                                .addComponent(jLabelIdMesa))
                            .addComponent(jScrollPaneProductosTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButtonCerrarTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabelGestionProductosTicket)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumeroTicket)
                    .addComponent(jLabelIdMesa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAnhadirProductoTicket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificarCantidadProductoTicket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminarProductoTicket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGuardarCambiosTicket))
                    .addComponent(jScrollPaneProductosTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotal)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCerrarTicket)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // TODO: ¿Generar idTicket de manera automática? Problema varios tickets abiertos

    private void jButtonAnhadirProductoTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnhadirProductoTicketActionPerformed

        CantidadesProducto dialogoCantidadesProducto = new CantidadesProducto(this, true, logicaNegocio);
        dialogoCantidadesProducto.setLocationRelativeTo(null);
        dialogoCantidadesProducto.setVisible(true);
        // El hilo se queda bloqueado en el setVisible porque el dialogo es modal.
        Collections.sort(logicaNegocio.getCurrentTicket().getListaProductosTicket());    // ordenamos la lista (en este caso no es necesario)
        // TODO: Decidir si guardamos al añadir cada producto o al pulsar guardar cambios
        rellenarTablaProductosTicket();   // actualiza la tabla añadiendo y mostrando el nuevo producto
        // ERROR: Sobra diálogo para mostrar mensaje de confirmación al añadir un producto al ticket
        //JOptionPane.showMessageDialog(this, "Producto añadido con éxito", "AÑADIR PRODUCTO TICKET", JOptionPane.INFORMATION_MESSAGE);
        jTextFieldTotal.setText(Double.toString(logicaNegocio.getCurrentTicket().calcularTotalTicket()));   // actualizamos el total del ticket

        // PERSISTENCIA DATOS EN CSV (adaptar a LogicaNegocio sin GestorFichero)
        // Creación del CSV
        //gf.escribirArchivo();
        // Lee el List con la nueva información (Productos añadidos)
        //gf.leerArchivo();
        System.out.println(logicaNegocio.getCurrentTicket().getListaProductosTicket());  // comprobación consola (se podría crear un método listarProductosTicket en LogicaNegocio)
    }//GEN-LAST:event_jButtonAnhadirProductoTicketActionPerformed

    private void jButtonModificarCantidadProductoTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarCantidadProductoTicketActionPerformed
        
        // obtenemos la posición real con respecto a la ordenación
        //int seleccionado = jTableTickets.convertColumnIndexToModel(jTableProductosTicket.getSelectedRow());   // teniendo en cuenta que se ha utilizado el sorter (necesita más código)
        int seleccionado = jTableProductosTicket.getSelectedRow();        // no es válido en caso de usar sorter
        if (jTableProductosTicket.getSelectedRow() != -1) {
            ProductoTicket productoTicketSeleccionado = logicaNegocio.getCurrentTicket().getListaProductosTicket().get(seleccionado);

            CantidadesProducto dialogoCantidadesProducto = new CantidadesProducto(this, true, logicaNegocio, productoTicketSeleccionado);
            dialogoCantidadesProducto.setLocationRelativeTo(null);
            dialogoCantidadesProducto.setVisible(true);

            // El hilo se queda bloqueado en el setVisible porque el dialogo es modal.
            Collections.sort(logicaNegocio.getCurrentTicket().getListaProductosTicket());    // ordenamos la lista
            rellenarTablaProductosTicket();
            // ERROR: Sobra diálogo para mostrar mensaje de confirmación al modificar un producto del ticket
            //JOptionPane.showMessageDialog(this, "Producto modificado con éxito", "MODIFICAR PRODUCTO TICKET", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldTotal.setText(Double.toString(logicaNegocio.getCurrentTicket().calcularTotalTicket()));   // actualizamos el total del ticket

            // PERSISTENCIA DATOS EN CSV (adaptar a LogicaNegocio sin GestorFichero)
            // Creación del CSV
            //gf.escribirArchivo();
            // Lee el List con la nueva información (mesas añadidas)
            //gf.leerArchivo();
            System.out.println(logicaNegocio.getCurrentTicket().getListaProductosTicket());  // comprobación consola (se podría crear un método listarProductosTicket en LogicaNegocio)
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto del ticket.", "ADVERTENCIA MODIFICACIÓN PRODUCTO TICKET", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonModificarCantidadProductoTicketActionPerformed

    private void jButtonEliminarProductoTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarProductoTicketActionPerformed
        // obtenemos la posición real con respecto a la ordenación
        //int seleccionado = jTableTickets.convertColumnIndexToModel(jTableProductosTicket.getSelectedRow());   // teniendo en cuenta que se ha utilizado el sorter (necesita más código)
        int seleccionado = jTableProductosTicket.getSelectedRow();        // no es válido en caso de haber oredenado la tabla mediante sorter
        if (jTableProductosTicket.getSelectedRow() != -1) {
            ProductoTicket productoTicketSeleccionado = logicaNegocio.getCurrentTicket().getListaProductosTicket().get(seleccionado);
            logicaNegocio.getCurrentTicket().getListaProductosTicket().remove(productoTicketSeleccionado);

            Collections.sort(logicaNegocio.getCurrentTicket().getListaProductosTicket());    // ordenamos la lista (en este caso no es necesario, de hacerlo, que sea por categorías)
            rellenarTablaProductosTicket();
            // Diálogo para mostrar mensaje de confirmación al añadir ProductoTicket
            //JOptionPane.showMessageDialog(this, "Producto modificado con éxito", "MODIFICAR PRODUCTO TICKET", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldTotal.setText(Double.toString(logicaNegocio.getCurrentTicket().calcularTotalTicket()));   // actualizamos el total del ticket

            // PERSISTENCIA DATOS EN CSV (adaptar a LogicaNegocio sin GestorFichero)
            // Creación del CSV
            //gf.escribirArchivo();
            // Lee el List con la nueva información (mesas añadidas)
            //gf.leerArchivo();
            System.out.println(logicaNegocio.getCurrentTicket().getListaProductosTicket());  // comprobación consola (se podría crear un método listarProductosTicket en LogicaNegocio)
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto del ticket.", "ADVERTENCIA ELIMINACIÓN PRODUCTO TICKET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarProductoTicketActionPerformed

    private void jButtonGuardarCambiosTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarCambiosTicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGuardarCambiosTicketActionPerformed

    private void jButtonCerrarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarTicketActionPerformed
        currentTicket.setCerrado(true);
        dispose();
    }//GEN-LAST:event_jButtonCerrarTicketActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO: Hacer que cuadro de diálogo permita no cerrar la ventana para guardar cambios manualmente ¿Tal vez evento closing?
        //JOptionPane.showMessageDialog(this, "Asegúrese de haber guardado las modificaciones porque se perderan al cerrar la ventana", "CIERRE GESTIÓN TICKET", JOptionPane.WARNING_MESSAGE);
        // TODO: Realizar isCerrado(true) y recuperar listaTicketsBackup en caso de cerrar ventana para que no se guarden los cambios

    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnhadirProductoTicket;
    private javax.swing.JButton jButtonCerrarTicket;
    private javax.swing.JButton jButtonEliminarProductoTicket;
    private javax.swing.JButton jButtonGuardarCambiosTicket;
    private javax.swing.JButton jButtonModificarCantidadProductoTicket;
    private javax.swing.JLabel jLabelGestionProductosTicket;
    private javax.swing.JLabel jLabelIdMesa;
    private javax.swing.JLabel jLabelNumeroTicket;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPaneProductosTicket;
    private javax.swing.JTable jTableProductosTicket;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
}
