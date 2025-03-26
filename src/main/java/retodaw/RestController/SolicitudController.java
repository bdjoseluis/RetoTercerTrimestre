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
import retodaw.modelo.services.SolicitudService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/solicitudes")
@Tag(name = "Solicitudes", description = "Operaciones sobre las solicitudes")
public class SolicitudController {

    @Autowired
    SolicitudService solicitudService;
    
    @Autowired
    SolicitudDto solicitudDto;
    
    @PostMapping("/alta")
    @Operation(summary = "Dar de alta una solicitud", description = "registra una nueva solicitud")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Solicitud registrada con éxito"),
        @ApiResponse(responseCode = "500", description = "Error al registrar la solicitud")
    })
    public ResponseEntity<SolicitudDto> alta(@RequestBody SolicitudDto solicitudDto) {
        return ResponseEntity.ok(SolicitudMapper.toDto(solicitudService.alta(SolicitudMapper.toEntity(solicitudDto))));
    }

    @PutMapping("/modificar")
    @Operation(summary = "Modificar una solicitud", description = "Actualiza los datos de una solicitud existente.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Solicitud modificada con éxito"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error al modificar la solicitud")
    })
    public ResponseEntity<SolicitudDto> modificar(@RequestBody SolicitudDto solicitudDto) {
        return ResponseEntity.ok(SolicitudMapper.toDto(solicitudService.modificar(SolicitudMapper.toEntity(solicitudDto))));
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
    @Operation(summary = "Buscar una solicitud", description = "obtiene los datos de una solicitud por su id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Solicitud encontrada"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error al buscar la solicitud")
    })
    public ResponseEntity<SolicitudDto> buscarUno(@PathVariable int idSolicitud) {
        return ResponseEntity.ok(SolicitudMapper.toDto(solicitudService.buscarUna(idSolicitud)));
    }

    @GetMapping("/todos")
    @Operation(summary = "Listar todas las solicitudes", description = "devuelve una lista con todas las solicitudes")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "lista obtenida con éxito"),
        @ApiResponse(responseCode = "500", description = "Error al obtener la lista de solicitudes")
    })
    public ResponseEntity<List<SolicitudDto>> buscarTodos() {
        return ResponseEntity.ok(solicitudService.buscarTodos()
                .stream()
                .map(SolicitudMapper::toDto)
                .collect(Collectors.toList()));
    }
}