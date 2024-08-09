package cl.praxis.biblioteca.DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.biblioteca.DTO.LibroDTO;

public class LibroDAO {

    File file = new File("src/main/java/cl/praxis/biblioteca/BBDD/libros.txt");

    public List<LibroDTO> findAll() {
        List<LibroDTO> librosBBDD = new ArrayList<>();

        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parte = line.split(",");

                LibroDTO libro = new LibroDTO(parte[0], parte[1], parte[2]);
                if (libro != null) {
                    librosBBDD.add(libro);
                }
            }

        } catch (IOException ex) {
            System.out.println("Error al leer el archivo: " + ex.getMessage());
        }
        return librosBBDD;
    }

    public void createLibro(LibroDTO libroNuevo) {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8");
             BufferedWriter bw = new BufferedWriter(osw)) {

            bw.write(libroNuevo.getNombre() + "," + libroNuevo.getCodigo() + "," + libroNuevo.getAutor());
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void updateLibro(LibroDTO libroActualizado) {
        List<LibroDTO> libros = findAll();

        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
             BufferedWriter bw = new BufferedWriter(osw)) {

            for (LibroDTO libro : libros) {
                if (libro.getCodigo().equals(libroActualizado.getCodigo())) {
                    libro.setAutor(libroActualizado.getAutor());
                    libro.setCodigo(libroActualizado.getCodigo());
                    libro.setNombre(libroActualizado.getNombre());
                    if (libroActualizado.getImg() != null){
                        libro.setImg(libroActualizado.getImg());
                    }
                }
                bw.write(libro.getNombre() + "," + libro.getCodigo() + "," + libro.getAutor());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

}
