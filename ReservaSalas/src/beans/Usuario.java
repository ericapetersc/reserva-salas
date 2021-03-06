package beans;

public class Usuario {
    private String nome;
    private String sobrenome; 
    private String dataNascimento;
    private String CPF;
    private int tipo;
    
    public Usuario (String nome, String sobrenome, String dataNascimento, String CPF){
        setNome(nome);
        setSobrenome(sobrenome);
        setDataNascimento(dataNascimento);
        setCPF(CPF);
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
    
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public String getCPF() {
        return CPF;
    }
    
    public void setCPF(String cpf){
        this.CPF = cpf;
    }

    public int getTipo() {
        return tipo;
    }
    
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return this.getCPF()+" - "+this.getNome()+" "+this.getSobrenome();
    }
    
}