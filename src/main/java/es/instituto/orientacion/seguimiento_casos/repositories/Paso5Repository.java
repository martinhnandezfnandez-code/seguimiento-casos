package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.Paso5;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Paso5Repository extends JpaRepository<Paso5, String> {
    Optional<Paso5> findByAlumnadoId(Long alumnadoId);
}
