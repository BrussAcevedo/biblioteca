package cl.praxis.biblioteca.DTO;

public class LibroDTO {
    private String nombre;
    private String codigo;
    private String autor;
    private String img;

    public LibroDTO(String nombre, String codigo, String autor, String img){
        this.nombre = nombre;
        this.codigo = codigo;
        this.autor = autor;
        this.img = img;
    }

    public LibroDTO(String nombre, String codigo, String autor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "LibroDTO [nombre=" + nombre + ", codigo=" + codigo + ", autor=" + autor + ", img=" + img + "]";
    }



    
}
