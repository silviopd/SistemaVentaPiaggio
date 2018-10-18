package presentancion;

import java.awt.Dimension;
import java.sql.ResultSet;
import negocio.Producto;
import negocio.Categoria;
import negocio.Marca;
import negocio.UnidadMedida;
import util.Funciones;

public class FrmProductoListado extends javax.swing.JInternalFrame {

    private ResultSet resultado;
    
    public FrmProductoListado(int x,int y,int ancho) {
        initComponents();
        
         this.setSize(ancho,this.getHeight());
        this.setLocation(x - (this.getWidth()/2), y - (this.getHeight()/2));
        
        this.cargarLista();
        this.listar();
    }
    
    private void cargarLista(){
        try {
            this.resultado = new Producto().listar();
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void listar(){
        try {
            int[] ancho = {180,280,100,200,200};
            String[] alineamiento = {"C","I","D","C","D"};
            
            Funciones.llenarTabla(tblListado, resultado, ancho, alineamiento);
            
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable(){
            public boolean isCellEditable(int fila, int columna){

                return false;
            }
        };
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtValorBusqueda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado de Productos");
        setToolTipText("");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListado);

        btnAgregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add2.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setFocusable(false);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
        btnCerrar.setText("Salir");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/articulos1.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listado de Productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtValorBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorBusquedaKeyReleased(evt);
            }
        });

        jLabel3.setText("Ingrese el valor que desea buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtValorBusqueda)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValorBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrmProducto objFrm = new FrmProducto(null, true);
        objFrm.setTitle("Agregar nuevo Producto");
        objFrm.setVisible(true);
        
        if (objFrm.accion == 1){ //EL usuario hizo clic en el boton grabar
            String codigo = objFrm.txtCodigo.getText();
            String nombre = objFrm.txtNombre.getText();
            int unidad = UnidadMedida.ListaUnidad.get( objFrm.cboUnidad.getSelectedIndex() ).getCodigo();
            Double precioVenta = Double.parseDouble( objFrm.txtPrecioVenta.getText() );
            int codigoCategoria= Categoria.ListaCategoria.get( objFrm.cboCategoria.getSelectedIndex() ).getCodigo();
            int codigoMarca= Marca.ListaMarca.get( objFrm.cboMarca.getSelectedIndex() ).getCodigo();
            
            try {
                Producto objProducto = new Producto();
                objProducto.setCodigo(codigo);
                objProducto.setDescripcion(nombre);
                objProducto.setPrecio(precioVenta);
                objProducto.setUnidadMedida(unidad);
                objProducto.setCodigoMarca(codigoMarca);
                objProducto.setCodigoCategoria(codigoCategoria);
                
                if (objProducto.agregar()==true){ //insertoooooooo
                    Funciones.mensajeInformacion("Se ha insertado un nuevo Producto", Funciones.NOMBRE_SOFTWARE);
                    this.cargarLista();
                    this.listar();
                }
            } catch (Exception e) {
                Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = 0;
        fila = this.tblListado.getSelectedRow();
        
        if (fila < 0){
            Funciones.mensajeError("Debe seleccionar un registro", Funciones.NOMBRE_SOFTWARE);
            return;
        }
        
        String codigo =  this.tblListado.getValueAt(fila, 0).toString();
        
        Producto objProducto = new Producto();
        try {
            ResultSet resultado = objProducto.leerDatos(codigo);
            if (resultado.next()){
                FrmProducto objFrmProducto = new FrmProducto(null, true);
                objFrmProducto.txtCodigo.setText(resultado.getString("codigo") );
                objFrmProducto.txtNombre.setText(resultado.getString("descripcion") );
                objFrmProducto.txtPrecioVenta.setText( String.valueOf(resultado.getDouble("precio")) );
                objFrmProducto.cboUnidad.setSelectedItem(resultado.getString("unidad_medida") );
                objFrmProducto.cboMarca.setSelectedItem(resultado.getString("marca"));
                objFrmProducto.cboCategoria.setSelectedItem(resultado.getString("categoria"));
                
                objFrmProducto.setTitle("Editar los datos de un Producto");
                objFrmProducto.setVisible(true);
                
                if (objFrmProducto.accion == 1){
                    
                    objProducto.setCodigo(objFrmProducto.txtCodigo.getText());
                    objProducto.setDescripcion(objFrmProducto.txtNombre.getText());
                    objProducto.setPrecio(Double.parseDouble( objFrmProducto.txtPrecioVenta.getText()));
                    objProducto.setUnidadMedida(UnidadMedida.ListaUnidad.get( objFrmProducto.cboUnidad.getSelectedIndex() ).getCodigo());
                    objProducto.setCodigoMarca(Marca.ListaMarca.get( objFrmProducto.cboMarca.getSelectedIndex() ).getCodigo());
                    objProducto.setCodigoCategoria(Categoria.ListaCategoria.get( objFrmProducto.cboCategoria.getSelectedIndex() ).getCodigo());
                    
                    if (objProducto.editar()){
                        Funciones.mensajeInformacion("Se ha editado el Producto", Funciones.NOMBRE_SOFTWARE);
                        this.cargarLista();
                        this.listar();
                    }
                    
                }
                
            }else{
                Funciones.mensajeAdvertencia("No se ha encontrado el registro", Funciones.NOMBRE_SOFTWARE);
            }
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = 0;
        fila = this.tblListado.getSelectedRow();
        
        if (fila < 0){
            Funciones.mensajeError("Debe seleccionar un registro", Funciones.NOMBRE_SOFTWARE);
            return;
        }
        
        int resultado = Funciones.mensajeConfirmacion("Esta seguro de eliminar el registro seleccionado", Funciones.NOMBRE_SOFTWARE);
        
        if (resultado==0){
            String codigo =  this.tblListado.getValueAt(fila, 0).toString();
            Producto objProducto = new Producto();
            objProducto.setCodigo(codigo);
            try {
                if (objProducto.eliminar()){
                    Funciones.mensajeInformacion("Se ha eliminado el producto", Funciones.NOMBRE_SOFTWARE);
                    this.cargarLista();
                    this.listar();
                }
            } catch (Exception e) {
                Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
            }
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    
    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        if (evt.getClickCount()==2){
            this.btnEditar.doClick();
        }
    }//GEN-LAST:event_tblListadoMouseClicked

    private void txtValorBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorBusquedaKeyReleased
        filtrar();
    }//GEN-LAST:event_txtValorBusquedaKeyReleased

     private void filtrar() {
        try {
             int[] ancho = {180,280,100,200,200};
            String[] alineamiento = {"C","I","D","C","D"};
                        
                Funciones.llenarTablaBusqueda(tblListado, resultado, ancho, alineamiento, "Producto", txtValorBusqueda.getText());

            
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtValorBusqueda;
    // End of variables declaration//GEN-END:variables
}
