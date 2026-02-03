package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso5;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Paso5Repository extends JpaRepository<Paso5, String> {
    @EntityGraph(attributePaths = {"anexo4", "anexo5"})
    Optional<Paso5> findByAlumnadoId(Long alumnadoId);
}
