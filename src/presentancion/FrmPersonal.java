package presentancion;

import negocio.CodigoCiudad;
import negocio.Jefe;
import util.Funciones;
import util.ValidaEmail;

public class FrmPersonal extends javax.swing.JDialog {

    public int accion = 0;
    
    public FrmPersonal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.cargarComboJefe();
        this.cargarComboCodigoCiudad();
        this.txtApMaterno.setTransferHandler(null);
        this.txtApPaterno.setTransferHandler(null);
        this.txtDireccion.setTransferHandler(null);
        this.txtDni.setTransferHandler(null);
        this.txtEmail.setTransferHandler(null);
        this.txtFijo.setTransferHandler(null);
        this.txtMovil1.setTransferHandler(null);
        this.txtMovil2.setTransferHandler(null);
        this.txtNombres.setTransferHandler(null);
        this.lblAdvertencia.setVisible(false);
        this.lblAdvertencia2.setVisible(false);
        this.jPanel2.setVisible(false);
    }

   
    private void cargarComboJefe(){
       try {
            new Jefe().llenarComboJefe(cboJefe);
       } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
       }
    };
    
    private void cargarComboCodigoCiudad(){
       try {
            new CodigoCiudad().llenarComboCodigoCiudad(cboCodigoCiudad);
       } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
       }
    };
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApPaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFijo = new javax.swing.JTextField();
        lblJefe = new javax.swing.JLabel();
        cboJefe = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtApMaterno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtMovil1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMovil2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        cboCodigoCiudad = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblAdvertencia = new javax.swing.JLabel();
        lblAdvertencia2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setBackground(new java.awt.Color(0, 204, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/config.png"))); // NOI18N
        jLabel1.setText("Mantenimiento de Personal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("DNI: ");

        txtDni.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Ap. Paterno: ");

        txtApPaterno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtApPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApPaternoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Telf. Fijo:");

        txtFijo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFijoActionPerformed(evt);
            }
        });
        txtFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFijoKeyTyped(evt);
            }
        });

        lblJefe.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblJefe.setText("Jefe: ");

        cboJefe.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboJefe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".:: Seleccione ::. (Si Fuese Necesario)" }));
        cboJefe.setToolTipText("");

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anular.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGrabar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGrabar.setText("Guardar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Ap. Materno: ");

        txtApMaterno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtApMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApMaternoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Nombres: ");

        txtNombres.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Direccion:");

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtMovil1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMovil1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMovil1KeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Movil 1:");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Movil 2:");

        txtMovil2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMovil2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMovil2KeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cboCodigoCiudad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("-");

        lblAdvertencia.setForeground(new java.awt.Color(255, 0, 0));
        lblAdvertencia.setText("Advertencia");
        lblAdvertencia.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        lblAdvertencia2.setForeground(new java.awt.Color(255, 0, 51));
        lblAdvertencia2.setText("Advertencia2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdvertencia)
                    .addComponent(lblAdvertencia2))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(lblAdvertencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdvertencia2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGrabar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(42, 42, 42)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(lblJefe)
                                .addGap(18, 18, 18)
                                .addComponent(cboJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEmail)
                                .addComponent(txtDireccion)
                                .addComponent(txtApMaterno)
                                .addComponent(txtApPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                                .addComponent(txtNombres)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cboCodigoCiudad, 0, 130, Short.MAX_VALUE)
                                        .addComponent(txtMovil2))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtMovil1)))))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJefe)
                    .addComponent(cboJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCodigoCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMovil2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtMovil1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGrabar)
                        .addComponent(btnCancelar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        
            String dni = this.txtDni.getText();
            String apPaterno = this.txtApPaterno.getText();
            String apMaterno = this.txtApMaterno.getText();
            String direccion = this.txtDireccion.getText();
            String email = this.txtEmail.getText();
            String fijo = this.txtFijo.getText();
            String movil1 = this.txtMovil1.getText();
            String movil2 = this.txtMovil2.getText();
            String nombres = this.txtNombres.getText();
            if (dni.isEmpty()) {
                this.jPanel2.setVisible(true);
                this.lblAdvertencia.setVisible(true);
                this.lblAdvertencia.setText("Falta llenar el campo DNI");
                this.lblAdvertencia2.setText("");
                return;
            }
            if (apPaterno.isEmpty()) {
                this.jPanel2.setVisible(true);
                this.lblAdvertencia.setVisible(true);
                this.lblAdvertencia.setText("Falta llenar el campo Ap. Paterno");
                this.lblAdvertencia2.setText("");
                return;
            }
            if (apMaterno.isEmpty()) {
                this.jPanel2.setVisible(true);
                this.lblAdvertencia.setVisible(true);
                this.lblAdvertencia.setText("Falta llenar el campo Ap. Materno");
                this.lblAdvertencia2.setText("");
                return;
            }
            if (nombres.isEmpty()) {
                this.jPanel2.setVisible(true);
                this.lblAdvertencia.setVisible(true);
                this.lblAdvertencia.setText("Falta llenar el campo Nombres");
                this.lblAdvertencia2.setText("");
                return;
            }
            if (direccion.isEmpty()) {
                this.jPanel2.setVisible(true);
                this.lblAdvertencia.setVisible(true);
                this.lblAdvertencia.setText("Falta llenar el campo Direccion");
                this.lblAdvertencia2.setText("");
                return;
            }
            if (fijo.isEmpty()) {
                this.jPanel2.setVisible(true);
                this.lblAdvertencia.setVisible(true);
                this.lblAdvertencia.setText("Falta llenar el campo Telf. Fijo");
                this.lblAdvertencia2.setText("");
                return;
            }
            if (email.isEmpty()) {
                this.jPanel2.setVisible(true);
                this.lblAdvertencia.setVisible(true);
                this.lblAdvertencia.setText("Falta llenar el campo Email");
                this.lblAdvertencia2.setText("");
                return;
            }else{
                if (!(ValidaEmail.validateEmail(email))) {
                    this.jPanel2.setVisible(true);
                    this.lblAdvertencia.setVisible(true);
                    this.lblAdvertencia2.setVisible(true);
                    this.lblAdvertencia.setText("Formato de Email incorrecto");
                    this.lblAdvertencia2.setText("Ejemplo: ejemplo@correo.com");
                    return;
                }
            }
            this.lblAdvertencia.setVisible(false);
            this.lblAdvertencia2.setVisible(false);
            int respuesta = Funciones.mensajeConfirmacion("Esta seguro de grabar", "Confirme");
        if (respuesta == 0){
            this.accion = 1;
            this.dispose();
        }
        
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.accion = 0;
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        Funciones.soloNumeros(evt, txtDni, 8);
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtApPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApPaternoKeyTyped
        Funciones.soloLetras(evt, txtApPaterno, 50);
    }//GEN-LAST:event_txtApPaternoKeyTyped

    private void txtApMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApMaternoKeyTyped
        Funciones.soloLetras(evt, txtApMaterno, 50);
    }//GEN-LAST:event_txtApMaternoKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        Funciones.soloLetras(evt, txtNombres, 50);
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtFijoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFijoKeyTyped
        Funciones.soloNumeros(evt, txtFijo, 20);
    }//GEN-LAST:event_txtFijoKeyTyped

    private void txtMovil1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMovil1KeyTyped
        Funciones.soloNumeros(evt, txtMovil1, 20);
    }//GEN-LAST:event_txtMovil1KeyTyped

    private void txtMovil2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMovil2KeyTyped
        Funciones.soloNumeros(evt, txtMovil2, 20);
    }//GEN-LAST:event_txtMovil2KeyTyped

    private void txtFijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFijoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFijoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGrabar;
    public javax.swing.JComboBox cboCodigoCiudad;
    public javax.swing.JComboBox cboJefe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAdvertencia;
    private javax.swing.JLabel lblAdvertencia2;
    public javax.swing.JLabel lblJefe;
    public javax.swing.JTextField txtApMaterno;
    public javax.swing.JTextField txtApPaterno;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtFijo;
    public javax.swing.JTextField txtMovil1;
    public javax.swing.JTextField txtMovil2;
    public javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
