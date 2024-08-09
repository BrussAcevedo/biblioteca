package cl.praxis.biblioteca.DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cl.praxis.biblioteca.DTO.SolicitudDTO;

public class SolicitudDAO {

    private static File fl = new File("src/main/java/cl/praxis/biblioteca/BBDD/solicitudes.txt");

    public List<SolicitudDTO> findAll() {
        List<SolicitudDTO> listaBBDD = new ArrayList<>();

        try (FileReader fr = new FileReader(fl); BufferedReader br = new BufferedReader(fr);) {
            String line;
            while ((line = br.readLine()) != null) {
                String parte[] = line.split(",");

                SolicitudDTO solicitud = new SolicitudDTO(parte[0], parte[1]);
                if (solicitud != null) {
                    listaBBDD.add(solicitud);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error. FileReader: " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("Error. BufferedReader: " + ex.getMessage());
        }
        return listaBBDD;
    }

    public void createSolicitud(SolicitudDTO solicitud) {

        try (FileWriter fw = new FileWriter(fl, true); BufferedWriter bw = new BufferedWriter(fw);) {

            bw.write(solicitud.getIdUsuario() + "," + solicitud.getIdSolicitud());
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error FileWriter: " + e.getMessage());
        }
    }

    public void deleteSolicitud(SolicitudDTO solicitud) {
        List<SolicitudDTO> solicitudesBBDD = findAll();
        
        
        solicitudesBBDD.remove(solicitud);
        System.out.println(solicitudesBBDD.toString());


        if (!solicitudesBBDD.isEmpty()) {


            Iterator<SolicitudDTO> iterator = solicitudesBBDD.iterator();
            while (iterator.hasNext()) {
                SolicitudDTO soli = iterator.next();
                if (soli.equals(solicitud)) {
                    iterator.remove();  // Elimina el objeto si coincide
                }
            }

            try (FileWriter fw = new FileWriter(fl); BufferedWriter bw = new BufferedWriter(fw);) {
                for (SolicitudDTO soli : solicitudesBBDD) {

                    bw.write(soli.getIdUsuario() + "," + soli.getIdSolicitud());
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error FileWriter: " + e.getMessage());
            }
        }
    }

}
