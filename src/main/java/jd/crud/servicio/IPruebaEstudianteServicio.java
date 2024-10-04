package jd.crud.servicio;

import jd.crud.modelo.PruebaEstudiante;

import java.util.List;

public interface IPruebaEstudianteServicio {
    public List<PruebaEstudiante> listarPruebasEstudiantes();

    public PruebaEstudiante buscarPruebaEstudiantePorId(Integer id);

    public void guardarPruebaEstudiante(PruebaEstudiante pruebaEstudiante);

    public void eliminarPruebaEstudiante(PruebaEstudiante pruebaEstudiante);
}
