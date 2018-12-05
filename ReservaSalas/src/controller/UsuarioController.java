
package controller;

import beans.Usuario;
import java.sql.SQLException;
import java.util.List;
import model.UsuarioModel;

public class UsuarioController {
    
    UsuarioModel model = new UsuarioModel();
    
    public List<Usuario> listaTodos(){
        try {
            List<Usuario> lista = model.consultaTodos();
            return lista;
        } catch (SQLException ex) {
        }
        return null;
    }
    
}
