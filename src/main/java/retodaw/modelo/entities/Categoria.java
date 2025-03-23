package retodaw.modelo.entities;

import java.util.Objects;

public class Categoria {
	
	private int id_categoria; 
	private String nombre; 
	private String descripcion;
	private int id_vacante;
	
	public Categoria() {
		super();
		
	}

	public Categoria(int id_categoria, String nombre, String descripcion, int id_vacante) {
		super();
		this.id_categoria = id_categoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.id_vacante = id_vacante;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
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

	public int getId_vacante() {
		return id_vacante;
	}

	public void setId_vacante(int id_vacante) {
		this.id_vacante = id_vacante;
	}



	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id_categoria, id_vacante, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(descripcion, other.descripcion) && id_categoria == other.id_categoria
				&& id_vacante == other.id_vacante && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Vacante [id_categoria=" + id_categoria + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", id_vacante=" + id_vacante + "]";
	}
	
	
}
