package negocio;

import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Venta extends Conexion{
    private int nroVenta;
    private String codigoTipoDocumento;
    private String serie;
    private String numero;
    private int codigoCliente;
    private Date fechaVenta;
    private double subtTotal;
    private double igv;
    private double total;
    private double porcentajeIGV;
    private int codigoUsuario;
    
    private ArrayList<VentaDetalle> detalleVenta;

    public int getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(int nroVenta) {
        this.nroVenta = nroVenta;
    }

    public String getCodigoTipoDocumento() {
        return codigoTipoDocumento;
    }

    public void setCodigoTipoDocumento(String codigoTipoDocumento) {
        this.codigoTipoDocumento = codigoTipoDocumento;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getSubtTotal() {
        return subtTotal;
    }

    public void setSubtTotal(double subtTotal) {
        this.subtTotal = subtTotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPorcentajeIGV() {
        return porcentajeIGV;
    }

    public void setPorcentajeIGV(double porcentajeIGV) {
        this.porcentajeIGV = porcentajeIGV;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public ArrayList<VentaDetalle> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(ArrayList<VentaDetalle> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

     public ResultSet listar(java.sql.Date fecha1, java.sql.Date fecha2, int tipo) throws Exception{
        String sql = "select * from f_listar_venta(?, ?, ?)";
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        sentencia.setDate(1, fecha1);
        sentencia.setDate(2, fecha2);
        sentencia.setInt(3, tipo);
        
        return this.ejecutarSQLSelectSP(sentencia);
    }
    
    public boolean agregar() throws Exception{
        String sql = "select numero+1 as numero from correlativo where tabla='ventas'";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        
        if (resultado.next()){
            
            this.setNroVenta(resultado.getInt("numero"));
            
            Connection con = this.abrirConexion();
            con.setAutoCommit(false);
            
            sql = "insert into venta"
                    + "(numero_venta, " +
                        " numero_serie, " +
                        " cod_tipo_documento, " +
                        " codigo_cliente, " +
                        " nro_documento, " +
                        " fecha_venta," +
                        " porcentaje_igv, " +
                        " sub_total,  " +
                        " igv, " +
                        " total, " +
                        " codigo_usuario)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement spVenta = con.prepareStatement(sql);
            spVenta.setInt(1, this.getNroVenta());
            spVenta.setString(2, this.getSerie());
            spVenta.setString(3, this.getCodigoTipoDocumento());
            spVenta.setInt(4, this.getCodigoCliente());
            spVenta.setString(5, this.getNumero());
            spVenta.setDate(6, this.getFechaVenta());
            spVenta.setDouble(7, this.getPorcentajeIGV());
            spVenta.setDouble(8, this.getSubtTotal());
            spVenta.setDouble(9, this.getIgv());
            spVenta.setDouble(10, this.getTotal());
            spVenta.setInt(11, this.getCodigoUsuario());
            
            this.ejecutarSQLSP(spVenta, con);
            
            for (int i = 0; i < detalleVenta.size(); i++) {
                sql = "insert into venta_detalle"
                        + "(numero_venta, \n" +
                            " codigo_producto, " +
                            " item, " +
                            " cantidad, " +
                            " precio, " +
                            " descuento, " +
                            " importe) "
                        + "values(?,?,?,?,?,?,?)";
                
                PreparedStatement spDetalle = con.prepareStatement(sql);
                spDetalle.setInt(1, this.getNroVenta());
                spDetalle.setString(2, detalleVenta.get(i).getCodigoProducto() );
                spDetalle.setInt(3, detalleVenta.get(i).getItem() );
                spDetalle.setInt(4, detalleVenta.get(i).getCantidad() );
                spDetalle.setDouble(5, detalleVenta.get(i).getPrecio());
                spDetalle.setDouble(6, detalleVenta.get(i).getDescuento());
                spDetalle.setDouble(7, detalleVenta.get(i).getImporte());
                                
                this.ejecutarSQLSP(spDetalle, con);
                
                sql = "update producto set stock = stock - ? where codigo = ?";
                PreparedStatement spActStock = con.prepareStatement(sql);
                spActStock.setInt(1, detalleVenta.get(i).getCantidad());
                spActStock.setString(2, detalleVenta.get(i).getCodigoProducto());
                this.ejecutarSQLSP(spActStock, con);
                
            }
            
            sql = "update correlativo set numero = ? where tabla='ventas'";
            PreparedStatement spCorrelativo = con.prepareStatement(sql);
            spCorrelativo.setInt(1, this.getNroVenta());
            this.ejecutarSQLSP(spCorrelativo, con);
            
            con.commit();
            con.close();
            
            
        }else{
            throw new Exception("No se ha configurado el correlativo para la tabla venta");
        }
            
        
        return true;
    }
    
    public boolean anular() throws Exception{
        String sql = "";
        
        sql = "select estado from venta where numero_venta = ?";
        PreparedStatement spEstadoVenta = this.abrirConexion().prepareStatement(sql);
        spEstadoVenta.setInt(1, this.getNroVenta());
        ResultSet rsEstadoVenta = this.ejecutarSQLSelectSP(spEstadoVenta);
        if (rsEstadoVenta.next()){
            if (rsEstadoVenta.getString("estado").equalsIgnoreCase("A")){
                throw new Exception("La venta que intenta anular ya esta anulada");
            }
        }else{
            throw new Exception("La venta que intenta anular no existe");
        }
        
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        
        
        
        sql = "update venta set estado = 'A' where numero_venta = ?";
        PreparedStatement sentencia = con.prepareStatement(sql);
        sentencia.setInt(1, this.getNroVenta());
        this.ejecutarSQLSP(sentencia, con);
        
        sql = "select codigo_producto, cantidad from venta_detalle where numero_venta = ?";
        
        PreparedStatement spDetalleVenta = this.abrirConexion().prepareStatement(sql);
        spDetalleVenta.setInt(1, this.getNroVenta());
        ResultSet rsDetalle = this.ejecutarSQLSelectSP(spDetalleVenta);
        
        while(rsDetalle.next()){
            sql = "update producto set stock = stock + ? where codigo = ?";
            PreparedStatement spActStock = con.prepareStatement(sql);
            spActStock.setInt(1, rsDetalle.getInt("cantidad"));
            spActStock.setString(2, rsDetalle.getString("codigo_producto"));
            this.ejecutarSQLSP(spActStock, con);
        }
        
        con.commit();
        con.close();
        
        return true;
        
    }
}
