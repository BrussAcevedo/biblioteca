package cl.praxis.biblioteca.DAO;

import java.util.ArrayList;
import java.util.List;

import cl.praxis.biblioteca.DTO.LibroDTO;

public class LibroDAO {


    public List<LibroDTO> findAll(){
        List<LibroDTO>librosBBDD = new ArrayList<>();

        LibroDTO libro1 = new LibroDTO("La casa de los espíritus", "01A25S", "Isabel Allende");
        LibroDTO libro2 = new LibroDTO("Hijo de ladrón", "02B34T", "Manuel Rojas");
        LibroDTO libro3 = new LibroDTO("El obsceno pájaro de la noche", "03C45U", "José Donoso");
        LibroDTO libro4 = new LibroDTO("Santa María de las flores negras", "04D56V", "Hernán Rivera Letelier");
        LibroDTO libro5 = new LibroDTO("El lugar sin límites", "05E67W", "José Donoso");
        LibroDTO libro6 = new LibroDTO("Coronación", "06F78X", "José Donoso");
        LibroDTO libro7 = new LibroDTO("Donde vuelan los cóndores", "07G89Y", "Francisco Coloane");
        LibroDTO libro8 = new LibroDTO("La Reina Isabel cantaba rancheras", "08H90Z", "Hernán Rivera Letelier");
        LibroDTO libro9 = new LibroDTO("La muerte y la doncella", "09I01A", "Ariel Dorfman");
        LibroDTO libro10 = new LibroDTO("Cien años de soledad", "10J12B", "Gabriel García Márquez");

        librosBBDD.add(libro1);
        librosBBDD.add(libro2);
        librosBBDD.add(libro3);
        librosBBDD.add(libro4);
        librosBBDD.add(libro5);
        librosBBDD.add(libro6);
        librosBBDD.add(libro7);
        librosBBDD.add(libro8);
        librosBBDD.add(libro9);
        librosBBDD.add(libro10);

        
        
        return librosBBDD;
    }

}
