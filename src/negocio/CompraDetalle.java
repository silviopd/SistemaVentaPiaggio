package negocio;

import accesodatos.Conexion;
import java.sql.ResultSet;

public class CompraDetalle extends Conexion{
    private int codigoProducto;
    private int item;
    private int cantidad;
    private double precio;
    private double descuento;
    private double importe;

    
    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoArticulo(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    public ResultSet configurarDetalleCompra() throws Exception{
        String sql ="select * from (" +
                    "	select " +
                    "		0::integer as codigo," +
                    "		''::character varying(100) as producto," +
                    "		0::integer as cantidad," +
                    "		0::numeric(14,2) as precio," +
                    "		0::numeric(14,2) as descuento," +
                    "		0::numeric(14,2) as importe" +
                    ") as tb1 where tb1.codigo > 0";
        
        return this.ejecutarSQLSelect(sql);

    }
    
    public double calcularImporte(int cantidad, double precio, double descuento){
        double importe=0;
        double importeDescuento=0;
        importe = cantidad * precio;
        importeDescuento = (importe * descuento)/100;
        importe = importe - importeDescuento;
        return importe;
    }
    
    
    
}
