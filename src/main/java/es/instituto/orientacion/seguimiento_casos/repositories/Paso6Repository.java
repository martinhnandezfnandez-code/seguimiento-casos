package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso6;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface Paso6Repository extends JpaRepository<Paso6, String> {
    Optional<Paso6> findByAlumnadoId(Long alumnadoId);
}

