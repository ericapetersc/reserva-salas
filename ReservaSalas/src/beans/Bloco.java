package beans;

public class Bloco {
    private String letra;
    private int numeroSalas;
    
    public Bloco(String letra, int numeroSalas){
        setLetra(letra);
        setNumeroSalas(numeroSalas);
    }
    
    public String getLetra(){
        return letra;
    }
    
    public void setLetra(String letra){
        this.letra = letra;
    }
    
    public int getNumeroSalas(){
        return numeroSalas;
    }
    
    public void setNumeroSalas(int numerosSalas){
        this.numeroSalas = numerosSalas;
    }
    
    @Override
    public String toString(){
        return "Bloco "+letra;
    }
}
