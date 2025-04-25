package retodaw.modelo.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
//@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Vacantes")
@Schema(description="vacantes")
public class Vacante {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacante")
    private int idVacante; 
	
	private String nombre; 
	private String descripcion;
	@Temporal(TemporalType.DATE)
	private Date fecha; 
	private double salario; 
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Estatus estatus; 
	@Column(nullable = false)
	private Byte destacado;

	//@Convert(converter = BooleanToBitConverter.class)
	

	
	private String imagen; 
	private String detalles;
	
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
    private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", nullable = false)
    private Empresa empresa;

	
    
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Vacante() {
		super();
	}

	public Vacante(int idVacante, String nombre, String descripcion, Date fecha, double salario, Estatus estatus,
			Byte destacado, String imagen, String detalles, Categoria categoria, Empresa empresa) {
		super();
		this.idVacante = idVacante;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.salario = salario;
		this.estatus = estatus;
		this.destacado = destacado;
		this.imagen = imagen;
		this.detalles = detalles;
		this.categoria = categoria;
		this.empresa = empresa;
	}

	public Vacante(String nombre, String descripcion, Date fecha, double salario, Estatus estatus, Byte destacado,
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
	

	public int getIdVacante() {
		return idVacante;
	}

	public void setIdVacante(int idVacante) {
		this.idVacante = idVacante;
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

	public Estatus getEstatus() {
		return estatus;
	}

	
	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

	public Byte getDestacado() {
		return destacado;
	}

	public void setDestacado(Byte destacado) {
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
