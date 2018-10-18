
package negocio;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;


public class CodigoCiudad extends accesodatos.Conexion{
    
    private String codDep;
    private String nombre;

    public String getCodDep() {
        return codDep;
    }

    public void setCodDep(String codDep) {
        this.codDep = codDep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static ArrayList<CodigoCiudad> listaCodigoCiudad= new ArrayList<CodigoCiudad>();
    
    public ResultSet listar() throws Exception{
        String sql = "select * from codigo_ciudad";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        return resultado;
    }
    
    private void cargarListaCodigoCiudad() throws Exception{
        
        ResultSet resultado = this.listar();
        listaCodigoCiudad.clear(); //limpiar los elementos ya existentes
        while(resultado.next()){
            CodigoCiudad objDepartamento = new CodigoCiudad();
            objDepartamento.setCodDep(resultado.getString("cod_ciudad") );
            objDepartamento.setNombre(resultado.getString("descripcion") );
            listaCodigoCiudad.add(objDepartamento);
        }
    }
    
    public void llenarComboCodigoCiudad(JComboBox objCombo) throws Exception{
        this.cargarListaCodigoCiudad();
        objCombo.removeAllItems();
        for (int i = 0; i < listaCodigoCiudad.size(); i++){
            objCombo.addItem( listaCodigoCiudad.get(i).getNombre());
        }
    }
}
