package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Paso4Repository extends JpaRepository<Paso4, String> {
    Optional<Paso4>findByAlumnadoId(Long alumnadoId);
}
