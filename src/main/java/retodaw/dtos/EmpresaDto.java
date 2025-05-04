package retodaw.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of = "id_empresa")
public class EmpresaDto {
    private int id_empresa; 
    private String cif; 
    private String nombre_empresa; 
    private String direccion_fiscal; 
    private String pais; 
    private String email;

    public EmpresaDto() {
    }

    public EmpresaDto(int id_empresa, String cif, String nombre_empresa, String direccion_fiscal, String pais, String email) {
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
}
