package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    private static Connection con = null;
    private static Statement st;
    
    public static void connect() {
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senha";
        String url = "jdbc:postgresql://localhost:5432/reservasalas";
        try {
            Class.forName(driver);          
            setCon((Connection) DriverManager.getConnection(url, user, senha));
            setSt(getCon().createStatement());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.print(e.getMessage());
        }
    }    

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection aCon) {
        con = aCon;
    }

    public static Statement getSt() {
        return st;
    }

    public static void setSt(Statement aSt) {
        st = aSt;
    }
}
