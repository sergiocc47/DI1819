/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dto.Corredor;
import interfaztablemodels.TableModelCorredores;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.GestorFichero;
import logica.LogicaNegocio;
import static utils.Utils.sdf;

/**
 *
 * @author SC
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private LogicaNegocio logicaNegocio = new LogicaNegocio();
    GestorFichero gf = new GestorFichero(logicaNegocio);
    
    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        rellenarTablaCorredores();
    }
    
    public void rellenarTablaCorredores(){
        String[] columnas = {"Nombre", "DNI", "Fecha de nacimiento", "Dirección", "Teléfono de contacto"};
        DefaultTableModel dtm = new DefaultTableModel(columnas,0);
        for (Corredor corredor : logicaNegocio.getListaCorredores()){
            String[] c = new String[5];
            c[0] = corredor.getNombre();
            c[1] = corredor.getDni();
            c[2] = sdf.format(corredor.getFechaNacimiento());
            c[3] = corredor.getDireccion();
            c[4] = String.valueOf(corredor.getTelefonoContacto());
            dtm.addRow(c);
        }
        jTableCorredores.setModel(dtm);
                   
    }
    
    //Utilizando un AbstractTableModel
    private void rellenarTablaCorredores2()
    {
        jTableCorredores.setModel(new TableModelCorredores(logicaNegocio.getListaCorredores()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog2 = new javax.swing.JDialog();
        jButtonAnhadir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCorredores = new javax.swing.JTable();
        jButtonModificar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAnhadir.setText("AÑADIR");
        jButtonAnhadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnhadirActionPerformed(evt);
            }
        });

        jTableCorredores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableCorredores);

        jButtonModificar.setText("MODIFICAR");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonBorrar.setText("BORRAR");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jButtonAnhadir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jButtonModificar)
                        .addGap(79, 79, 79)
                        .addComponent(jButtonBorrar)))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonBorrar)
                    .addComponent(jButtonAnhadir))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnhadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnhadirActionPerformed
        AltaCorredor pantallaSecundaria = new AltaCorredor(this, true, logicaNegocio);
        pantallaSecundaria.setLocationRelativeTo(null);
        pantallaSecundaria.setVisible(true);
        //El hilo se queda bloqueado en el setVisible porque el dialogo es modal.
        rellenarTablaCorredores();
        //Diálogo para mostrar mensaje de confirmación al añadir corredor.
        JOptionPane.showMessageDialog(this, "Corredor añadido con éxito", "Alta Corredor", JOptionPane.INFORMATION_MESSAGE);
        //Creación del CSV
        gf.escribirArchivo();
        // Lee el List con la nueva información (corredores añadidos)
        gf.leerArchivo();
        logicaNegocio.listarCorredores();       
    }//GEN-LAST:event_jButtonAnhadirActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        int seleccionado = jTableCorredores.getSelectedRow();
        Corredor corredorSeleccionado = logicaNegocio.getListaCorredores().get(seleccionado);//getTablaCorredores().get(seleccionado);
        AltaCorredor dialogoModificar = new AltaCorredor(this,true, corredorSeleccionado);
        dialogoModificar.setLocationRelativeTo(null);
        dialogoModificar.setVisible(true);
        rellenarTablaCorredores();
        logicaNegocio.listarCorredores();
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        int seleccionado = jTableCorredores.getSelectedRow();
        Corredor corredorSeleccionado = logicaNegocio.getListaCorredores().get(seleccionado);
        AltaCorredor dialogoBorrar = new AltaCorredor ();
        //continuar código
    }//GEN-LAST:event_jButtonBorrarActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnhadir;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCorredores;
    // End of variables declaration//GEN-END:variables
}
