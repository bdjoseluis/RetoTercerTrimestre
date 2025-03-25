package retodaw.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import retodaw.modelo.entities.Estatus;
import retodaw.modelo.entities.Usuario;
import retodaw.modelo.entities.Vacante;


public class VacanteMapper {
	public static VacanteDto toDto(Vacante vacante) {
        return new VacanteDto(
        		vacante.getIdVacante(),
        		vacante.getNombre(),
        		vacante.getDescripcion(),
        		vacante.getFecha(),
        		vacante.getSalario(),
        		vacante.getEstatus(),
        		vacante.getDestacado(),
        		vacante.getImagen(),
        		vacante.getDetalles()
        );
    }

    public static Vacante toEntity(VacanteDto dto) {
        if (dto == null) {
            return null;
        }

        Vacante vacante = new Vacante(
        		dto.getIdVacante(),
        		dto.getNombre(),
        		dto.getDescripcion(),
        		dto.getFecha(),
        		dto.getSalario(),
        		dto.getEstatus(),
        		dto.getDestacado(),
        		dto.getImagen(),
        		dto.getDetalles()
        );
        
        return vacante;
    }
}
