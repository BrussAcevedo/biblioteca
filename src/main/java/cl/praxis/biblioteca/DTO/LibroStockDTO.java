package cl.praxis.biblioteca.DTO;

public class LibroStockDTO {

    private String idLibro;
    private Integer stock;
    
    public LibroStockDTO(String idLibro, Integer stock) {
        this.idLibro = idLibro;
        this.stock = stock;
    }
    public String getIdLibro() {
        return idLibro;
    }
    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    @Override
    public String toString() {
        return "LibroStockDTO [idLibro=" + idLibro + ", stock=" + stock + "]";
    }
    
}
