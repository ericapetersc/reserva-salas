package controller;

import beans.Aluno;
import java.sql.SQLException;
import java.util.List;
import model.AlunoModel;
import model.MestrandoModel;
import model.UsuarioModel;
import view.ViewAlterarAluno;
import view.ViewBuscarAluno;
import view.ViewCadastrarAluno;
import view.ViewExcluirAluno;


public class AlunoController {
    
    UsuarioModel modelUsuario = new UsuarioModel();
    AlunoModel modelAluno = new AlunoModel();
    MestrandoModel modelMestrando = new MestrandoModel();
    
    
    public void cadastraAluno(){
        ViewCadastrarAluno view = ViewCadastrarAluno.getInstance();
        if(view.verificaCampos()==false)
            view.AvisoCampos();
        if(view.verificaCurso()==false)
            view.AvisoCurso();
        else{
            //Removendo mascaras antes de mandar para o BD
            String cpfSemTracosEPonto = view.RemoverTracosEPontosDoCpf(view.getCpf());
            String dataSemBarra = view.RemoverBarrasDoNascimento(view.getNascimento());
            String semestreInicioSemBarra =  view.RemoverBarrasDoSemestreInicio(view.getSemestre());
            
            Aluno a = new Aluno(view.getNome(), view.getSobrenome(), dataSemBarra, cpfSemTracosEPonto, view.getMatricula(), semestreInicioSemBarra, view.getCurso());
            try{
                if(view.getFormacao().equals("Graduando"))
                    modelAluno.insere(a);
                else
                    modelMestrando.insere(a);
            view.AvisoCadastroConcluido();
            }catch(Exception e){
                view.AvisoErroNoCadastro();
                System.out.println(e);
            }
            view.LimparTela();
        }
    }
    
    public void alteraAluno(){
        ViewAlterarAluno view = ViewAlterarAluno.getInstance();
        if(view.verificaCampos()==false)
            view.AvisoCampos();
        if(view.verificaCurso()==false)
            view.AvisoCurso();
        else{
            //Removendo mascara antes de enviar para o banco
            String dataSemBarra = view.RemoverBarrasDoNascimento(view.getNascimento());
            String semestreInicioSemBarra =  view.RemoverBarrasDoSemestreInicio(view.getSemestre());
            
            Aluno a = new Aluno(view.getNome(), view.getSobrenome(), dataSemBarra, view.getCpf(), view.getMatricula(), semestreInicioSemBarra, view.getCurso());
            try{
                if(view.getFormacao().equals("Graduando"))
                    modelAluno.altera(a);
                else
                    modelMestrando.altera(a);
            view.AvisoAlteracaoConcluida();
            }catch(Exception e){
                view.avisoErroNaAlteracao();
                System.out.println(e);
            }
            view.LimparTela();
        }
    }
    
    public void excluiAluno(){
        ViewExcluirAluno view = ViewExcluirAluno.getInstance();
        Aluno a;
        try {
            a = modelUsuario.consultaUmAlunoMestrando(view.getCpf());
            modelAluno.remove(a);
            view.avisoExclusaoConcluida();
        } catch (SQLException ex) {
            view.avisoErroExcluir();
        }
        view.LimparTela();
    }
    
    public void consultaAlunoExcluir(){
        ViewExcluirAluno view = ViewExcluirAluno.getInstance();
        String cpf = view.getCpf();
        Aluno a;
        try {
            a = modelUsuario.consultaUmAlunoMestrando(cpf);
            view.setCampos(a);
        } catch (SQLException ex) {
            view.avisoSetCampos();
        }
    }
    
    public void consultaAlunoBuscar(){
        ViewBuscarAluno view = ViewBuscarAluno.getInstance();
        String cpf = view.getCpf();
        Aluno a;
        try {
            a = modelUsuario.consultaUmAlunoMestrando(cpf);
            view.setCampos(a);
        } catch (SQLException ex) {
            view.avisoSetCampos();
        }
    }
    
    public void consultaAlunoAlterar(){
        ViewAlterarAluno view = ViewAlterarAluno.getInstance();
        String cpf = view.getCpf();
        Aluno a;
        try {
            a = modelUsuario.consultaUmAlunoMestrando(cpf);
            view.setCampos(a);
        } catch (SQLException ex) {
            view.avisoSetCampos();
        }
    }
    
    public List<Aluno> listaCpf(){
        try {
            List<Aluno> lista = modelUsuario.consultaAlunosMestrandos();
            return lista;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public int tipoAluno(String cpf){
        try {
            Aluno a = modelUsuario.consultaUmAlunoMestrando(cpf);
            int tipo = a.getTipo();
            return tipo;
        } catch (SQLException ex) {
        }
        return -1;
    }
}
