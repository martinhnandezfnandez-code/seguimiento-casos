package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositorio para la gestión de persistencia de la entidad {@link Paso1}.
 * <p>
 * Esta interfaz centraliza el acceso a los datos del primer paso del protocolo:
 * la Comunicación de Hechos. Permite almacenar y recuperar información sobre
 * quién comunica la situación y el detalle de los hechos detectados.
 * </p>
 *
 * @author Departamento de Orientación
 * @version 1.0
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface Paso1Repository extends JpaRepository<Paso1, String> {

    /**
     * Recupera el registro de comunicación inicial (Paso 1) asociado a un alumno.
     * <p>
     * Se utiliza para obtener el punto de partida del expediente de seguimiento
     * filtrando por el identificador del alumno.
     * </p>
     *
     * @param alumnadoId Identificador único del alumno asociado al expediente.
     * @return Un {@link Optional} con el Paso 1 si existe, o vacío en caso contrario.
     */
    Optional<Paso1> findByAlumnadoId(Long alumnadoId);
}