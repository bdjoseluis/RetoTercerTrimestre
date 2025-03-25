package retodaw.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import retodaw.modelo.entities.Empresa;
import retodaw.modelo.entities.Solicitud;


public class SolicitudMapper {
	public static SolicitudDto toDto(Solicitud solicitud) {
        return new SolicitudDto(
        	solicitud.getId_solicitud(),
        	solicitud.getDate(),
        	solicitud.getArchivo(),
        	solicitud.getComentarios(),
        	solicitud.getEstado(),
        	solicitud.getCurriculum()
        );
    }

    public static Solicitud toEntity(SolicitudDto dto) {
        if (dto == null) {
            return null;
        }

        Solicitud solicitud = new Solicitud(
        		dto.getId_solicitud(),
            	dto.getDate(),
            	dto.getArchivo(),
            	dto.getComentarios(),
            	dto.getEstado(),
            	dto.getCurriculum()
        );
        
        return solicitud;
    }
}
