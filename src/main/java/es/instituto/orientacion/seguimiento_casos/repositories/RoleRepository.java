package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * @param aLong Identificador único del rol.
     * @return Un {@link Optional} que contiene el rol si se han registrado
     * medidas, o un contenedor vacío si no existen registros.
     */
    @Override
    Optional<Role> findById(Long aLong);
}
