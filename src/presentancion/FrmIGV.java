
package presentancion;

import negocio.Configuracion;
import util.Funciones;


public class FrmIGV extends javax.swing.JDialog {

    public int accion=0;

    public FrmIGV(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.obtenerPorcentajeIGV();
        this.setLocationRelativeTo(null);
        this.txtValorIGV.requestFocus();
        this.txtValorIGV.setTransferHandler(null);
        this.lblAdv.setVisible(false);
        this.lblIncMar.setVisible(false);
        
    }

    public boolean validarDatos(){
        
        if (txtValorIGV.getText().isEmpty()) {
            this.lblAdv.setText("El campo IGV no debe estar vacío");
            this.lblAdv.setVisible(true);
            this.lblIncMar.setVisible(true);
            this.txtValorIGV.requestFocus();
            return false;
        }
        
        return true;
    }
    
    private void obtenerPorcentajeIGV(){
        try {
            this.txtValorIGV.setText(new Configuracion().obtenerValorParametro(1));
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtValorIGV = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblAdv = new javax.swing.JLabel();
        lblIncMar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel2.setText("IGV:");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anular.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtValorIGV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorIGVKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorIGVKeyTyped(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/config.png"))); // NOI18N
        jLabel6.setText("Mantenimiento de IGV");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        lblAdv.setForeground(new java.awt.Color(255, 0, 0));
        lblAdv.setText("jLabel4");

        lblIncMar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/incorrecto.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtValorIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblIncMar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addComponent(lblAdv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtValorIGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)
                    .addComponent(lblIncMar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdv)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtValorIGVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorIGVKeyTyped
        Funciones.soloNumeros(evt, txtValorIGV, 2);
    }//GEN-LAST:event_txtValorIGVKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        Configuracion obj= new Configuracion();
        if (this.validarDatos()){
            try {
                if(obj.editar(txtValorIGV.getText())){
                    int respuesta = Funciones.mensajeConfirmacion("Esta seguro de grabar", "Confirme");
                    this.lblAdv.setVisible(false);
                    this.lblIncMar.setVisible(false);
                    if (respuesta == 0){ 
                        this.accion = 1;
                        this.dispose();
            }
                }
            } catch (Exception ex) {
                this.lblAdv.setText("Error");
            }
            
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.accion=0;
        this .dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtValorIGVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorIGVKeyPressed
        if(evt.getKeyCode()==10)
        {
            this.btnGuardar.doClick();
        }
    }//GEN-LAST:event_txtValorIGVKeyPressed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdv;
    private javax.swing.JLabel lblIncMar;
    public javax.swing.JTextField txtValorIGV;
    // End of variables declaration//GEN-END:variables
}
