package model;
import beans.Aluno;
import bd.*;
import java.sql.*;
import java.util.*;

public class AlunoModel {
    
    public void insere(Aluno a) throws SQLException {
        String cmd = "INSERT INTO usuarios (cpf, nome, sobrenome, datanascimento, tipo, matricula, semestre, curso) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, a.getCPF());
        st.setString(2, a.getNome());
        st.setString(3, a.getSobrenome());
        st.setString(4, a.getDataNascimento());
        st.setInt(5, 0);
        st.setString(6, a.getMatricula());
        st.setString(7, a.getSemestreInicio());
        st.setString(8, a.getCurso());
        st.executeUpdate();
    }
    
    public void altera(Aluno a) throws SQLException {
        String cmd = "UPDATE usuarios SET nome=?, sobrenome=?, datanascimento=?, tipo=?, matricula=?, semestre=?, curso=? WHERE cpf=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, a.getNome());
        st.setString(2, a.getSobrenome());
        st.setString(3, a.getDataNascimento());
        st.setInt(4, 0);
        st.setString(5, a.getMatricula());
        st.setString(6, a.getSemestreInicio());
        st.setString(7, a.getCurso());
        st.setString(8, a.getCPF());
        st.executeUpdate();
    }
    
    public void remove(Aluno a) throws SQLException {
        String cmd = "DELETE FROM usuarios WHERE cpf=?";
        PreparedStatement st = Conexao.getCon().prepareStatement(cmd);
        st.setString(1, a.getCPF());
        st.executeUpdate();
    }
    
    public Aluno consultaUm(String cpf) throws SQLException {
        String cmd = "SELECT nome, sobrenome, datanascimento, matricula, semestre, curso, tipo FROM usuarios WHERE tipo=0 AND cpf=?";
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
    
    public List<Aluno> consultaTodos() throws SQLException {
        String cmd = "SELECT cpf, nome, sobrenome, datanascimento, matricula, semestre, curso, tipo FROM usuarios WHERE tipo=0";
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
            al.setTipo(8);
            alunos.add(al);
        }
        return alunos;
    }
    
}
