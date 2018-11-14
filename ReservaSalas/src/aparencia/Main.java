package aparencia;
import teste.*;

public class Main {
    
    public static MenuPrincipal menu;
    
    public static void main(String args[]){
        Conexao.connect();
        menu = new MenuPrincipal();
        menu.setVisible( true );
    }
}
