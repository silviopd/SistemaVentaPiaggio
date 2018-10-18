
package negocio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;



public class Distrito extends accesodatos.Conexion{

    private String codDis;
    private String codPro;
    private String codDep;
    private String nombre;
    
    public static ArrayList<Distrito> listaDistrito= new ArrayList<Distrito>();
    
    private void cargarListaDistrito(String codigoDepartamento, String codigoProvincia) throws Exception{
        String sql = "select "
                + "codigo_distrito, "
                + "nombre "
                + "from distrito "
                + "where codigo_departamento=? and codigo_provincia=? ";
        
        PreparedStatement sp = 
                this.abrirConexion().prepareStatement(sql);
        
        sp.setString(1, codigoDepartamento);
        sp.setString(2, codigoProvincia);
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        listaDistrito.clear(); //limpiar la lista
        while(resultado.next()){
            Distrito objDistrito = new Distrito();
            objDistrito.setCodDis(resultado.getString("codigo_distrito") );
            objDistrito.setNombre(resultado.getString("nombre") );
            listaDistrito.add(objDistrito);
        }
    }
    
    public void llenarComboDistrito(JComboBox objCombo, String codigoDepartamento,String codigoProvincia) throws Exception{
        objCombo.removeAllItems(); 
        this.cargarListaDistrito(codigoDepartamento,codigoProvincia);
        for (int i= 0; i<listaDistrito.size(); i++) {
            objCombo.addItem( listaDistrito.get(i).getNombre());
        }
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static ArrayList<Distrito> getListaDistrito() {
        return listaDistrito;
    }

    public static void setListaDistrito(ArrayList<Distrito> listaDistrito) {
        Distrito.listaDistrito = listaDistrito;
    }


    
    
}
