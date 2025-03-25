package retodaw.modelo.entities;

import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "Vacantes")
@Schema(description="vacantes")
public class Vacante {
	
	// falta el id??? para primary key? 
	// 	@Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id_vacante")
	// private int idVacante; 
	
	private String nombre; 
	private String descripcion; 
	private Date fecha; 
	private double salario; 
	private Enum estatus; 
	private int destacado; 
	private String imagen; 
	private String detalles;
	
	public Vacante() {
		super();
	}

	public Vacante(String nombre, String descripcion, Date fecha, double salario, Enum estatus, int destacado,
			String imagen, String detalles) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.salario = salario;
		this.estatus = estatus;
		this.destacado = destacado;
		this.imagen = imagen;
		this.detalles = detalles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Enum getEstatus() {
		return estatus;
	}

	public void setEstatus(Enum estatus) {
		this.estatus = estatus;
	}

	public int getDestacado() {
		return destacado;
	}

	public void setDestacado(int destacado) {
		this.destacado = destacado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, destacado, detalles, estatus, fecha, imagen, nombre, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacante other = (Vacante) obj;
		return Objects.equals(descripcion, other.descripcion) && destacado == other.destacado
				&& Objects.equals(detalles, other.detalles) && Objects.equals(estatus, other.estatus)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(imagen, other.imagen)
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario);
	}

	@Override
	public String toString() {
		return "Vacante [nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + ", salario="
				+ salario + ", estatus=" + estatus + ", destacado=" + destacado + ", imagen=" + imagen + ", detalles="
				+ detalles + "]";
	}
	
	
	
}
