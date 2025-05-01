package retodaw.dtos;

import org.springframework.stereotype.Component;
import retodaw.modelo.entities.Solicitud;
import retodaw.modelo.entities.Usuario;
import retodaw.modelo.entities.Vacante;

@Component
public class SolicitudMapper {

    public static SolicitudDto toDto(Solicitud solicitud) {
        return new SolicitudDto(
            solicitud.getIdSolicitud(),
            solicitud.getFecha(),
            solicitud.getArchivo(),
            solicitud.getComentarios(),
            solicitud.getEstado(),
            solicitud.getCurriculum(),
            solicitud.getUsuario().getEmail(),
            solicitud.getVacante() != null ? solicitud.getVacante().getIdVacante() : 0
        );
    }

    public static Solicitud toEntity(SolicitudDto dto, Usuario usuario, Vacante vacante) {
        return new Solicitud(
            dto.getIdSolicitud(),
            dto.getFecha(),
            dto.getArchivo(),
            dto.getComentarios(),
            dto.getEstado(),
            dto.getCurriculum(),
            usuario,
            vacante
        );
    }


}
