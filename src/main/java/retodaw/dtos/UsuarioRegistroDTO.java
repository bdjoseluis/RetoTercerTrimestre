package retodaw.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "email")
public class UsuarioRegistroDTO {
    private String email;
    private String password;

}
