package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso10;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Paso10Repository extends JpaRepository<Paso10, String> {
    Optional<Paso10> findByAlumnadoId(Long alumnadoId);
}
