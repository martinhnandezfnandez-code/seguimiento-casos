package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso1;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Cronograma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CronogramaRepository extends JpaRepository<Cronograma, String> {
    Optional<Cronograma> findByPaso2(Long paso2);
}
