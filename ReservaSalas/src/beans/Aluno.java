package beans;

public class Aluno extends Usuario{
    private String matricula; 
    private String semestreInicio;
    public String curso;
    
    public Aluno (String nome, String sobrenome, String dataNascimento, String CPF, String matricula, String semestreInicio, String curso){
        super (nome, sobrenome, dataNascimento, CPF);
        setMatricula(matricula);
        setSemestreInicio(semestreInicio);
        setCurso(curso);
    }
    

    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getSemestreInicio() {
        return semestreInicio;
    }    
    
    public void setSemestreInicio(String semestreInicio){
        this.semestreInicio = semestreInicio;
    }
    
    public String getCurso(){
        return curso;
    }
    
    public void setCurso(String curso){
        this.curso = curso;
    }
 
    @Override
    public String toString(){
        return this.getCPF()+" - "+this.getNome()+" "+this.getSobrenome();
    }
}
