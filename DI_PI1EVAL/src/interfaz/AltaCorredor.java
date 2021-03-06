/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dto.Corredor;
import java.awt.Frame;
import java.util.Date;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import logica.LogicaNegocio;
import org.netbeans.validation.api.builtin.stringvalidation.DNIValidator;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author SC
 */
public class AltaCorredor extends javax.swing.JDialog {

    private LogicaNegocio logicaNegocio;
    private Corredor corredorModificar = null;

    /**
     * Creates new form AltaCorredor
     */
    // Constructor Alta
    public AltaCorredor(java.awt.Frame parent, boolean modal, LogicaNegocio logicaNegocio) {
        super(parent, modal);
        this.logicaNegocio = logicaNegocio;
        initComponents();

        jButtonAceptar.setEnabled(false);
        ValidationGroup group = validationPanelCorredor.getValidationGroup();
        group.add(jTextFieldNombre, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldDNI, StringValidators.REQUIRE_NON_EMPTY_STRING, new DNIValidator());        //simple, mejorar
        group.add(jTextFieldDireccion, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldTelefonoContacto, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER);

        validationPanelCorredor.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                if (validationPanelCorredor.getProblem() == null) {
                    jButtonAceptar.setEnabled(true);
                } else {
                    jButtonAceptar.setEnabled(false);
                }
            }

        });

    }

    // Constructor Modificar. Será un alta si el valor de corredorModificar es null 
    // y será una modificación si tiene un valor
    public AltaCorredor(java.awt.Frame parent, boolean modal, Corredor corredorModificar) {
        super(parent, modal);
        this.corredorModificar = corredorModificar;
        initComponents();
        
        jTextFieldNombre.setText(corredorModificar.getNombre());
        jTextFieldDNI.setText(corredorModificar.getDni());
        jSpinnerFechaNacimiento.setValue(corredorModificar.getFechaNacimiento());
        jTextFieldDireccion.setText(corredorModificar.getDireccion());
        jTextFieldTelefonoContacto.setText(String.valueOf(corredorModificar.getTelefonoContacto()));

        ValidationGroup group = validationPanelCorredor.getValidationGroup();
        group.add(jTextFieldNombre, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldDNI, StringValidators.REQUIRE_NON_EMPTY_STRING, new DNIValidator());        //simple, mejorar
        group.add(jTextFieldDireccion, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldTelefonoContacto, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER);

        validationPanelCorredor.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                if (validationPanelCorredor.getProblem() == null) {
                    jButtonAceptar.setEnabled(true);
                } else {
                    jButtonAceptar.setEnabled(false);
                }
            }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAltaCorredor = new javax.swing.JPanel();
        jLabelAltaCorredor = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelDNI = new javax.swing.JLabel();
        jLabelFechaNacimiento = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelTelefonoContacto = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldDNI = new javax.swing.JTextField();
        jSpinnerFechaNacimiento = new javax.swing.JSpinner();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldTelefonoContacto = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        validationPanelCorredor = new org.netbeans.validation.api.ui.swing.ValidationPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelAltaCorredor.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabelAltaCorredor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAltaCorredor.setText("ALTA CORREDOR");

        jLabelNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelNombre.setText("Nombre");

        jLabelDNI.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelDNI.setText("DNI");

        jLabelFechaNacimiento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelFechaNacimiento.setText("Fecha de nacimiento");

        jLabelDireccion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelDireccion.setText("Dirección");

        jLabelTelefonoContacto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelTelefonoContacto.setText("Teléfono de contacto");

        jTextFieldNombre.setName("Nombre"); // NOI18N

        jTextFieldDNI.setName("DNI"); // NOI18N

        jSpinnerFechaNacimiento.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1538120449356L), null, null, java.util.Calendar.DAY_OF_MONTH));

        jTextFieldDireccion.setName("Dirección"); // NOI18N

        jTextFieldTelefonoContacto.setName("Teléfono de contacto"); // NOI18N

        jButtonAceptar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonAceptar.setText("ACEPTAR");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonLimpiar.setText("LIMPIAR");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAltaCorredorLayout = new javax.swing.GroupLayout(jPanelAltaCorredor);
        jPanelAltaCorredor.setLayout(jPanelAltaCorredorLayout);
        jPanelAltaCorredorLayout.setHorizontalGroup(
            jPanelAltaCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAltaCorredorLayout.createSequentialGroup()
                .addGroup(jPanelAltaCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAltaCorredorLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanelAltaCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAltaCorredorLayout.createSequentialGroup()
                                .addGroup(jPanelAltaCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelTelefonoContacto)
                                    .addComponent(jLabelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelFechaNacimiento))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelAltaCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldDireccion)
                                    .addComponent(jTextFieldDNI)
                                    .addComponent(jTextFieldNombre)
                                    .addComponent(jTextFieldTelefonoContacto, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSpinnerFechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanelAltaCorredorLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabelAltaCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanelAltaCorredorLayout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addGroup(jPanelAltaCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(validationPanelCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelAltaCorredorLayout.createSequentialGroup()
                                .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelAltaCorredorLayout.setVerticalGroup(
            jPanelAltaCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAltaCorredorLayout.createSequentialGroup()
                .addComponent(jLabelAltaCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelAltaCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAltaCorredorLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabelNombre))
                    .addGroup(jPanelAltaCorredorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAltaCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDNI)
                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAltaCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaNacimiento)
                    .addComponent(jSpinnerFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAltaCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDireccion)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAltaCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefonoContacto)
                    .addComponent(jTextFieldTelefonoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(validationPanelCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(253, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanelAltaCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanelAltaCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        String nombre = jTextFieldNombre.getText();
        String dni = jTextFieldDNI.getText();
        Date fechaNacimiento = (Date) jSpinnerFechaNacimiento.getValue();
        String direccion = jTextFieldDireccion.getText();
        int telefonoContacto = Integer.parseInt(jTextFieldTelefonoContacto.getText());
        // Comprobamos si es un alta o una modificación
        if (corredorModificar == null) {
            Corredor c = new Corredor(nombre, dni, fechaNacimiento, direccion, telefonoContacto);
            logicaNegocio.altaCorredor(c);
        } else {
            corredorModificar.setNombre(nombre);
            corredorModificar.setDni(dni);
            corredorModificar.setDireccion(direccion);
            corredorModificar.setFechaNacimiento(fechaNacimiento);
            corredorModificar.setDireccion(direccion);
            corredorModificar.setTelefonoContacto(telefonoContacto);
        }
        dispose();
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JLabel jLabelAltaCorredor;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelFechaNacimiento;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefonoContacto;
    private javax.swing.JPanel jPanelAltaCorredor;
    private javax.swing.JSpinner jSpinnerFechaNacimiento;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefonoContacto;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelCorredor;
    // End of variables declaration//GEN-END:variables
}
