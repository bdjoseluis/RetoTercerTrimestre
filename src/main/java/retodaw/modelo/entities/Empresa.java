package retodaw.modelo.entities;

import java.util.Objects;

public class Empresa {
	private int id_empresa; 
	private String cif; 
	private String nombre_empresa; 
	private String direccion_fiscal; 
	private String pais; 
	private String email;
	
	public Empresa() {
		super();

	}

	public Empresa(int id_empresa, String cif, String nombre_empresa, String direccion_fiscal, String pais,
			String email) {
		super();
		this.id_empresa = id_empresa;
		this.cif = cif;
		this.nombre_empresa = nombre_empresa;
		this.direccion_fiscal = direccion_fiscal;
		this.pais = pais;
		this.email = email;
	}

	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	public String getDireccion_fiscal() {
		return direccion_fiscal;
	}

	public void setDireccion_fiscal(String direccion_fiscal) {
		this.direccion_fiscal = direccion_fiscal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cif, direccion_fiscal, email, id_empresa, nombre_empresa, pais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(cif, other.cif) && Objects.equals(direccion_fiscal, other.direccion_fiscal)
				&& Objects.equals(email, other.email) && id_empresa == other.id_empresa
				&& Objects.equals(nombre_empresa, other.nombre_empresa) && Objects.equals(pais, other.pais);
	}

	@Override
	public String toString() {
		return "Empresa [id_empresa=" + id_empresa + ", cif=" + cif + ", nombre_empresa=" + nombre_empresa
				+ ", direccion_fiscal=" + direccion_fiscal + ", pais=" + pais + ", email=" + email + "]";
	}
	
	
}
