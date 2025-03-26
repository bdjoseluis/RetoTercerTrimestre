package retodaw.dtos;

import retodaw.modelo.entities.Categoria;
import retodaw.modelo.entities.Vacante;
import retodaw.modelo.services.VacanteService;

public class CategoriaMapper {

    private static VacanteService vacanteService;

    public static CategoriaDto toDto(Categoria categoria) {
        return new CategoriaDto(
            categoria.getId_categoria(),
            categoria.getNombre(),
            categoria.getDescripcion(),
            categoria.getVacante() != null ? categoria.getVacante().getIdVacante() : 0
        );
    }

    public static Categoria toEntity(CategoriaDto dto) {
        if (dto == null) {
            return null;
        }

        Vacante vacante = vacanteService.buscarUna(dto.getId_vacante());

        Categoria categoria = new Categoria(
            dto.getId_categoria(),
            dto.getNombre(),
            dto.getDescripcion(),
            vacante
        );

        return categoria;
    }
}
