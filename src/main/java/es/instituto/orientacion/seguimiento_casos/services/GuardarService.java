package es.instituto.orientacion.seguimiento_casos.services;

import es.instituto.orientacion.seguimiento_casos.entities.dto.FormularioDTO;
import org.springframework.stereotype.Service;

@Service
public interface GuardarService {

    boolean crearAlumnado(FormularioDTO formularioDTO);
    boolean editarAlumnado(FormularioDTO formularioDTO);
}
