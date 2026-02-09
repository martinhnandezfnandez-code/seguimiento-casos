package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso8;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso9;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Paso9Repository extends JpaRepository<Paso9, String> {
    Optional<Paso9> findByAlumnadoId(Long alumnadoId);
}
