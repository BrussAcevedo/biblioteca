package cl.praxis.biblioteca.DTO;

import java.util.List;

public class libroVO {
    private String mensaje;
    private List<LibroDTO> listaLibros;
    private LibroDTO libro;
    public libroVO(String mensaje, List<LibroDTO> listaLibros) {
        this.mensaje = mensaje;
        this.listaLibros = listaLibros;
    }
    public libroVO(String mensaje, LibroDTO libro) {
        this.mensaje = mensaje;
        this.libro = libro;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public List<LibroDTO> getListaLibros() {
        return listaLibros;
    }
    public void setListaLibros(List<LibroDTO> listaLibros) {
        this.listaLibros = listaLibros;
    }
    public LibroDTO getLibro() {
        return libro;
    }
    public void setLibro(LibroDTO libro) {
        this.libro = libro;
    }
    @Override
    public String toString() {
        return "libroVO [mensaje=" + mensaje + ", listaLibros=" + listaLibros + ", libro=" + libro + "]";
    }


    
}
