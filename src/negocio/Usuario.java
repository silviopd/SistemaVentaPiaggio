package negocio;

import accesodatos.Conexion;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Usuario extends Conexion{
    
    private int codigo;
    private String dniUsuario;
    private String login;
    private String clave;
    private String claveN;
    private String estado;
    private int codTipoUsuario;
    
    public String getClaveN() {
        return claveN;
    }

    public void setClaveN(String claveN) {
        this.claveN = claveN;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodTipoUsuario() {
        return codTipoUsuario;
    }

    public void setCodTipoUsuario(int codTipoUsuario) {
        this.codTipoUsuario = codTipoUsuario;
    }

    
     public ResultSet leerDatos(String codigo) throws Exception{
        String sql = "select tu.idtipo, u.dni_usuario,(apellido_paterno||' '||" +
                        "apellido_materno||', '||nombres) as nombre, " +
                        "u.login, u.clave, u.estado, tu.nombretipo from tipo_usuario tu " +
                        "inner join usuario u on u.idtipo_usuario=tu.idtipo " +
                        "inner join personal p on p.dni=u.dni_usuario " +
                        "where u.dni_usuario=?";
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        sentencia.setString(1, codigo);
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        
        return resultado;
    }
    
    public ResultSet leerDatos2(int codigo) throws Exception{
        String sql = "select * from usuario where codigo_usuario=?";
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        sentencia.setInt(1, codigo);
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        
        return resultado;
    }
    
    public ResultSet listar() throws Exception {
        String sql = "select * from fn_listar_usuario()";
        PreparedStatement sentencia = 
                this.abrirConexion().prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                );
        
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        return resultado;
    }
    
    public String[] obtenerCamposBusqueda(){
        String[] campos = {"DNI","USUARIO", "EMAIL", "LOGIN"};
        return campos;
    }
    
    public boolean agregar() throws Exception{
        
        
            Connection con = this.abrirConexion();
            con.setAutoCommit(false);
            
            
            String sql = "INSERT INTO usuario( " 
                        + "dni_usuario, "
                        + "login, "
                        + "clave, "
                        + "estado, "
                        + "idtipo_usuario) " 
                       + "VALUES (?, ?, md5(?), ?, ?);";
            System.out.println(this.getClave());
             System.out.println(StringMD.getStringMessageDigest(this.getClave(), StringMD.MD5));
                    
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, this.getDniUsuario());
            sentencia.setString(2, this.getLogin());
            sentencia.setString(3, this.getClave());
            sentencia.setString(4, this.getEstado());
            sentencia.setInt(5, this.getCodTipoUsuario());
            this.ejecutarSQLSP(sentencia, con);
                        
            con.commit();
            con.close();
            
            return true;
        
    }
    
    public boolean mantenimientoUsuario() throws Exception{
        
        
            Connection con = this.abrirConexion();
            con.setAutoCommit(false);
            
            
            String sql = "select fn_cambio_contraseña(?,?,?,?,?)";
            
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, this.getDniUsuario());
            sentencia.setString(2, this.getClaveN());
            sentencia.setString(3, this.getClave());
            sentencia.setString(4, this.getEstado());
            sentencia.setInt(5, this.getCodTipoUsuario());
            this.ejecutarSQLSP(sentencia, con);
                        
            con.commit();
            con.close();
            
            return true;
        
    }
    
    public boolean claveUpdate() throws Exception{
        
        
            Connection con = this.abrirConexion();
            con.setAutoCommit(false);
            
            
            String sql = "UPDATE usuario SET " +
                    "	    clave=md5(?)," +
                    "	    estado=?, " +
                    "       idtipo_usuario=? " +
                    "	  WHERE dni_usuario=? and clave=md5(?)";
            
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, this.getClaveN());
            sentencia.setString(2, this.getEstado());
            sentencia.setInt(3, this.getCodTipoUsuario());
            sentencia.setString(4, this.getDniUsuario());
            sentencia.setString(5, this.getClave());
            
            this.ejecutarSQLSP(sentencia, con);
                        
            con.commit();
            con.close();
            
            return true;
        
    }
    
    public boolean eliminar() throws Exception{
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);

        String sql = "delete from usuario where dni_usuario = ? ";
        PreparedStatement sentencia = con.prepareStatement(sql);
        sentencia.setString(1, this.getDniUsuario());
        this.ejecutarSQLSP(sentencia, con);
       
        con.commit();
        con.close();
        return true;
    }

}
