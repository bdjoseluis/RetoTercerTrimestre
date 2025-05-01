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

    public SolicitudDto(int idSolicitud, Date fecha, String archivo, String comentarios, Byte estado, String curriculum, String email, int idVacante) {
        this.idSolicitud = idSolicitud;
        this.fecha = fecha;
        this.archivo = archivo;
        this.comentarios = comentarios;
        this.estado = estado;
        this.curriculum = curriculum;
        this.email = email;
        this.idVacante = idVacante;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Byte getEstado() {
        return estado;
    }

    public void setEstado(Byte estado) {
        this.estado = estado;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdVacante() {
        return idVacante;
    }

    public void setIdVacante(int idVacante) {
        this.idVacante = idVacante;
    }
}
