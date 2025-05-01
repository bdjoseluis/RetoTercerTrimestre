package retodaw.dtos;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitudDto {
    private int idSolicitud;
    private Date fecha;
    private String archivo;
    private String comentarios;
    private Byte estado;
    private String curriculum;
    private String email;
    private int idVacante;
}
