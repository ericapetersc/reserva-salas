package model;

import bd.Conexao;
import beans.Aluno;
import beans.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UsuarioModel {
    
    public List<Usuario> consultaTodos() throws SQLException {
        String cmd = "SELECT cpf, nome, sobrenome, datanascimento, tipo FROM usuarios";
        Statement st = Conexao.getSt();
        List<Usuario> usuarios = new ArrayList();
        ResultSet rs = st.executeQuery(cmd);
        while(rs.next()) {
            String cpf = rs.getString(1);
            String nome = rs.getString(2);
            String sobrenome = rs.getString(3);
            String datanascimento = rs.getString(4);
            Usuario u = new Usuario(nome, sobrenome, datanascimento, cpf);
            u.setTipo(rs.getInt(5));
            usuarios.add(u);
        }
        return usuarios;
    }
    
    public Usuario consultaUm(String cpf) throws SQLException {
        String cmd = "SELECT nome, sobrenome, datanascimento, tipo FROM usuarios WHERE cpf=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, cpf);
        ResultSet rs = st.executeQuery();
        rs.next();
        String nome = rs.getString(1);
        String sobrenome = rs.getString(2);
        String datanascimento = rs.getString(3);
        Usuario u = new Usuario (nome, sobrenome, datanascimento, cpf);
        u.setTipo(rs.getInt(4));
        return u;
    }
    
    public List<Aluno> consultaAlunosMestrandos() throws SQLException {
        String cmd = "SELECT cpf, nome, sobrenome, datanascimento, matricula, semestre, curso, tipo FROM usuarios WHERE tipo=0 OR tipo=1";
        Statement st = Conexao.getSt();
        List<Aluno> alunos = new ArrayList();
        ResultSet rs = st.executeQuery(cmd);
        while(rs.next()) {
            String cpf = rs.getString(1);
            String nome = rs.getString(2);
            String sobrenome = rs.getString(3);
            String datanascimento = rs.getString(4);
            String matricula = rs.getString(5);
            String semestre = rs.getString(6);
            String curso = rs.getString(7);
            Aluno al = new Aluno (nome, sobrenome, datanascimento, cpf, matricula, semestre, curso);
            al.setTipo(rs.getInt(8));
            alunos.add(al);
        }
        return alunos;
    }
    
    public Aluno consultaUmAlunoMestrando(String cpf) throws SQLException {
        String cmd = "SELECT nome, sobrenome, datanascimento, matricula, semestre, curso, tipo FROM usuarios WHERE cpf=? AND (tipo=0 OR tipo=1)";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, cpf);
        ResultSet rs = st.executeQuery();
        rs.next();
        String nome = rs.getString(1);
        String sobrenome = rs.getString(2);
        String datanascimento = rs.getString(3);
        String matricula = rs.getString(4);
        String semestre = rs.getString(5);
        String curso = rs.getString(6);
        Aluno al = new Aluno (nome, sobrenome, datanascimento, cpf, matricula, semestre, curso);
        al.setTipo(rs.getInt(7));
        return al;
    }
    
}
