package retodaw.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "email")
@Builder
public class UsuarioDto {
	private String email;
	private String nombre;
	private String apellidos;
	private String password;
	private int enabled;
	private Date fechaRegistro;
	private String rol;
}
