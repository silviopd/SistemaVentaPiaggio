
package negocio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Provincia extends accesodatos.Conexion{
    
    private String codPro;
    private String nombre;
    private String codDep;
    
    public static ArrayList<Provincia> listaProvincias= new ArrayList<Provincia>();
    
    private void cargarListaProvincia(String codigoDepartamento) throws Exception{
        String sql = "select "
                + "codigo_provincia, "
                + "nombre "
                + "from provincia "
                + "where codigo_departamento = ?";
        
        PreparedStatement sp = 
                this.abrirConexion().prepareStatement(sql);
        sp.setString(1, codigoDepartamento);
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        listaProvincias.clear(); //limpiar la lista
        while(resultado.next()){
            Provincia objProvincia = new Provincia();
            objProvincia.setCodPro(resultado.getString("codigo_provincia") );
            objProvincia.setNombre(resultado.getString("nombre") );
            Provincia.listaProvincias.add(objProvincia);
        }
    }
    
    public void llenarComboProvincia(JComboBox objCombo, String codigoDepartamento) throws Exception{
        this.cargarListaProvincia(codigoDepartamento);
        objCombo.removeAllItems(); //limpiar los elementos exitentes
        for (int i= 0; i<listaProvincias.size(); i++) {
            objCombo.addItem( listaProvincias.get(i).getNombre());
        }
    }

    public String getCodPro() {
        return codPro;
    }

    public void setCodPro(String codPro) {
        this.codPro = codPro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodDep() {
        return codDep;
    }

    public void setCodDep(String codDep) {
        this.codDep = codDep;
    }
    
    
    
    
}
