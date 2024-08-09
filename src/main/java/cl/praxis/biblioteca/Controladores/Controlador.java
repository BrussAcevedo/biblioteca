package cl.praxis.biblioteca.Controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.praxis.biblioteca.DAO.LibroDAO;
import cl.praxis.biblioteca.DTO.LibroDTO;
import cl.praxis.biblioteca.DTO.LibroStockVO;
import cl.praxis.biblioteca.servicios.ServicioLibro;
import cl.praxis.biblioteca.servicios.ServicioLibroStock;
import cl.praxis.biblioteca.servicios.ServicioUsuario;
import jakarta.servlet.http.HttpSession;






@Controller
public class Controlador {

    @Autowired
    private ServicioLibro servicioLibro;

    @Autowired
    private ServicioUsuario servicioUsuario;

    @Autowired
    private ServicioLibroStock servicioStock;

    List<LibroDTO> carritoTemp = new ArrayList<>();

    private Logger logger = LoggerFactory.getLogger("");
    
    @GetMapping("/")
    public String inicio() {
        return "loggin";
    }

    @PostMapping("/validateLoggin")
    public String postMethodName(@RequestParam String nombreUsuarioTxt, @RequestParam String passwordTxt, HttpSession session, Model model) {
        boolean validacion = servicioUsuario.validarPassword(nombreUsuarioTxt, passwordTxt);

        if (validacion == true) {
            logger.info("Correo y contraseña Validas");
            session.setAttribute("nombreUsuarioTxt", nombreUsuarioTxt);
            return "redirect:/listadoLibros";
             };
             
             String errorLoggin = "Credenciasles incorrectas.";
                logger.warn(errorLoggin);
             model.addAttribute("errorMensaje", errorLoggin);
        return "loggin";
             
    }

    

    @GetMapping("/agregarACarrito")
    public String agregarALista(@RequestParam String libroIdTxt) {
        LibroDTO nuevoLibro = servicioLibro.findLibroByID(libroIdTxt);
        carritoTemp.add(nuevoLibro);
        logger.info("Nuevo Libro Agregado al carrito");
      
        return "redirect:/listadoLibros";
    }


    @GetMapping("/listadoLibros")
    public String listadoLibro(Model model, HttpSession session) {
        session.getAttribute("nombreUsuarioTxt");


        LibroDAO librosBBDD = new LibroDAO();
        List<LibroDTO> listaLibros = librosBBDD.findAll();
        LibroStockVO stockLibros = servicioStock.listaStock();
        Map<String, Integer> mapeoStock = stockLibros.getIdLibroStock();
        model.addAttribute("mapStock", mapeoStock);
        model.addAttribute("listaLibros", listaLibros);
        model.addAttribute("listaCarrito", carritoTemp);
      

        logger.info("listados enviados a galeria libros");

        return "galeriaLibros"; 
        
    }
    
    

    @GetMapping("/verLibro")
    public String detallesLibro(@RequestParam String libroIdTxt, Model model) {
        LibroDTO libroSelect = servicioLibro.findLibroByID(libroIdTxt);

        LibroStockVO stockLibros = servicioStock.listaStock();
        Map<String, Integer> mapeoStock = stockLibros.getIdLibroStock();
        
        model.addAttribute("mapStock", mapeoStock);
        model.addAttribute("libroSeleccionado", libroSelect);
        model.addAttribute("listaCarrito", carritoTemp);
        
        logger.info("Libro enviado a vista libroSeleccionado: " + libroSelect.toString());
        return "libroSeleccionado";
    }

   
    @GetMapping("/verCarrito")
    public String verCarrito(HttpSession session, Model model) {

        model.addAttribute("listaCarrito", carritoTemp);
    
        logger.info("Lista Carrito a vista prestacion");
  
        return "prestacion";
        
    }

    @PostMapping("/eliminarDelCarrito")
    public String postMethodName(@RequestParam String libroIdTxt) {
        boolean estado = servicioLibro.removerLibroDeLista(carritoTemp, libroIdTxt);  
        
        if(estado==true){
            logger.info("Libro eliminado ID: "+libroIdTxt);
        }else{
            logger.warn("No se ha podido eliminar libro ID: " +libroIdTxt);
        }
        
        return "redirect:/verCarrito";
    }
    
    @GetMapping("/enviarSolicitud")
    public String enviarSolicitud(RedirectAttributes redirectAttributes) {
        Random random = new Random();
        int codigoSolicitud = random.nextInt(10000);
        carritoTemp.clear();
        redirectAttributes.addFlashAttribute("codigoSolicitud", codigoSolicitud);

        logger.info("Solicitud enviada y lista Carrito vaciada.");
        return "redirect:/verCarrito";
    }
    
    
    @GetMapping("/buscar")
    public ModelAndView getMethodName(@RequestParam String busquedaTxt) {
        ModelAndView modelView = new ModelAndView("galeriaLibros");
        LibroDAO librosBBDD = new LibroDAO();
        List<LibroDTO> listaLibros = librosBBDD.findAll();
        List<LibroDTO> listaBusqueda  = servicioLibro.busuqedaLibro(listaLibros, busquedaTxt);

      

        if (!listaBusqueda.isEmpty()){
            System.out.println("flag");
            modelView.addObject("listaLibros", listaBusqueda);
            modelView.addObject("listaCarrito", carritoTemp);
            
        }else{
            System.out.println("flag2");
            String sinResultado = "No se han encontrado resultados de la busqueda";
            modelView.addObject("listaLibros", listaLibros);
            modelView.addObject("listaCarrito", carritoTemp);
            modelView.addObject("sinResultado", sinResultado);
        }

        return modelView;
    }
    





}
