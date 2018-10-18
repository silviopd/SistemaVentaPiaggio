package negocio;

import accesodatos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoUsuario extends Conexion{
    private int codigo;
    private String descripcion;
    
    public static ArrayList<TipoUsuario> listaTipoUsuario = new ArrayList<TipoUsuario>();

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
    
  
    
    private void cargarListaTipoUsuario() throws Exception{
        String sql = "select * from tipo_usuario order by 2";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaTipoUsuario.clear(); //limpiar los elementos ya existentes
        while(resultado.next()){
            TipoUsuario objMarca = new TipoUsuario();
            objMarca.setCodigo( resultado.getInt("idtipo") );
            objMarca.setDescripcion(resultado.getString("nombretipo") );
            listaTipoUsuario.add(objMarca);
        }
    }
    
    public void llenarComboTipoUsuario(JComboBox objCombo) throws Exception{
        this.cargarListaTipoUsuario();
        objCombo.removeAllItems();
        for (int i = 0; i < listaTipoUsuario.size(); i++){
            objCombo.addItem( listaTipoUsuario.get(i).getDescripcion());
        }
    }
}
