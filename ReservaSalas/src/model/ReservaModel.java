
package model;
import beans.Reserva;
import bd.*;
import beans.Sala;
import java.sql.*;
import java.util.*;


public class ReservaModel {
    
    public void insere(Reserva r) throws SQLException {
        String cmd = "INSERT INTO reservas (idsala, cpf, periodo, data) VALUES(?,?,?,?)";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(2, r.getCPF());
        st.setInt(1, r.getIdSala());
        st.setString(3, r.getPeriodo());
        st.setString(4, r.getData());
        st.executeUpdate();
    }    
    
    //precisamos garantir que o codigo de r tenha sido setado
    public void remove(Reserva r) throws SQLException {
        String cmd = "DELETE FROM reservas WHERE codigo=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setInt(1, r.getCodigo());
        st.executeUpdate();
    }
    
    public Reserva consultaUma(int codigo) throws SQLException {
        String cmd = "SELECT * FROM reservas WHERE codigo=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setInt(1, codigo);
        ResultSet rs = st.executeQuery();
        rs.next();
        Reserva r = new Reserva(rs.getString(3), rs.getInt(2), rs.getString(4), rs.getString(5));
        //cpf, idsala, periodo, data
        r.setCodigo(rs.getInt(1));
        return r;
    }
    
    public int consultaCodigoReserva(Reserva r) throws SQLException {
        String cmd = "SELECT codigo FROM reservas WHERE cpf=? AND data=? AND IdSala=? AND periodo=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, r.getCPF());
        st.setString(2, r.getData());
        st.setInt(3, r.getIdSala());
        st.setString(4, r.getPeriodo());
        ResultSet rs = st.executeQuery();
        rs.next();
        int codigo = rs.getInt(1);
        return codigo;
    }
    
    public List<Reserva> consultaTodas() throws SQLException {
        String cmd = "SELECT * FROM reservas";
        Statement st = Conexao.getSt();
        List<Reserva> reservas = new ArrayList();
        ResultSet rs = st.executeQuery(cmd);
        while(rs.next()){
            int idsala = rs.getInt(2);
            String cpf = rs.getString(3);
            String periodo = rs.getString(4);
            String data = rs.getString(5);
            Reserva r = new Reserva(cpf, idsala, periodo, data);
            r.setCodigo(rs.getInt(1));
            reservas.add(r);
        }
        return reservas;
    }
    
    public List<Reserva> consultaCpf(String cpf) throws SQLException {
        String cmd = "SELECT * FROM reservas WHERE cpf=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, cpf);
        List<Reserva> reservas = new ArrayList();
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            int idsala = rs.getInt(2);
            String periodo = rs.getString(4);
            String data = rs.getString(5);
            Reserva r = new Reserva(cpf, idsala, periodo, data);
            r.setCodigo(rs.getInt(1));
            reservas.add(r);
        }
        return reservas;
    }

    public List<Reserva> consultaIdSala(int idsala) throws SQLException {
        String cmd = "SELECT * FROM reservas WHERE idsala=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setInt(1, idsala);
        List<Reserva> reservas = new ArrayList();
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            String cpf = rs.getString(3);
            String periodo = rs.getString(4);
            String data = rs.getString(5);
            Reserva r = new Reserva(cpf, idsala, periodo, data);
            r.setCodigo(rs.getInt(1));
            reservas.add(r);
        }
        return reservas;
    }

    public List<Reserva> consultaData(String data) throws SQLException {
        String cmd = "SELECT * FROM reservas WHERE data=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, data);
        List<Reserva> reservas = new ArrayList();
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            int idsala = rs.getInt(2);
            String cpf = rs.getString(3);
            String periodo = rs.getString(4);
            Reserva r = new Reserva(cpf, idsala, periodo, data);
            r.setCodigo(rs.getInt(1));
            reservas.add(r);
        }
        return reservas;
    }

}
