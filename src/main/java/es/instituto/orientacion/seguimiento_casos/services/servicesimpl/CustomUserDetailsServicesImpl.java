package es.instituto.orientacion.seguimiento_casos.services.servicesimpl;

import es.instituto.orientacion.seguimiento_casos.entities.Usuarios;
import es.instituto.orientacion.seguimiento_casos.repositories.UsuariosRepository;
import es.instituto.orientacion.seguimiento_casos.services.CustomUserDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsServicesImpl implements CustomUserDetailsServices, UserDetailsService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuarios> usuarioOptional = usuariosRepository.findByNombre(username);
        if (usuarioOptional.isPresent()) {
            Usuarios usuario = usuarioOptional.get();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuario.getRole().getNombre());
            return new User(usuario.getNombre(), usuario.getContraseña(), Collections.singletonList(grantedAuthority));
        } else {
            throw new UsernameNotFoundException("usuario no encontrado: " + username);
        }
    }
}
