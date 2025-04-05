package retodaw.modelo.services;

import java.util.Collection;
import java.util.List;

import retodaw.dtos.UsuarioDto;
import retodaw.modelo.entities.Solicitud;
import retodaw.modelo.entities.Usuario;

public interface UsuarioService {
	Usuario alta(Usuario vacante);
	Usuario modificar(Usuario vacante);
    int eliminar(String email);
    Usuario buscarUno(String email);
    List<Usuario> buscarTodos();
	List<Solicitud> obtenerSolicitudesPorUsuario(String email);
}
