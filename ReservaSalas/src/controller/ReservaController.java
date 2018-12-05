
package controller;

import beans.Reserva;
import beans.Sala;
import beans.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ReservaModel;
import model.SalaModel;
import model.UsuarioModel;
import view.ViewBuscarReserva;
import view.ViewExcluirReserva;
import view.ViewFazerReserva;
import view.ViewListarReservas;
import view.ViewListarReservasPorCPF;
import view.ViewListarReservasPorData;

public class ReservaController {
 
    ReservaModel modelReserva = new ReservaModel();
    UsuarioModel modelUsuario = new UsuarioModel();
    SalaModel modelSala = new SalaModel();
    
    public void fazReserva(){
        ViewFazerReserva view = ViewFazerReserva.getInstance();
        try {
            Sala s = modelSala.consultaUma(view.getSala(), view.getBloco());
            //Removendo mascara de data
            String data = view.RemoverBarrasDaData(view.getData());
            Reserva r = new Reserva(view.getCpf(), s.getIdSala(), view.getPeriodo(), data);
            modelReserva.insere(r);
            int codigo = modelReserva.consultaCodigoReserva(r);
            view.AvisoReservaConcluida(codigo);
            
        } catch (SQLException ex){
            view.AvisoErroNaReserva();
        }
        view.LimparTela();
    }
    
    public int ConsultaReservaExluir(){
        ViewExcluirReserva view = ViewExcluirReserva.getInstance();
        int codigo = Integer.parseInt(view.getCodigo());
        Reserva r;
        try {
            r = modelReserva.consultaUma(codigo);
            view.setCampos(r);
            return r.getIdSala();
        } catch (SQLException ex) {
            view.avisoSetCampos();
        }
        return 0;
    }
    
    public void consultarSalaExcluir(int idSala){
        ViewExcluirReserva view = ViewExcluirReserva.getInstance();
        Sala s;
        try{
            s = modelSala.consultaUmaPeloCodigo(idSala);
            view.setCamposSala(s);
        } catch (SQLException ex) {
            view.avisoSetCampos();
        }
       
    }
    
    public void excluiReserva(){
        ViewExcluirReserva view = ViewExcluirReserva.getInstance();
        Reserva r;
        try{
            r = modelReserva.consultaUma(Integer.parseInt(view.getCodigo()));
            modelReserva.remove(r);
            view.avisoExclusaoConcluida();
        } catch (SQLException ex) {
            view.avisoErroExcluir();
        }
        view.LimparTela();
    }
    
    public int consultaReserva(){
        ViewBuscarReserva view = ViewBuscarReserva.getInstance();
        int codigo = Integer.parseInt(view.getCodigo());
        Reserva r;
        try {
            r = modelReserva.consultaUma(codigo);
            view.setCampos(r);
            return r.getIdSala();
        } catch (SQLException ex) {
            view.avisoSetCampos();
        }
        return 0;
    }
    
    public void consultarSala(int idSala){
        ViewBuscarReserva view = ViewBuscarReserva.getInstance();
        Sala s;
        try{
            s = modelSala.consultaUmaPeloCodigo(idSala);
            view.setCamposSala(s);
        } catch (SQLException ex) {
            view.avisoSetCampos();
        }
    }
    
    public Sala consultarSalaListarTodasReservas (int idSala){
        Sala s;
        try{
            s = modelSala.consultaUmaPeloCodigo(idSala);
            return s;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public void listaSalas(){
        ViewFazerReserva view = ViewFazerReserva.getInstance();
        String bloco = view.getBloco();
        System.out.println(bloco);
        String periodo = view.getPeriodo();
        
        //Removendo mascara de data
        String data = view.RemoverBarrasDaData(view.getData());
        String cpf = view.getCpf();
        List<Sala> salas;
        Usuario u;
        try {
            u = modelUsuario.consultaUm(cpf);
            System.out.println(u.getTipo());
            if(u.getTipo()==0)
                salas = modelSala.consultaDisponiveisNormaisBloco(bloco, periodo, data);
            else
                salas = modelSala.consultaDisponiveisBloco(bloco, periodo, data);
            view.popularSalas(salas);
        } catch (SQLException ex) {
        }
    }
    
    public List<Reserva> listaReservas(){
        try{
            List<Reserva> lista = modelReserva.consultaTodas();
            return lista;
        } catch (SQLException ex){
        }
        return null;
    }
    
    public List<Reserva> listaReservasPorCPF(){
        ViewListarReservasPorCPF view = ViewListarReservasPorCPF.getInstance();
        try{
            List<Reserva> lista = modelReserva.consultaCpf(view.getCPF());
            return lista;
        }catch (SQLException ex){
        }
        return null;
    }
    
    public List<Reserva> listaReservasPorData(String data){
        ViewListarReservasPorData view = ViewListarReservasPorData.getInstance();
        try{
            List<Reserva> lista = modelReserva.consultaData(data);
            return lista;
        }catch (SQLException ex){
        }
        return null;
    }
    
    public List<Reserva> listaReservasPorSala(int idSala){
        ViewListarReservasPorData view = ViewListarReservasPorData.getInstance();
        try{
            List<Reserva> lista = modelReserva.consultaIdSala(idSala);
            return lista;
        }catch (SQLException ex){
        }
        return null;
    }
}
