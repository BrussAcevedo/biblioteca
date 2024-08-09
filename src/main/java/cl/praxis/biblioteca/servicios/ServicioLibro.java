package cl.praxis.biblioteca.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import cl.praxis.biblioteca.DAO.LibroDAO;
import cl.praxis.biblioteca.DTO.LibroDTO;

@Service
public class ServicioLibro {

    LibroDAO libroDao = new LibroDAO();

    public LibroDTO findLibroByID(String idLibro) {
        LibroDTO libroVacio = new LibroDTO("NOT FOUND", "NOT FOUND", "NOT FOUND");
        List<LibroDTO> librosBBDD = libroDao.findAll();

        Optional<LibroDTO> libroEncontrado = librosBBDD.stream().filter(libro -> libro.getCodigo().equals(idLibro))
                .findFirst();
        if (libroEncontrado.isPresent()) {

            return libroEncontrado.get();
        }

        return libroVacio;

    }

    public boolean removerLibroDeLista(List<LibroDTO>lista, String id){
        int inicialSizeList = lista.size();
        
        lista.removeIf(book -> book.getCodigo().equals(id));
        int finalSizeList = lista.size();

        if (inicialSizeList > finalSizeList){
                return true;
            }    
        
        return false;
    }

    public List<LibroDTO> busuqedaLibro(List<LibroDTO> listaEntrada, String entradaBusqueda){
        List<LibroDTO>listaResultado = new ArrayList<>();
        listaResultado.clear();
        for(LibroDTO libro: listaEntrada){
            if(StringUtils.containsAnyIgnoreCase(libro.getNombre(), entradaBusqueda)|| StringUtils.containsAnyIgnoreCase(libro.getAutor(), entradaBusqueda)){
                listaResultado.add(libro);
            }
        }
        

        
        return listaResultado;
    }




}
