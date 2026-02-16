package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Cronograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio para la gestión de persistencia de la entidad {@link Cronograma}.
 * <p>
 * Esta interfaz gestiona el almacenamiento de los hitos cronológicos asociados
 * a la recogida de información (Paso 2). Permite realizar un seguimiento temporal
 * detallado de las actuaciones y situaciones detectadas en cada caso.
 * </p>
 *
 * @author Departamento de Orientación
 * @version 1.0
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface CronogramaRepository extends JpaRepository<Cronograma, String> {

    /**
     * Recupera el cronograma asociado a un identificador específico de Paso 2.
     * <p>
     * Se utiliza para obtener la secuencia de actuaciones vinculada a una fase de
     * recogida de datos concreta.
     * </p>
     *
     * @param paso2 Identificador único (ID) de la entidad Paso 2.
     * @return Un {@link Optional} que contiene el Cronograma si se encuentra,
     * o un contenedor vacío si no hay registros asociados.
     */
    Optional<Cronograma> findByPaso2(Long paso2);
}