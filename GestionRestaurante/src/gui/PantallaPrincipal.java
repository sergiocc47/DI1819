/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dto.Mesa;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import logica.LogicaNegocio;

/**
 *
 * @author sergio
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private LogicaNegocio logicaNegocio = new LogicaNegocio();

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        // Método para cargar lista en un ComboBox
        /*
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        for (Mesa mesa : logicaNegocio.getListaMesas){
            dcm.addElement(comic);
        }
        jComboBoxPrueba.setModel(dcm);
         */
        // Método para cargar lista en una jTable (recomendado)
        //jTableProductosTicket.setModel(new TableModelProductosTicket(logicaNegocio.getListaProductosTicket()));   //comentado para que no falle la ejecución
        initComponents();
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
        jButtonGestionMesas = new javax.swing.JButton();
        jButtonGestionCarta = new javax.swing.JButton();
        jButtonAperturaTicket = new javax.swing.JButton();
        jButtonFiltrarTicketFecha = new javax.swing.JButton();
        jButtonFiltrarTicketMesa = new javax.swing.JButton();
        jLabelListaTicket = new javax.swing.JLabel();
        jScrollPaneProductosTicket = new javax.swing.JScrollPane();
        jTableProductosTicket = new javax.swing.JTable();
        jMenuBarPantallaPrincipal = new javax.swing.JMenuBar();
        jMenuMesas = new javax.swing.JMenu();
        jMenuItemGestionMesas = new javax.swing.JMenuItem();
        jMenuItemAltaMesa = new javax.swing.JMenuItem();
        jMenuCarta = new javax.swing.JMenu();
        jMenuItemGestionCarta = new javax.swing.JMenuItem();
        jMenuItemAltaProducto = new javax.swing.JMenuItem();
        jMenuTickets = new javax.swing.JMenu();
        jMenuItemAperturaTicket = new javax.swing.JMenuItem();
        jMenuFiltrar = new javax.swing.JMenu();
        jMenuItemFiltrarFecha = new javax.swing.JMenuItem();
        jMenuItemFiltrarMesa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelGestionRestaurante.setText("GESTIÓN RESTAURANTE");

        jButtonGestionMesas.setText("Gestión mesas");
        jButtonGestionMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionMesasActionPerformed(evt);
            }
        });

        jButtonGestionCarta.setText("Gestión carta");
        jButtonGestionCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionCartaActionPerformed(evt);
            }
        });

        jButtonAperturaTicket.setText("Apertura ticket");
        jButtonAperturaTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAperturaTicketActionPerformed(evt);
            }
        });

        jButtonFiltrarTicketFecha.setText("Filtrar ticket (mesa)");

        jButtonFiltrarTicketMesa.setText("Filtrar ticket (fecha)");

        jLabelListaTicket.setText("LISTA TICKETS");

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

        jMenuMesas.setText("Mesas");

        jMenuItemGestionMesas.setText("Gestión ...");
        jMenuItemGestionMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionMesasActionPerformed(evt);
            }
        });
        jMenuMesas.add(jMenuItemGestionMesas);

        jMenuItemAltaMesa.setText("Alta ...");
        jMenuMesas.add(jMenuItemAltaMesa);

        jMenuBarPantallaPrincipal.add(jMenuMesas);

        jMenuCarta.setText("Carta");

        jMenuItemGestionCarta.setText("Gestión ..");
        jMenuItemGestionCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionCartaActionPerformed(evt);
            }
        });
        jMenuCarta.add(jMenuItemGestionCarta);

        jMenuItemAltaProducto.setText("Alta ...");
        jMenuCarta.add(jMenuItemAltaProducto);

        jMenuBarPantallaPrincipal.add(jMenuCarta);

        jMenuTickets.setText("Tickets");

        jMenuItemAperturaTicket.setText("Apertura ...");
        jMenuItemAperturaTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAperturaTicketActionPerformed(evt);
            }
        });
        jMenuTickets.add(jMenuItemAperturaTicket);

        jMenuFiltrar.setText("Filtrar ...");

        jMenuItemFiltrarFecha.setText("Por fecha");
        jMenuFiltrar.add(jMenuItemFiltrarFecha);

        jMenuItemFiltrarMesa.setText("Por mesa");
        jMenuFiltrar.add(jMenuItemFiltrarMesa);

        jMenuTickets.add(jMenuFiltrar);

        jMenuBarPantallaPrincipal.add(jMenuTickets);

        setJMenuBar(jMenuBarPantallaPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonFiltrarTicketMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonFiltrarTicketFecha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAperturaTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGestionCarta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGestionMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelGestionRestaurante)
                            .addComponent(jScrollPaneProductosTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabelListaTicket)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabelGestionRestaurante)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGestionMesas)
                    .addComponent(jLabelListaTicket))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonGestionCarta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAperturaTicket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFiltrarTicketMesa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFiltrarTicketFecha)
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addComponent(jScrollPaneProductosTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // TODO Cambiar tanto botón por un barra de menú
    private void jButtonGestionMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionMesasActionPerformed
        GestionMesas gestionMesas = new GestionMesas(this, true, logicaNegocio);
        gestionMesas.setVisible(true);
    }//GEN-LAST:event_jButtonGestionMesasActionPerformed

    private void jButtonGestionCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionCartaActionPerformed
        GestionCarta gestionCarta = new GestionCarta(this, true, logicaNegocio);
        gestionCarta.setVisible(true);
    }//GEN-LAST:event_jButtonGestionCartaActionPerformed

    private void jButtonAperturaTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAperturaTicketActionPerformed
        AperturaTicket aperturaTicket = new AperturaTicket(this, true);
        aperturaTicket.setVisible(true);
    }//GEN-LAST:event_jButtonAperturaTicketActionPerformed

    private void jMenuItemGestionMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionMesasActionPerformed
        GestionMesas gestionMesas = new GestionMesas(this, true, logicaNegocio);
        gestionMesas.setVisible(true);
    }//GEN-LAST:event_jMenuItemGestionMesasActionPerformed

    private void jMenuItemGestionCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionCartaActionPerformed
        GestionCarta gestionCarta = new GestionCarta(this, true, logicaNegocio);
        gestionCarta.setVisible(true);
    }//GEN-LAST:event_jMenuItemGestionCartaActionPerformed

    private void jMenuItemAperturaTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAperturaTicketActionPerformed
        AperturaTicket aperturaTicket = new AperturaTicket(this, true);
        aperturaTicket.setVisible(true);
    }//GEN-LAST:event_jMenuItemAperturaTicketActionPerformed

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
                Locale.setDefault(new Locale ("es", "ES"));
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAperturaTicket;
    private javax.swing.JButton jButtonFiltrarTicketFecha;
    private javax.swing.JButton jButtonFiltrarTicketMesa;
    private javax.swing.JButton jButtonGestionCarta;
    private javax.swing.JButton jButtonGestionMesas;
    private javax.swing.JLabel jLabelGestionRestaurante;
    private javax.swing.JLabel jLabelListaTicket;
    private javax.swing.JMenuBar jMenuBarPantallaPrincipal;
    private javax.swing.JMenu jMenuCarta;
    private javax.swing.JMenu jMenuFiltrar;
    private javax.swing.JMenuItem jMenuItemAltaMesa;
    private javax.swing.JMenuItem jMenuItemAltaProducto;
    private javax.swing.JMenuItem jMenuItemAperturaTicket;
    private javax.swing.JMenuItem jMenuItemFiltrarFecha;
    private javax.swing.JMenuItem jMenuItemFiltrarMesa;
    private javax.swing.JMenuItem jMenuItemGestionCarta;
    private javax.swing.JMenuItem jMenuItemGestionMesas;
    private javax.swing.JMenu jMenuMesas;
    private javax.swing.JMenu jMenuTickets;
    private javax.swing.JScrollPane jScrollPaneProductosTicket;
    private javax.swing.JTable jTableProductosTicket;
    // End of variables declaration//GEN-END:variables
}
