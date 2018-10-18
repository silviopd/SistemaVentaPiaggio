
package presentancion;

import java.sql.ResultSet;
import negocio.Cliente;
import negocio.Departamento;
import negocio.Distrito;
import negocio.Provincia;
//import sun.org.mozilla.javascript.internal.Token;
import util.Funciones;


public class FrmClienteListado extends javax.swing.JInternalFrame {

    ResultSet resultado;
    public FrmClienteListado(int x,int y,int ancho) {
        initComponents();
        
         this.setSize(ancho,this.getHeight());
        this.setLocation(x - (this.getWidth()/2), y - (this.getHeight()/2));
        
        this.cargarLista();
        this.listar();
        
    }
    
    private void cargarLista(){
        try {
            this.resultado = new Cliente().listar();
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void listar(){
        try {
            int[] ancho = {60,120,150,200,180,100,100};
            String[] alineamiento = {"C","I","I","I","C","C","C"};
            
            Funciones.llenarTabla(tblClientes, resultado, ancho, alineamiento);
            
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable(){
            public boolean isCellEditable(int fila, int columna){

                return false;
            }
        };
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado de Clientes");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

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
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente2.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(51, 153, 255));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lista de Clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCerrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        if (evt.getClickCount()==2){
            this.btnEditar.doClick();
        }
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrmCliente objFrm = new FrmCliente(null, true);
        objFrm.setTitle("Agregar nuevo Cliente");
        objFrm.setVisible(true);

        if (objFrm.accion == 1){ //EL usuario hizo clic en el boton grabar

            try {
                Cliente obj= new Cliente();
                obj.setApellidoPaterno(objFrm.txtApellidoPaterno.getText());
                obj.setApellidoMaterno(objFrm.txtApellidoMaterno.getText());
                obj.setNombres(objFrm.txtNombre.getText());
                obj.setDireccion(objFrm.txtDireccion.getText());
                obj.setTelefonoFijo(objFrm.txtTelelfonoFijo.getText());
                obj.setTelefonoMovil1(objFrm.txtTelefonoMovil1.getText());
                obj.setTelefonoMovil2(objFrm.txtTelefonoMovil2.getText());
                obj.setCodDep(Departamento.listaDepartamentos.get( objFrm.cboDep.getSelectedIndex() ).getCodDep());
                obj.setCodPro(Provincia.listaProvincias.get( objFrm.cboPro.getSelectedIndex() ).getCodPro());
                obj.setCodDis(Distrito.listaDistrito.get( objFrm.cboDis.getSelectedIndex() ).getCodDis());
                
                if (obj.agregar()==true){ //insertoooooooo
                    Funciones.mensajeInformacion("Se ha insertado un nuevo Cliente", Funciones.NOMBRE_SOFTWARE);
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
        fila = this.tblClientes.getSelectedRow();
        
        if (fila < 0){
            Funciones.mensajeError("Debe seleccionar un registro", Funciones.NOMBRE_SOFTWARE);
            return;
        }
        
        int codigo =  Integer.parseInt(this.tblClientes.getValueAt(fila, 0).toString());
        
        Cliente obj = new Cliente();
        try {
            ResultSet resultado = obj.leerDatos(codigo);
            if (resultado.next()){
                FrmCliente objFrm = new FrmCliente(null, true);
                objFrm.txtCodigo.setText(resultado.getString("codigo_cliente"));
                objFrm.txtApellidoPaterno.setText(resultado.getString("apellido_paterno"));
                objFrm.txtApellidoMaterno.setText(resultado.getString("apellido_materno"));
                objFrm.txtNombre.setText(resultado.getString("nombres"));
                objFrm.txtDireccion.setText(resultado.getString("direccion"));
                objFrm.txtTelelfonoFijo.setText(resultado.getString("telefono_fijo"));
                objFrm.txtTelefonoMovil1.setText(resultado.getString("telefono_movil1"));
                objFrm.txtTelefonoMovil2.setText(resultado.getString("telefono_movil2"));
                objFrm.cboDep.setSelectedItem(resultado.getString("departamento"));
                objFrm.cboPro.setSelectedItem(resultado.getString("provincia"));
                objFrm.cboDis.setSelectedItem(resultado.getString("distrito"));
                
                objFrm.setTitle("Editar los datos de un artículo");
                objFrm.setVisible(true);
                
                if (objFrm.accion == 1){
                    obj.setCodigoCliente(Integer.parseInt(objFrm.txtCodigo.getText()));
                    obj.setApellidoPaterno((objFrm.txtApellidoPaterno.getText()));
                    obj.setApellidoMaterno((objFrm.txtApellidoMaterno.getText()));
                    obj.setNombres((objFrm.txtNombre.getText()));
                    obj.setDireccion((objFrm.txtDireccion.getText()));
                    obj.setTelefonoFijo((objFrm.txtTelelfonoFijo.getText()));
                    obj.setTelefonoMovil1((objFrm.txtTelefonoMovil1.getText()));
                    obj.setTelefonoMovil2((objFrm.txtTelefonoMovil2.getText()));
                    obj.setCodDep(new Departamento().listaDepartamentos.get(objFrm.cboDep.getSelectedIndex()).getCodDep());
                    obj.setCodPro(new Provincia().listaProvincias.get(objFrm.cboPro.getSelectedIndex()).getCodPro());
                    obj.setCodDis(new Distrito().listaDistrito.get(objFrm.cboDis.getSelectedIndex()).getCodDis());
                    
                    if (obj.editar()){
                        Funciones.mensajeInformacion("Se ha editado al Cliente", Funciones.NOMBRE_SOFTWARE);
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
        fila = this.tblClientes.getSelectedRow();

        if (fila < 0){
            Funciones.mensajeError("Debe seleccionar un registro", Funciones.NOMBRE_SOFTWARE);
            return;
        }

        int resultado = Funciones.mensajeConfirmacion("Esta seguro de eliminar el registro seleccionado?", Funciones.NOMBRE_SOFTWARE);

        if (resultado==0){
            int codigo =  Integer.parseInt(this.tblClientes.getValueAt(fila, 0).toString());
            Cliente objCliente = new Cliente();
            objCliente.setCodigoCliente(codigo);
            try {
                if (objCliente.eliminar()){
                    Funciones.mensajeInformacion("Se ha eliminado al Cliente", Funciones.NOMBRE_SOFTWARE);
                    this.cargarLista();
                    this.listar();
                }
            } catch (Exception e) {
                Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
            }
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
