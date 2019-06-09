package gui;

import dto.Mesa;
import dto.Ticket;
import gui.tablemodels.TableModelTickets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableRowSorter;
import logica.LogicaNegocio;

/**
 *
 * @author sergio
 */
public class PantallaPrincipal extends javax.swing.JFrame {

// TODO (todas las pantallas): Eliminar jTextFields títulos
    // TODO (extra): Declarar atributo logo
    //private static final String RUTA_LOGO = "nombreRuta";
    private LogicaNegocio logicaNegocio = new LogicaNegocio();
    private GestionMesas gestionMesas;      // TODO: ¿Necesario? Sólo se utiliza como variable local en apertura diálogo GestionMesas
    private GestionCarta gestionCarta;      // TODO: ¿Necesario? Sólo se utiliza como variable local en apertura diálogo GestionCarta
    private Ticket currentTicket = null;        // inicializado a null para que nunca haya uno al abrir pantalla
    private Ticket ticket = new Ticket();       // TODO: ¿Por qué tengo esto aquí? ¿No debería ir en Dialogo AperturaTicket?
    // Almacenamos aquí esta propiedad para poder acceder a ella desde el botón
    // de filtrar
    private TableRowSorter<TableModelTickets> sorter;     // TODO: Eliminar atributo o corregir error selección tras filtrado

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        // Método para cargar lista en un ComboBox
        /*
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        for (Mesa mesa : logicaNegocio.getListaMesas){
            dcm.addElement(mesa);
        }
        jComboBoxPrueba.setModel(dcm);
         */
        // Método para cargar lista en una jTable (recomendado)
        //jTableProductosTicket.setModel(new TableModelProductosTicket(logicaNegocio.getListaProductosTicket()));   //comentado para que no falle la ejecución
        initComponents();
        setLocationRelativeTo(null);    // coloca el frame/dialogo en el centro de la pantalla

        // TODO (extra): Asignación de logos
        //Establecer una imagen en una label
        //jLabelIcono.setIcon(new ImageIcon(getClass().getResource(RUTA_LOGO)));
        //Establecer el logo de la aplicación
        //setIconImage(new ImageIcon(getClass().getResource(RUTA_LOGO)).getImage());
        //Establecer el título de la aplicación
        setTitle("GESTIÓN RESTAURANTE");
        Collections.sort(logicaNegocio.getListaTickets());
        rellenarTablaTickets();
    }

    // TODO (fail): Corregir formato fecha
    // Utilizando un AbstractTableModel
    private void rellenarTablaTickets() {
        TableModelTickets tmt = new TableModelTickets(logicaNegocio.getListaTickets());
        jTableTickets.setModel(tmt);
        /*
        // TODO: Eliminar si todo funciona correctamente
        // Añadimos la funcionalidad de ordenar
        sorter = new TableRowSorter<>(tmt);
        jTableTickets.setRowSorter(sorter);

        // Establecemos el orden por defecto
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        */
    }

    public void reabrirTicket() {
        int seleccionado = jTableTickets.getSelectedRow();        // no es válido en caso de usar sorter
        if (jTableTickets.getSelectedRow() != -1) {
            Ticket ticketSeleccionado = logicaNegocio.getListaTickets().get(seleccionado);
            if (!ticketSeleccionado.isCerrado()) {
                JOptionPane.showMessageDialog(this, "El ticket seleccionado ya está abierto.\nPor favor, seleccione un ticket que esté cerrado.", "ADVERTENCIA REAPERTURA TICKET", JOptionPane.ERROR_MESSAGE);
            } else {
                Ticket currentTicket = ticketSeleccionado;
                currentTicket.setCerrado(false);    // cambiamos estado a 'abierto' para poder ser modifcado

                GestionProductosTicket reaperturaTicket = new GestionProductosTicket(this, true, logicaNegocio, currentTicket); // TODO: Falta ticketSeleccionado
                reaperturaTicket.setLocationRelativeTo(null);
                reaperturaTicket.setVisible(true);

                // El hilo se queda bloqueado en el setVisible porque el dialogo es modal.
                Collections.sort(logicaNegocio.getListaTickets());    // ordenamos la lista
                rellenarTablaTickets();     // TODO: ¿Necesario?
                // Diálogo para mostrar mensaje de confirmación al reabrir Ticket
                //JOptionPane.showMessageDialog(this, "Ticket reabierto con éxito", "REAPERTURA TICKET", JOptionPane.INFORMATION_MESSAGE);

                // PERSISTENCIA DATOS EN CSV (adaptar a LogicaNegocio sin GestorFichero)
                // Creación del CSV
                //gf.escribirArchivo();
                // Lee el List con la nueva información (mesas añadidas)
                //gf.leerArchivo();
                logicaNegocio.listarTickets();  // comprobación consola
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un ticket de la tabla.", "ADVERTENCIA REAPERTURA TICKET", JOptionPane.ERROR_MESSAGE);
        
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelGestionRestaurante = new javax.swing.JLabel();
        jButtonVisualizacionTicket = new javax.swing.JButton();
        jButtonAperturaTicket = new javax.swing.JButton();
        jButtonReaperturaTicket = new javax.swing.JButton();
        jButtonFiltradoTicketsFecha = new javax.swing.JButton();
        jButtonFiltradoTicketsMesa = new javax.swing.JButton();
        jLabelListaTicket = new javax.swing.JLabel();
        jScrollPaneTickets = new javax.swing.JScrollPane();
        jTableTickets = new javax.swing.JTable();
        jMenuBarPantallaPrincipal = new javax.swing.JMenuBar();
        jMenuMesas = new javax.swing.JMenu();
        jMenuItemGestionMesas = new javax.swing.JMenuItem();
        jMenuItemAltaMesa = new javax.swing.JMenuItem();
        jMenuCarta = new javax.swing.JMenu();
        jMenuItemGestionCarta = new javax.swing.JMenuItem();
        jMenuItemAltaProducto = new javax.swing.JMenuItem();
        jMenuTickets = new javax.swing.JMenu();
        jMenuItemAperturaTicket = new javax.swing.JMenuItem();
        jMenuFiltrado = new javax.swing.JMenu();
        jMenuItemFiltradoTicketsFecha = new javax.swing.JMenuItem();
        jMenuItemFiltradoTicketsMesa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelGestionRestaurante.setText("GESTIÓN RESTAURANTE");

        jButtonVisualizacionTicket.setText("Ver ticket");
        jButtonVisualizacionTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizacionTicketActionPerformed(evt);
            }
        });

        jButtonAperturaTicket.setText("Apertura ticket");
        jButtonAperturaTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAperturaTicketActionPerformed(evt);
            }
        });

        jButtonReaperturaTicket.setText("Reapertura ticket");
        jButtonReaperturaTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReaperturaTicketActionPerformed(evt);
            }
        });

        jButtonFiltradoTicketsFecha.setText("Filtrar por fecha");
        jButtonFiltradoTicketsFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltradoTicketsFechaActionPerformed(evt);
            }
        });

        jButtonFiltradoTicketsMesa.setText("Filtrar por mesa");
        jButtonFiltradoTicketsMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltradoTicketsMesaActionPerformed(evt);
            }
        });

        jLabelListaTicket.setText("LISTA TICKETS");

        jTableTickets.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneTickets.setViewportView(jTableTickets);

        jMenuMesas.setText("Mesas");

        jMenuItemGestionMesas.setText("Gestión...");
        jMenuItemGestionMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionMesasActionPerformed(evt);
            }
        });
        jMenuMesas.add(jMenuItemGestionMesas);

        jMenuItemAltaMesa.setText("Alta...");
        jMenuItemAltaMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAltaMesaActionPerformed(evt);
            }
        });
        jMenuMesas.add(jMenuItemAltaMesa);

        jMenuBarPantallaPrincipal.add(jMenuMesas);

        jMenuCarta.setText("Carta");

        jMenuItemGestionCarta.setText("Gestión...");
        jMenuItemGestionCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionCartaActionPerformed(evt);
            }
        });
        jMenuCarta.add(jMenuItemGestionCarta);

        jMenuItemAltaProducto.setText("Alta...");
        jMenuItemAltaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAltaProductoActionPerformed(evt);
            }
        });
        jMenuCarta.add(jMenuItemAltaProducto);

        jMenuBarPantallaPrincipal.add(jMenuCarta);

        jMenuTickets.setText("Tickets");

        jMenuItemAperturaTicket.setText("Apertura...");
        jMenuItemAperturaTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAperturaTicketActionPerformed(evt);
            }
        });
        jMenuTickets.add(jMenuItemAperturaTicket);

        jMenuFiltrado.setText("Filtrado...");

        jMenuItemFiltradoTicketsFecha.setText("Por fecha");
        jMenuItemFiltradoTicketsFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFiltradoTicketsFechaActionPerformed(evt);
            }
        });
        jMenuFiltrado.add(jMenuItemFiltradoTicketsFecha);

        jMenuItemFiltradoTicketsMesa.setText("Por mesa");
        jMenuItemFiltradoTicketsMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFiltradoTicketsMesaActionPerformed(evt);
            }
        });
        jMenuFiltrado.add(jMenuItemFiltradoTicketsMesa);

        jMenuTickets.add(jMenuFiltrado);

        jMenuBarPantallaPrincipal.add(jMenuTickets);

        setJMenuBar(jMenuBarPantallaPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelGestionRestaurante)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabelListaTicket)))
                .addGap(137, 137, 137))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonFiltradoTicketsFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonReaperturaTicket, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonFiltradoTicketsMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAperturaTicket, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonVisualizacionTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabelGestionRestaurante)
                .addGap(18, 18, 18)
                .addComponent(jLabelListaTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonVisualizacionTicket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAperturaTicket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonReaperturaTicket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFiltradoTicketsFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFiltradoTicketsMesa)
                        .addGap(17, 17, 17))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemGestionMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionMesasActionPerformed
        GestionMesas gestionMesas = new GestionMesas(this, true, logicaNegocio);
        gestionMesas.setVisible(true);
    }//GEN-LAST:event_jMenuItemGestionMesasActionPerformed

    private void jMenuItemAltaMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAltaMesaActionPerformed
        // TODO (extra): tras alta llevar a GestionMesas (para ver la tabla de mesas)
        AltaMesa altaMesa = new AltaMesa(this.gestionMesas, true, logicaNegocio);
        altaMesa.setVisible(true);
    }//GEN-LAST:event_jMenuItemAltaMesaActionPerformed

    private void jMenuItemGestionCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionCartaActionPerformed
        GestionCarta gestionCarta = new GestionCarta(this, true, logicaNegocio);
        gestionCarta.setVisible(true);
    }//GEN-LAST:event_jMenuItemGestionCartaActionPerformed

    private void jMenuItemAltaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAltaProductoActionPerformed
        // TODO (extra): tras alta llevar a GestionCarta (para ver la tabla de productos de la carta)
        AltaProducto altaProducto = new AltaProducto(this.gestionCarta, true, logicaNegocio);
        altaProducto.setVisible(true);
    }//GEN-LAST:event_jMenuItemAltaProductoActionPerformed

    private void jMenuItemAperturaTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAperturaTicketActionPerformed
        AperturaTicket aperturaTicket = new AperturaTicket(this, true, logicaNegocio);
        aperturaTicket.setVisible(true);
    }//GEN-LAST:event_jMenuItemAperturaTicketActionPerformed

    private void jMenuItemFiltradoTicketsFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFiltradoTicketsFechaActionPerformed
        FiltradoTicketFecha filtradoTicketFecha = new FiltradoTicketFecha(this, true, logicaNegocio);
        filtradoTicketFecha.setVisible(true);
    }//GEN-LAST:event_jMenuItemFiltradoTicketsFechaActionPerformed

    private void jMenuItemFiltradoTicketsMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFiltradoTicketsMesaActionPerformed
        FiltradoTicketMesa filtradoTicketMesa = new FiltradoTicketMesa(this, true, logicaNegocio);
        filtradoTicketMesa.setVisible(true);
    }//GEN-LAST:event_jMenuItemFiltradoTicketsMesaActionPerformed

    private void jButtonAperturaTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAperturaTicketActionPerformed
        AperturaTicket aperturaTicket = new AperturaTicket(this, true, logicaNegocio);
        aperturaTicket.setVisible(true);
        rellenarTablaTickets();
    }//GEN-LAST:event_jButtonAperturaTicketActionPerformed

    private void jButtonReaperturaTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReaperturaTicketActionPerformed
        reabrirTicket();
    }//GEN-LAST:event_jButtonReaperturaTicketActionPerformed

    private void jButtonFiltradoTicketsFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltradoTicketsFechaActionPerformed
        FiltradoTicketFecha filtradoTicketFecha = new FiltradoTicketFecha(this, true, logicaNegocio);
        filtradoTicketFecha.setVisible(true);
    }//GEN-LAST:event_jButtonFiltradoTicketsFechaActionPerformed

    private void jButtonFiltradoTicketsMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltradoTicketsMesaActionPerformed
        FiltradoTicketMesa filtradoTicketMesa = new FiltradoTicketMesa(this, true, logicaNegocio);
        filtradoTicketMesa.setVisible(true);
    }//GEN-LAST:event_jButtonFiltradoTicketsMesaActionPerformed

    private void jButtonVisualizacionTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizacionTicketActionPerformed
        // TODO (extra): Desarrollar método
    }//GEN-LAST:event_jButtonVisualizacionTicketActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Locale.setDefault(new Locale("es", "ES"));
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAperturaTicket;
    private javax.swing.JButton jButtonFiltradoTicketsFecha;
    private javax.swing.JButton jButtonFiltradoTicketsMesa;
    private javax.swing.JButton jButtonReaperturaTicket;
    private javax.swing.JButton jButtonVisualizacionTicket;
    private javax.swing.JLabel jLabelGestionRestaurante;
    private javax.swing.JLabel jLabelListaTicket;
    private javax.swing.JMenuBar jMenuBarPantallaPrincipal;
    private javax.swing.JMenu jMenuCarta;
    private javax.swing.JMenu jMenuFiltrado;
    private javax.swing.JMenuItem jMenuItemAltaMesa;
    private javax.swing.JMenuItem jMenuItemAltaProducto;
    private javax.swing.JMenuItem jMenuItemAperturaTicket;
    private javax.swing.JMenuItem jMenuItemFiltradoTicketsFecha;
    private javax.swing.JMenuItem jMenuItemFiltradoTicketsMesa;
    private javax.swing.JMenuItem jMenuItemGestionCarta;
    private javax.swing.JMenuItem jMenuItemGestionMesas;
    private javax.swing.JMenu jMenuMesas;
    private javax.swing.JMenu jMenuTickets;
    private javax.swing.JScrollPane jScrollPaneTickets;
    private javax.swing.JTable jTableTickets;
    // End of variables declaration//GEN-END:variables
}
