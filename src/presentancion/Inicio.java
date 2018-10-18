package presentancion;

import javax.swing.UIManager;

public class Inicio {

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        new FrmInicioSesion().setVisible(true);
        
    }
    
}
