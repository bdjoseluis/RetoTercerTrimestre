package retodaw.dtos;

import retodaw.modelo.entities.Solicitud;
import retodaw.modelo.entities.Usuario;

public class UsuarioMapper {
	public static UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(
        		usuario.getEmail(),
        		usuario.getNombre(),
        		usuario.getApellidos(),
        		usuario.getPassword(),
        		usuario.getEnabled(),
        		usuario.getFecha_Registro(),
        		usuario.getRol()
        );
    }

    public static Usuario toEntity(UsuarioDto dto) {
        if (dto == null) {
            return null;
        }

        Usuario usuario = new Usuario(
        		dto.getEmail(),
            	dto.getNombre(),
            	dto.getApellidos(),
            	dto.getPassword(),
            	dto.getEnabled(),
            	dto.getFecha_Registro(),
            	dto.getRol()
        );
        
        return usuario;
    }
}
