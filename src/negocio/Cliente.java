
package negocio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Cliente extends accesodatos.Conexion{
    
    private int codigoCliente;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String direccion;
    private String telefonoFijo;
    private String telefonoMovil1;
    private String telefonoMovil2;
    private String codDis;
    private String codPro;
    private String codDep;
    
    public ResultSet listar() throws Exception{
        String sql="select c.codigo_cliente as Codigo, c.nombres as Nombre, (c.apellido_paterno||' '||c.apellido_materno) as Apellido,c.direccion as Direccion,(di.nombre||'/'||p.nombre||'/'||de.nombre) as Ubigeo,\n" +
"                c.telefono_fijo as Telefono,c.telefono_movil1 as Movil1,c.telefono_movil2 as Movil2 \n" +
"                from cliente c  inner join distrito di on c.codigo_distrito=di.codigo_distrito and c.codigo_provincia=di.codigo_provincia and c.codigo_departamento=di.codigo_departamento\n" +
"                inner join provincia p on di.codigo_provincia=p.codigo_provincia and di.codigo_departamento=p.codigo_departamento\n" +
"                inner join departamento de on di.codigo_departamento=de.codigo_departamento \n" +
"                order by c.codigo_cliente";
                
        PreparedStatement sentencia=this.abrirConexion().prepareStatement(sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
        
        ResultSet resultado=this.ejecutarSQLSelectSP(sentencia);
        return resultado;
        
    }
    
    public boolean agregar() throws Exception{
        Connection con=this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="insert into cliente (apellido_paterno,apellido_materno,nombres,direccion"
                + ",telefono_fijo,telefono_movil1,telefono_movil2,codigo_distrito,codigo_provincia,codigo_departamento)"
                + " values (?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement sentencia=con.prepareStatement(sql);
        sentencia.setString(1,this.getApellidoPaterno());
        sentencia.setString(2,this.getApellidoMaterno());
        sentencia.setString(3,this.getNombres());
        sentencia.setString(4,this.getDireccion());
        sentencia.setString(5,this.getTelefonoFijo());
        sentencia.setString(6,this.getTelefonoMovil1());
        sentencia.setString(7,this.getTelefonoMovil2());
        sentencia.setString(8,this.getCodDis());
        sentencia.setString(9,this.getCodPro());
        sentencia.setString(10,this.getCodDep());
        
        this.ejecutarSQLSP(sentencia, con);
        
        con.commit();
        con.close();
        
        return true;
    }
    
    public boolean editar() throws Exception{
        Connection con=this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="update cliente set apellido_paterno=?,apellido_materno=?,nombres=?,direccion=?,"
                + "telefono_fijo=?,telefono_movil1=?,telefono_movil2=?,codigo_distrito=?,codigo_provincia=?,"
                + "codigo_departamento=? where codigo_cliente=?";
        
        PreparedStatement sentencia=con.prepareStatement(sql);
        sentencia.setString(1,this.getApellidoPaterno());
        sentencia.setString(2,this.getApellidoMaterno());
        sentencia.setString(3,this.getNombres());
        sentencia.setString(4,this.getDireccion());
        sentencia.setString(5,this.getTelefonoFijo());
        sentencia.setString(6,this.getTelefonoMovil1());
        sentencia.setString(7,this.getTelefonoMovil2());
        sentencia.setString(8,this.getCodDis());
        sentencia.setString(9,this.getCodPro());
        sentencia.setString(10,this.getCodDep());
        sentencia.setInt(11,this.getCodigoCliente());
        
        this.ejecutarSQLSP(sentencia, con);
        
        con.commit();
        con.close();
        
        return true;

    }
    
    public boolean eliminar() throws Exception{
        Connection con=this.abrirConexion();
        con.setAutoCommit(false);
        
        String sql="delete from cliente where codigo_cliente=?";
        
        PreparedStatement sentencia=con.prepareStatement(sql);
        
        sentencia.setInt(1,this.getCodigoCliente());
        
        this.ejecutarSQLSP(sentencia, con);
        
        con.commit();
        con.close();
        
        return true;
        
    }
    
    public ResultSet leerDatos(int codigo) throws Exception{
        String sql = "select c.codigo_cliente, c.apellido_paterno,c.apellido_materno,c.nombres,"
                   + "c.direccion,c.telefono_fijo,c.telefono_movil1,c.telefono_movil2," 
                   +"di.nombre as distrito,p.nombre as provincia,de.nombre as departamento " 
                   +"from cliente c  inner join distrito di on c.codigo_distrito=di.codigo_distrito " 
                   +"inner join provincia p on c.codigo_provincia=p.codigo_provincia " 
                   +"inner join departamento de on c.codigo_departamento=de.codigo_departamento " 
                   +"where codigo_cliente=?";
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        sentencia.setInt(1, codigo);
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        
        return resultado;
    }
    
    public ResultSet buscar()throws Exception{
        String sql= "select*from fn_buscar_cliente(?)";
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        sentencia.setInt(1, this.getCodigoCliente());
        return this.ejecutarSQLSelectSP(sentencia);
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil1() {
        return telefonoMovil1;
    }

    public void setTelefonoMovil1(String telefonoMovil1) {
        this.telefonoMovil1 = telefonoMovil1;
    }

    public String getTelefonoMovil2() {
        return telefonoMovil2;
    }

    public void setTelefonoMovil2(String telefonoMovil2) {
        this.telefonoMovil2 = telefonoMovil2;
    }

    public String getCodDis() {
        return codDis;
    }

    public void setCodDis(String codDis) {
        this.codDis = codDis;
    }

    public String getCodPro() {
        return codPro;
    }

    public void setCodPro(String codPro) {
        this.codPro = codPro;
    }

    public String getCodDep() {
        return codDep;
    }

    public void setCodDep(String codDep) {
        this.codDep = codDep;
    }
}