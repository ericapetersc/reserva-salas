package beans;

public class Servidor extends Usuario{
    private String identificacao;
    private String cargo;
    
    public Servidor (String nome, String sobrenome, String dataNascimento, String CPF, String id, String cargo){
        super (nome, sobrenome, dataNascimento, CPF);
        setIdentificacao(id);
        setCargo(cargo);
    }

    public String getIdentificacao() {
        return identificacao;
    }
    
    public void setIdentificacao(String id){
        this.identificacao = id;
    }
    
    public String getCargo(){
        return this.cargo;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    @Override
    public String toString(){
        return this.getCPF()+" - "+this.getNome()+" "+this.getSobrenome();
    }
    
}
