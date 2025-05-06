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
import retodaw.dtos.EmpresaDto;
import retodaw.dtos.EmpresaMapper;
import retodaw.dtos.SolicitudDto;
import retodaw.dtos.SolicitudMapper;
import retodaw.modelo.entities.Empresa;
import retodaw.modelo.services.EmpresaService;
import retodaw.modelo.services.VacanteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/empresas")
@Tag(name = "Empresas", description = "Operaciones sobre las empresas")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @Autowired
    private VacanteService vacanteService;


    @PostMapping("/alta")
    @Operation(summary = "Dar de alta una empresa", description = "registra una nueva empresa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empresa registrado con exito"),
            @ApiResponse(responseCode = "500", description = "Error al registrar la empresa")
    })
    public ResponseEntity<EmpresaDto> alta(@RequestBody EmpresaDto empresaDto) {
        return ResponseEntity.ok(EmpresaMapper.toDto(empresaService.alta(EmpresaMapper.toEntity(empresaDto))));
    }

    @PutMapping("/modificar")
    @Operation(summary = "Modificar una empresa", description = "Actualiza los datos de una empresa existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empresa modificada con éxito"),
            @ApiResponse(responseCode = "404", description = "Empresa no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error al modificar la empresa")
    })
    public ResponseEntity<EmpresaDto> modificar(@RequestBody EmpresaDto empresaDto) {
        return ResponseEntity.ok(EmpresaMapper.toDto(empresaService.modificar(EmpresaMapper.toEntity(empresaDto))));
    }

    @DeleteMapping("/eliminar/{idEmpresa}")
    @Operation(summary = "Eliminar una empresa", description = "Borra una empresa por su id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empresa eliminada con éxito"),
            @ApiResponse(responseCode = "404", description = "Empresa no encontrada"),
            @ApiResponse(responseCode = "400", description = "La empresa no se puede eliminar porque tiene vacantes asociadas"),
            @ApiResponse(responseCode = "500", description = "Error al eliminar la empresa")
    })
    public ResponseEntity<Integer> eliminar(@PathVariable int idEmpresa) {
        try {
            if(vacanteService.vacantesPorEmpresa(idEmpresa).isEmpty()) {
                return ResponseEntity.ok(empresaService.eliminar(idEmpresa));
            }
            else {
                return ResponseEntity.status(400).body(null);
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/uno/{idEmpresa}")
    @Operation(summary = "Buscar una empresa", description = "obtiene los datos de una empresa por su id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empresa encontrado"),
            @ApiResponse(responseCode = "404", description = "Empresa no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error al buscar la empresa")
    })
    public ResponseEntity<EmpresaDto> buscarUno(@PathVariable int idEmpresa) {
        return ResponseEntity.ok(EmpresaMapper.toDto(empresaService.buscarUna(idEmpresa)));
    }

    @GetMapping("/todos")
    @Operation(summary = "Listar todos las empresas", description = "devuelve una lista con todas las empresas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "lista obtenida con exito"),
            @ApiResponse(responseCode = "500", description = "Error al obtener la lista de empresas")
    })
    public ResponseEntity<List<EmpresaDto>> buscarTodos() {
        return ResponseEntity.ok(empresaService.buscarTodos()
                .stream()
                .map(EmpresaMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/vacante/solicitudes/{idEmpresa}")
    @Operation(summary = "Solicitudes recibidas por una empresa", description = "Devuelve una lista de solicitudes recibidas a través de las vacantes de una empresa específica")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Solicitudes obtenidas con éxito"),
            @ApiResponse(responseCode = "404", description = "Empresa no encontrada o sin vacantes"),
            @ApiResponse(responseCode = "500", description = "Error al obtener las solicitudes")
    })
    public ResponseEntity<List<SolicitudDto>> obtenerSolicitudesRecibidasPorEmpresa(@PathVariable int idEmpresa) {
        try {
            return ResponseEntity.ok(
                    empresaService.obtenerSolicitudesDeEmpresa(idEmpresa)
                            .stream()
                            .map(SolicitudMapper::toDto)
                            .collect(Collectors.toList())
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Buscar una empresa por email", description = "obtiene los datos de una emprea por su email")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empresa encontrada"),
            @ApiResponse(responseCode = "404", description = "Empresa no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error al buscar la empresa")
    })
    public ResponseEntity<EmpresaDto> buscarPorEmail(@PathVariable String email) {
        Empresa empresa = empresaService.buscarPorEmail(email);
        if (empresa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(EmpresaMapper.toDto(empresa));
    }



}