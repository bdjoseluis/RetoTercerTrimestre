package retodaw.dtos;

import retodaw.modelo.entities.Empresa;

public class EmpresaMapper {
	 public static EmpresaDto toDto(Empresa empresa) {
	        return new EmpresaDto(
	        	empresa.getId_empresa(),
	        	empresa.getCif(),
	        	empresa.getNombre_empresa(),
	        	empresa.getDireccion_fiscal(),
	        	empresa.getPais(),
	        	empresa.getEmail()
	        );
	    }

	    public static Empresa toEntity(EmpresaDto dto) {
	        if (dto == null) {
	            return null;
	        }

	        Empresa empresa = new Empresa(
	        		dto.getId_empresa(),
	        	    dto.getCif(),
	        		dto.getNombre_empresa(),
	        		dto.getDireccion_fiscal(),
	        		dto.getPais(),
	        		dto.getEmail() 
	        );

	        return empresa;
	    }

}
