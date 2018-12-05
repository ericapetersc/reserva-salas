package model;
import bd.*;
import beans.Servidor;
import java.sql.*;
import java.util.*;


public class ServidorModel {
    
    public void insere(Servidor s) throws SQLException {
        String cmd = "INSERT INTO usuarios (cpf, nome, sobrenome, datanascimento, tipo, idservidor, cargo) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, s.getCPF());
        st.setString(2, s.getNome());
        st.setString(3, s.getSobrenome());
        st.setString(4, s.getDataNascimento());
        st.setInt(5, 2);
        st.setString(6, s.getIdentificacao());
        st.setString(7, s.getCargo());
        st.executeUpdate();
    }
    
    public void altera(Servidor s) throws SQLException {
        String cmd = "UPDATE usuarios SET nome=?, sobrenome=?, datanascimento=?, tipo=?, idservidor=?, cargo=? WHERE cpf=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, s.getNome());
        st.setString(2, s.getSobrenome());
        st.setString(3, s.getDataNascimento());
        st.setInt(4, 2);
        st.setString(5, s.getIdentificacao());
        st.setString(6, s.getCargo());
        st.setString(7, s.getCPF());
        st.executeUpdate();
    }
    
    public void remove(Servidor s) throws SQLException {
        String cmd = "DELETE FROM usuarios WHERE cpf=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, s.getCPF());
        st.executeUpdate();
    }
    
    public Servidor consultaUm(String cpf) throws SQLException {
        String cmd = "SELECT nome, sobrenome, datanascimento, idservidor, cargo FROM usuarios WHERE tipo=2 AND cpf=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, cpf);
        ResultSet rs = st.executeQuery();
        rs.next();
        String nome = rs.getString(1);
        String sobrenome = rs.getString(2);
        String datanascimento = rs.getString(3);
        String idservidor = rs.getString(4);
        String cargo = rs.getString(5);
        Servidor s = new Servidor(nome, sobrenome, datanascimento, cpf, idservidor, cargo);
        s.setTipo(2);
        return s;
    }
    
    public List<Servidor> consultaTodos() throws SQLException {
        String cmd = "SELECT cpf, nome, sobrenome, datanascimento, idservidor, cargo FROM usuarios WHERE tipo=2";
        Statement st = Conexao.getSt();
        List<Servidor> servidores = new ArrayList();
        ResultSet rs = st.executeQuery(cmd);
        while(rs.next()) {
            String cpf = rs.getString(1);
            String nome = rs.getString(2);
            String sobrenome = rs.getString(3);
            String datanascimento = rs.getString(4);
            String idservidor = rs.getString(5);
            String cargo = rs.getString(6);
            Servidor s = new Servidor(nome, sobrenome, datanascimento, cpf, idservidor, cargo);
            s.setTipo(2);
            servidores.add(s);
        }
        return servidores;
    }
    
}
