package retodaw.dtos;

import retodaw.modelo.entities.Usuario;

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

        return Usuario.builder()
            .email(dto.getEmail())
            .nombre(dto.getNombre())
            .apellidos(dto.getApellidos())
            .password(dto.getPassword())
            .enabled(dto.getEnabled())
            .fechaRegistro(dto.getFechaRegistro())
            .rol(dto.getRol())
            .build();
    }
}
