package view;
import bd.Conexao;

public class Main {
    
    public static MenuPrincipal menu;
    public static void main(String args[]){
        Conexao.connect();
        menu = MenuPrincipal.getInstance();
        menu.setVisible( true );
        
    }
}
