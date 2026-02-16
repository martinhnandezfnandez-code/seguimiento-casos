package es.instituto.orientacion.seguimiento_casos.services;

import es.instituto.orientacion.seguimiento_casos.entities.dto.FormularioDTO;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de la persistencia y gestión de los datos del alumnado
 * dentro del sistema de seguimiento de casos.
 * <p>
 * Esta interfaz define las operaciones necesarias para el registro inicial
 * y la actualización posterior de la información enviada a través de los
 * formularios de intervención.
 * </p>
 *
 * @author Departamento de Orientación
 * @version 1.0
 */
@Service
public interface GuardarService {

    /**
     * Registra un nuevo alumno en el sistema a partir de los datos proporcionados.
     * <p>
     * El método procesa el objeto DTO, valida la integridad de la información
     * y persiste las entidades correspondientes en la base de datos.
     * </p>
     *
     * @param formularioDTO Objeto de transferencia de datos que contiene la información del alumno y sus pasos iniciales.
     * @return {@code true} si el alumnado se creó correctamente; {@code false} en caso de error o datos inválidos.
     */
    boolean crearAlumnado(FormularioDTO formularioDTO);

    /**
     * Actualiza la información de un alumno ya existente en el sistema.
     * <p>
     * Localiza el registro mediante el identificador único y actualiza los campos
     * modificados en el flujo de seguimiento de casos.
     * </p>
     *
     * @param formularioDTO Objeto que contiene los datos actualizados y el ID del alumno.
     * @return {@code true} si la edición se completó con éxito; {@code false} si el registro no existe o hubo un fallo en la persistencia.
     */
    boolean editarAlumnado(FormularioDTO formularioDTO);
}