package retodaw.dtos;

import retodaw.modelo.entities.Categoria;
import retodaw.modelo.entities.Empresa;
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
        		vacante.getDetalles(),
        		vacante.getCategoria().getId_categoria(),
        		vacante.getEmpresa().getId_empresa()
        );
    }

    public static Vacante toEntity(VacanteDto dto, Categoria categoria, Empresa dtoempresa) {
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
        		dto.getDetalles(), 
        		categoria,
        		dtoempresa
        );
        
        return vacante;
    }

}
