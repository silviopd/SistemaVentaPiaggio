
package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;


public class UnidadMedida extends accesodatos.Conexion{
    
    private int codigo;
    private String descripcion;
    
    public static ArrayList<UnidadMedida> ListaUnidad= new ArrayList();
    
    private void cargarListaUnidad() throws Exception{
        String sql = "select idunidad as Codigo, descripcion as Unidad from unidad_medida order by idunidad";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        ListaUnidad.clear(); 
        while(resultado.next()){
            UnidadMedida objMarca = new UnidadMedida();
            objMarca.setCodigo( resultado.getInt("Codigo") );
            objMarca.setDescripcion(resultado.getString("Unidad") );
            ListaUnidad.add(objMarca);
        }
    }
    
    public void llenarComboUnidad(JComboBox objCombo) throws Exception{
        this.cargarListaUnidad();
        objCombo.removeAllItems();
        for (int i = 0; i < ListaUnidad.size(); i++){
            objCombo.addItem( ListaUnidad.get(i).getDescripcion());
        }
    }
    
    public ResultSet listar()throws Exception {
        
        Connection con =this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="select idunidad as Codigo, descripcion as Unidad from unidad_medida";
        
        PreparedStatement sentencia=this.abrirConexion().prepareStatement(sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
        
        ResultSet resultado=this.ejecutarSQLSelectSP(sentencia);
        return resultado;
        
    }
    
    public ResultSet leerDatos(int codigo)throws Exception {
        
        Connection con =this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="select * from inidad_medida where idunidad=?";
        
        PreparedStatement sentencia=con.prepareStatement(sql);
        sentencia.setInt(1, codigo);
        
        ResultSet resultado=this.ejecutarSQLSelectSP(sentencia);
        return resultado;
        
    }
    
    public boolean agregar() throws Exception{
        
        Connection con= this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="insert into unidad_medida (descripcion) values(?)";
        
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
        
        String sql="update unidad_medida set descripcion=? where idunidad=?";
        
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
        
        String sql="delete from unidad_medida where idunidad=? ";
        
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
