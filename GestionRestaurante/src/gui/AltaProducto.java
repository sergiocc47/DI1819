/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dto.Producto;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultComboBoxModel;
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
public class AltaProducto extends javax.swing.JDialog {
    
    private GestionCarta gestionCarta;
    private LogicaNegocio logicaNegocio;
    private Producto productoModificar = null;

    /**
     * Creates new form AltaProducto
     */
    // Constructor Alta
    public AltaProducto(java.awt.Dialog parent, boolean modal, LogicaNegocio logicaNegocio) {
        super(parent, modal);
        gestionCarta = (GestionCarta) parent;
        this.logicaNegocio = logicaNegocio;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("ALTA PRODUCTO CARTA");
        ponLaAyuda();
        
        cargarComboBoxProductos();
        jButtonAltaProductoAceptar.setEnabled(false);
        ValidationGroup group = validationPanelAltaProducto.getValidationGroup();
        // MSG_MAY_NOT_BE_EMPTY, ERR_NOT_INTEGER en Bundle_es.properties
        group.add(jTextFieldNombre, StringValidators.REQUIRE_NON_EMPTY_STRING, new MayusculaValidator());
        group.add(jTextFieldPrecio, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_NUMBER, StringValidators.REQUIRE_NON_NEGATIVE_NUMBER);
        // NOT_A_NUMBER, ERR_NEGATIVE_NUMBER en Bundle_es.properties
        // NOTA: jComboBoxCategoria no se evalúa (ningún ComboBox)

        validationPanelAltaProducto.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanelAltaProducto.getProblem() == null) {
                    jButtonAltaProductoAceptar.setEnabled(true);
                } else {
                    jButtonAltaProductoAceptar.setEnabled(false);
                }
            }
        });
    }

    // Constructor Modificar
    public AltaProducto(java.awt.Dialog parent, boolean modal, LogicaNegocio logicaNegocio, Producto productoModificar) {
        super(parent, modal);
        gestionCarta = (GestionCarta) parent;
        this.logicaNegocio = logicaNegocio;
        this.productoModificar = productoModificar;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("MODIFICACIÓN PRODUCTO CARTA");
        ponLaAyuda();
        
        jTextFieldNombre.setText(productoModificar.getNombre());
        jTextFieldNombre.setEnabled(false);
        jTextFieldPrecio.setText(Double.toString(productoModificar.getPrecio()));
        cargarComboBoxProductos();
        
        jButtonAltaProductoAceptar.setEnabled(false);
        ValidationGroup group = validationPanelAltaProducto.getValidationGroup();
        // MSG_MAY_NOT_BE_EMPTY, ERR_NOT_INTEGER en Bundle_es.properties
        group.add(jTextFieldNombre, StringValidators.REQUIRE_NON_EMPTY_STRING, new MayusculaValidator());
        group.add(jTextFieldPrecio, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_NUMBER, StringValidators.REQUIRE_NON_NEGATIVE_NUMBER);
        // NOT_A_NUMBER, ERR_NEGATIVE_NUMBER en Bundle_es.properties

        validationPanelAltaProducto.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanelAltaProducto.getProblem() == null) {
                    jButtonAltaProductoAceptar.setEnabled(true);
                } else {
                    jButtonAltaProductoAceptar.setEnabled(false);
                }
            }
        });
    }
    
    public void cargarComboBoxProductos() {
        String[] categorias = {"Bebidas", "Primer plato", "Segundo plato", "Postre", "Otros"};
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        for (String categoria : categorias) {
            dcm.addElement(categoria);
        }
        jComboBoxCategoria.setModel(dcm);
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
        hb.enableHelpOnButton(jMenuItemMostrarAyuda, "alta_producto_carta", helpset);
        hb.enableHelpKey(getRootPane(), "alta_producto_carta", helpset);
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

        jLabelAltaProducto = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelCategoria = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jButtonAltaProductoAceptar = new javax.swing.JButton();
        validationPanelAltaProducto = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jMenuBarAltaProducto = new javax.swing.JMenuBar();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemMostrarAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelAltaProducto.setText("ALTA PRODUCTO");

        jLabelNombre.setText("Nombre");

        jLabelPrecio.setText("Precio");

        jLabelCategoria.setText("Categoría");

        jTextFieldNombre.setName("Nombre"); // NOI18N

        jTextFieldPrecio.setName("Precio"); // NOI18N

        jButtonAltaProductoAceptar.setText("Aceptar");
        jButtonAltaProductoAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaProductoAceptarActionPerformed(evt);
            }
        });

        jMenuAyuda.setText("Ayuda");

        jMenuItemMostrarAyuda.setText("Mostrar ayuda");
        jMenuAyuda.add(jMenuItemMostrarAyuda);

        jMenuBarAltaProducto.add(jMenuAyuda);

        setJMenuBar(jMenuBarAltaProducto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(validationPanelAltaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPrecio)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelCategoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAltaProducto)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButtonAltaProductoAceptar)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabelAltaProducto)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecio)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategoria)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validationPanelAltaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAltaProductoAceptar)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAltaProductoAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltaProductoAceptarActionPerformed
        
        String nombre = jTextFieldNombre.getText();
        double precio = Double.parseDouble(jTextFieldPrecio.getText());
        String categoria = (String) jComboBoxCategoria.getSelectedItem();
        
        Producto producto = new Producto(nombre, precio, categoria);      // producto temporal
        // Comprobamos si es un alta o una modificación
        if (productoModificar == null) {
            // TODO: Comprobar ignoreCase y tildes
            if (logicaNegocio.existeProductoCarta(producto)) {
                JOptionPane.showMessageDialog(this, "El producto " + producto.getNombre() + " ya existe.\nPor favor, introduzca otro nombre.", "ERROR ALTA PRODUCTO", JOptionPane.ERROR_MESSAGE);
                System.out.println("Producto NO añadido.");  //comprobación consola
            } else {
                logicaNegocio.altaProductoCarta(producto);
                // Dialogo éxito alta
                JOptionPane.showMessageDialog(this, "Producto añadido con éxito.", "ALTA PRODUCTO", JOptionPane.INFORMATION_MESSAGE);
                //setVisible(false);    // oculta el formulario (pero no lo destruye)
                dispose();              // destruye el formulario
            }
        } else {
            // TODO (fail): Corregir duplicado al modificar
            productoModificar.setNombre(nombre);
            productoModificar.setPrecio(precio);
            productoModificar.setCategoria(categoria);
            
            logicaNegocio.altaProductoCarta(productoModificar);

            // Dialogo éxito modificación
            JOptionPane.showMessageDialog(this, "Producto modificado con éxito.", "MODIFICACIÓN PRODUCTO", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            logicaNegocio.listarProductosCarta();// comprobación consola
        }
    }//GEN-LAST:event_jButtonAltaProductoAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAltaProductoAceptar;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabelAltaProducto;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBarAltaProducto;
    private javax.swing.JMenuItem jMenuItemMostrarAyuda;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelAltaProducto;
    // End of variables declaration//GEN-END:variables
}
