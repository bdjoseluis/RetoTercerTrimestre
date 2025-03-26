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
import retodaw.dtos.VacanteDto;
import retodaw.dtos.VacanteMapper;
import retodaw.modelo.services.VacanteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vacantes")
@Tag(name = "Vacantes", description = "Operaciones sobre las vacantes")
public class VacanteController {

    @Autowired
    VacanteService vacanteService;
    
    @Autowired
    VacanteDto vacanteDto;
    
    @PostMapping("/alta")
    @Operation(summary = "Dar de alta una vacante", description = "registra una nueva vacante")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Vacante registrada con éxito"),
        @ApiResponse(responseCode = "500", description = "Error al registrar la vacante")
    })
    public ResponseEntity<VacanteDto> alta(@RequestBody VacanteDto vacanteDto) {
        return ResponseEntity.ok(VacanteMapper.toDto(vacanteService.alta(VacanteMapper.toEntity(vacanteDto))));
    }

    @PutMapping("/modificar")
    @Operation(summary = "Modificar una vacante", description = "Actualiza los datos de una vacante existente.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Vacante modificada con éxito"),
        @ApiResponse(responseCode = "404", description = "Vacante no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error al modificar la vacante")
    })
    public ResponseEntity<VacanteDto> modificar(@RequestBody VacanteDto vacanteDto) {
        return ResponseEntity.ok(VacanteMapper.toDto(vacanteService.modificar(VacanteMapper.toEntity(vacanteDto))));
    }

    @DeleteMapping("/eliminar/{idVacante}")
    @Operation(summary = "Eliminar una vacante", description = "Borra una vacante por su id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Vacante eliminada con éxito"),
        @ApiResponse(responseCode = "404", description = "Vacante no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error al eliminar la vacante")
    })
    public ResponseEntity<Integer> eliminar(@PathVariable int idVacante) {
        return ResponseEntity.ok(vacanteService.eliminar(idVacante));
    }

    @GetMapping("/uno/{idVacante}")
    @Operation(summary = "Buscar una vacante", description = "obtiene los datos de una vacante por su id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Vacante encontrada"),
        @ApiResponse(responseCode = "404", description = "Vacante no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error al buscar la vacante")
    })
    public ResponseEntity<VacanteDto> buscarUno(@PathVariable int idVacante) {
        return ResponseEntity.ok(VacanteMapper.toDto(vacanteService.buscarUna(idVacante)));
    }

    @GetMapping("/todos")
    @Operation(summary = "Listar todas las vacantes", description = "devuelve una lista con todas las vacantes")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "lista obtenida con éxito"),
        @ApiResponse(responseCode = "500", description = "Error al obtener la lista de vacantes")
    })
    public ResponseEntity<List<VacanteDto>> buscarTodos() {
        return ResponseEntity.ok(vacanteService.buscarTodos()
                .stream()
                .map(VacanteMapper::toDto)
                .collect(Collectors.toList()));
    }
}