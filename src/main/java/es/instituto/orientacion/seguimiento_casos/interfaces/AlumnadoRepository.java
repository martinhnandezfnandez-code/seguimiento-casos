package es.instituto.orientacion.seguimiento_casos.interfaces;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnadoRepository extends JpaRepository<Alumnado, String> {
    // Puedes añadir métodos personalizados si los necesitas, por ejemplo:
    // List<Caso> findByPaso(String paso);
}
