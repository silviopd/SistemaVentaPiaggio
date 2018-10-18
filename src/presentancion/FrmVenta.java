
package presentancion;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import negocio.Cliente;
import negocio.CompraDetalle;
import negocio.Configuracion;
import negocio.TipoDocumento;
import util.Funciones;


public class FrmVenta extends javax.swing.JDialog {

    public int accion=0;
    
    public FrmVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.llenarComboTD();
        this.asignarFechaCompra();
        this.obtenerPorcentajeIGV();
        this.configurarDetalleCompra();
        
        tblVentaDetalle.setCellSelectionEnabled(true);
        tblVentaDetalle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblVentaDetalle.setRowHeight(25);
        
        this.calcularTotal();
        
        
        
    }
    
    public void calcularTotal(){
        double porcentajeIGV = 0;
        
        if (this.txtPorcentajeIGV.getText().isEmpty()){
            porcentajeIGV = 0;
        }else{
            porcentajeIGV = Double.parseDouble( this.txtPorcentajeIGV.getText() );
        }
        
        double importe=0;
        double total=0;
        
        for(int i=0; i<this.tblVentaDetalle.getRowCount(); i++){
            importe = Double.parseDouble(this.tblVentaDetalle.getValueAt(i, 5).toString().replace(",", "") );
            total = total + importe;
        }
        
        double subTotal = total / ( 1 + (porcentajeIGV / 100) );
        double igv = total - subTotal;
        
        this.lblSubTotal.setText(Funciones.formatearNumero(subTotal));
        this.lblIGV.setText(Funciones.formatearNumero(igv));
        this.lblTotal.setText( Funciones.formatearNumero(total) );
        
    }
    
    private void configurarDetalleCompra(){
        try {
            String alineacion[] = {"C","I","D","D","D","D"};
            int anchoColumna[] = {70, 200, 70, 70, 90, 80};
            Funciones.llenarTabla(
                    tblVentaDetalle, 
                    new CompraDetalle().configurarDetalleCompra(), 
                    anchoColumna, 
                    alineacion
            );
            
        } catch (Exception e) {
        }
    }
    
    private void obtenerPorcentajeIGV(){
        try {
            this.txtPorcentajeIGV.setText(new Configuracion().obtenerValorParametro(1));
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void asignarFechaCompra(){
        java.util.Date objFecha = new java.util.Date();
        this.txtFecha.setDate(objFecha);
    }
    
    private void buscarCliente(){
        int codigoCliente = Integer.parseInt(this.txtCodigo.getText());
        
            try {
                Cliente objCliente = new Cliente();
                objCliente.setCodigoCliente(codigoCliente);
                ResultSet resultado = objCliente.buscar();
                if (resultado.next()){
                    this.lblNombres.setText(resultado.getString("cliente"));
                    this.lblTelFijo.setText(resultado.getString("telefono_fijo"));
                    this.lblTelMovil.setText(resultado.getString("telefono_movil"));
                    this.lblDireccion.setText(resultado.getString("direccion"));
                    this.lblUbigeo.setText(resultado.getString("ubigeo"));
                }else{
                    Funciones.mensajeAdvertencia("No se ha encontrado el cliente con el Número de Codigo ingresado", Funciones.NOMBRE_SOFTWARE);
                    this.lblNombres.setText("");
                    this.lblTelFijo.setText("");
                    this.lblTelMovil.setText("");
                    this.lblDireccion.setText("");
                    this.lblUbigeo.setText("");
                    this.txtCodigo.setText("");
                    this.txtCodigo.requestFocus();
                    //Solucionar error de transaccion
                   
                }
            } catch (Exception e) {
                Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
            }
        }
        
    private void llenarComboTD(){
        try {
            TipoDocumento objTD = new TipoDocumento();
            objTD.llenarCombo(cboTipoDocumento);
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNumeroCompra = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboTipoDocumento = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtNroDoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        //parte 1

        final JTextField field = new JTextField("hola");
        final DefaultCellEditor edit = new DefaultCellEditor(field);
        field.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.blue));
        field.setForeground(Color.blue);
        tblVentaDetalle = new javax.swing.JTable(){

            public boolean isCellEditable(int fila, int columna){
                if (columna == 2 || columna == 4){
                    return true;
                }
                return false;
            }

            public TableCellEditor getCellEditor(int row, int col) {
                if (col == 2){
                    field.setDocument(new util.ValidaNumeros());
                }else{
                    field.setDocument(new util.ValidaNumeros(util.ValidaNumeros.ACEPTA_DECIMAL));
                }

                edit.setClickCountToStart(2);
                field.addFocusListener(new FocusAdapter() {
                    public void focusGained(FocusEvent e) {
                        //field.selectAll();
                    }
                    public void focusLost(FocusEvent e) {
                        field.select(0,0);

                        if (field.getText().isEmpty()){
                            //field.setText("0");

                        }
                    }
                });
                return edit;
            }
        };
        btnGrabar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPorcentajeIGV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblIGV = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        lblUbigeo = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblTelFijo = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblTelMovil = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Venta");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nº Compra");

        txtNumeroCompra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNumeroCompra.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/compra_cab_32.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel9.setText("Registrar Venta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Tipo de Documento");

        cboTipoDocumento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Nº Documento");

        txtNroDoc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNroDoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNroDocFocusLost(evt);
            }
        });
        txtNroDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroDocKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Fecha de Venta");

        btnAgregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add2.png"))); // NOI18N
        btnAgregar.setText("Agregar Producto");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnQuitar.setText("Quitar Producto");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        tblVentaDetalle.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                //field.selectAll();
                field.setText("");
                field.requestFocus();
            }
        });

        field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode()==10){
                    if (field.getText().isEmpty()){
                        evt.consume();
                    }
                }
            }
        });
        tblVentaDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        tblVentaDetalle.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblVentaDetallePropertyChange(evt);
            }
        });
        tblVentaDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblVentaDetalleKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblVentaDetalle);

        btnGrabar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
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

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("% IGV");

        txtPorcentajeIGV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPorcentajeIGV.setEnabled(false);
        txtPorcentajeIGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorcentajeIGVActionPerformed(evt);
            }
        });
        txtPorcentajeIGV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPorcentajeIGVFocusLost(evt);
            }
        });
        txtPorcentajeIGV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorcentajeIGVKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Nº Serie");

        txtSerie.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSerie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSerieFocusLost(evt);
            }
        });
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSerieKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Sub Total:");

        lblSubTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubTotal.setText("jLabel11");
        lblSubTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("IGV:");

        lblIGV.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblIGV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIGV.setText("jLabel11");
        lblIGV.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Total:");

        lblTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("jLabel11");
        lblTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIGV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addGap(17, 17, 17))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", 0, 0, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 102, 255))); // NOI18N

        jLabel5.setText("Codigo: ");

        txtCodigo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        lblNombres.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNombres.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblNombres.setPreferredSize(new java.awt.Dimension(44, 21));

        lblUbigeo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblUbigeo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblUbigeo.setPreferredSize(new java.awt.Dimension(44, 21));

        jLabel18.setText("Ubigeo: ");

        jLabel19.setText("Nombres: ");

        jLabel20.setText("Telefono Fijo: ");

        lblTelFijo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTelFijo.setForeground(new java.awt.Color(204, 0, 0));
        lblTelFijo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblTelFijo.setPreferredSize(new java.awt.Dimension(44, 21));

        jLabel21.setText("Celular: ");

        lblTelMovil.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTelMovil.setForeground(new java.awt.Color(204, 0, 0));
        lblTelMovil.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblTelMovil.setPreferredSize(new java.awt.Dimension(44, 21));

        jLabel22.setText("Dirección: ");

        lblDireccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblDireccion.setPreferredSize(new java.awt.Dimension(44, 21));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUbigeo, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(lblTelFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(lblTelMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(lblTelFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUbigeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNumeroCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNroDoc))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addComponent(txtPorcentajeIGV)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnGrabar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumeroCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPorcentajeIGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGrabar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrmProductoBuscar objFrmProductoBuscar = new FrmProductoBuscar(null, true);
        objFrmProductoBuscar.setVisible(true);
        
        if (objFrmProductoBuscar.accion == 1){
            String codigoProducto = objFrmProductoBuscar.tblResultado.getValueAt(objFrmProductoBuscar.tblResultado.getSelectedRow(), 0).toString();
            String nombreProducto = objFrmProductoBuscar.tblResultado.getValueAt(objFrmProductoBuscar.tblResultado.getSelectedRow(), 1).toString();
            Double precioVenta= Double.parseDouble(objFrmProductoBuscar.tblResultado.getValueAt(objFrmProductoBuscar.tblResultado.getSelectedRow(), 2).toString());
            //Funciones.mensajeInformacion("Codigo:" + codigoArticulo + "\nArticulo:" + nombreArticulo , null);
            
            Object detalleCompra[] = new Object[6];
            detalleCompra[0] = codigoProducto;
            detalleCompra[1] = nombreProducto;
            detalleCompra[2] = 0;
            detalleCompra[3] = precioVenta;
            detalleCompra[4] = 0;
            detalleCompra[5] = 0;
            
            DefaultTableModel modelo = 
                    (DefaultTableModel)this.tblVentaDetalle.getModel();
            
            modelo.addRow(detalleCompra);
            this.tblVentaDetalle.setModel(modelo);
            
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int fila = 0;
        
        if (this.tblVentaDetalle.getRowCount()<=0){
            Funciones.mensajeInformacion("No hay registros en el detalle de la Venta", Funciones.NOMBRE_SOFTWARE);
            return;
        }
        
        fila = this.tblVentaDetalle.getSelectedRow();

        if (fila < 0){
            Funciones.mensajeError("Debe seleccionar un registro", Funciones.NOMBRE_SOFTWARE);
            return;
        }

        int r = Funciones.mensajeConfirmacion("Desea quitar el Producto seleccionado", "Confirme");
        if (r==0){
            DefaultTableModel modelo = (DefaultTableModel)this.tblVentaDetalle.getModel();
            modelo.removeRow(fila);
            this.tblVentaDetalle.setModel(modelo);
        }
            
    }//GEN-LAST:event_btnQuitarActionPerformed

    private boolean validarDatos() {

        if (txtSerie.getText().isEmpty()) {
            Funciones.mensajeAdvertencia("Debe ingresar la serie", "Verifique");
            txtSerie.requestFocus();
            return false;
        } else if (txtNroDoc.getText().isEmpty()) {
            Funciones.mensajeAdvertencia("Debe ingresar numero de documento", "Verifique");
            txtNroDoc.requestFocus();
            return false;
        } else if (txtFecha.getDate() == null) {
            Funciones.mensajeAdvertencia("Debe ingresar una fecha", "Verifique");
            txtFecha.requestFocus();
            return false;
        } else if (lblNombres.getText().isEmpty()) {
            Funciones.mensajeAdvertencia("Debe ingresar un nombre", "Verifique");
            txtCodigo.requestFocus();
            return false;
        } else if (tblVentaDetalle.getRowCount() <= 0) {
            Funciones.mensajeAdvertencia("Debe agregar articulos para registrar una venta", "Verifique");
            return false;
        }

        int cantidad = 0;
        String articulo = "";
        double descuento = 0;
        for (int i = 0; i < tblVentaDetalle.getRowCount(); i++) {
            cantidad = Integer.parseInt(this.tblVentaDetalle.getValueAt(i, 2).toString());
            articulo = this.tblVentaDetalle.getValueAt(i, 1).toString();
            descuento = Double.parseDouble(this.tblVentaDetalle.getValueAt(i, 4).toString());
            if (cantidad == 0) {
                Funciones.mensajeAdvertencia("Debe agregar una cantidad al articulo " + articulo, "Verifique");
                tblVentaDetalle.changeSelection(i, 2, false, false);
                tblVentaDetalle.requestFocus();
                return false;
            } else if (descuento < 0 || descuento > 100) {
                Funciones.mensajeAdvertencia("Debe ingresar un descuento entre 0 y 100 en el articulo " + articulo, "Verifique");
                tblVentaDetalle.changeSelection(i, 4, false, false);
                tblVentaDetalle.requestFocus();
                return false;
            }
        }

        return true;
    }    
    
    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
         if (validarDatos() == false) {
            return;
        }
        this.accion = 1;
        this.dispose();
        
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.accion = 0;
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblVentaDetallePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblVentaDetallePropertyChange
        if (evt.getPropertyName().equalsIgnoreCase("tableCellEditor")){
            int fila = this.tblVentaDetalle.getEditingRow();
            int columna = this.tblVentaDetalle.getEditingColumn();
            
            if (columna == 2 || columna == 3 || columna == 4){
                int  cantidad = Integer.parseInt( this.tblVentaDetalle.getValueAt(fila, 2).toString());
                double precio = Double.parseDouble(this.tblVentaDetalle.getValueAt(fila, 3).toString());
                double descuento = Double.parseDouble(this.tblVentaDetalle.getValueAt(fila, 4).toString());
                
                if (descuento<=100) {
                    double importe = new CompraDetalle().calcularImporte(cantidad, precio, descuento);
                
                    this.tblVentaDetalle.setValueAt( Funciones.formatearNumero(importe), fila, 5);

                    this.calcularTotal();
                }else{
                    Funciones.mensajeError("El descuento no puede ser mas de 100%", Funciones.NOMBRE_SOFTWARE);
                    double importe = new CompraDetalle().calcularImporte(cantidad, precio, 0);
                    return;
                }
                
                
            }
            
            
        }
    }//GEN-LAST:event_tblVentaDetallePropertyChange

    private void txtField(java.awt.event.KeyEvent evt, JTextField f) {                                  
        Funciones.soloNumeros(evt, f, 10);
    }
    
    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        Funciones.soloNumeros(evt, txtSerie, 4);
    }//GEN-LAST:event_txtSerieKeyTyped

    private void txtSerieFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerieFocusLost
        if (this.txtSerie.getText().length() > 0){
            Funciones.autoCompletarNumeros(txtSerie, 4);
        }
    }//GEN-LAST:event_txtSerieFocusLost

    private void txtNroDocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNroDocFocusLost
        if (this.txtNroDoc.getText().length()>0){
            Funciones.autoCompletarNumeros( this.txtNroDoc, 7);
        }
    }//GEN-LAST:event_txtNroDocFocusLost

    private void txtSerieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyReleased
        
    }//GEN-LAST:event_txtSerieKeyReleased

    private void txtNroDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroDocKeyTyped
        Funciones.soloNumeros(evt, txtNroDoc, 7);
    }//GEN-LAST:event_txtNroDocKeyTyped

    private void txtPorcentajeIGVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeIGVKeyTyped
        Funciones.soloNumerosDecimal(evt, txtPorcentajeIGV, 5);
    }//GEN-LAST:event_txtPorcentajeIGVKeyTyped

    private void txtPorcentajeIGVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPorcentajeIGVFocusLost
        
    }//GEN-LAST:event_txtPorcentajeIGVFocusLost

    private void tblVentaDetalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVentaDetalleKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tblVentaDetalleKeyTyped

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        Funciones.soloNumeros(evt, txtCodigo, 11);
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if (evt.getKeyCode() == 10){
            this.buscarCliente();
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtPorcentajeIGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorcentajeIGVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcentajeIGVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox cboTipoDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblDireccion;
    public javax.swing.JLabel lblIGV;
    public javax.swing.JLabel lblNombres;
    public javax.swing.JLabel lblSubTotal;
    public javax.swing.JLabel lblTelFijo;
    public javax.swing.JLabel lblTelMovil;
    public javax.swing.JLabel lblTotal;
    public javax.swing.JLabel lblUbigeo;
    public javax.swing.JTable tblVentaDetalle;
    public javax.swing.JTextField txtCodigo;
    public com.toedter.calendar.JDateChooser txtFecha;
    public javax.swing.JTextField txtNroDoc;
    public javax.swing.JTextField txtNumeroCompra;
    public javax.swing.JTextField txtPorcentajeIGV;
    public javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
