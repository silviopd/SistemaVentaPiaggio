package presentancion;

import negocio.Departamento;
import negocio.Distrito;
import negocio.Provincia;
import util.Funciones;

public class FrmCliente extends javax.swing.JDialog {

    public int accion = 0;
    
    public FrmCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.cargarComboDepartamento();
        this.txtApellidoMaterno.setTransferHandler(null);
        this.txtApellidoPaterno.setTransferHandler(null);
        this.txtDireccion.setTransferHandler(null);
        this.txtNombre.setTransferHandler(null);
        this.txtTelefonoMovil1.setTransferHandler(null);
        this.txtTelefonoMovil2.setTransferHandler(null);
        this.txtTelelfonoFijo.setTransferHandler(null);
        this.lblAdvApMat.setVisible(false);
        this.lblAdvApPat.setVisible(false);
        this.lblAdvNom.setVisible(false);
        this.lblAdvDir.setVisible(false);
        this.lblIncPat.setVisible(false);
        this.lblIncMat.setVisible(false);
        this.lblIncNom.setVisible(false);
        this.lblIncDir.setVisible(false);
        
    } 
    
    private void cargarComboDepartamento(){
        try {
            new Departamento().llenarComboDepartamento(cboDep);;
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboDep = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cboPro = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cboDis = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTelelfonoFijo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTelefonoMovil1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTelefonoMovil2 = new javax.swing.JTextField();
        lblAdvApPat = new javax.swing.JLabel();
        lblAdvApMat = new javax.swing.JLabel();
        lblAdvNom = new javax.swing.JLabel();
        lblAdvDir = new javax.swing.JLabel();
        lblIncPat = new javax.swing.JLabel();
        lblIncMat = new javax.swing.JLabel();
        lblIncNom = new javax.swing.JLabel();
        lblIncDir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setBackground(new java.awt.Color(0, 204, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente2.png"))); // NOI18N
        jLabel1.setText("  Mantenimiento de Clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Código:");

        txtCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCodigo.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Apellido Paterno:");

        txtApellidoPaterno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPaternoActionPerformed(evt);
            }
        });
        txtApellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPaternoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Departamento:");

        cboDep.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboDep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDepActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Provincia:");

        cboPro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Distrito:");

        cboDis.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboDis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
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

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Direccion:");

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel12.setText("Telefono Fijo:");

        txtTelelfonoFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelelfonoFijoKeyTyped(evt);
            }
        });

        jLabel15.setText("Apellido Materno:");

        txtApellidoMaterno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMaternoKeyTyped(evt);
            }
        });

        jLabel11.setText("Telefono Móvil 1:");

        txtTelefonoMovil1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoMovil1KeyTyped(evt);
            }
        });

        jLabel13.setText("Telefono Móvil 2:");

        txtTelefonoMovil2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoMovil2KeyTyped(evt);
            }
        });

        lblAdvApPat.setForeground(new java.awt.Color(255, 0, 0));
        lblAdvApPat.setText("lblAdvApPat");

        lblAdvApMat.setForeground(new java.awt.Color(255, 0, 0));
        lblAdvApMat.setText("lblAdvApMat");

        lblAdvNom.setForeground(new java.awt.Color(255, 0, 0));
        lblAdvNom.setText("lblAdvNom");

        lblAdvDir.setForeground(new java.awt.Color(255, 0, 0));
        lblAdvDir.setText("lblAdvDir");

        lblIncPat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/incorrecto.png"))); // NOI18N

        lblIncMat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/incorrecto.png"))); // NOI18N

        lblIncNom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/incorrecto.png"))); // NOI18N

        lblIncDir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/incorrecto.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboDep, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel10)
                                .addComponent(jLabel12))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion)
                            .addComponent(txtNombre)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblAdvNom)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAdvDir)
                                    .addComponent(lblAdvApPat)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblIncPat)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblAdvApMat)
                                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTelelfonoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefonoMovil1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefonoMovil2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(129, 129, 129)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboPro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboDis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIncMat)
                            .addComponent(lblIncNom)
                            .addComponent(lblIncDir))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIncMat)
                    .addComponent(lblIncPat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdvApPat)
                    .addComponent(lblAdvApMat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIncNom)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(lblAdvNom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIncDir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdvDir)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTelelfonoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtTelefonoMovil1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtTelefonoMovil2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboDis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnGrabar))
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
        if (this.txtApellidoPaterno.getText().isEmpty()){
            this.lblAdvApPat.setText("Falta completar los datos en el campo Apellido Paterno");
            this.lblAdvApPat.setVisible(true);
            this.lblAdvApMat.setVisible(false);
            this.lblAdvNom.setVisible(false);
            this.lblAdvDir.setVisible(false);
            this.lblIncPat.setVisible(true);
            this.lblIncMat.setVisible(false);
            this.lblIncNom.setVisible(false);
            this.lblIncDir.setVisible(false);
            this.txtApellidoPaterno.requestFocus();
            return false;
            
        }else if (this.txtApellidoMaterno.getText().isEmpty()){
            this.lblAdvApMat.setText("Falta completar los datos en el campo Apellido Materno");
            this.lblAdvApMat.setVisible(true);
            this.lblAdvApPat.setVisible(false);
            this.lblAdvNom.setVisible(false);
            this.lblAdvDir.setVisible(false);
            this.lblIncPat.setVisible(false);
            this.lblIncMat.setVisible(true);
            this.lblIncNom.setVisible(false);
            this.lblIncDir.setVisible(false);
            this.txtApellidoMaterno.requestFocus();
            return false;
        
        
        }else if (this.txtNombre.getText().isEmpty()){
            this.lblAdvNom.setText("Falta completar los datos en el campo Nombre");
            this.lblAdvNom.setVisible(true);
            this.lblAdvApMat.setVisible(false);
            this.lblAdvApPat.setVisible(false);
            this.lblAdvDir.setVisible(false);
            this.lblIncPat.setVisible(false);
            this.lblIncMat.setVisible(false);
            this.lblIncNom.setVisible(true);
            this.lblIncDir.setVisible(false);
            this.txtNombre.requestFocus();
            return false;
           
        }else if (this.txtDireccion.getText().isEmpty()){
            this.lblAdvDir.setText("Falta completar los datos en el campo Dirección");
            this.lblAdvDir.setVisible(true);
            this.lblAdvApMat.setVisible(false);
            this.lblAdvApPat.setVisible(false);
            this.lblAdvNom.setVisible(false);
            this.lblIncPat.setVisible(false);
            this.lblIncMat.setVisible(false);
            this.lblIncNom.setVisible(false);
            this.lblIncDir.setVisible(true);
            this.txtDireccion.requestFocus();
            return false;
            
        }      
        return true;
        
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.accion = 0;
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDepActionPerformed
        if (this.cboDep.getSelectedIndex() >= 0){
            String codigoDepartamento = Departamento.listaDepartamentos.get( this.cboDep.getSelectedIndex() ).getCodDep();
            try {
                new Provincia().llenarComboProvincia(cboPro, codigoDepartamento);
                String codigoProvincia = Provincia.listaProvincias.get( this.cboPro.getSelectedIndex() ).getCodPro();
                new Distrito().llenarComboDistrito(cboDis, codigoDepartamento,codigoProvincia);
                } catch (Exception e) {
                Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
            }
            
        }
        
    }//GEN-LAST:event_cboDepActionPerformed

    private void txtApellidoPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPaternoKeyTyped
        Funciones.soloLetras(evt, txtApellidoPaterno, 30);
    }//GEN-LAST:event_txtApellidoPaternoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        Funciones.soloLetras(evt, txtNombre, 30);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void cboProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProActionPerformed
        // TODO add your handling code here:
        if (this.cboDep.getSelectedIndex() >= 0){
            String codigoDepartamento = Departamento.listaDepartamentos.get( this.cboDep.getSelectedIndex() ).getCodDep();
            try {
                
                if (this.cboPro.getSelectedIndex() >= 0){
                    String codigoProvincia = Provincia.listaProvincias.get( this.cboPro.getSelectedIndex() ).getCodPro();
                    System.out.println(codigoDepartamento+"-"+codigoProvincia);
                    new Distrito().llenarComboDistrito(cboDis, codigoDepartamento,codigoProvincia);   
                }
            } catch (Exception e) {
                Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
            }
            
        }
    }//GEN-LAST:event_cboProActionPerformed

    private void txtApellidoMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMaternoKeyTyped
        // TODO add your handling code here:
        Funciones.soloLetras(evt, txtApellidoMaterno, 30);
    }//GEN-LAST:event_txtApellidoMaternoKeyTyped

    private void txtApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPaternoActionPerformed

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        Funciones.aceptaTodosCaracteres(evt, txtDireccion, 50);
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtTelelfonoFijoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelelfonoFijoKeyTyped
        Funciones.aceptaTodosCaracteres(evt, txtCodigo, 20);
    }//GEN-LAST:event_txtTelelfonoFijoKeyTyped

    private void txtTelefonoMovil1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoMovil1KeyTyped
        // TODO add your handling code here:
        Funciones.aceptaTodosCaracteres(evt, txtCodigo, 20);
    }//GEN-LAST:event_txtTelefonoMovil1KeyTyped

    private void txtTelefonoMovil2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoMovil2KeyTyped
        // TODO add your handling code here:
        Funciones.aceptaTodosCaracteres(evt, txtCodigo, 20);
    }//GEN-LAST:event_txtTelefonoMovil2KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGrabar;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox cboDep;
    public javax.swing.JComboBox cboDis;
    public javax.swing.JComboBox cboPro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdvApMat;
    private javax.swing.JLabel lblAdvApPat;
    private javax.swing.JLabel lblAdvDir;
    private javax.swing.JLabel lblAdvNom;
    private javax.swing.JLabel lblIncDir;
    private javax.swing.JLabel lblIncMat;
    private javax.swing.JLabel lblIncNom;
    private javax.swing.JLabel lblIncPat;
    public javax.swing.JTextField txtApellidoMaterno;
    public javax.swing.JTextField txtApellidoPaterno;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefonoMovil1;
    public javax.swing.JTextField txtTelefonoMovil2;
    public javax.swing.JTextField txtTelelfonoFijo;
    // End of variables declaration//GEN-END:variables
}
