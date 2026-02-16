package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso5;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio para la gestión de persistencia de la entidad {@link Paso5}.
 * <p>
 * Esta interfaz gestiona la fase de "Análisis y Conclusiones", actuando como
 * contenedor principal para los informes técnicos detallados en los Anexos 4 y 5.
 * </p>
 *
 * @author Departamento de Orientación
 * @version 1.0
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface Paso5Repository extends JpaRepository<Paso5, String> {

    /**
     * Recupera el análisis de conclusiones (Paso 5) asociado a un alumno,
     * cargando de forma optimizada sus anexos.
     * <p>
     * Utiliza {@link EntityGraph} para realizar un "fetch join" de las entidades
     * {@code anexo4} y {@code anexo5}, evitando consultas adicionales a la
     * base de datos cuando se accede a los detalles técnicos.
     * </p>
     *
     * @param alumnadoId Identificador único del alumno asociado al expediente.
     * @return Un {@link Optional} con el Paso 5 y sus anexos cargados, o vacío si no existe.
     */
    @EntityGraph(attributePaths = {"anexo4", "anexo5"})
    Optional<Paso5> findByAlumnadoId(Long alumnadoId);
}