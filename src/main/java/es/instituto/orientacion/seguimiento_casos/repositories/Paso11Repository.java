package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso11;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso8;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Paso11Repository extends JpaRepository<Paso11, String> {
    Optional<Paso11> findByAlumnadoId(Long alumnadoId);
}
