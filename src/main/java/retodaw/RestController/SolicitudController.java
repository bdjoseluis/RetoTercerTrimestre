package retodaw.RestController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import retodaw.dtos.SolicitudDto;
import retodaw.dtos.SolicitudMapper;
import retodaw.modelo.entities.Solicitud;
import retodaw.modelo.entities.Usuario;
import retodaw.modelo.entities.Vacante;
import retodaw.modelo.services.SolicitudService;
import retodaw.modelo.services.UsuarioService;
import retodaw.modelo.services.VacanteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/solicitudes")
@Tag(name = "Solicitudes", description = "Operaciones sobre las solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private VacanteService vacanteService;

    @PostMapping("/alta")
    @Operation(summary = "Dar de alta una solicitud", description = "Registra una nueva solicitud")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Solicitud registrada con éxito"),
        @ApiResponse(responseCode = "500", description = "Error al registrar la solicitud")
    })
    public ResponseEntity<SolicitudDto> alta(@RequestBody SolicitudDto solicitudDto) {
        Usuario usuario = usuarioService.buscarUno(solicitudDto.getEmail());
        if (usuario == null) {
            return ResponseEntity.badRequest().build();
        }

        Vacante vacante = vacanteService.buscarUna(solicitudDto.getIdVacante());
        if (vacante == null) {
            return ResponseEntity.badRequest().build();
        }

        Solicitud solicitud = SolicitudMapper.toEntity(solicitudDto, usuario, vacante);
        return ResponseEntity.ok(SolicitudMapper.toDto(solicitudService.alta(solicitud)));
    }

    @PutMapping("/modificar")
    @Operation(summary = "Modificar una solicitud", description = "Actualiza los datos de una solicitud existente.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Solicitud modificada con éxito"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error al modificar la solicitud")
    })
    public ResponseEntity<SolicitudDto> modificar(@RequestBody SolicitudDto solicitudDto) {
        Usuario usuario = usuarioService.buscarUno(solicitudDto.getEmail());
        if (usuario == null) {
            return ResponseEntity.badRequest().build();
        }

        Vacante vacante = vacanteService.buscarUna(solicitudDto.getIdVacante());
        if (vacante == null) {
            return ResponseEntity.badRequest().build();
        }

        Solicitud solicitud = SolicitudMapper.toEntity(solicitudDto, usuario, vacante);
        return ResponseEntity.ok(SolicitudMapper.toDto(solicitudService.modificar(solicitud)));
    }

    @DeleteMapping("/eliminar/{idSolicitud}")
    @Operation(summary = "Eliminar una solicitud", description = "Borra una solicitud por su id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Solicitud eliminada con éxito"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error al eliminar la solicitud")
    })
    public ResponseEntity<Integer> eliminar(@PathVariable int idSolicitud) {
        return ResponseEntity.ok(solicitudService.eliminar(idSolicitud));
    }

    @GetMapping("/uno/{idSolicitud}")
    @Operation(summary = "Buscar una solicitud", description = "Obtiene los datos de una solicitud por su id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Solicitud encontrada"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error al buscar la solicitud")
    })
    public ResponseEntity<SolicitudDto> buscarUno(@PathVariable int idSolicitud) {
        return ResponseEntity.ok(SolicitudMapper.toDto(solicitudService.buscarUna(idSolicitud)));
    }

    @GetMapping("/todos")
    @Operation(summary = "Listar todas las solicitudes", description = "Devuelve una lista con todas las solicitudes")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito"),
        @ApiResponse(responseCode = "500", description = "Error al obtener la lista de solicitudes")
    })
    public ResponseEntity<List<SolicitudDto>> buscarTodos() {
        return ResponseEntity.ok(solicitudService.buscarTodos()
                .stream()
                .map(SolicitudMapper::toDto)
                .collect(Collectors.toList()));
    }
}
