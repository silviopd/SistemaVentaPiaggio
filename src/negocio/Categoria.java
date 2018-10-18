
package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;


public class Categoria extends accesodatos.Conexion{
    
    private int codigo;
    private String descripcion;
    
    public static ArrayList<Categoria> ListaCategoria= new ArrayList();
    
    private void cargarListaCategorias() throws Exception{
        String sql = "select codigo_categoria as Codigo,descripcion as Categoria from categoria order by Categoria";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        ListaCategoria.clear(); 
        while(resultado.next()){
            Categoria objCategoria = new Categoria();
            objCategoria.setCodigo( resultado.getInt("Codigo") );
            objCategoria.setDescripcion(resultado.getString("Categoria") );
            ListaCategoria.add(objCategoria);
        }
    }
    
    public void llenarComboCategoria(JComboBox objCombo) throws Exception{
        this.cargarListaCategorias();
        objCombo.removeAllItems();
        for (int i = 0; i < ListaCategoria.size(); i++){
            objCombo.addItem( ListaCategoria.get(i).getDescripcion());
        }
    }
    
    public ResultSet listar()throws Exception {
        
        Connection con =this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="select codigo_categoria as Codigo,descripcion as Categoria from categoria";
        
        PreparedStatement sentencia=this.abrirConexion().prepareStatement(sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
        
        ResultSet resultado=this.ejecutarSQLSelectSP(sentencia);
        return resultado;
        
    }
    
    public ResultSet leerDatos(int codigo)throws Exception {
        
        Connection con =this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="select * from categoria where codigo_categoria=?";
        
        PreparedStatement sentencia=con.prepareStatement(sql);
        sentencia.setInt(1, codigo);
        
        ResultSet resultado=this.ejecutarSQLSelectSP(sentencia);
        return resultado;
        
    }
    
    public boolean agregar() throws Exception{
        
        Connection con= this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="insert into categoria (descripcion) values(?)";
        
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
        
        String sql="update categoria set descripcion=? where codigo_categoria=?";
        
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
        
        String sql="delete from categoria where codigo_categoria=? ";
        
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
