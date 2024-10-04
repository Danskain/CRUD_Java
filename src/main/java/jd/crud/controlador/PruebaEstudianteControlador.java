package jd.crud.controlador;

import jd.crud.modelo.PruebaEstudiante;
import jd.crud.servicio.PruebaEstudianteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PruebaEstudianteControlador {

    private static final Logger logger = LoggerFactory.getLogger(PruebaEstudianteControlador.class);

    @Autowired
    PruebaEstudianteServicio pruebaEstudianteServicio;

    @GetMapping("/")
    public String iniciar(ModelMap modelo){
        List<PruebaEstudiante> pruebaEstudiantes = pruebaEstudianteServicio.listarPruebasEstudiantes();
        pruebaEstudiantes.forEach((prueba) -> logger.info(prueba.toString()));
        modelo.put("pruebasEstudiantes", pruebaEstudiantes);

        return "index";
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(){
        return "agregar";//agregar.html
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("pruebaEstudianteForma") PruebaEstudiante pruebaEstudiante){
        logger.info("pruena de estudiante a agregar:" + pruebaEstudiante);
        pruebaEstudianteServicio.guardarPruebaEstudiante(pruebaEstudiante);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value = "id") int id, ModelMap modelo){
        PruebaEstudiante pruebaEstudiante = pruebaEstudianteServicio.buscarPruebaEstudiantePorId(id);
        logger.info("prueba estudiante a mostrar: " + pruebaEstudiante);
        modelo.put("pruebasEstudiante", pruebaEstudiante);
        return "editar";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("pruebasEstudiante") PruebaEstudiante pruebaEstudiante){
        logger.info("prueba estudiante a editar: " + pruebaEstudiante);
        pruebaEstudianteServicio.guardarPruebaEstudiante(pruebaEstudiante);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") int id){
        PruebaEstudiante pruebaEstudiante = new PruebaEstudiante();
        pruebaEstudiante.setId(id);
        pruebaEstudianteServicio.eliminarPruebaEstudiante(pruebaEstudiante);
        return "redirect:/";
    }

}
