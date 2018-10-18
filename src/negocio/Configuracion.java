package negocio;

import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Configuracion extends Conexion{
    
    public double obtenerValorIGV() throws Exception{
        String sql = "select valor::numeric(14,2) from configuracion where codigo = 1";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        double igv = 0;
        if (resultado.next()){
            igv = resultado.getDouble("valor");
        }
        return igv;
    }
    
    public String obtenerValorParametro(int codigo) throws Exception{
        String sql = "select valor from configuracion where codigo = ?";
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        sentencia.setInt(1, codigo);
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        
        String valor = "";
        if (resultado.next()){
            valor = resultado.getString("valor");
        }
        return valor;
    }
    
    public boolean editar(String vn) throws Exception{
        Connection con=this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="UPDATE configuracion SET valor=? WHERE codigo=1;";
        
        PreparedStatement sentencia=con.prepareStatement(sql);
        sentencia.setString(1,vn);
        
        this.ejecutarSQLSP(sentencia, con);
        
        con.commit();
        con.close();
        
        return true;

    }
    
}
