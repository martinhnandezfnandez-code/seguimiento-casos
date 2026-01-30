package es.instituto.orientacion.seguimiento_casos.services.servicesimpl;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.Paso1;
import es.instituto.orientacion.seguimiento_casos.entities.dto.FormularioDTO;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso1DTO;
import es.instituto.orientacion.seguimiento_casos.repositories.AlumnadoRepository;
import es.instituto.orientacion.seguimiento_casos.repositories.Paso1Repository;
import es.instituto.orientacion.seguimiento_casos.services.GuardarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GuardarServiceImpl implements GuardarService {
    private final AlumnadoRepository alumnadoRepository;
    private final Paso1Repository paso1Repository;

    public GuardarServiceImpl(AlumnadoRepository alumnadoRepository, Paso1Repository paso1Repository) {
        this.alumnadoRepository = alumnadoRepository;
        this.paso1Repository = paso1Repository;
    }

    @Override
    public boolean crearAlumnado(FormularioDTO formularioDTO) {

        Alumnado alumnado = new Alumnado(formularioDTO);

        if (alumnado.getPaso1() != null) {
            alumnado.getPaso1().setAlumnado(alumnado);
            alumnado.getPaso1().setFechaRegistro(LocalDate.now());
        }
        guardarCronograma(formularioDTO, alumnado);
        Long idNuevo = alumnadoRepository.save(alumnado).getId();
        return idNuevo != null;
    }

    @Override
    public boolean editarAlumnado(FormularioDTO formularioDTO) {
        Alumnado alumnado;
        alumnado = alumnadoRepository.findById(String.valueOf(formularioDTO.getId()))
                .orElseThrow();

        Paso1 paso1 = alumnado.getPaso1();
        if (paso1 == null) {
            paso1 = new Paso1();
            paso1.setAlumnado(alumnado);
            alumnado.setPaso1(paso1);
        }
        Paso1DTO dto = formularioDTO.getPaso1DTO();
        paso1.setCodigoAlumno(dto.getCodigoAlumno());
        paso1.setAlumnoComunica(dto.getAlumnoComunica());
        paso1.setCompanerosComunican(dto.getCompanerosComunican());
        paso1.setFamiliaComunica(dto.getFamiliaComunica());
        paso1.setIntentoPrevio(dto.getIntentoPrevio());
        paso1.setConductaAutolesiva(dto.getConductaAutolesiva());
        paso1.setOtrosDetalle(dto.getOtrosDetalle());
        paso1.setDetalleHechos(dto.getDetalleHechos());
        paso1.setFechaRegistro(dto.getFechaRegistro());
        paso1.setFirmas(dto.getFirmas());

        guardarCronograma(formularioDTO, alumnado);
        alumnadoRepository.save(alumnado);
        return true;
    }


    private static void guardarCronograma(FormularioDTO formularioDTO, Alumnado alumnado) {
        if (formularioDTO.getCronograma() != null) {
            formularioDTO.getCronograma().forEach(c -> {
                c.setAlumnado(alumnado);
                alumnado.getCronograma().add(c);
            });
        }
    }
}
