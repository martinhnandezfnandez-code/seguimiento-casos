package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Paso3Repository extends JpaRepository<Paso3, String> {
    Optional<Paso3> findByAlumnadoId(Long alumnadoId);
}
