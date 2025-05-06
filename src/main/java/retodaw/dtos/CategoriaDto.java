package retodaw.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id_categoria")
public class CategoriaDto {
    private int id_categoria;
    private String nombre;
    private String descripcion;

}
