
package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Producto extends accesodatos.Conexion{
    
    public String codigo;
    public String descripcion;
    public Double precio;
    public int unidadMedida;
    public int codigoMarca;
    public int codigoCategoria;
    
    public ResultSet listar() throws Exception{
        String sql = "select p.codigo as Codigo, p.descripcion as Producto, p.precio as Precio, u.descripcion as Unidad, p.stock as Stock from producto p inner join unidad_medida u on p.unidad_medida=u.idunidad order by 2";
        PreparedStatement sentencia = 
                this.abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        return resultado;
    }
    
    public boolean agregar() throws Exception{
        
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
            
        String sql = "insert into producto (codigo,descripcion,precio,unidad_medida,"
                + "codigo_marca,codigo_categoria) values (?,?,?,?,?,?)";
        
        PreparedStatement sentencia= con.prepareStatement(sql);
        sentencia.setString(1,this.getCodigo());
        sentencia.setString(2,this.getDescripcion());
        sentencia.setDouble(3,this.getPrecio());
        sentencia.setInt(4,this.getUnidadMedida());
        sentencia.setInt(5,this.getCodigoMarca());
        sentencia.setInt(6,this.getCodigoCategoria());
        
        this.ejecutarSQLSP(sentencia, con);
        
        con.commit();
        con.close();
            
        return true;
        
    }    
    
    public boolean editar() throws Exception{
        
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);

        String sql = "update producto set codigo=?,descripcion=?,precio=?,unidad_medida=?,"
                + "codigo_marca=?,codigo_categoria=? where codigo=?";

        PreparedStatement sentencia = con.prepareStatement(sql);
        
        sentencia.setString(1,this.getCodigo());
        sentencia.setString(2,this.getDescripcion());
        sentencia.setDouble(3,this.getPrecio());
        sentencia.setInt(4,this.getUnidadMedida());
        sentencia.setInt(5,this.getCodigoMarca());
        sentencia.setInt(6,this.getCodigoCategoria());
        sentencia.setString(7,this.getCodigo());
        
        this.ejecutarSQLSP(sentencia, con);
          
        con.commit();
        con.close();

        return true;
        
    }
    
    public boolean eliminar() throws Exception{
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);

        String sql = "delete from producto where codigo= ? ";
        
        PreparedStatement sentencia = con.prepareStatement(sql);
        sentencia.setString(1, this.getCodigo());
        this.ejecutarSQLSP(sentencia, con);
         
        con.commit();
        con.close();
        return true;
    }
    
    public ResultSet buscar(String codigo, String nombre, int tipo) throws Exception{
        String sql = "select * from f_buscar_producto(?,?,?)";
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        
        sentencia.setString(1, codigo);
        sentencia.setString(2, nombre);
        sentencia.setInt(3, tipo);
        return this.ejecutarSQLSelectSP(sentencia);
    }
    
    public ResultSet leerDatos(String codigo) throws Exception{
        
        String sql = "select p.codigo,p.descripcion,p.precio,p.unidad_medida,m.descripcion as marca,"
                + "c.descripcion as categoria, stock " 
                +"from producto p inner join marca m on p.codigo_marca=m.codigo_marca "
                +"inner join categoria c on p.codigo_categoria=c.codigo_categoria " 
                +"where codigo=?";
        
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        sentencia.setString(1, codigo);
        
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        
        return resultado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(int unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(int codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }   
    
}
