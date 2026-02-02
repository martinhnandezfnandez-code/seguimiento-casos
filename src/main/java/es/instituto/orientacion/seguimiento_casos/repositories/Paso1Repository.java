package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Paso1Repository extends JpaRepository<Paso1, String> {
    Optional<Paso1> findByAlumnadoId(Long alumnadoId);
}
