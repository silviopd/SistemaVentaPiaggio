package presentancion;

import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import negocio.Personal;
import negocio.Jefe;
import negocio.StringMD;
import negocio.TipoUsuario;
import negocio.Usuario;
import util.Funciones;

public class FrmUsuariolListar extends javax.swing.JInternalFrame {

    private ResultSet resultado;
    
    public FrmUsuariolListar(int x,int y,int ancho) {
        initComponents();
        
         this.setSize(ancho,this.getHeight());
        this.setLocation(x - (this.getWidth()/2), y - (this.getHeight()/2));
        
        this.cargarCamposBusqueda();
        this.cargarLista();
        this.listar();
    }
    
    private void cargarLista(){
        try {
            this.resultado = new Usuario().listar();
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void listar(){
        try {
            int[] ancho = {130,250,250,120,120,150};
            String[] alineamiento = {"C","I","I","I","I","I"};
            
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
        String[] campos = new Usuario().obtenerCamposBusqueda();
        
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
        setTitle("Listado de Usuarios");
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
        FrmUsuario objFrm = new FrmUsuario(null, true);
        objFrm.setTitle("Agregar nuevo Usuario");
        objFrm.setVisible(true);
        
        if (objFrm.accion == 1){
            
            String dni = Jefe.listaJefe.get(objFrm.cboPersonal.getSelectedIndex()).getCodigo();
            String login = objFrm.txtLogin.getText();
            String clave = objFrm.txtClave.getText();
            int tipoUsuario= TipoUsuario.listaTipoUsuario.get(objFrm.cboTipoUsuario.getSelectedIndex()).getCodigo();
                     
            
            try {
                Usuario objUsuario = new Usuario();
                objUsuario.setDniUsuario(dni);
                objUsuario.setLogin(login);
                objUsuario.setClave(clave);
                if (objFrm.rbActivo.isSelected()) {
                    objUsuario.setEstado("A");
                } else {
                    objUsuario.setEstado("I");
                }
                objUsuario.setCodTipoUsuario(tipoUsuario);
                
                                
                if (objUsuario.agregar()){ 
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
        
        if (fila < 0){
            Funciones.mensajeError("Debe seleccionar un registro", Funciones.NOMBRE_SOFTWARE);
            return;
        }
        
        String codigo =  this.tblListado.getValueAt(fila, 0).toString();
        
        Usuario obj=new Usuario();
        try {
            ResultSet resultado = obj.leerDatos(codigo);
            if (resultado.next()){
                FrmMantenimientoUsuario objU = new FrmMantenimientoUsuario(null, true);
                objU.txtLogin.setText(resultado.getString("login"));
                if (resultado.getString("estado").equalsIgnoreCase("A")) {
                    objU.rbActivo.setSelected(true);
                }else {
                    objU.rbInactivo.setSelected(true);
                }
                objU.cboTipoUsuario.setSelectedItem(resultado.getString("nombretipo"));
                objU.cboPersonal.setSelectedItem(resultado.getString("nombre"));
                
                objU.setTitle("Manteniemiento de un Usuario");
                objU.setVisible(true);
                
                
                if (objU.accion == 1){
                    

                    String login = objU.txtLogin.getText();
                    String claveN = objU.txtClaveN.getText();
                    String clave = objU.txtClave.getText();
                    int codTipo = TipoUsuario.listaTipoUsuario.get(objU.cboTipoUsuario.getSelectedIndex()).getCodigo();
                    String codU = Jefe.listaJefe.get(objU.cboPersonal.getSelectedIndex()).getCodigo();
                    String claveEncriptada=StringMD.getStringMessageDigest(clave, StringMD.MD5);
                    /*System.out.println(clave);
                    System.out.println(claveEncriptada);
                    System.out.println("Nuevo: "+claveN);*/
                    if(resultado.getString("clave").equalsIgnoreCase(claveEncriptada)){
                    
                    obj.setClaveN(claveN);
                    obj.setClave(clave);
                    if (objU.rbActivo.isSelected()) {
                        obj.setEstado("A");
                    }else{
                        obj.setEstado("I");
                    }
                    obj.setCodTipoUsuario(codTipo);
                    obj.setDniUsuario(codU);
                    
                    
                    if (obj.claveUpdate()){
                        this.cargarLista();
                        this.listar();
                        Funciones.mensajeInformacion("Los datos se han guardado correctamente", Funciones.NOMBRE_SOFTWARE);
                    }
                    
                }else{
                    Funciones.mensajeError("La clave actual no es correcta", Funciones.NOMBRE_SOFTWARE);
                    return;
                }
                
              }else{
                Funciones.mensajeAdvertencia("No se ha encontrado el registro", Funciones.NOMBRE_SOFTWARE);
            }
                
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
            Usuario objUsuario = new Usuario();
            objUsuario.setDniUsuario(codigo);
            try {
                if (objUsuario.eliminar()){
                    this.cargarLista();
                    this.listar();
                }
            } catch (Exception e) {
                Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
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
