package retodaw.dtos;

import org.springframework.stereotype.Component;
import retodaw.modelo.entities.Usuario;

@Component
public class UsuarioMapper {

    public static UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(
            usuario.getEmail(),
            usuario.getNombre(),
            usuario.getApellidos(),
            usuario.getPassword(),
            usuario.getEnabled(),
            usuario.getFechaRegistro(),
            usuario.getRol()
        );
    }

    public static Usuario toEntity(UsuarioDto dto) {
        if (dto == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setNombre(dto.getNombre());
        usuario.setApellidos(dto.getApellidos());
        usuario.setPassword(dto.getPassword());
        usuario.setEnabled(dto.getEnabled());
        usuario.setFechaRegistro(dto.getFechaRegistro());
        usuario.setRol(dto.getRol());
        return usuario;
    }
}
