package retodaw.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_categoria")
@Builder
public class CategoriaDto {
	
    private int id_categoria;
    private String nombre;
    private String descripcion;
}
