package gui;

import dto.Producto;
import dto.ProductoTicket;
import dto.Ticket;
import gui.tablemodels.TableModelProductosTicket;
import gui.tablemodels.TableModelTickets;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Date;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.TableRowSorter;
import logica.LogicaNegocio;

/**
 *
 * @author sergio
 */
public class VisualizacionTicketsPorFecha extends javax.swing.JDialog {

    // TODO: Adaptar a su función (ver ticket)
    private FiltradoTicketFecha filtradoTicketFecha;
    private LogicaNegocio logicaNegocio;
    private Date fechaInicioFiltradoTicket;
    private Date fechaFinFiltradoTicket;
    //Ticket ticketReapertura = null;
    //Ticket currentTicket;

    // Almacenamos aquí esta propiedad para poder acceder a ella desde el botón
    // de filtrar
    private TableRowSorter<TableModelProductosTicket> sorter;     // TODO: Eliminar atributo o corregir error selección tras filtrado

    /**
     * Creates new form GestionTicket
     */
    // TODO: ¿Necesarias fechaInicioFiltradoTicket y fechaFinFiltradoTicket en constructor?
    public VisualizacionTicketsPorFecha(java.awt.Dialog parent, boolean modal, LogicaNegocio logicaNegocio) {
        super(parent, modal);
        filtradoTicketFecha = (FiltradoTicketFecha) parent;
        this.logicaNegocio = logicaNegocio;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FILTRADO TICKETS POR FECHA");
        //logicaNegocio.setCurrentTicket(ticketReapertura);     // Sobra ya que convierte ticketActual a null
        //rellenarTablaTickets();

        fechaInicioFiltradoTicket = logicaNegocio.getFechaInicioFiltradoTicket();
        fechaFinFiltradoTicket = logicaNegocio.getFechaFinFiltradoTicket();

        jLabelHistorialTicketsFechaInicio.setText("Fecha Inicio: " + fechaInicioFiltradoTicket);
        jLabelHistorialTicketsFechaFin.setText("Fecha Fin: " + fechaFinFiltradoTicket);
        //Collections.sort(logicaNegocio.getListaTicketsFiltradoFecha(fechaInicioFiltradoTicket, fechaFinFiltradoTicket));      // TODO (borrar): No es donde debe ir. Se ordena en LogicaNegocio
        rellenarTablaTickets();
        ponLaAyuda();
    }

    // Utilizando un AbstractTableModel
    private void rellenarTablaTickets() {
        TableModelTickets tmt = new TableModelTickets(logicaNegocio.getListaTicketsFiltradoFecha(fechaInicioFiltradoTicket, fechaFinFiltradoTicket));
        jTableTicketsFecha.setModel(tmt);
    }

    private void ponLaAyuda() {
        try {
        // Carga el fichero de ayuda
        File fichero = new File("help"+File.separator+"help_set.hs");
        URL hsURL = fichero.toURI().toURL();
        
        HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
        HelpBroker hb = helpset.createHelpBroker();
        
        // Pone ayuda a item de menu al pulsarlo 
        // y a F1 en ventana principal.
        hb.enableHelpOnButton(jMenuItemMostrarAyuda, "visualizacion_tickets_fecha", helpset);
        hb.enableHelpKey(getRootPane(), "visualizacion_tickets_fecha", helpset);
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
    // TODO (requerido): Debe permitir tener más de un ticket abierto a la vez (pero solo uno por mesa)
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelVisualizacionTicketFiltradoFecha = new javax.swing.JLabel();
        jLabelHistorialTicketsFechaInicio = new javax.swing.JLabel();
        jLabelHistorialTicketsFechaFin = new javax.swing.JLabel();
        jButtonVisualizacionTicket = new javax.swing.JButton();
        jButtonReaperturaTicket = new javax.swing.JButton();
        jButtonVolverAtras = new javax.swing.JButton();
        jScrollPaneProductosTicket = new javax.swing.JScrollPane();
        jTableTicketsFecha = new javax.swing.JTable();
        jMenuBarVisualizacionTicketsPorMesa = new javax.swing.JMenuBar();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemMostrarAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabelVisualizacionTicketFiltradoFecha.setText("FILTRADO TICKETS POR FECHA");

        jLabelHistorialTicketsFechaInicio.setText("Fecha Inicio");

        jLabelHistorialTicketsFechaFin.setText("Fecha Fin");

        jButtonVisualizacionTicket.setText("Ver ticket");
        jButtonVisualizacionTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizacionTicketActionPerformed(evt);
            }
        });

        jButtonReaperturaTicket.setText("Reapertura ticket");
        jButtonReaperturaTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReaperturaTicketActionPerformed(evt);
            }
        });

        jButtonVolverAtras.setText("Volver atrás");
        jButtonVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAtrasActionPerformed(evt);
            }
        });

        jTableTicketsFecha.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneProductosTicket.setViewportView(jTableTicketsFecha);

        jMenuAyuda.setText("Ayuda");

        jMenuItemMostrarAyuda.setText("Mostrar ayuda");
        jMenuAyuda.add(jMenuItemMostrarAyuda);

        jMenuBarVisualizacionTicketsPorMesa.add(jMenuAyuda);

        setJMenuBar(jMenuBarVisualizacionTicketsPorMesa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButtonReaperturaTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelHistorialTicketsFechaFin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneProductosTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVisualizacionTicketFiltradoFecha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHistorialTicketsFechaInicio, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonVisualizacionTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonVolverAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabelVisualizacionTicketFiltradoFecha)
                .addGap(10, 10, 10)
                .addComponent(jLabelHistorialTicketsFechaInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelHistorialTicketsFechaFin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonReaperturaTicket)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneProductosTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVisualizacionTicket)
                    .addComponent(jButtonVolverAtras))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAtrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVolverAtrasActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO: Hacer que cuadro de diálogo permita no cerrar la ventana para guardar cambios manualmente ¿Tal vez evento closing?
        //JOptionPane.showMessageDialog(this, "Asegúrese de haber guardado las modificaciones porque se perderan al cerrar la ventana", "CIERRE GESTIÓN TICKET", JOptionPane.WARNING_MESSAGE);
        // TODO: Realizar isCerrado(true) y recuperar listaTicketsBackup en caso de cerrar ventana para que no se guarden los cambios

    }//GEN-LAST:event_formWindowClosed

    private void jButtonReaperturaTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReaperturaTicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReaperturaTicketActionPerformed

    private void jButtonVisualizacionTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizacionTicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVisualizacionTicketActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReaperturaTicket;
    private javax.swing.JButton jButtonVisualizacionTicket;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JLabel jLabelHistorialTicketsFechaFin;
    private javax.swing.JLabel jLabelHistorialTicketsFechaInicio;
    private javax.swing.JLabel jLabelVisualizacionTicketFiltradoFecha;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBarVisualizacionTicketsPorMesa;
    private javax.swing.JMenuItem jMenuItemMostrarAyuda;
    private javax.swing.JScrollPane jScrollPaneProductosTicket;
    private javax.swing.JTable jTableTicketsFecha;
    // End of variables declaration//GEN-END:variables
}