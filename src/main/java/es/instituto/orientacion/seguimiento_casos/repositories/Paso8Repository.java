package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Paso8Repository extends JpaRepository<Paso8, String> {
    Optional<Paso8> findByAlumnadoId(Long alumnadoId);
}
