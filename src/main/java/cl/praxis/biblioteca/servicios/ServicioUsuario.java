package cl.praxis.biblioteca.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.praxis.biblioteca.DAO.UsuarioDAO;
import cl.praxis.biblioteca.DTO.UsuarioDTO;


@Service
public class ServicioUsuario {


    private UsuarioDAO usuarioDao = new UsuarioDAO();

    public boolean validarPassword (String nombreUsuario, String password){
        
        List<UsuarioDTO> usuariosBBDD = usuarioDao.findAll();

        for (UsuarioDTO usuario : usuariosBBDD) {
            
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getPassword().equals(password)){
                return true;
            }        
        }
        
        return false;
    }

}
