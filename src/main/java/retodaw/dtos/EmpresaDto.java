package retodaw.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_empresa")
@Builder
public class EmpresaDto {
	
	private int id_empresa; 
	private String cif; 
	private String nombre_empresa; 
	private String direccion_fiscal; 
	private String pais; 
	private String email;
}
