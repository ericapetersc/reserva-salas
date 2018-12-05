
package model;
import beans.Bloco;
import bd.*;
import java.sql.*;
import java.util.*;

public class BlocoModel {

    public void insere(Bloco b) throws SQLException {
        String cmd = "INSERT INTO blocos (letra, numerosalas) VALUES(?,?)";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, b.getLetra());
        st.setInt(2, b.getNumeroSalas());
        st.executeUpdate();
    }
    
    public void remove(Bloco b) throws SQLException {
        String cmd = "DELETE FROM blocos WHERE letra=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, b.getLetra());
        st.executeUpdate();
    }
    
    public List<Bloco> consultaTodos() throws SQLException {
        String cmd = "SELECT * FROM blocos";
        Statement st = Conexao.getSt();
        List<Bloco> blocos = new ArrayList();
        ResultSet rs = st.executeQuery(cmd);
        while(rs.next()) {
            String letra = rs.getString(1);
            int nSalas = rs.getInt(2);
            Bloco bl = new Bloco(letra,nSalas);
            blocos.add(bl);
        }
        return blocos;
    }
    
}
