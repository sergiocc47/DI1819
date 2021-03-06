/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dto.Mesa;
import dto.Ticket;
import java.io.File;
import java.net.URL;
import java.util.Date;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import logica.LogicaNegocio;
import org.netbeans.validation.api.builtin.stringvalidation.MayusculaValidator;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author sergio
 */
public class FiltradoTicketFecha extends javax.swing.JDialog {

    private PantallaPrincipal pantallaPrincipal;
    private LogicaNegocio logicaNegocio;
    private Ticket ticketFiltrado;      // TODO (borrar): ¿Es necesario?
    private Date fechaInicioFiltradoTicket;
    private Date fechaFinFiltradoTicket;

    /**
     * Creates new form FiltradoTicketFecha
     */
    public FiltradoTicketFecha(java.awt.Frame parent, boolean modal, LogicaNegocio logicaNegocio) {
        super(parent, modal);
        pantallaPrincipal = (PantallaPrincipal) parent;
        this.logicaNegocio = logicaNegocio;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FILTRADO TICKET POR FECHA");
        ponLaAyuda();

        /*group.add(jTextFieldIdentificador, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER);
        // MSG_MAY_NOT_BE_EMPTY, ERR_NOT_INTEGER en Bundle_es.properties
        group.add(jTextFieldLocalizacion, StringValidators.REQUIRE_NON_EMPTY_STRING, new MayusculaValidator());
        // MSG_MAYUSCULA en Bundle_es.properties
        group.add(jTextFieldCapacidad, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER);
        
        validationPanelFiltradoTicketFecha.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
        if (validationPanelFiltradoTicketFecha.getProblem() == null) {
        jButtonFiltradoTicketFechaAceptar.setEnabled(true);
        } else {
        jButtonFiltradoTicketFechaAceptar.setEnabled(false);
        }
        }
        });*/
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
        hb.enableHelpOnButton(jMenuItemMostrarAyuda, "filtrado_ticket_fecha", helpset);
        hb.enableHelpKey(getRootPane(), "filtrado_ticket_fecha", helpset);
        } catch (Exception e) {
        e.printStackTrace();
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

        jLabelFiltradoTicketFecha = new javax.swing.JLabel();
        jLabelFiltradoTicketFechaInicio = new javax.swing.JLabel();
        jLabelFiltradoTicketFechaFin = new javax.swing.JLabel();
        jSpinnerFechaInicio = new javax.swing.JSpinner();
        jSpinnerFechaFin = new javax.swing.JSpinner();
        jButtonFiltradoTicketFechaAceptar = new javax.swing.JButton();
        validationPanelFiltradoTicketFecha = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jMenuBarFiltradoTicketFecha = new javax.swing.JMenuBar();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemMostrarAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelFiltradoTicketFecha.setText("FILTRADO TICKET POR FECHA");

        jLabelFiltradoTicketFechaInicio.setText("Desde");

        jLabelFiltradoTicketFechaFin.setText("Hasta");

        jSpinnerFechaInicio.setModel(new javax.swing.SpinnerDateModel());
        jSpinnerFechaInicio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSpinnerFechaInicioPropertyChange(evt);
            }
        });

        jSpinnerFechaFin.setModel(new javax.swing.SpinnerDateModel());

        jButtonFiltradoTicketFechaAceptar.setText("Aceptar");
        jButtonFiltradoTicketFechaAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltradoTicketFechaAceptarActionPerformed(evt);
            }
        });

        jMenuAyuda.setText("Ayuda");

        jMenuItemMostrarAyuda.setText("Mostrar ayuda");
        jMenuAyuda.add(jMenuItemMostrarAyuda);

        jMenuBarFiltradoTicketFecha.add(jMenuAyuda);

        setJMenuBar(jMenuBarFiltradoTicketFecha);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonFiltradoTicketFechaAceptar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFiltradoTicketFechaInicio)
                            .addComponent(jLabelFiltradoTicketFechaFin))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFiltradoTicketFecha)
                            .addComponent(jSpinnerFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(validationPanelFiltradoTicketFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabelFiltradoTicketFecha)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFiltradoTicketFechaInicio)
                    .addComponent(jSpinnerFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFiltradoTicketFechaFin)
                    .addComponent(jSpinnerFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validationPanelFiltradoTicketFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFiltradoTicketFechaAceptar)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFiltradoTicketFechaAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltradoTicketFechaAceptarActionPerformed
        /*
        // TODO: Casteo fechas, crear listaTicketsFiltradoFecha y crear método anhadirTicketFiltradoFecha() en LogicaNegocio
        Date fechaTicketFiltrado = ticketFiltrado.getFecha();
        Date fechaInicio = jSpinnerFechaInicio.getValue();
        Date fechaFin = jSpinnerFechaFin.getValue();
        if (fechaTicketFiltrado<=fechaFin && fechaTicketFiltrado>=fechaInicio){
        logicaNegocio.anhadirTicketFiltradoFecha(ticketFiltrado);
        }
         */
 /*
        // EJEMPLO PROPIO DI_PI1EVAL (adaptado a errores) + DIEGO
        int idMesa = Integer.parseInt(jTextFieldIdMesa.getText());
        String localizacion = jTextFieldLocalizacion.getText();
        int capacidad = Integer.parseInt(jTextFieldCapacidad.getText());

        Mesa mesa = new Mesa(idMesa, localizacion, capacidad);  // mesa temporal
        // Comprobamos si es un alta o una modificación
        if (mesaModificar == null) {
            if (logicaNegocio.existeMesa(mesa)) {
                JOptionPane.showMessageDialog(this, "La mesa con identificador " + mesa.getIdMesa() + " ya existe.\nPor favor, introduzca otro identificador.", "ERROR ALTA MESA", JOptionPane.ERROR_MESSAGE);
                System.out.println("Mesa NO añadida.");  //comprobación consola
            } else {
                logicaNegocio.altaMesa(mesa);
                //Dialogo éxito alta
                //setVisible(false);    // oculta el formulario (pero no lo destruye)
                dispose();              // destruye el formulario
            }
        } else {
            mesaModificar.setIdMesa(idMesa);
            mesaModificar.setLocalizacion(localizacion);
            mesaModificar.setCapacidad(capacidad);

            logicaNegocio.altaMesa(mesaModificar);
            //Dialogo éxito modificación
            //setVisible(false);    // oculta el formulario (pero no lo destruye)
            dispose();              // destruye el formulario
        }
        /*
        int idMesa = Integer.parseInt(jTextFieldIdentificador.getText());
        String localizacion = jTextFieldLocalizacion.getText();
        int capacidad = Integer.parseInt(jTextFieldCapacidad.getText());

        Mesa mesa = new Mesa(idMesa, localizacion, capacidad);      // mesa temporal
        // Comprobamos si es un alta o una modificación
        if (mesaModificar == null) {
            // TODO: Corregir rechazo id duplicado al modificar
            if (logicaNegocio.existeMesa(mesa)) {
                // Dialogo éxito alta
                JOptionPane.showMessageDialog(this, "La mesa con identificador " + mesa.getIdMesa() + " ya existe.\nPor favor, introduzca otro identificador.", "ERROR ALTA MESA", JOptionPane.ERROR_MESSAGE);
                System.out.println("Mesa NO añadida.");  //comprobación consola
            } else {
                logicaNegocio.altaMesa(mesa);
                //gestionMesas.anhadirMesa(mesa);   // si utilizamos DefaultTableModel
                // Dialogo éxito modificación
                JOptionPane.showMessageDialog(this, "Mesa añadida con éxito", "ALTA MESA", JOptionPane.INFORMATION_MESSAGE);
                //setVisible(false);    // oculta el formulario (pero no lo destruye)
                dispose();              // destruye el formulario
            }
        } else {
            mesaModificar.setIdMesa(idMesa);
            mesaModificar.setLocalizacion(localizacion);
            mesaModificar.setCapacidad(capacidad);

            logicaNegocio.altaMesa(mesaModificar);
            // Dialogo éxito modificación
            JOptionPane.showMessageDialog(this, "Mesa modificada con éxito", "MODIFICACIÓN MESA", JOptionPane.INFORMATION_MESSAGE);
            dispose();

            logicaNegocio.listarMesas();  // comprobación consola
        }
         */

        fechaInicioFiltradoTicket = (Date) jSpinnerFechaInicio.getValue();
        logicaNegocio.setFechaInicioFiltradoTicket(fechaInicioFiltradoTicket);
        fechaFinFiltradoTicket = (Date) jSpinnerFechaFin.getValue();
        logicaNegocio.setFechaFinFiltradoTicket(fechaFinFiltradoTicket);

        if (fechaInicioFiltradoTicket.compareTo(fechaFinFiltradoTicket) > 0) {
            jButtonFiltradoTicketFechaAceptar.setEnabled(false);
            JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser mayor que la de fin.", "ADVERTENCIA SELECCIÓN FECHAS", JOptionPane.ERROR_MESSAGE);
        } else {
            jButtonFiltradoTicketFechaAceptar.setEnabled(true);
        }
        VisualizacionTicketsPorFecha visualizacionTicketsFiltradoFecha = new VisualizacionTicketsPorFecha(this, true, logicaNegocio);     // NOTA: Si necesitase un Frame (pero recibe un Dialog). Se podría
        visualizacionTicketsFiltradoFecha.setVisible(true);                                                                               // arreglar con con this.pantallaPrincipal (Frame) por this (Dialog)

        dispose();
    }//GEN-LAST:event_jButtonFiltradoTicketFechaAceptarActionPerformed

    private void jSpinnerFechaInicioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSpinnerFechaInicioPropertyChange
        // Asignar fecha de inicio de filtrado del valor de la fecha seleccionado
        // Convertir el object a Date
        logicaNegocio.setFechaInicioFiltradoTicket((Date) jSpinnerFechaInicio.getValue());
    }//GEN-LAST:event_jSpinnerFechaInicioPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFiltradoTicketFechaAceptar;
    private javax.swing.JLabel jLabelFiltradoTicketFecha;
    private javax.swing.JLabel jLabelFiltradoTicketFechaFin;
    private javax.swing.JLabel jLabelFiltradoTicketFechaInicio;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBarFiltradoTicketFecha;
    private javax.swing.JMenuItem jMenuItemMostrarAyuda;
    private javax.swing.JSpinner jSpinnerFechaFin;
    private javax.swing.JSpinner jSpinnerFechaInicio;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelFiltradoTicketFecha;
    // End of variables declaration//GEN-END:variables
}
