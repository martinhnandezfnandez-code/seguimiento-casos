package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.Paso4;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Paso4Repository extends JpaRepository<Paso4, String> {
    Optional<Paso4>findByAlumnadoId(Long alumnadoId);
}
