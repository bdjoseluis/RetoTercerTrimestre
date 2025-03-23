package retodaw.modelo.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "solicitudes")
@Schema(description="Solicitudes")
public class Solicitud {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
	private int id_solicitud;
	private Date date;
	private String archivo;
	private String comentarios;
	private int estado;
	private String curriculum;
	@OneToOne 
	@JoinColumn(name = "email", nullable = false)
    private Usuario usuario;
	public Solicitud() {
		super();
	
	}
	public Solicitud(int id_solicitud, Date date, String archivo, String comentarios, int estado, String curriculum) {
		super();
		this.id_solicitud = id_solicitud;
		this.date = date;
		this.archivo = archivo;
		this.comentarios = comentarios;
		this.estado = estado;
		this.curriculum = curriculum;
	}
	public int getId_solicitud() {
		return id_solicitud;
	}
	public void setId_solicitud(int id_solicitud) {
		this.id_solicitud = id_solicitud;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	@Override
	public int hashCode() {
		return Objects.hash(archivo, comentarios, curriculum, date, estado, id_solicitud);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitud other = (Solicitud) obj;
		return Objects.equals(archivo, other.archivo) && Objects.equals(comentarios, other.comentarios)
				&& Objects.equals(curriculum, other.curriculum) && Objects.equals(date, other.date)
				&& estado == other.estado && id_solicitud == other.id_solicitud;
	}
	@Override
	public String toString() {
		return "Solicitud [id_solicitud=" + id_solicitud + ", date=" + date + ", archivo=" + archivo + ", comentarios="
				+ comentarios + ", estado=" + estado + ", curriculum=" + curriculum + "]";
	}
	
	
	
}
