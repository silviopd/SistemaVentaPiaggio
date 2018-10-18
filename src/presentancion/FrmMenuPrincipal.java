package presentancion;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import negocio.Jefe;
import negocio.StringMD;
import negocio.TipoUsuario;
import negocio.Usuario;
import util.Funciones;
import util.ImagenFondo;
import util.Reportes;

public class FrmMenuPrincipal extends javax.swing.JFrame {

   
    public FrmMenuPrincipal() {
        initComponents();
        this.lblFecha.setText("Fecha: "+Funciones.obtenerFechaActual());
        this.lblUsuario.setText("Usuario: " + Funciones.USUARIO_LOGUEADO);
        this.contenedor.setBorder(new ImagenFondo("ext"));
        this.acceso();
        this.setTitle( Funciones.NOMBRE_SOFTWARE + " [ Menú Principal ]" );
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }

      public void acceso(){
        if(Funciones.TIPO_USUARIO_LOGUEADO.equalsIgnoreCase("Administrador")){//Ventas
            this.mnuMantenimientos.setEnabled(true);
            this.mnuMantenimientoPersonal.setEnabled(true);
            //falta transacciones y reportes
            
        }else{
        
           // this.mnuProveedor.setEnabled(false);
            this.mnuCategoria.setEnabled(false);
            this.mnuClientes.setEnabled(true);
            this.mnuMarca.setEnabled(false);            
            this.MenuRapClientes.setEnabled(true);            
            this.mnuProducto.setEnabled(false);
            this.mnuMantenimientoPersonal.setEnabled(false);
          //  this.MenuAdmSistem.setEnabled(false);
            this.mnuUsuarios.setEnabled(false);
            this.mnuItemCambiarContrasena.setEnabled(true);
            this.MenuRapPersonal.setEnabled(false);
            this.MenuRapUsuarios.setEnabled(false);
            
        }
      
      }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        MenuRapClientes = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        MenuRapPersonal = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        MenuRapUsuarios = new javax.swing.JButton();
        MenuRapSalir = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        lblUsuario = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        lblFecha = new javax.swing.JLabel();
        contenedor = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuMantenimientos = new javax.swing.JMenu();
        mnuClientes = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuMantenimientoPersonal = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuMarca = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuCategoria = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnuProducto = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        mnuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuVentas = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        MenuAdmSistem = new javax.swing.JMenu();
        mnuUsuarios = new javax.swing.JMenuItem();
        mnuItemCambiarContrasena = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem26 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);
        jToolBar1.setEnabled(false);

        MenuRapClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N
        MenuRapClientes.setToolTipText("Clientes");
        MenuRapClientes.setFocusable(false);
        MenuRapClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MenuRapClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MenuRapClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRapClientesActionPerformed(evt);
            }
        });
        jToolBar1.add(MenuRapClientes);
        jToolBar1.add(jSeparator10);

        MenuRapPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedor.png"))); // NOI18N
        MenuRapPersonal.setToolTipText("Personal");
        MenuRapPersonal.setFocusable(false);
        MenuRapPersonal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MenuRapPersonal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MenuRapPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRapPersonalActionPerformed(evt);
            }
        });
        jToolBar1.add(MenuRapPersonal);
        jToolBar1.add(jSeparator11);

        MenuRapUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario2.png"))); // NOI18N
        MenuRapUsuarios.setToolTipText("Usuarios");
        MenuRapUsuarios.setFocusable(false);
        MenuRapUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MenuRapUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MenuRapUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRapUsuariosActionPerformed(evt);
            }
        });
        jToolBar1.add(MenuRapUsuarios);

        MenuRapSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
        MenuRapSalir.setToolTipText("Salir del Sistema");
        MenuRapSalir.setFocusable(false);
        MenuRapSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MenuRapSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MenuRapSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRapSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(MenuRapSalir);

        jToolBar2.setRollover(true);
        jToolBar2.setEnabled(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bienvenido.png"))); // NOI18N
        jLabel1.setText("Bienvenido");
        jToolBar2.add(jLabel1);
        jToolBar2.add(jSeparator13);

        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario2.png"))); // NOI18N
        lblUsuario.setText("Usuario:");
        jToolBar2.add(lblUsuario);
        jToolBar2.add(jSeparator14);

        lblFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendario.png"))); // NOI18N
        lblFecha.setText("jLabel3");
        jToolBar2.add(lblFecha);

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        mnuMantenimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/archivo2.png"))); // NOI18N
        mnuMantenimientos.setText("Mantenimientos");

        mnuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N
        mnuClientes.setText("Clientes");
        mnuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClientesActionPerformed(evt);
            }
        });
        mnuMantenimientos.add(mnuClientes);
        mnuMantenimientos.add(jSeparator2);

        mnuMantenimientoPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedor.png"))); // NOI18N
        mnuMantenimientoPersonal.setText("Personal");
        mnuMantenimientoPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenimientoPersonalActionPerformed(evt);
            }
        });
        mnuMantenimientos.add(mnuMantenimientoPersonal);
        mnuMantenimientos.add(jSeparator5);

        mnuMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lineas.png"))); // NOI18N
        mnuMarca.setText("Marca");
        mnuMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMarcaActionPerformed(evt);
            }
        });
        mnuMantenimientos.add(mnuMarca);
        mnuMantenimientos.add(jSeparator4);

        mnuCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categorias.png"))); // NOI18N
        mnuCategoria.setText("Categoria");
        mnuCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCategoriaActionPerformed(evt);
            }
        });
        mnuMantenimientos.add(mnuCategoria);
        mnuMantenimientos.add(jSeparator6);

        mnuProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        mnuProducto.setText("Producto");
        mnuProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProductoActionPerformed(evt);
            }
        });
        mnuMantenimientos.add(mnuProducto);
        mnuMantenimientos.add(jSeparator8);

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
        mnuSalir.setText("Cerrar");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuMantenimientos.add(mnuSalir);

        jMenuBar1.add(mnuMantenimientos);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/transaccion.png"))); // NOI18N
        jMenu2.setText("Transacciones");

        mnuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas2.png"))); // NOI18N
        mnuVentas.setText("Ventas");
        mnuVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVentasActionPerformed(evt);
            }
        });
        jMenu2.add(mnuVentas);

        jMenuBar1.add(jMenu2);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte.png"))); // NOI18N
        jMenu1.setText("Reportes");

        jMenuItem1.setText("Ventas general");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Ventas por fechas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Stock mínimo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        MenuAdmSistem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/config.png"))); // NOI18N
        MenuAdmSistem.setText("Administración del Sistema");

        mnuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario2.png"))); // NOI18N
        mnuUsuarios.setText("Usuarios");
        mnuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuariosActionPerformed(evt);
            }
        });
        MenuAdmSistem.add(mnuUsuarios);

        mnuItemCambiarContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cambiarcontra.png"))); // NOI18N
        mnuItemCambiarContrasena.setText("Cambiar Contraseña");
        mnuItemCambiarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemCambiarContrasenaActionPerformed(evt);
            }
        });
        MenuAdmSistem.add(mnuItemCambiarContrasena);

        jMenuBar1.add(MenuAdmSistem);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ayuda.png"))); // NOI18N
        jMenu5.setText("Ayuda");

        jMenuItem26.setText("Acerca de");
        jMenu5.add(jMenuItem26);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
            .addComponent(contenedor)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuMantenimientoPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenimientoPersonalActionPerformed
        // TODO add your handling code here:
        FrmPersonalListar obj = new FrmPersonalListar(this.contenedor.getWidth()/2,this.contenedor.getHeight()/2,this.contenedor.getWidth());
        this.contenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_mnuMantenimientoPersonalActionPerformed

    private void mnuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuariosActionPerformed
        // TODO add your handling code here:
           
        FrmUsuariolListar obj = new FrmUsuariolListar(this.contenedor.getWidth()/2,this.contenedor.getHeight()/2,this.contenedor.getWidth());
        this.contenedor.add(obj);
        obj.setVisible(true);
       
    }//GEN-LAST:event_mnuUsuariosActionPerformed

    private void mnuMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMarcaActionPerformed
        // TODO add your handling code here:
        FrmMarcaListado objFrmMarcaListado= new FrmMarcaListado(this.contenedor.getWidth()/2,this.contenedor.getHeight()/2,this.contenedor.getWidth());
        this.contenedor.add(objFrmMarcaListado);
        objFrmMarcaListado.setVisible(true);
    }//GEN-LAST:event_mnuMarcaActionPerformed

    private void mnuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCategoriaActionPerformed
        // TODO add your handling code here:
        FrmCategoriaListado objFrmCategoriaListado= new FrmCategoriaListado(this.contenedor.getWidth()/2,this.contenedor.getHeight()/2,this.contenedor.getWidth());
        this.contenedor.add(objFrmCategoriaListado);
        objFrmCategoriaListado.setVisible(true);
    }//GEN-LAST:event_mnuCategoriaActionPerformed

    private void mnuProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProductoActionPerformed
        // TODO add your handling code here:
        FrmProductoListado objFrmProductoListado= new FrmProductoListado(this.contenedor.getWidth()/2,this.contenedor.getHeight()/2,this.contenedor.getWidth());
        this.contenedor.add(objFrmProductoListado);
        objFrmProductoListado.setVisible(true);
    }//GEN-LAST:event_mnuProductoActionPerformed

    private void mnuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClientesActionPerformed
        // TODO add your handling code here:
        FrmClienteListado objFrmClienteListado= new FrmClienteListado(this.contenedor.getWidth()/2,this.contenedor.getHeight()/2,this.contenedor.getWidth());
        this.contenedor.add(objFrmClienteListado);
        objFrmClienteListado.setVisible(true);
    }//GEN-LAST:event_mnuClientesActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        this.dispose();
         new FrmInicioSesion().setVisible(true);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void MenuRapClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRapClientesActionPerformed
        FrmClienteListado objFrmClienteListado= new FrmClienteListado(this.contenedor.getWidth()/2,this.contenedor.getHeight()/2,this.contenedor.getWidth());
        this.contenedor.add(objFrmClienteListado);
        objFrmClienteListado.setVisible(true);
    }//GEN-LAST:event_MenuRapClientesActionPerformed

    private void MenuRapSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRapSalirActionPerformed
        this.dispose();
         new FrmInicioSesion().setVisible(true);
    }//GEN-LAST:event_MenuRapSalirActionPerformed

    private void MenuRapUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRapUsuariosActionPerformed
        FrmUsuariolListar obj = new FrmUsuariolListar(this.contenedor.getWidth()/2,this.contenedor.getHeight()/2,this.contenedor.getWidth());
        this.contenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_MenuRapUsuariosActionPerformed

    private void MenuRapPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRapPersonalActionPerformed
         FrmPersonalListar obj = new FrmPersonalListar(this.contenedor.getWidth()/2,this.contenedor.getHeight()/2,this.contenedor.getWidth());
        this.contenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_MenuRapPersonalActionPerformed

    private void mnuItemCambiarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemCambiarContrasenaActionPerformed
         String codigo=Funciones.DNI_LOGUEADO;
        
        Usuario obj=new Usuario();
        try {
            ResultSet resultado = obj.leerDatos(codigo);
            if (resultado.next()){
                FrmMantenimientoUsuarioEditar objU = new FrmMantenimientoUsuarioEditar(null, true);
                objU.txtLogin.setText(resultado.getString("login"));
                if (resultado.getString("estado").equalsIgnoreCase("A")) {
                    objU.rbActivo.setSelected(true);
                }else {
                    objU.rbInactivo.setSelected(true);
                }
                objU.cboTipoUsuario.setSelectedItem(resultado.getString("nombretipo"));
                objU.cboPersonal.setSelectedItem(resultado.getString("nombre"));
                
                objU.setTitle("Cambio de Contraseña");
                objU.setVisible(true);
                
                
                if (objU.accion == 1){
                    

                    String login = objU.txtLogin.getText();
                    String claveN = objU.txtClaveN.getText();
                    String clave = objU.txtClave.getText();
                    int codTipo = TipoUsuario.listaTipoUsuario.get(objU.cboTipoUsuario.getSelectedIndex()).getCodigo();
                    String codU = Jefe.listaJefe.get(objU.cboPersonal.getSelectedIndex()).getCodigo();
                    String claveEncriptada=StringMD.getStringMessageDigest(clave, StringMD.MD5);
                    /* System.out.println(clave);
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
                        Funciones.mensajeInformacion("Los datos se han guardado correctamente", Funciones.NOMBRE_SOFTWARE);
                    }
                    
                }else{
                    Funciones.mensajeError("La clave actual no es correcta", Funciones.NOMBRE_SOFTWARE);
                    return;
                }
                
              }else{
                Funciones.mensajeAdvertencia("No se ha realizado ningun cambio", Funciones.NOMBRE_SOFTWARE);
            }
                
            }
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }//GEN-LAST:event_mnuItemCambiarContrasenaActionPerformed

    private void mnuVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVentasActionPerformed
        // TODO add your handling code here:
        FrmVentaListado obj = new FrmVentaListado(this.contenedor.getWidth()/2,this.contenedor.getHeight()/2,this.contenedor.getWidth());
        this.contenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_mnuVentasActionPerformed
        String nombreArchivoReporte="";
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
        nombreArchivoReporte="Reporte_de_Ventas.jasper";
            new Reportes().reporteInterno(nombreArchivoReporte,null).setVisible(true);
            
            
        } catch (Exception ex) {
            Logger.getLogger(FrmMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FrmReporteFechas obj = new FrmReporteFechas();
        this.contenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
        nombreArchivoReporte="reporteStock.jasper";
            new Reportes().reporteInterno(nombreArchivoReporte,null).setVisible(true);
            
            
        } catch (Exception ex) {
            Logger.getLogger(FrmMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAdmSistem;
    private javax.swing.JButton MenuRapClientes;
    private javax.swing.JButton MenuRapPersonal;
    private javax.swing.JButton MenuRapSalir;
    private javax.swing.JButton MenuRapUsuarios;
    public static javax.swing.JDesktopPane contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuItem mnuCategoria;
    private javax.swing.JMenuItem mnuClientes;
    private javax.swing.JMenuItem mnuItemCambiarContrasena;
    private javax.swing.JMenuItem mnuMantenimientoPersonal;
    private javax.swing.JMenu mnuMantenimientos;
    private javax.swing.JMenuItem mnuMarca;
    private javax.swing.JMenuItem mnuProducto;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenuItem mnuUsuarios;
    private javax.swing.JMenuItem mnuVentas;
    // End of variables declaration//GEN-END:variables
}
