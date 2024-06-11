package com.emergentes.bean;

import com.emergentes.entidades.Estudiante;
import com.emergentes.jpa.EstudianteJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanEstudiante {

    private EntityManagerFactory emf;
    private EstudianteJpaController jpaEstudiante;

    public BeanEstudiante() {
        emf = Persistence.createEntityManagerFactory("UPseguimiento");
        jpaEstudiante = new EstudianteJpaController(emf);
    }

    public void insertar(Estudiante e) {
        jpaEstudiante.create(e);
    }

    public void editar(Estudiante e) {
        try {
            jpaEstudiante.edit(e);
        } catch (Exception ex) {
            Logger.getLogger(BeanEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Integer id) {
        try {
            jpaEstudiante.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Estudiante buscar(Integer id) {
        Estudiante est = new Estudiante();
        est = jpaEstudiante.findEstudiante(id);
        return est;
    }

    public List<Estudiante> listartodos() {
        //listando la lista
        return jpaEstudiante.findEstudianteEntities();
    }
}
