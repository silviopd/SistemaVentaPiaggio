
package negocio;

import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Personal extends Conexion{
    private String dni;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String direccion;
    private String telefonoFijo;
    private String telefonoMovil1;
    private String telefonoMovil2;
    private String email;
    private String dniJefe;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDniJefe() {
        return dniJefe;
    }

    public void setDniJefe(String dniJefe) {
        this.dniJefe = dniJefe;
    }
    
    public ResultSet listar() throws Exception{
        String sql = "select * from f_listar_personal()";
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
        String[] campos = {"DNI","PERSONAL", "DIRECCION"};
        return campos;
    }
    
    public boolean agregar() throws Exception{
        
        
            Connection con = this.abrirConexion();
            con.setAutoCommit(false);
            
            
            String sql = "insert into personal"
                    + "(dni, "
                    + "apellido_paterno, "
                    + "apellido_materno, "
                    + "nombres, "
                    + "direccion, "
                    + "telefono_fijo, "
                    + "telefono_movil1, "
                    + "telefono_movil2, "
                    + "email, "
                    + "dni_jefe) "
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, this.getDni());
            sentencia.setString(2, this.getApellidoPaterno());
            sentencia.setString(3, this.getApellidoMaterno());
            sentencia.setString(4, this.getNombres());
            sentencia.setString(5, this.getDireccion());
            sentencia.setString(6, this.getTelefonoFijo());
            sentencia.setString(7, this.getTelefonoMovil1());
            sentencia.setString(8, this.getTelefonoMovil2());
            sentencia.setString(9, this.getEmail());
            sentencia.setString(10, this.getDniJefe());
            this.ejecutarSQLSP(sentencia, con);
                        
            con.commit();
            con.close();
            
            return true;
        
    }  
    
    
    
    public boolean editar() throws Exception{
        
        
            Connection con = this.abrirConexion();
            con.setAutoCommit(false);
            
            
            String sql = "UPDATE personal SET " +
                        "   apellido_paterno=?, " +
                        "   apellido_materno=?, " +
                        "   nombres=?, " +
                        "   direccion=?, " +
                        "   telefono_fijo=?, " +
                        "   telefono_movil1=?, " +
                        "   telefono_movil2=?, " +
                        "   email=? " +
                        " WHERE dni=?";
            
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, this.getApellidoPaterno());
            sentencia.setString(2, this.getApellidoMaterno());
            sentencia.setString(3, this.getNombres());
            sentencia.setString(4, this.getDireccion());
            sentencia.setString(5, this.getTelefonoFijo());
            sentencia.setString(6, this.getTelefonoMovil1());
            sentencia.setString(7, this.getTelefonoMovil2());
            sentencia.setString(8, this.getEmail());
            sentencia.setString(9, this.getDni());
            this.ejecutarSQLSP(sentencia, con);
                        
            con.commit();
            con.close();
            
            return true;
    }    
    
    public ResultSet leerDatos(String dni) throws Exception{
        String sql = "select * from f_leer_datos_personal(?)";
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        sentencia.setString(1, dni);
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        
        return resultado;
    }
    
    public boolean eliminar() throws Exception{
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);

        String sql = "delete from personal where dni = ? ";
        PreparedStatement sentencia = con.prepareStatement(sql);
        sentencia.setString(1, this.getDni());
        this.ejecutarSQLSP(sentencia, con);
       
        con.commit();
        con.close();
        return true;
    }
}

