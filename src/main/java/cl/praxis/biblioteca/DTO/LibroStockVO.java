package cl.praxis.biblioteca.DTO;

import java.util.Map;

public class LibroStockVO {
    private String mensaje;
    private Map <String, Integer> idLibroStock;
    private LibroStockDTO stock;

    
    public LibroStockVO(String mensaje) {
        this.mensaje = mensaje;
    }
    public LibroStockVO(String mensaje, Map<String, Integer> idLibroStock) {
        this.mensaje = mensaje;
        this.idLibroStock = idLibroStock;
    }
    public LibroStockVO(String mensaje, LibroStockDTO stock) {
        this.mensaje = mensaje;
        this.stock = stock;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public Map<String, Integer> getIdLibroStock() {
        return idLibroStock;
    }
    public void setIdLibroStock(Map<String, Integer> idLibroStock) {
        this.idLibroStock = idLibroStock;
    }
    public LibroStockDTO getStock() {
        return stock;
    }
    public void setStock(LibroStockDTO stock) {
        this.stock = stock;
    }
    @Override
    public String toString() {
        return "LibroStockVO [mensaje=" + mensaje + ", idLibroStock=" + idLibroStock + ", stock=" + stock + "]";
    }


    


    
}
