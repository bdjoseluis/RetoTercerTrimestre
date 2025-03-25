package retodaw.dtos;

import retodaw.modelo.entities.Categoria;

public class CategoriaMapper {
	 public static CategoriaDto toDto(Categoria categoria) {
	        return new CategoriaDto(
	            categoria.getId_categoria(),
	            categoria.getNombre(),
	            categoria.getDescripcion(),
	            categoria.getId_vacante()
	        );
	    }

	    public static Categoria toEntity(CategoriaDto dto) {
	        if (dto == null) {
	            return null;
	        }

	        Categoria categoria = new Categoria(
	        		dto.getId_categoria(),
	        	    dto.getNombre(),
	        		dto.getDescripcion(),
	        		dto.getId_vacante()
	            
	        );
	        
	        return categoria;
	    }
}
