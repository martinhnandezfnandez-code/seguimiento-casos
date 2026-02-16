package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la gestión de persistencia de la entidad {@link Alumnado}.
 * <p>
 * Proporciona las operaciones CRUD básicas (Crear, Leer, Actualizar, Borrar)
 * gracias a la extensión de {@link JpaRepository}. Este repositorio sirve como
 * punto de acceso principal a la base de datos para toda la información
 * relacionada con los expedientes de alumnos.
 * </p>
 *
 * @author Departamento de Orientación
 * @version 1.0
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface AlumnadoRepository extends JpaRepository<Alumnado, String> {

}