package model;
import beans.Sala;
import bd.*;
import java.sql.*;
import java.util.*;


public class SalaModel {
    
    public void insere(Sala s) throws SQLException {
        String cmd = "INSERT INTO salas (numero, bloco, tipo) VALUES(?,?,?)";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setInt(1, s.getNumero());
        st.setString(2, s.getBloco());
        st.setInt(3, s.getTipo());
        st.executeUpdate();
    }
    
    public void remove(Sala s) throws SQLException {
        String cmd = "DELETE FROM salas WHERE numero=? AND bloco=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setInt(1, s.getNumero());
        st.setString(2, s.getBloco());
        st.executeUpdate();
    }
    
    /*consulta sala por bloco e numero*/
    public Sala consultaUma(int numero, String bloco) throws SQLException {
        String cmd = "SELECT * FROM salas WHERE numero=? AND bloco=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setInt(1, numero);
        st.setString(2, bloco);
        ResultSet rs = st.executeQuery();
        rs.next();
        Sala s = new Sala(rs.getInt(2), rs.getInt(4), rs.getString(3), rs.getInt(1));
        //numero, tipo, bloco, idsala
        return s;
    }
    
    public Sala consultaUmaPeloCodigo (int numero) throws SQLException {
        String cmd = "SELECT * FROM salas WHERE idsala=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setInt(1, numero);
        ResultSet rs = st.executeQuery();
        rs.next();
        Sala s = new Sala (rs.getInt(2), rs.getInt(4), rs.getString(3), rs.getInt(1));
        return s;
    }
    
    /*consulta todas as salas*/
    public List<Sala> consultaTodas() throws SQLException {
        String cmd = "SELECT * FROM salas";
        Statement st = Conexao.getSt();
        List<Sala> salas = new ArrayList();
        ResultSet rs = st.executeQuery(cmd);
        while(rs.next()) {
            int idsala = rs.getInt(1);
            int numero = rs.getInt(2);
            int tipo = rs.getInt(4);
            String bloco = rs.getString(3);
            Sala s = new Sala(numero, tipo, bloco, idsala);
            salas.add(s);
        }
        return salas;
    }
    
    /*consulta todas as salas de um bloco*/
    public List<Sala> consultaDeUmBloco(String letra) throws SQLException {
        String cmd = "SELECT * FROM salas WHERE bloco=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, letra);
        List<Sala> salas = new ArrayList();
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            int idsala = rs.getInt(1);
            int numero = rs.getInt(2);
            int tipo = rs.getInt(4);
            String bloco = rs.getString(3);
            Sala s = new Sala(numero, tipo, letra, idsala);
            salas.add(s);
        }
        return salas;
    }
    
    /*consulta todas as salas do tipo normais de um bloco*/
    public List<Sala> consultaNormaisDeUmBloco(String letra) throws SQLException {
        String cmd = "SELECT * FROM salas WHERE bloco=? AND tipo=1";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, letra);
        List<Sala> salas = new ArrayList();
        ResultSet rs = st.executeQuery();
        while(rs.next()) {
            int idsala = rs.getInt(1);
            int numero = rs.getInt(2);
            int tipo = rs.getInt(4);
            String bloco = rs.getString(3);
            Sala s = new Sala(numero, tipo, bloco, idsala);
            salas.add(s);
        }
        return salas;
    }
    
    /*consulta todas as salas disponíveis em um periodo e data*/
    public List<Sala> consultaDisponiveis(String periodo, String data) throws SQLException {
        String cmd = "SELECT * FROM salas EXCEPT SELECT s.idsala, s.numero, s.bloco, s.tipo FROM salas s JOIN reservas r ON s.idsala=r.idsala AND r.periodo=? AND r.data=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, periodo);
        st.setString(2, data);
        List<Sala> salas = new ArrayList();
        ResultSet rs = st.executeQuery();
        while(rs.next()) {
            int idsala = rs.getInt(1);
            int numero = rs.getInt(2);
            int tipo = rs.getInt(4);
            String bloco = rs.getString(3);
            Sala s = new Sala(numero, tipo, bloco, idsala);
            salas.add(s);
        }
        return salas;
    }
    
    /*consulta todas as salas disponíveis em bloco, por periodo e data*/
    public List<Sala> consultaDisponiveisBloco(String bloco, String periodo, String data) throws SQLException {
        String cmd = "SELECT idsala, numero, bloco, tipo FROM salas WHERE bloco=? EXCEPT SELECT s.idsala, s.numero, s.bloco, s.tipo FROM salas s JOIN reservas r ON s.idsala=r.idsala AND r.periodo=? AND r.data=? AND bloco=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, bloco);
        st.setString(2, periodo);
        st.setString(3, data);
        st.setString(4, bloco);
        List<Sala> salas = new ArrayList();
        ResultSet rs = st.executeQuery();
        while(rs.next()) {
            int idsala = rs.getInt(1);
            int numero = rs.getInt(2);
            int tipo = rs.getInt(4);
            String bl = rs.getString(3);
            Sala s = new Sala(numero, tipo, bl, idsala);
            salas.add(s);
        }
        return salas;
    }
    
    /*consulta todas as salas disponíveis, desde que sejam salas do tipo normal*/
    public List<Sala> consultaDisponiveisNormais(String periodo, String data) throws SQLException {
        String cmd = "SELECT * FROM salas WHERE tipo=1 EXCEPT SELECT s.idsala, s.numero, s.bloco, s.tipo FROM salas s JOIN reservas r ON s.idsala=r.idsala AND r.periodo=? AND r.data=? WHERE tipo=1";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, periodo);
        st.setString(2, data);
        List<Sala> salas = new ArrayList();
        ResultSet rs = st.executeQuery();
        while(rs.next()) {
            int idsala = rs.getInt(1);
            int numero = rs.getInt(2);
            int tipo = rs.getInt(4);
            String bloco = rs.getString(3);
            Sala s = new Sala(numero, tipo, bloco, idsala);
            salas.add(s);
        }
        return salas;
    }
    
    /*consulta todas as salas disponíveis em um bloco, desde que sejam salas do tipo normal*/
    public List<Sala> consultaDisponiveisNormaisBloco(String bloco, String periodo, String data) throws SQLException {
        String cmd = "SELECT * FROM salas WHERE tipo=1 AND bloco=? EXCEPT SELECT s.idsala, s.numero, s.bloco, s.tipo FROM salas s JOIN reservas r ON s.idsala=r.idsala AND r.periodo=? AND r.data=? WHERE tipo=1 AND bloco=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, bloco);
        st.setString(2, periodo);
        st.setString(3, data);
        st.setString(4, bloco);
        List<Sala> salas = new ArrayList();
        ResultSet rs = st.executeQuery();
        while(rs.next()) {
            int idsala = rs.getInt(1);
            int numero = rs.getInt(2);
            int tipo = rs.getInt(4);
            String bl = rs.getString(3);
            Sala s = new Sala(numero, tipo, bl, idsala);
            salas.add(s);
        }
        return salas;
    }
    
}