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
@EqualsAndHashCode(of = "id_solicitud")
@Builder
public class SolicitudDto {
	private int id_solicitud;
	private Date date;
	private String archivo;
	private String comentarios;
	private int estado;
	private String curriculum;
}
