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

import cl.praxis.biblioteca.DTO.UsuarioDTO;

public class UsuarioDAO {

    File fl = new File("src/main/java/cl/praxis/biblioteca/BBDD/usuarios.txt");

    public List<UsuarioDTO> findAll (){
        List<UsuarioDTO> usuariosBBDD = new ArrayList<>();
        try (FileReader fr = new FileReader(fl);  BufferedReader br = new BufferedReader(fr);){
            String line = null;
            while((line = br.readLine())!=null){
                String parte [] = line.split(",");
               
                if (parte.length ==3){
                    UsuarioDTO usuario = new UsuarioDTO(parte[0], parte[1], parte[2]);
                    usuariosBBDD.add(usuario);
                }

            }
           
        } catch (FileNotFoundException e) {
            System.out.println("Error. FileReader: "+e.getMessage());
        } catch (IOException ex) {
            System.out.println("Error. BufferedReader: "+ex.getMessage());
        }
        
       

        return usuariosBBDD;

    }


    public void createUsuario (UsuarioDTO nuevoUsuario){
      
        try (FileWriter fw = new FileWriter(fl, true); BufferedWriter bw = new BufferedWriter(fw);){
            bw.write(nuevoUsuario.getPassword()+","+nuevoUsuario.getNombreUsuario()+","+nuevoUsuario.getIdUsuario());
            bw.newLine();
            
        } catch (IOException e) {
         
            System.out.println("Error FileWriter: "+e.getMessage());
        }
        
    }

}
