
package controller;

import beans.Sala;
import java.sql.SQLException;
import java.util.List;
import model.SalaModel;

public class SalaController {
    
    SalaModel model = new SalaModel();
    
    public List<Sala> listaTodas(){
        try {
            List<Sala> lista = model.consultaTodas();
            return lista;
        } catch (SQLException ex) {
        }
        return null;
    }
}
