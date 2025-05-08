package retodaw.modelo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "solicitudes")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_solicitud")
    private int idSolicitud;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(nullable = false)
    private String archivo;

    private String comentarios;

    @Column(nullable = false)
    private Byte estado;


    private String curriculum;

    @ManyToOne
    @JoinColumn(name = "id_vacante", referencedColumnName = "id_vacante", nullable = false)
    private Vacante vacante;
    
    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private Usuario usuario;

    public Solicitud(int idSolicitud, Date fecha, String archivo, String comentarios, Byte estado, 
                     String curriculum, Usuario usuario, Vacante vacante) {
        this.idSolicitud = idSolicitud;
        this.fecha = fecha;
        this.archivo = archivo;
        this.comentarios = comentarios;
        this.estado = estado;
        this.curriculum = curriculum;
        this.usuario = usuario;
        this.vacante = vacante;
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

	public Vacante getVacante() {
		return vacante;
	}

	public void setVacante(Vacante vacante) {
		this.vacante = vacante;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
    
}
