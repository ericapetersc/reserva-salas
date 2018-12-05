
package controller;
import beans.Servidor;
import java.sql.SQLException;
import java.util.List;
import model.ServidorModel;
import view.ViewAlterarServidor;
import view.ViewBuscarServidor;
import view.ViewCadastrarServidor;
import view.ViewExcluirServidor;

public class ServidorController {
   
    ServidorModel model = new ServidorModel();
    
    public void cadastraServidor(){
        ViewCadastrarServidor view = ViewCadastrarServidor.getInstance();
        if(view.verificaCampos()==false)
            view.AvisoCampos();
        else{
            //Removendo mascara antes de enviar para o banco
            String cpfSemTracosEPonto = view.RemoverTracosEPontosDoCpf(view.getCpf());
            String dataSemBarra = view.RemoverBarrasDoNascimento(view.getNascimento());
            
            Servidor s = new Servidor(view.getNome(), view.getSobrenome(), dataSemBarra, cpfSemTracosEPonto, view.getId(), view.getCargo());
            try{
                model.insere(s);
            view.AvisoCadastroConcluido();
            }catch(Exception e){
                view.AvisoErroNoCadastro();
                System.out.println(e);
            }
            view.LimparTela();
        }
    }
    
    public void alteraServidor(){
        ViewAlterarServidor view = ViewAlterarServidor.getInstance();
        if(view.verificaCampos()==false)
            view.AvisoCampos();
        else{
            //Tirando a mascara antes de enviar para o banco
            String dataSemBarra = view.RemoverBarrasDoNascimento(view.getNascimento());
            
            Servidor s = new Servidor(view.getNome(), view.getSobrenome(), dataSemBarra, view.getCpf(), view.getId(), view.getCargo());
            try{
                model.altera(s);
                view.AvisoAlteracaoConcluida();
            }catch(Exception e){
                view.avisoErroNaAlteracao();
                System.out.println(e);
            }
            view.LimparTela();
        }
    }
    
    public void excluiServidor(){
        ViewExcluirServidor view = ViewExcluirServidor.getInstance();
        Servidor s;
        try {
            s = model.consultaUm(view.getCpf());
            model.remove(s);
            view.avisoExclusaoConcluida();
        } catch (SQLException ex) {
            view.avisoErroExcluir();
        }
        view.LimparTela();
    }
    
    public void consultaServidorAlterar(){
        ViewAlterarServidor view = ViewAlterarServidor.getInstance();
        String cpf = view.getCpf();
        Servidor s;
        try {
            s = model.consultaUm(cpf);
            view.setCampos(s);
        } catch (SQLException ex) {
            view.avisoSetCampos();
        }
    }
    
    public void consultaServidorBuscar(){
        ViewBuscarServidor view = ViewBuscarServidor.getInstance();
        String cpf = view.getCpf();
        Servidor s;
        try {
            s = model.consultaUm(cpf);
            view.setCampos(s);
        } catch (SQLException ex) {
            view.avisoSetCampos();
        }
    }
    
    public void consultaServidorExcluir(){
        ViewExcluirServidor view = ViewExcluirServidor.getInstance();
        String cpf = view.getCpf();
        Servidor s;
        try {
            s = model.consultaUm(cpf);
            view.setCampos(s);
        } catch (SQLException ex) {
            view.avisoSetCampos();
        }
    }
    
    public List<Servidor> listaCpf(){
        try {
            List<Servidor> lista = model.consultaTodos();
            return lista;
        } catch (SQLException ex) {
        }
        return null;
    }
    
}
