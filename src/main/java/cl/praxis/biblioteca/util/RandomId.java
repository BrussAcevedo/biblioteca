package cl.praxis.biblioteca.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cl.praxis.biblioteca.DAO.LibroDAO;
import cl.praxis.biblioteca.DAO.SolicitudDAO;
import cl.praxis.biblioteca.DTO.LibroDTO;
import cl.praxis.biblioteca.DTO.SolicitudDTO;

public class RandomId {

    private static final String LETRAS = "ABCDEFGHYJKLMNOPQRSTUVWXYZ";
    private static Random random = new Random();

    public static String generarIdLibro() {
        LibroDAO libroDao = new LibroDAO();
        List<LibroDTO> librosBBDD = libroDao.findAll();
        String codigoGenerado ="";
        System.out.println(librosBBDD.toString());
        for (int i = 0; i < 10; i++) { 
            codigoGenerado = construirRandom();
          
            for(LibroDTO libro : librosBBDD){
                System.out.println(codigoGenerado);
                if (!libro.getCodigo().equals(codigoGenerado)){
                   return codigoGenerado;
                }
            }
        }
        return "ERRO_NO_ID";

    }

    public static String generarIdSolicitud(LibroDTO libroSolicitud){
        String codigoLibro = libroSolicitud.getCodigo();
        SolicitudDAO solicitudDao = new SolicitudDAO();
        List<SolicitudDTO> solicitudes = new ArrayList<>();
        String codigoGenerado = null;
        StringBuilder codigoCompleto= new StringBuilder();
        
        solicitudes = solicitudDao.findAll();
        if (!solicitudes.isEmpty()){
        for (int i = 0; i<10; i++){
            codigoGenerado = construirRandom2();
            
            for (SolicitudDTO solicitud : solicitudes){
                if (!solicitud.getIdSolicitud().contains(codigoGenerado)){
                    
                    codigoCompleto.append(codigoGenerado);
                    codigoCompleto.append("-");
                    codigoCompleto.append(libroSolicitud.getCodigo());
                   return codigoCompleto.toString();
                    
                }
            }
        }

        }else{
            codigoGenerado = construirRandom2();
            codigoCompleto.append(codigoGenerado);
            codigoCompleto.append("-");
            codigoCompleto.append(libroSolicitud.getCodigo());
        }

        return codigoCompleto.toString();
    }



    public static String construirRandom() {
        StringBuilder formatoId = new StringBuilder();

        formatoId.append(letraRandom());
        formatoId.append(letraRandom());
        formatoId.append(numeroRandom());
        formatoId.append(letraRandom());
        formatoId.append(numeroRandom());
        formatoId.append(numeroRandom());
        formatoId.append(letraRandom());

        return formatoId.toString();
    }

    public static String construirRandom2() {
        StringBuilder formatoId = new StringBuilder();

        formatoId.append(letraRandom());
        formatoId.append(letraRandom());
        formatoId.append(numeroRandom());
        formatoId.append(letraRandom());

        return formatoId.toString();
    }

    public static char letraRandom() {
        int index = random.nextInt(LETRAS.length());
        return LETRAS.charAt(index);
    }

    public static char numeroRandom() {
        int index = random.nextInt(10);
        return (char) ('0' + index);
    }

}
