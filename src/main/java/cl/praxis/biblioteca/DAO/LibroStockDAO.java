package cl.praxis.biblioteca.DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.biblioteca.DTO.LibroStockDTO;

public class LibroStockDAO {
    
    private static File fl = new File("src/main/java/cl/praxis/biblioteca/BBDD/librosStock.txt");

    public List<LibroStockDTO> findAll(){
        List<LibroStockDTO>listaStock = new ArrayList<>();
    
        try (FileReader fr = new FileReader(fl); BufferedReader br = new BufferedReader(fr);) {
            String line = null;
            while ( (line=br.readLine()) != null){         

                String parte [] =line.split(",");
                if(parte.length==2){
                    LibroStockDTO stock = new LibroStockDTO(parte[0], Integer.valueOf(parte[1]));
                    listaStock.add(stock);
                }       
            }


        } catch (FileNotFoundException e) {
            System.out.println("Error. FileReader: "+e.getMessage());
        } catch (IOException ex) {
            System.out.println("Error. BufferedReader: "+ex.getMessage());
        }
        return listaStock;
    }


    public void createStock(LibroStockDTO nuevoStock){
        try (FileWriter fw = new FileWriter(fl, true);BufferedWriter bw = new BufferedWriter(fw);){
            
            bw.write(nuevoStock.getIdLibro()+","+ String.valueOf(nuevoStock.getStock()));
            bw.newLine();

        } catch (IOException e) {
         
            System.out.println("Error FileWriter: "+e.getMessage());
        }
    }

    public void updateStock (LibroStockDTO actualizaLibroStockDTO){
        List<LibroStockDTO> stocksBBDD = findAll();
        try (FileWriter fw = new FileWriter(fl); BufferedWriter bw = new BufferedWriter(fw);){
                 
        for (LibroStockDTO stock : stocksBBDD){
            
            if (stock.getIdLibro().equals(actualizaLibroStockDTO.getIdLibro())){
                stock.setIdLibro(actualizaLibroStockDTO.getIdLibro());
                stock.setStock(actualizaLibroStockDTO.getStock());
            }
            bw.write(stock.getIdLibro()+","+stock.getStock());
            bw.newLine();
         
            }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

}
