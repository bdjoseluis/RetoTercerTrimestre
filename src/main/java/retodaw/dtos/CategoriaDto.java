package retodaw.dtos;

import lombok.*;

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
