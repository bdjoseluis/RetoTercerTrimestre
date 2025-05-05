package retodaw.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import retodaw.modelo.entities.Estatus;


@EqualsAndHashCode(of = "idVacante")
public class VacanteDto {

	private int idVacante; 
	private String nombre; 
	private String descripcion; 
	private Date fecha; 
	private double salario; 
	private Estatus estatus;
	private Byte destacado;
	private String imagen; 
	private String detalles;
	private int id_categoria;
	private int id_empresa;

	public VacanteDto(int idVacante, String nombre, String descripcion, Date fecha, double salario, Estatus estatus, Byte destacado, String imagen, String detalles, int id_categoria, int id_empresa) {
		this.idVacante = idVacante;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.salario = salario;
		this.estatus = estatus;
		this.destacado = destacado;
		this.imagen = imagen;
		this.detalles = detalles;
		this.id_categoria = id_categoria;
		this.id_empresa = id_empresa;
	}

	public VacanteDto() {
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

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
}
