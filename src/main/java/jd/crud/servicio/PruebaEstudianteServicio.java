package jd.crud.servicio;

import jd.crud.modelo.PruebaEstudiante;
import jd.crud.repositorio.PruebaEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PruebaEstudianteServicio implements IPruebaEstudianteServicio{

    @Autowired
    private PruebaEstudianteRepositorio PruebaEstudianteRepositorio;

    @Override
    public List<PruebaEstudiante> listarPruebasEstudiantes() {
        return PruebaEstudianteRepositorio.findAll();
    }

    @Override
    public PruebaEstudiante buscarPruebaEstudiantePorId(Integer id) {
        PruebaEstudiante pruebaEstudiante = PruebaEstudianteRepositorio.findById(id).orElse(null);
        return pruebaEstudiante;
    }

    @Override
    public void guardarPruebaEstudiante(PruebaEstudiante pruebaEstudiante) {
        PruebaEstudianteRepositorio.save(pruebaEstudiante);
    }

    @Override
    public void eliminarPruebaEstudiante(PruebaEstudiante pruebaEstudiante) {
        PruebaEstudianteRepositorio.delete(pruebaEstudiante);
    }
}
