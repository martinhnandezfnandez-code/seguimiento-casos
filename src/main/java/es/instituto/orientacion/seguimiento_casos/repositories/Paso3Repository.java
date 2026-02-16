package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio para la gestión de persistencia de la entidad {@link Paso3}.
 * <p>
 * Esta interfaz gestiona el acceso a los datos de la fase de "Medidas Provisionales".
 * En este paso se registran las actuaciones de carácter inmediato y urgente
 * adoptadas por la dirección del centro tras la comunicación inicial de los hechos.
 * </p>
 *
 * @author Departamento de Orientación
 * @version 1.0
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface Paso3Repository extends JpaRepository<Paso3, String> {

    /**
     * Recupera el registro de medidas provisionales (Paso 3) asociado a un alumno.
     * <p>
     * Permite consultar qué decisiones de urgencia se tomaron para un expediente
     * específico utilizando el identificador único del alumno.
     * </p>
     *
     * @param alumnadoId Identificador único del alumno asociado al expediente.
     * @return Un {@link Optional} que contiene el Paso 3 si se han registrado
     * medidas, o un contenedor vacío si no existen registros.
     */
    Optional<Paso3> findByAlumnadoId(Long alumnadoId);
}