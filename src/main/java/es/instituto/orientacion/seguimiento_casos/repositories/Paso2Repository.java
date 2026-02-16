package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio para la gestión de persistencia de la entidad {@link Paso2}.
 * <p>
 * Esta interfaz gestiona el acceso a los datos de la fase de "Recogida de Información".
 * Incluye la persistencia de las entrevistas iniciales, consultas de expedientes
 * previos y sirve como anclaje para la colección de hitos del cronograma.
 * </p>
 *
 * @author Departamento de Orientación
 * @version 1.0
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface Paso2Repository extends JpaRepository<Paso2, String> {

    /**
     * Recupera el registro de recogida de información (Paso 2) asociado a un alumno.
     * <p>
     * Permite acceder a las actuaciones previas y al cronograma de hechos
     * utilizando el identificador único del alumno.
     * </p>
     *
     * @param alumnadoId Identificador único del alumno asociado al expediente.
     * @return Un {@link Optional} que contiene el Paso 2 si se ha iniciado la fase,
     * o vacío en caso contrario.
     */
    Optional<Paso2> findByAlumnadoId(Long alumnadoId);
}