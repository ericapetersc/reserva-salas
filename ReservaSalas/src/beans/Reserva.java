
package beans;


public class Reserva {
    private String cpf;
    private int idsala;
    private String periodo;
    private String data;
    private int codigo;

    public Reserva(String cpf, int idsala, String periodo, String data){
        setCPF(cpf);
        setIdSala(idsala);
        setPeriodo(periodo);
        setData(data);
    }
    
    public Reserva(){};
    
    public int getIdSala(){
        return idsala;
    }
    
    public void setIdSala(int idsala){
        this.idsala = idsala;
    }
    
    public String getPeriodo(){
        return periodo;
    }
    
    public void setPeriodo(String periodo){
        this.periodo = periodo;
    }
    
    public String getData(){
        return data;
    }
    
    public void setData(String data){
        this.data = data;
    }
    
    public String getCPF(){
        return cpf;
    }
    
    public void setCPF(String cpf){
        this.cpf = cpf;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    @Override
    public String toString(){
        return this.getCodigo()+" - "+"Sala cod. "+this.getCodigo()+" reservada pelo cpf "+this.getCPF()+" em "+this.getData()+" "+this.getPeriodo()+".";
    }
}
