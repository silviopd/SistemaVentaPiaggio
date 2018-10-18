
package presentancion;

import java.sql.ResultSet;
import java.util.ArrayList;
import negocio.TipoDocumento;
import negocio.Venta;
import negocio.VentaDetalle;
import util.Funciones;

public class FrmVentaListado extends javax.swing.JInternalFrame {

    public FrmVentaListado(int x,int y,int ancho) {
        initComponents();
        
         this.setSize(ancho,this.getHeight());
        this.setLocation(x - (this.getWidth()/2), y - (this.getHeight()/2));
        
        this.obtenerFechaActual();
        this.listar();
        this.txtFecha1.setEnabled(false);
        this.txtFecha2.setEnabled(false);
    }
    
    private void obtenerFechaActual(){
        java.util.Date fecha = new java.util.Date();
        this.txtFecha1.setDate(fecha);
        this.txtFecha2.setDate(fecha);
    }
    
    private void listar(){
        try {
            int tipo=0;
            if (this.rbHoy.isSelected()){
                tipo = 1;
            }else if (this.rbFecha.isSelected()){
                tipo = 2;
            }else{
                tipo = 3;
            }
            
            java.sql.Date fecha1 = new java.sql.Date(this.txtFecha1.getDate().getTime());
            java.sql.Date fecha2 = new java.sql.Date(this.txtFecha2.getDate().getTime());
            
            ResultSet resultado = new Venta().listar(fecha1, fecha2, tipo);
            
            String alineamiento[] = {"C","C","C","C","C","I","C","D","D","D","D","I","I","I","I"};
            int ancho[] = {100,80,80,100,120,180,90,80,60,80,90,200,120,120,100};
            
            Funciones.llenarTabla(tblListado, resultado, ancho, alineamiento);
            
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable(){
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        };
        btnAgregar = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        rbHoy = new javax.swing.JRadioButton();
        rbFecha = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        txtFecha1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFecha2 = new com.toedter.calendar.JDateChooser();
        btnFiltrar = new javax.swing.JButton();
        btnMantIGV = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado de Ventas");

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/archivo2.png"))); // NOI18N
        jLabel2.setText("Listado de Ventas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblListado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListado);

        btnAgregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add2.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnAnular.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anular.png"))); // NOI18N
        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar por Fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        buttonGroup1.add(rbHoy);
        rbHoy.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbHoy.setSelected(true);
        rbHoy.setText("Hoy");
        rbHoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbHoyActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbFecha);
        rbFecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbFecha.setText("Fecha");
        rbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFechaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbTodos);
        rbTodos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbTodos.setText("Todas las Fechas");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Hasta:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Desde:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbFecha)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbHoy)
                            .addComponent(rbTodos))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(rbHoy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(rbFecha)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTodos)
                .addGap(9, 9, 9))
        );

        btnFiltrar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnMantIGV.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnMantIGV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
        btnMantIGV.setText("Cambiar valor de IGV");
        btnMantIGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantIGVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMantIGV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFiltrar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnAnular)
                    .addComponent(btnSalir)
                    .addComponent(btnMantIGV))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrmVenta objFrmVenta = new FrmVenta(null, true);
        objFrmVenta.setTitle("Agregar nueva venta");
        objFrmVenta.setVisible(true);
        
        if (objFrmVenta.accion == 1){
            try {
                String tipoDocumento = TipoDocumento.listaTD.get(objFrmVenta.cboTipoDocumento.getSelectedIndex()).getCodTipoDocumento();
                String serie = objFrmVenta.txtSerie.getText();
                String nroDoc = objFrmVenta.txtNroDoc.getText();
                int codigoCliente = Integer.parseInt(objFrmVenta.txtCodigo.getText());
                java.sql.Date fechaVenta = new java.sql.Date( objFrmVenta.txtFecha.getDate().getTime());
                double subTotal = Double.parseDouble(objFrmVenta.lblSubTotal.getText().replace(",", "") );
                double igv = Double.parseDouble(objFrmVenta.lblIGV.getText().replace(",", "") );
                double total = Double.parseDouble(objFrmVenta.lblTotal.getText().replace(",", "") );
                double porcentajeIGV = Double.parseDouble(objFrmVenta.txtPorcentajeIGV.getText().replace(",", "") );
                int codigoUsuario = Funciones.CODIGO_USUARIO_LOGUEADO;
                
                ArrayList<VentaDetalle> detalleVenta = new ArrayList<VentaDetalle>();
                
                for ( int i=0; i<objFrmVenta.tblVentaDetalle.getRowCount();i++){
                    String codigoP = objFrmVenta.tblVentaDetalle.getValueAt(i, 0).toString();
                    int item = i+1;
                    int cantidad = Integer.parseInt( objFrmVenta.tblVentaDetalle.getValueAt(i, 2).toString());
                    double precio = Double.parseDouble(objFrmVenta.tblVentaDetalle.getValueAt(i, 3).toString());
                    double descuento = Double.parseDouble(objFrmVenta.tblVentaDetalle.getValueAt(i, 4).toString());
                    double importe = Double.parseDouble(objFrmVenta.tblVentaDetalle.getValueAt(i, 5).toString().replace(",", ""));
                    
                    VentaDetalle objDetalle = new VentaDetalle();
                    objDetalle.setCodigoProducto(codigoP);
                    objDetalle.setItem(item);
                    objDetalle.setCantidad(cantidad);
                    objDetalle.setPrecio(precio);
                    objDetalle.setDescuento(descuento);
                    objDetalle.setImporte(importe);
                    
                    detalleVenta.add(objDetalle);
                }
                
                Venta objVenta = new Venta();
                objVenta.setCodigoTipoDocumento(tipoDocumento);
                objVenta.setSerie(serie);
                objVenta.setNumero(nroDoc);
                objVenta.setCodigoCliente(codigoCliente);
                objVenta.setFechaVenta(fechaVenta);
                objVenta.setSubtTotal(subTotal);
                objVenta.setIgv(igv);
                objVenta.setTotal(total);
                objVenta.setPorcentajeIGV(porcentajeIGV);
                objVenta.setCodigoUsuario(codigoUsuario);
                
                objVenta.setDetalleVenta(detalleVenta);
                
                if (objVenta.agregar()){
                    Funciones.mensajeInformacion("Grabado exitosamente", Funciones.NOMBRE_SOFTWARE);
                    this.listar();
                }
                
            } catch (Exception e) {
                Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
            }
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        int fila = 0;
        int nroVenta=0;
        
        try {
            fila = this.tblListado.getSelectedRow();
            nroVenta = Integer.parseInt(this.tblListado.getValueAt(fila, 0).toString());
        } catch (Exception e) {
            Funciones.mensajeError("Debe seleccionar la venta que desea anular", Funciones.NOMBRE_SOFTWARE);
            return;
        }
        
        int r = Funciones.mensajeConfirmacion("Desea anular la venta seleccionada", "Confirme");
        if (r==1){
            return;
        }
        
        try {
            Venta objVenta = new Venta();
            objVenta.setNroVenta(nroVenta);
            if (objVenta.anular()){
                Funciones.mensajeInformacion("La venta ha sido anulada correctamente", Funciones.NOMBRE_SOFTWARE);
                this.listar();
            }
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
        
    }//GEN-LAST:event_btnAnularActionPerformed

    
    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
    
    }//GEN-LAST:event_tblListadoMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rbHoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbHoyActionPerformed
        this.txtFecha1.setEnabled(false);
        this.txtFecha2.setEnabled(false);
        this.obtenerFechaActual();
    }//GEN-LAST:event_rbHoyActionPerformed

    private void rbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFechaActionPerformed
        this.txtFecha1.setEnabled(true);
        this.txtFecha2.setEnabled(true);
        this.obtenerFechaActual();
    }//GEN-LAST:event_rbFechaActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        this.txtFecha1.setEnabled(false);
        this.txtFecha2.setEnabled(false);
        this.obtenerFechaActual();
    }//GEN-LAST:event_rbTodosActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        this.listar();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnMantIGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantIGVActionPerformed
        // TODO add your handling code here:
        FrmIGV obj = new FrmIGV(null, true);
        obj.setTitle("Mantenimiento de IGV");
        obj.setVisible(true);
    }//GEN-LAST:event_btnMantIGVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnMantIGV;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbFecha;
    private javax.swing.JRadioButton rbHoy;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tblListado;
    private com.toedter.calendar.JDateChooser txtFecha1;
    private com.toedter.calendar.JDateChooser txtFecha2;
    // End of variables declaration//GEN-END:variables
}
