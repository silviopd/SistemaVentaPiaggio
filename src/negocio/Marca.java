
package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;


public class Marca extends accesodatos.Conexion{
    
    private int codigo;
    private String descripcion;
    
    public static ArrayList<Marca> ListaMarca= new ArrayList();
    
    private void cargarListaMarcas() throws Exception{
        String sql = "select codigo_marca as Codigo, descripcion as Marca from marca order by codigo_marca";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        ListaMarca.clear(); 
        while(resultado.next()){
            Marca objMarca = new Marca();
            objMarca.setCodigo( resultado.getInt("Codigo") );
            objMarca.setDescripcion(resultado.getString("Marca") );
            ListaMarca.add(objMarca);
        }
    }
    
    public void llenarComboMarca(JComboBox objCombo) throws Exception{
        this.cargarListaMarcas();
        objCombo.removeAllItems();
        for (int i = 0; i < ListaMarca.size(); i++){
            objCombo.addItem( ListaMarca.get(i).getDescripcion());
        }
    }
    
    public ResultSet listar()throws Exception {
        
        Connection con =this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="select codigo_marca as Codigo, descripcion as Marca from marca";
        
        PreparedStatement sentencia=this.abrirConexion().prepareStatement(sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
        
        ResultSet resultado=this.ejecutarSQLSelectSP(sentencia);
        return resultado;
        
    }
    
    public ResultSet leerDatos(int codigo)throws Exception {
        
        Connection con =this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="select * from marca where codigo_marca=?";
        
        PreparedStatement sentencia=con.prepareStatement(sql);
        sentencia.setInt(1, codigo);
        
        ResultSet resultado=this.ejecutarSQLSelectSP(sentencia);
        return resultado;
        
    }
    
    public boolean agregar() throws Exception{
        
        Connection con= this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="insert into marca (descripcion) values(?)";
        
        PreparedStatement sentencia=con.prepareStatement(sql);
        sentencia.setString(1,this.getDescripcion());
        
        this.ejecutarSQLSP(sentencia, con);
        
        con.commit();
        con.close();
                
        return true;
    }
    
    public boolean editar() throws Exception{
        
        Connection con= this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="update marca set descripcion=? where codigo_marca=?";
        
        PreparedStatement sentencia=con.prepareStatement(sql);
        
        sentencia.setString(1,this.getDescripcion());
        sentencia.setInt(2,this.getCodigo());
        
        this.ejecutarSQLSP(sentencia, con);
        
        con.commit();
        con.close();
                
        return true;
    }
    
    public boolean eliminar() throws Exception{
        
        Connection con= this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="delete from marca where codigo_marca=? ";
        
        PreparedStatement sentencia=con.prepareStatement(sql);
        sentencia.setInt(1,this.getCodigo());
        
        this.ejecutarSQLSP(sentencia, con);
        
        con.commit();
        con.close();
                
        return true;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
