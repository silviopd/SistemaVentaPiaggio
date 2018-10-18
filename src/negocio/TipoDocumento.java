package negocio;

import accesodatos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoDocumento extends Conexion{
    private String codTipoDocumento;
    private String nombre;
    
    public static ArrayList<TipoDocumento> listaTD = new ArrayList<>();

    public String getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(String codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private void cargarListaTD() throws Exception{
        String sql = "select cod_tipo_documento, nombre from tipo_documento order by 1";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaTD.clear();
        while(resultado.next()){
            TipoDocumento objTD = new TipoDocumento();
            objTD.setCodTipoDocumento( resultado.getString("cod_tipo_documento") );
            objTD.setNombre(resultado.getString("nombre") );
            listaTD.add(objTD);
        }
    }
    
    public void llenarCombo(JComboBox objCombo) throws Exception{
        this.cargarListaTD();
        objCombo.removeAllItems();
        for (int i = 0; i < listaTD.size(); i++) {
            objCombo.addItem( listaTD.get(i).getNombre() );
        }
    }
    
    
    
}
