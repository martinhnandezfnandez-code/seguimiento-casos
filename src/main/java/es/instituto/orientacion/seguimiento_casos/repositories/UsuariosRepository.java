package es.instituto.orientacion.seguimiento_casos.repositories;

import es.instituto.orientacion.seguimiento_casos.entities.Role;
import es.instituto.orientacion.seguimiento_casos.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    /**
     * @param aLong Identificador único del usuario.
     * @return Un {@link Optional} que contiene el usuario si se han registrado
     * medidas, o un contenedor vacío si no existen registros.
     */
    @Override
    Optional<Usuarios> findById(Long aLong);

    Optional<Usuarios> findByNombre(String nombre);
}

