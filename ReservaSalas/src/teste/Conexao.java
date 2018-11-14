package teste;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author udesc
 */
public class Conexao {
    private static Connection con = null;
    private static Statement st;
    
    public static void connect() {
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "udesc";
        String url = "jdbc:postgresql://localhost:5432/clinica";
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

    /**
     * @return the con
     */
    public static Connection getCon() {
        return con;
    }

    /**
     * @param aCon the con to set
     */
    public static void setCon(Connection aCon) {
        con = aCon;
    }

    /**
     * @return the st
     */
    public static Statement getSt() {
        return st;
    }

    /**
     * @param aSt the st to set
     */
    public static void setSt(Statement aSt) {
        st = aSt;
    }
}
