package retodaw.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import retodaw.modelo.entities.Estatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idVacante")
@Builder
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
}
