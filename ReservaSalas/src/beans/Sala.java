package beans;


public class Sala {
    private int numero;
    private int tipo;//1 - normal; 0 - laboratório
    private String bloco;
    private int idsala;
    
    public Sala(int numero, int tipo, String bloco, int idsala){
        setNumero(numero);
        setTipo(tipo);
        setBloco(bloco);
        setIdSala(idsala);
    }
    
    public int getNumero(){
        return numero;
    }
    
    public void setNumero(int n){
        this.numero = n;
    }
    
    public int getTipo(){
        return tipo;
    }
    
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
    
    public String getBloco(){
        return bloco;
    }
    
    public void setBloco(String bloco){
        this.bloco = bloco;
    }
    
    public int getIdSala(){
        return idsala;
    }
    
    public void setIdSala(int idsala){
        this.idsala = idsala;
    }
    
    @Override
    public String toString(){
        return idsala+" - "+bloco+""+numero+" tipo "+tipo;
    }
    
}
