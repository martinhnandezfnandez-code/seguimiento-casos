package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositorio para la gestión de persistencia de la entidad {@link Paso10}.
 * <p>
 * Proporciona las operaciones CRUD básicas (Crear, Leer, Actualizar, Borrar)
 * gracias a la extensión de {@link JpaRepository}. Este repositorio sirve como
 * punto de acceso principal a la base de datos para toda la información
 * relacionada con los expedientes de alumnos.
 * </p>
 *
 * @author Departamento de Orientación
 * @version 1.0
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface Paso10Repository extends JpaRepository<Paso10, String> {
    /**
     * Recupera el registro de medidas provisionales (Paso 10) asociado a un alumno.
     *
     * @param alumnadoId Identificador único del alumno asociado al expediente.
     * @return Un {@link Optional} que contiene el Paso 10 si se han registrado
     * medidas, o un contenedor vacío si no existen registros.
     */
    Optional<Paso10> findByAlumnadoId(Long alumnadoId);
}
