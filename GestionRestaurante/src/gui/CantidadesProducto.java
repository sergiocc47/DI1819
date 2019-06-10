package gui;

import dto.Producto;
import dto.ProductoTicket;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.MutableComboBoxModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import logica.LogicaNegocio;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author sergio
 */
public class CantidadesProducto extends javax.swing.JDialog {
    
    private GestionProductosTicket gestionProductosTicket;
    private LogicaNegocio logicaNegocio;
    ProductoTicket productoTicketModificar = null;

    /**
     * Creates new form UnidadesProducto
     */
    // Será un alta si el valor de mesaModificar es null 
    // y será una modificación si tiene un valor
    // Constructor Alta
    public CantidadesProducto(java.awt.Dialog parent, boolean modal, LogicaNegocio logicaNegocio) {    // Frame cambiado a Dialog
        super(parent, modal);
        gestionProductosTicket = (GestionProductosTicket) parent;
        this.logicaNegocio = logicaNegocio;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FORMULARIO AÑADIR PRODUCTO TICKET");
        rellenarComboBoxListaProductos();
        ponLaAyuda();
        
        jButtonAceptarProductoYCantidad.setEnabled(false);
        ValidationGroup group = validationPanelCantidadesProducto.getValidationGroup();
        group.add(jTextFieldCantidad, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER);
        
        validationPanelCantidadesProducto.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanelCantidadesProducto.getProblem() == null) {
                    jButtonAceptarProductoYCantidad.setEnabled(true);
                } else {
                    jButtonAceptarProductoYCantidad.setEnabled(false);
                }
            }
        });
    }

    // Constructor Modificar
    public CantidadesProducto(java.awt.Dialog parent, boolean modal, LogicaNegocio logicaNegocio, ProductoTicket productoTicketModificar) {
        super(parent, modal);
        gestionProductosTicket = (GestionProductosTicket) parent;
        this.logicaNegocio = logicaNegocio;
        this.productoTicketModificar = productoTicketModificar;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FORMULARIO MODIFICACIÓN PRODUCTO TICKET");
        rellenarComboBoxListaProductos();
        ponLaAyuda();
        
        //jComboBoxListaProductos.setEnabled(false);      // TODO: Arreglar visualización nombreProducto en ComboBox
        jTextFieldCantidad.setText(Integer.toString(productoTicketModificar.getCantidad()));
        
        jButtonAceptarProductoYCantidad.setEnabled(false);
        ValidationGroup group = validationPanelCantidadesProducto.getValidationGroup();
        group.add(jTextFieldCantidad, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER);
        
        validationPanelCantidadesProducto.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanelCantidadesProducto.getProblem() == null) {
                    jButtonAceptarProductoYCantidad.setEnabled(true);
                } else {
                    jButtonAceptarProductoYCantidad.setEnabled(false);
                }
            }
        });

        /*
        jTextFieldIdMesa.setText(Integer.toString(mesaModificar.getIdMesa()));
        jTextFieldIdMesa.setEnabled(false);
        jTextFieldLocalizacion.setText(mesaModificar.getLocalizacion());
        jTextFieldCapacidad.setText(Integer.toString(mesaModificar.getCapacidad()));
        jButtonAltaMesaAceptar.setEnabled(false);
        ValidationGroup group = validationPanelAltaMesa.getValidationGroup();
        group.add(jTextFieldIdMesa, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER);
        // MSG_MAY_NOT_BE_EMPTY, ERR_NOT_INTEGER en Bundle_es.properties
        group.add(jTextFieldLocalizacion, StringValidators.REQUIRE_NON_EMPTY_STRING, new MayusculaValidator());
        // MSG_MAYUSCULA en Bundle_es.properties
        group.add(jTextFieldCapacidad, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER);

        validationPanelAltaMesa.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanelAltaMesa.getProblem() == null) {
                    jButtonAltaMesaAceptar.setEnabled(true);
                } else {
                    jButtonAltaMesaAceptar.setEnabled(false);
                }
            }
        });
         */
    }
    
    public void rellenarComboBoxListaProductos() {

        // Cargado listaProductos en ComboBox
        MutableComboBoxModel<Producto> modelListaProductos = new DefaultComboBoxModel<Producto>();
        jComboBoxListaProductos.setModel(modelListaProductos);
        for (Producto producto : logicaNegocio.getListaProductosCarta()) {
            jComboBoxListaProductos.addItem(producto);      // TODO: Debería ser producto.getNombre() + producto.getCAtegoria()
        }

        // extraído de https://tips4java.wordpress.com/2013/11/17/combo-box-with-custom-renderer/
        /*
        // Use the KeySelectionRenderer to determine which property from the Foo object to display in the combo box
        KeySelectionRenderer renderer = new KeySelectionRenderer(jComboBoxListaMesas) {
        @Override
        public String getDisplayValue(Object value) {
        Mesa mesa = (Mesa) value;
        return mesa.getDescription();
        }
        };
         */
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
        hb.enableHelpOnButton(jMenuItemMostrarAyuda, "alta_producto_ticket", helpset);
        hb.enableHelpKey(getRootPane(), "alta_producto_ticket", helpset);
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

        jLabelSeleccionProducto = new javax.swing.JLabel();
        jLabelProducto = new javax.swing.JLabel();
        jComboBoxListaProductos = new javax.swing.JComboBox<>();
        jLabelCantidad = new javax.swing.JLabel();
        jTextFieldCantidad = new javax.swing.JTextField();
        jButtonAceptarProductoYCantidad = new javax.swing.JButton();
        validationPanelCantidadesProducto = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jMenuBarCantidadesProducto = new javax.swing.JMenuBar();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemMostrarAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelSeleccionProducto.setText("SELECCIÓN PRODUCTO");

        jLabelProducto.setText("Producto");

        jLabelCantidad.setText("Cantidad");

        jButtonAceptarProductoYCantidad.setText("Aceptar");
        jButtonAceptarProductoYCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarProductoYCantidadActionPerformed(evt);
            }
        });

        jMenuAyuda.setText("Ayuda");

        jMenuItemMostrarAyuda.setText("Mostrar ayuda");
        jMenuAyuda.add(jMenuItemMostrarAyuda);

        jMenuBarCantidadesProducto.add(jMenuAyuda);

        setJMenuBar(jMenuBarCantidadesProducto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCantidad)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelSeleccionProducto)
                            .addComponent(jComboBoxListaProductos, 0, 235, Short.MAX_VALUE)
                            .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(validationPanelCantidadesProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonAceptarProductoYCantidad)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelProducto)
                            .addGap(263, 263, 263))))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabelSeleccionProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProducto)
                    .addComponent(jComboBoxListaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validationPanelCantidadesProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAceptarProductoYCantidad)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarProductoYCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarProductoYCantidadActionPerformed
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
        */
        
        // TODO (fail): Arreglar añadido a lista porque lo hace por duplicado (añadido/modificado y nuevo)
        int cantidad = Integer.parseInt(jTextFieldCantidad.getText());
        Producto producto = (Producto) jComboBoxListaProductos.getSelectedItem();
        
        ProductoTicket productoTicket = new ProductoTicket(cantidad, producto);
        // Comprobamos si es un alta o una modificación
        if (productoTicketModificar == null) {
            // TODO (fail): ¿Podría fallar porque productoTicket está formado por cantidad y producto?
            if (logicaNegocio.existeProductoTicket(productoTicket)) {
                JOptionPane.showMessageDialog(this, "El producto con nombre " + productoTicket.getProducto().getNombre() + " ya está en el ticket.\nPor favor, seleccione otro producto.", "ERROR ALTA MESA", JOptionPane.ERROR_MESSAGE);
                System.out.println("Producto NO añadido al ticket.");  //comprobación consola
            } else {
                //logicaNegocio.getCurrentTicket().getListaProductosTicket().add(productoTicket);   // TODO (borrar): Repite el producto al añadir/modificar
                logicaNegocio.altaProductoTicket(productoTicket);
                //gestionProductosTicket.rellenarTablaProductosTicket();  // TODO: ¿necesario?
                dispose();
            }
        } else {
            // TODO (fail): Corregir duplicado al modificar
            productoTicketModificar.setCantidad(cantidad);
            productoTicketModificar.setProducto(producto);
            //logicaNegocio.getCurrentTicket().getListaProductosTicket().add(productoTicket);   // TODO (borrar): Repite el producto al añadir/modificar
            dispose();
        }
    }//GEN-LAST:event_jButtonAceptarProductoYCantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptarProductoYCantidad;
    private javax.swing.JComboBox<Producto> jComboBoxListaProductos;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JLabel jLabelSeleccionProducto;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBarCantidadesProducto;
    private javax.swing.JMenuItem jMenuItemMostrarAyuda;
    private javax.swing.JTextField jTextFieldCantidad;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelCantidadesProducto;
    // End of variables declaration//GEN-END:variables
}
