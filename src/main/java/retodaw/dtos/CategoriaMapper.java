package retodaw.dtos;

import retodaw.modelo.entities.Categoria;
import retodaw.modelo.entities.Vacante;
import retodaw.modelo.services.VacanteService;

public class CategoriaMapper {


    public static CategoriaDto toDto(Categoria categoria) {
        return new CategoriaDto(
            categoria.getId_categoria(),
            categoria.getNombre(),
            categoria.getDescripcion()
        );
    }

    public static Categoria toEntity(CategoriaDto dto) {
        if (dto == null) {
            return null;
        }


        Categoria categoria = new Categoria(
            dto.getId_categoria(),
            dto.getNombre(),
            dto.getDescripcion()
        );

        return categoria;
    }
}
