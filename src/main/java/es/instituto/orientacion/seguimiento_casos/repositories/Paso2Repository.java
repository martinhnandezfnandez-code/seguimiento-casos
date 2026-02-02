package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Paso2Repository extends JpaRepository<Paso2, String> {
    Optional<Paso2> findByAlumnadoId(Long alumnadoId);
}
