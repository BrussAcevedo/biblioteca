package cl.praxis.biblioteca.servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cl.praxis.biblioteca.DAO.LibroStockDAO;
import cl.praxis.biblioteca.DTO.LibroStockDTO;
import cl.praxis.biblioteca.DTO.LibroStockVO;
@Service
public class ServicioLibroStock {

    private LibroStockDAO stockDAO  = new LibroStockDAO();
    Map <String, Integer> mapeoLibroStock = new HashMap<>();
    LibroStockVO stockMapeado = new LibroStockVO("No fue posible realizar el Mapeo.");

    public LibroStockVO listaStock (){

        List<LibroStockDTO> listaStock =  stockDAO.findAll();
        
        if (!listaStock.isEmpty()){

            for (LibroStockDTO stock : listaStock){
                mapeoLibroStock.put(stock.getIdLibro(), stock.getStock());
            }  
        }
        if (!mapeoLibroStock.isEmpty()){
            stockMapeado = new LibroStockVO("Mapeo Realizado con éxito", mapeoLibroStock);
        }
        
        return stockMapeado;
    }



     public LibroStockVO findById(String idSoliciud){
        List<LibroStockDTO> listaStock = stockDAO.findAll();
        LibroStockVO stockNoEncontrado = new LibroStockVO("IdLibro No Encontrado");

        if (!listaStock.isEmpty()){
            for (LibroStockDTO stock : listaStock){
                if (stock.getIdLibro().equals(idSoliciud)){
                    LibroStockVO stockEncontrado = new LibroStockVO("Id Libro y Stock Encontrado", stock);
                    return stockEncontrado;
                }    
            }
        }
        return stockNoEncontrado;
    }

}
