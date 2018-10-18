package presentancion;

import negocio.Categoria;
import negocio.Marca;
import negocio.UnidadMedida;
import util.Funciones;

public class FrmProducto extends javax.swing.JDialog {

    public int accion = 0;
    
    public FrmProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.cargarComboCategoria();
        this.cargarComboMarca();
        this.cargarComboUnidad();
        this.txtNombre.setTransferHandler(null);
        this.txtPrecioVenta.setTransferHandler(null);
        this.lblAdvCod.setVisible(false);
        this.lblAdvNom.setVisible(false);
        this.lblAdvPre.setVisible(false);
        this.lblIncCod.setVisible(false);
        this.lblIncMed.setVisible(false);
        this.lblIncNom.setVisible(false);
        this.lblIncPre.setVisible(false);
    }

    private void cargarComboCategoria(){
        try {
            new Categoria().llenarComboCategoria(cboCategoria);;
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void cargarComboMarca(){
        try {
            new Marca().llenarComboMarca(cboMarca);;
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void cargarComboUnidad(){
        try {
            new UnidadMedida().llenarComboUnidad(cboUnidad);;
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cboMarca = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblIncCod = new javax.swing.JLabel();
        lblIncNom = new javax.swing.JLabel();
        lblIncPre = new javax.swing.JLabel();
        lblIncMed = new javax.swing.JLabel();
        lblAdvCod = new javax.swing.JLabel();
        lblAdvNom = new javax.swing.JLabel();
        lblAdvPre = new javax.swing.JLabel();
        cboUnidad = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setBackground(new java.awt.Color(0, 204, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categorias2.png"))); // NOI18N
        jLabel1.setText("Mantenimiento de Productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Código:");

        txtCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Unidad Medida:");

        txtPrecioVenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Categoría:");

        cboCategoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Marca:");

        cboMarca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anular.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnGrabar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Precio Venta:");

        lblIncCod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/incorrecto.png"))); // NOI18N

        lblIncNom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/incorrecto.png"))); // NOI18N

        lblIncPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/incorrecto.png"))); // NOI18N

        lblIncMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/incorrecto.png"))); // NOI18N

        lblAdvCod.setForeground(new java.awt.Color(255, 0, 0));
        lblAdvCod.setText("advCod");

        lblAdvNom.setForeground(new java.awt.Color(255, 0, 0));
        lblAdvNom.setText("advNom");

        lblAdvPre.setForeground(new java.awt.Color(255, 0, 0));
        lblAdvPre.setText("advPre");

        cboUnidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIncNom))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIncCod))
                            .addComponent(lblAdvNom)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblIncMed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAdvPre)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblIncPre))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cboMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(lblAdvCod)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIncCod, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIncMed)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAdvCod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIncNom, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAdvNom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(jLabel4)
                            .addComponent(lblIncPre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdvPre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if (this.validarDatos()){
            int respuesta = Funciones.mensajeConfirmacion("Esta seguro de grabar", "Confirme");
            if (respuesta == 0){ //hizo clic en el boton {si}
                this.accion = 1;
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private boolean validarDatos(){
        if (this.txtCodigo.getText().isEmpty() ){
            this.lblAdvCod.setText("Falta completar los datos del campo Código");
            this.lblAdvCod.setVisible(true);
            this.lblAdvNom.setVisible(false);
            this.lblAdvPre.setVisible(false);
            this.lblIncCod.setVisible(true);
            this.lblIncMed.setVisible(false);
            this.lblIncNom.setVisible(false);
            this.lblIncPre.setVisible(false);
            this.cboMarca.requestFocus();
            return false;
        }else if (this.txtNombre.getText().isEmpty()){
            this.lblAdvNom.setText("Falta completar los datos en el campo nombre");
            this.lblAdvCod.setVisible(false);
            this.lblAdvNom.setVisible(true);
            this.lblAdvPre.setVisible(false);
            this.lblIncCod.setVisible(false);
            this.lblIncMed.setVisible(false);
            this.lblIncNom.setVisible(true);
            this.lblIncPre.setVisible(false);
            this.txtNombre.requestFocus();
            return false;
            
        }else if (this.txtPrecioVenta.getText().isEmpty()){
            this.lblAdvPre.setText("Falta completar los datos en el campo precio de venta");
            this.lblAdvCod.setVisible(false);
            this.lblAdvNom.setVisible(false);
            this.lblAdvPre.setVisible(true);
            this.lblIncCod.setVisible(false);
            this.lblIncMed.setVisible(false);
            this.lblIncNom.setVisible(false);
            this.lblIncPre.setVisible(true);
            this.txtNombre.requestFocus();
            this.txtPrecioVenta.requestFocus();
            return false;
        }else if (this.cboCategoria.getSelectedIndex() < 0 ){
            Funciones.mensajeAdvertencia("Debe seleccionar una categoría", Funciones.NOMBRE_SOFTWARE);
            this.cboCategoria.requestFocus();
            return false;
        }else if (this.cboMarca.getSelectedIndex() < 0 ){
            Funciones.mensajeAdvertencia("Debe seleccionar una marca", Funciones.NOMBRE_SOFTWARE);
            this.cboMarca.requestFocus();
            return false;
        }
        
        return true;
        
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.accion = 0;
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        Funciones.soloNumerosDecimal(evt, txtPrecioVenta, 10);
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:
    //    Funciones.aceptaTodosCaracteres(evt, txtCodigo, 20);
        Funciones.soloNumerosyLetras(evt, txtCodigo, 20);
    }//GEN-LAST:event_txtCodigoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGrabar;
    public javax.swing.JComboBox cboCategoria;
    public javax.swing.JComboBox cboMarca;
    public javax.swing.JComboBox cboUnidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdvCod;
    private javax.swing.JLabel lblAdvNom;
    private javax.swing.JLabel lblAdvPre;
    private javax.swing.JLabel lblIncCod;
    private javax.swing.JLabel lblIncMed;
    private javax.swing.JLabel lblIncNom;
    private javax.swing.JLabel lblIncPre;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
