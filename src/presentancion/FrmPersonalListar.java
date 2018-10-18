package presentancion;

import java.awt.Dimension;
import java.sql.ResultSet;
import negocio.CodigoCiudad;
import negocio.TipoUsuario;
import negocio.Personal;
import negocio.Jefe;
import util.Funciones;

public class FrmPersonalListar extends javax.swing.JInternalFrame {

    private ResultSet resultado;
    
    public FrmPersonalListar(int x,int y,int ancho) {
        initComponents();
        
         this.setSize(ancho,this.getHeight());
        this.setLocation(x - (this.getWidth()/2), y - (this.getHeight()/2));
        
        this.cargarCamposBusqueda();
        this.cargarLista();
        this.listar();
    }
    
    private void cargarLista(){
        try {
            this.resultado = new Personal().listar();
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void listar(){
        try {
            int[] ancho = {100,240,240,220,140,140,250};
            String[] alineamiento = {"C","I","I","I","I","I","I"};
            
            Funciones.llenarTablaBusqueda(
                    tblListado, 
                    resultado,
                    ancho, 
                    alineamiento, 
                    this.cboBusqueda.getSelectedItem().toString(), 
                    this.txtValorBusqueda.getText()
            );
            
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void cargarCamposBusqueda(){
        String[] campos = new Personal().obtenerCamposBusqueda();
        
        this.cboBusqueda.removeAllItems();
        
        for (int i=0; i<campos.length; i++) {
            this.cboBusqueda.addItem( campos[i] );
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
        tbOpciones = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        cboBusqueda = new javax.swing.JComboBox();
        txtValorBusqueda = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnCerrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado de Personal");
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

        tbOpciones.setRollover(true);

        jLabel1.setText("Buscar:");
        tbOpciones.add(jLabel1);

        cboBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tbOpciones.add(cboBusqueda);

        txtValorBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorBusquedaKeyReleased(evt);
            }
        });
        tbOpciones.add(txtValorBusqueda);
        tbOpciones.add(jSeparator1);

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
        tbOpciones.add(btnAgregar);

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
        tbOpciones.add(btnEditar);

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
        tbOpciones.add(btnEliminar);

        btnActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setFocusable(false);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        tbOpciones.add(btnActualizar);
        tbOpciones.add(jSeparator2);

        btnCerrar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        tbOpciones.add(btnCerrar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        this.cboBusqueda.setPreferredSize(new Dimension(120, 25));
        this.txtValorBusqueda.setPreferredSize(new Dimension(250, 25));
        
        this.tbOpciones.add(cboBusqueda, 1);
        this.tbOpciones.add(txtValorBusqueda, 2);
    }//GEN-LAST:event_formInternalFrameActivated

    private void txtValorBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorBusquedaKeyReleased
        this.listar();
    }//GEN-LAST:event_txtValorBusquedaKeyReleased

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrmPersonal objFrm = new FrmPersonal(null, true);
        objFrm.setTitle("Agregar nuevo Personal");
        objFrm.setVisible(true);
        
        if (objFrm.accion == 1){
            
            String dni = objFrm.txtDni.getText();
            String appaterno = objFrm.txtApPaterno.getText();
            String apmaterno= objFrm.txtApMaterno.getText();            
            String nombre= objFrm.txtNombres.getText();            
            String direccion= objFrm.txtDireccion.getText();            
            String fijo= objFrm.txtFijo.getText();            
            String movil1= objFrm.txtMovil1.getText();           
            String movil2= objFrm.txtMovil2.getText();          
            String email= objFrm.txtEmail.getText();          
            String codCiudad= CodigoCiudad.listaCodigoCiudad.get(objFrm.cboCodigoCiudad.getSelectedIndex()).getCodDep();          
            
            try {
                Personal objPersonal = new Personal();
                objPersonal.setDni(dni);
                if(objFrm.cboJefe.getSelectedIndex()<=0){
                    objPersonal.setDniJefe(null);
                }else{
                    objPersonal.setDniJefe(Jefe.listaJefe.get(objFrm.cboJefe.getSelectedIndex()-1).getCodigo());
                }
                objPersonal.setApellidoPaterno(appaterno);
                objPersonal.setApellidoMaterno(apmaterno);
                objPersonal.setNombres(nombre);
                objPersonal.setDireccion(direccion);
                objPersonal.setTelefonoFijo(codCiudad+" - "+fijo);
                objPersonal.setTelefonoMovil1(movil1);
                objPersonal.setTelefonoMovil2(movil2);
                objPersonal.setEmail(email);
                                
                if (objPersonal.agregar()){ 
                    this.cargarLista();
                    this.listar();
                }
            } catch (Exception e) {
                Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
            }
            
            
        }
        
        
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
         if (evt.getClickCount()==2){
            this.btnEditar.doClick();
        }
    }//GEN-LAST:event_tblListadoMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = 0;
        fila = this.tblListado.getSelectedRow();
        FrmPersonal objFrmPersonal = new FrmPersonal(null, true);
        objFrmPersonal.txtDni.disable();
        objFrmPersonal.cboJefe.disable();
        objFrmPersonal.cboJefe.enable(false);
        objFrmPersonal.lblJefe.enable(false);
        
        if (fila < 0){
            Funciones.mensajeError("Debe seleccionar un registro", Funciones.NOMBRE_SOFTWARE);
            return;
        }
        
        String codigo =  this.tblListado.getValueAt(fila, 0).toString();
        
        Personal obj= new Personal();
        try {
            ResultSet resultado = obj.leerDatos(codigo);
            if (resultado.next()){
                
                objFrmPersonal.txtDni.setText(resultado.getString("dni"));
                objFrmPersonal.txtApPaterno.setText(resultado.getString("apellido_paterno"));
                objFrmPersonal.txtApMaterno.setText(resultado.getString("apellido_materno"));
                objFrmPersonal.txtNombres.setText( resultado.getString("nombres") );
                objFrmPersonal.txtDireccion.setText(resultado.getString("direccion"));
                objFrmPersonal.txtFijo.setText(resultado.getString("telefono_fijo").substring(5));
                objFrmPersonal.txtMovil1.setText(resultado.getString("telefono_movil1"));
                objFrmPersonal.txtMovil2.setText(resultado.getString("telefono_movil2"));
                objFrmPersonal.txtEmail.setText(resultado.getString("email"));
                objFrmPersonal.cboCodigoCiudad.setSelectedItem(resultado.getString("descripcion"));
                objFrmPersonal.setTitle("Editar los datos de un Personal");
                objFrmPersonal.setVisible(true);
                
                
                if (objFrmPersonal.accion == 1){
                    String dni = objFrmPersonal.txtDni.getText();
                    String apPaterno = objFrmPersonal.txtApPaterno.getText();
                    String apMaterno = objFrmPersonal.txtApMaterno.getText();
                    String nombres = objFrmPersonal.txtNombres.getText();
                    String direccion = objFrmPersonal.txtDireccion.getText();
                    String fijo = objFrmPersonal.txtFijo.getText();
                    String movil1 = objFrmPersonal.txtMovil1.getText();
                    String movil2 = objFrmPersonal.txtMovil2.getText();
                    String email = objFrmPersonal.txtEmail.getText();
                    String codCiudad= CodigoCiudad.listaCodigoCiudad.get(objFrmPersonal.cboCodigoCiudad.getSelectedIndex()).getCodDep();
                    
                    obj.setDni(dni);
                    obj.setApellidoPaterno(apPaterno);
                    obj.setApellidoMaterno(apMaterno);
                    obj.setNombres(nombres);
                    obj.setDireccion(direccion);
                    if (!codCiudad.equalsIgnoreCase("1")) {
                         obj.setTelefonoFijo(codCiudad+" - "+fijo);
                    } else {
                        obj.setTelefonoFijo("0"+codCiudad+" - "+fijo);
                    }
                   
                    obj.setTelefonoMovil1(movil1);
                    obj.setTelefonoMovil2(movil2);
                    obj.setEmail(email);
                    
                    if (obj.editar()){
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
            Personal obj = new Personal();
            obj.setDni(codigo);
            try {
                if (obj.eliminar()){
                    this.cargarLista();
                    this.listar();
                }
            } catch (Exception e) {
                Funciones.mensajeError("Imposible eliminar registro esta siendo referedia por otra tabla", Funciones.NOMBRE_SOFTWARE);
            }
        } 
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
         this.cargarLista();
        this.listar();
    }//GEN-LAST:event_btnActualizarActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox cboBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar tbOpciones;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtValorBusqueda;
    // End of variables declaration//GEN-END:variables
}
