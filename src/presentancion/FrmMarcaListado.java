
package presentancion;

import java.sql.ResultSet;
import negocio.Categoria;
import negocio.Marca;

import util.Funciones;

public class FrmMarcaListado extends javax.swing.JInternalFrame {

    ResultSet resultado;
    
    public FrmMarcaListado(int x,int y,int ancho) {
        initComponents();
        
         this.setSize(ancho,this.getHeight());
        this.setLocation(x - (this.getWidth()/2), y - (this.getHeight()/2));
        
        this.cargarLista();
        this.listar();
    }
    
    private void cargarLista(){
        try {
            this.resultado = new Marca().listar();
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void listar(){
        try {
            int[] ancho = {70,120};
            String[] alineamiento = {"C","I"};
            
            Funciones.llenarTabla(tblMarcas, resultado, ancho, alineamiento);
            
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMarcas = new javax.swing.JTable(){
            public boolean isCellEditable(int fila, int columna){

                return false;
            }
        };
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado de Marcas");

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/marca.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(51, 153, 255));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lista de Marcas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(24, 24, 24))
        );

        tblMarcas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMarcas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMarcasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMarcas);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add2.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addGap(14, 14, 14)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        FrmMarca objFrmMarca = new FrmMarca(null, true);
        objFrmMarca.setTitle("Agregar nueva Marca");
        objFrmMarca.setVisible(true);
        
        if (objFrmMarca.accion == 1){ //EL usuario hizo clic en el boton grabar
            String marca = objFrmMarca.txtMarca.getText();
            
            try {
                Marca objMarca = new Marca();
                objMarca.setDescripcion(marca);
                
                if (objMarca.agregar()==true){ //insertoooooooo
                    Funciones.mensajeInformacion("Se ha insertado una nueva Marca", Funciones.NOMBRE_SOFTWARE);
                    this.cargarLista();
                    this.listar();
                }
            } catch (Exception e) {
                Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int fila = 0;
        fila = this.tblMarcas.getSelectedRow();
        
        if (fila < 0){
            Funciones.mensajeError("Debe seleccionar un registro", Funciones.NOMBRE_SOFTWARE);
            return;
        }
        
        int codigo =  Integer.parseInt(this.tblMarcas.getValueAt(fila, 0).toString());
        
        Marca objMarca = new Marca();
        try {
            ResultSet resultado = objMarca.leerDatos(codigo);
            if (resultado.next()){
                FrmMarca objFrmMarca = new FrmMarca(null, true);
                objFrmMarca.txtCodigo.setText(resultado.getString("codigo_marca"));  
                objFrmMarca.txtMarca.setText(resultado.getString("descripcion")); 
                
                objFrmMarca.setTitle("Editar Marca");
                objFrmMarca.setVisible(true);
                
                if (objFrmMarca.accion == 1){
                    
                    objMarca.setCodigo(Integer.parseInt(objFrmMarca.txtCodigo.getText()));
                    objMarca.setDescripcion(objFrmMarca.txtMarca.getText());
                    
                    if (objMarca.editar()){
                        Funciones.mensajeInformacion("Se ha editado la Marca", Funciones.NOMBRE_SOFTWARE);
                        this.cargarLista();
                        this.listar();
                    }
                }
                
            }else{
                Funciones.mensajeAdvertencia("No se tiene registrado una marca con ese codigo", Funciones.NOMBRE_SOFTWARE);
            }
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int fila = 0;
        fila = this.tblMarcas.getSelectedRow();
        
        if (fila < 0){
            Funciones.mensajeError("Debe seleccionar un registro", Funciones.NOMBRE_SOFTWARE);
            return;
        }
        
        int resultado = Funciones.mensajeConfirmacion("Esta seguro de eliminar el registro seleccionado", Funciones.NOMBRE_SOFTWARE);
        
        if (resultado==0){
            int codigo =  Integer.parseInt(this.tblMarcas.getValueAt(fila, 0).toString());
            Marca objMarca = new Marca();
            objMarca.setCodigo(codigo);
            try {
                if (objMarca.eliminar()){
                    Funciones.mensajeInformacion("Se ha eliminado la Marca ", Funciones.NOMBRE_SOFTWARE);
                    this.cargarLista();
                    this.listar();
                }
            } catch (Exception e) {
                Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblMarcasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMarcasMouseClicked
        if (evt.getClickCount()==2){
            this.btnEditar.doClick();
        }
    }//GEN-LAST:event_tblMarcasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMarcas;
    // End of variables declaration//GEN-END:variables
}
