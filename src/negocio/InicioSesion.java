package negocio;

import accesodatos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.Funciones;

public class InicioSesion extends Conexion{
    private String email;
    private String clave;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave){
        this.clave = clave;
    }
    
    public int iniciarSesionSP() throws Exception{
        String sql= "select * from fn_iniciar_sesion(?, ?)";
        
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        sentencia.setString(1, this.getEmail());
        sentencia.setString(2, this.getClave());
        
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        
        if (resultado.next()){ //Encontró registros
            if (resultado.getString("estado").equalsIgnoreCase("A")){ //El usuario esta con estado Activo(A)
                
                        Funciones.USUARIO_LOGUEADO = 
                        resultado.getString("usuario");
                        Funciones.DNI_LOGUEADO = resultado.getString("dni_usuario");
                        Funciones.TIPO_USUARIO_LOGUEADO=
                        resultado.getString("tipo_usuario");
                        Funciones.CODIGO_USUARIO_LOGUEADO=
                        resultado.getInt("codigo_usuario");
                return 1;
            }else{
                return 2;
            }
        }
        
        return 0;
        

    }
    
}
