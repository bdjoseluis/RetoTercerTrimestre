package retodaw.dtos;

import lombok.*;

@EqualsAndHashCode(of = "id_categoria")
public class CategoriaDto {
    private int id_categoria;
    private String nombre;
    private String descripcion;

    public CategoriaDto() {
    }

    public CategoriaDto(int id_categoria, String nombre, String descripcion) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
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


}
