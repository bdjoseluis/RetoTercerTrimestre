package retodaw.RestController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import retodaw.dtos.SolicitudDto;
import retodaw.dtos.SolicitudMapper;
import retodaw.dtos.UsuarioDto;
import retodaw.dtos.UsuarioMapper;
import retodaw.modelo.services.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
@Tag(name = "Usuarios", description = "Operaciones sobre los usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    
    @PostMapping("/alta")
    @Operation(summary = "Dar de alta un usuario", description = "registra un nuevo usuario")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario registrado con éxito"),
        @ApiResponse(responseCode = "500", description = "Error al registrar el usuario")
    })
    public ResponseEntity<UsuarioDto> alta(@RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(UsuarioMapper.toDto(usuarioService.alta(UsuarioMapper.toEntity(usuarioDto))));
    }

    @PutMapping("/modificar")
    @Operation(summary = "Modificar un usuario", description = "Actualiza los datos de un usuario existente.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario modificado con éxito"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error al modificar el usuario")
    })
    public ResponseEntity<UsuarioDto> modificar(@RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(UsuarioMapper.toDto(usuarioService.modificar(UsuarioMapper.toEntity(usuarioDto))));
    }

    @DeleteMapping("/eliminar/{email}")
    @Operation(summary = "Eliminar un usuario", description = "Borra un usuario por su email")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario eliminado con éxito"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error al eliminar el usuario")
    })
    public ResponseEntity<Integer> eliminar(@PathVariable String email) {
        return ResponseEntity.ok(usuarioService.eliminar(email));
    }

    @GetMapping("/uno/{email}")
    @Operation(summary = "Buscar un usuario", description = "obtiene los datos de un usuario por su email")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error al buscar el usuario")
    })
    public ResponseEntity<UsuarioDto> buscarUno(@PathVariable String email) {
        return ResponseEntity.ok(UsuarioMapper.toDto(usuarioService.buscarUno(email)));
    }

    @GetMapping("/todos")
    @Operation(summary = "Listar todos los usuarios", description = "devuelve una lista con todos los usuarios")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "lista obtenida con éxito"),
        @ApiResponse(responseCode = "500", description = "Error al obtener la lista de usuarios")
    })
    public ResponseEntity<List<UsuarioDto>> buscarTodos() {
        return ResponseEntity.ok(usuarioService.buscarTodos()
                .stream()
                .map(UsuarioMapper::toDto)
                .collect(Collectors.toList()));
    }
    
   /* @GetMapping("/usuario/solicitudes/{email}")
    @Operation(summary = "Solicitudes por usuario", description = "Devuelve una lista con las solicitudes realizadas por un usuario concreto")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado o sin solicitudes"),
        @ApiResponse(responseCode = "500", description = "Error al obtener las solicitudes del usuario")
    })
    public ResponseEntity<List<SolicitudDto>> solicitudesRealizadasPorUsuario(@PathVariable String email) {
        return ResponseEntity.ok(
            usuarioService.obtenerSolicitudesPorUsuario(email)
                .stream()
                .map(SolicitudMapper::toDto)
                .collect(Collectors.toList())
        );
    }
*/

}