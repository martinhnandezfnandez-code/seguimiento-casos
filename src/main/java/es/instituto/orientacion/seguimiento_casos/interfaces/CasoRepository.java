package es.instituto.orientacion.seguimiento_casos.interfaces;

import es.instituto.orientacion.seguimiento_casos.entities.Caso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasoRepository extends JpaRepository<Caso, String> {
    // Puedes añadir métodos personalizados si los necesitas, por ejemplo:
    // List<Caso> findByPaso(String paso);
}
