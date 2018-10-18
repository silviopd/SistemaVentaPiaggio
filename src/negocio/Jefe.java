package negocio;

import accesodatos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import static negocio.Jefe.listaJefe;

public class Jefe extends Conexion{
    private String codigo;
    private String descripcion;
    
    public static ArrayList<Jefe> listaJefe = new ArrayList<Jefe>();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
  
    
    private void cargarListaJefe() throws Exception{
        String sql = "select dni, (apellido_paterno||' '||apellido_materno||', '||nombres) as nombre "
                + "from personal order by 2";
        
        
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaJefe.clear();
        while(resultado.next()){
            Jefe objMarca = new Jefe();
            objMarca.setCodigo( resultado.getString("dni") );
            objMarca.setDescripcion(resultado.getString("nombre") );
            listaJefe.add(objMarca);
        }
    }
    
    public void llenarComboJefe(JComboBox objCombo) throws Exception{
        this.cargarListaJefe();
        //objCombo.removeAllItems();
        for (int i = 0; i < listaJefe.size(); i++){
            objCombo.addItem(listaJefe.get(i).getDescripcion());
        }
    }
    
    public void llenarCombo(JComboBox objCombo) throws Exception{
        this.cargarListaJefe();
        objCombo.removeAllItems();
        for (int i = 0; i < listaJefe.size(); i++){
            objCombo.addItem(listaJefe.get(i).getDescripcion());
        }
    }
    
     private void cargarListaPersonalNoUsuario() throws Exception{
        String sql = "select p.dni, (p.apellido_paterno||' '||p.apellido_materno||', '||p.nombres) as nombre \n" +
"from personal p where p.dni not in( select pe.dni from personal pe inner join usuario u on p.dni=u.dni_usuario)";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaJefe.clear();
        while(resultado.next()){
            Jefe objMarca = new Jefe();
            objMarca.setCodigo( resultado.getString("dni") );
            objMarca.setDescripcion(resultado.getString("nombre") );
            listaJefe.add(objMarca);
        }
    }
    
    public void llenarComboJNU(JComboBox objCombo) throws Exception{
        this.cargarListaPersonalNoUsuario();
        objCombo.removeAllItems();
        for (int i = 0; i < listaJefe.size(); i++){
            objCombo.addItem(listaJefe.get(i).getDescripcion());
        }
    }



}
