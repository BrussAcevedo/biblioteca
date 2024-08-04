package cl.praxis.biblioteca.DAO;

import java.util.ArrayList;
import java.util.List;

import cl.praxis.biblioteca.DTO.UsuarioDTO;

public class UsuarioDAO {


    public List<UsuarioDTO> findAll (){
        List<UsuarioDTO> usuariosBBDD = new ArrayList<>();

        UsuarioDTO usuario1 = new UsuarioDTO("usuario", "123456");
        usuariosBBDD.add(usuario1);


        return usuariosBBDD;

    }

}
