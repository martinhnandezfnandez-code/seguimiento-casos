package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso7;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface Paso7Repository extends JpaRepository<Paso7, String> {
    Optional<Paso7> findByAlumnadoId(Long alumnadoId);
}
