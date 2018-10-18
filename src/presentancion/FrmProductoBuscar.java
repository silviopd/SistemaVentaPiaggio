package presentancion;

import java.sql.ResultSet;
import negocio.Producto;
import util.Funciones;

public class FrmProductoBuscar extends javax.swing.JDialog {

    public int accion = 0;
    
    public FrmProductoBuscar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.rbPorNombre.setSelected(true);
        this.setLocationRelativeTo(null);
        this.txtValor.requestFocus();
    }
    
    private void buscarProducto(){
        try {
            
            String codigo = "";
            String nombre = "";
            
            if (this.txtValor.getText().isEmpty()){
                Funciones.mensajeAdvertencia("Por favor ingrese el valor que desea buscar", Funciones.NOMBRE_SOFTWARE);
                return;
            }
            
            int tipo=0;
            if (rbPorNombre.isSelected()){
                tipo = 1;
                nombre = this.txtValor.getText().toLowerCase();
            }else{
                tipo = 2;
                codigo = this.txtValor.getText();
            }
            
            Producto objProducto = new Producto();
            ResultSet resultado = objProducto.buscar(codigo, nombre, tipo);
            String alineacion[] = {"C","I","D","I","D","I","I"};
            int anchoCol[] = {80,260,70,100,60,150,150};
            Funciones.llenarTabla(tblResultado, resultado, anchoCol, alineacion);
            if (tblResultado.getRowCount() > 0){
                tblResultado.getSelectionModel().setSelectionInterval(0, 0);
                tblResultado.requestFocus();
            }
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rbPorNombre = new javax.swing.JRadioButton();
        txtValor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable(){
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        };
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busqueda de Productos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/archivo2.png"))); // NOI18N
        jLabel6.setText("Busqueda de Productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroup1.add(rbPorNombre);
        rbPorNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbPorNombre.setText("Buscar por Nombre");
        rbPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPorNombreActionPerformed(evt);
            }
        });

        txtValor.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Ingrese el valor que desea buscar");

        tblResultado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultado);

        btnAceptar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ok.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
        btnSalir.setText("Cerrar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(rbPorNombre)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 387, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addGap(390, 390, 390))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbPorNombre)
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnSalir))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Busqueda de Productos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (tblResultado.getRowCount() > 0){
            int fila = tblResultado.getSelectedRow();
            if (fila >= 0){
                this.accion = 1;
                this.dispose();
            }else{
                Funciones.mensajeAdvertencia("Debe seleccionar un registro", Funciones.NOMBRE_SOFTWARE);
            }
        }else{
            Funciones.mensajeAdvertencia("No hay registros", Funciones.NOMBRE_SOFTWARE);
            this.txtValor.requestFocus();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.accion = 0;
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtValorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyPressed
        if (evt.getKeyCode()==10){
            this.buscarProducto();
        }
    }//GEN-LAST:event_txtValorKeyPressed

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
                
    }//GEN-LAST:event_txtValorKeyTyped

    private void rbPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPorNombreActionPerformed
        this.txtValor.setText("");
        this.txtValor.requestFocus();
    }//GEN-LAST:event_rbPorNombreActionPerformed

    private void tblResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoMouseClicked
        if (evt.getClickCount()==2){ //Contar la cantidad de clic
            this.btnAceptarActionPerformed(null);
        }
    }//GEN-LAST:event_tblResultadoMouseClicked

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbPorNombre;
    public javax.swing.JTable tblResultado;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
