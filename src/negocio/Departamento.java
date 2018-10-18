
package negocio;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;


public class Departamento extends accesodatos.Conexion{
    
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


    
    
    
    public static ArrayList<Departamento> listaDepartamentos= new ArrayList<Departamento>();
    
    public ResultSet listar() throws Exception{
        String sql = "select * from departamento";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        return resultado;
    }
    
    private void cargarListaDepartamento() throws Exception{
        
        ResultSet resultado = this.listar();
        listaDepartamentos.clear(); //limpiar los elementos ya existentes
        while(resultado.next()){
            Departamento objDepartamento = new Departamento();
            objDepartamento.setCodDep(resultado.getString("codigo_departamento") );
            objDepartamento.setNombre(resultado.getString("nombre") );
            listaDepartamentos.add(objDepartamento);
        }
    }
    
    public void llenarComboDepartamento(JComboBox objCombo) throws Exception{
        this.cargarListaDepartamento();
        objCombo.removeAllItems();
        for (int i = 0; i < listaDepartamentos.size(); i++){
            objCombo.addItem( listaDepartamentos.get(i).getNombre());
        }
    }
}
