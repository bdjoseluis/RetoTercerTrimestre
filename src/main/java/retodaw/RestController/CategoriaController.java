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
import retodaw.dtos.CategoriaDto;
import retodaw.dtos.CategoriaMapper;
import retodaw.modelo.services.CategoriaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clientes")
@Tag(name = "Clientes", description = "Operaciones sobre los clientes")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	CategoriaDto categoriaDto;
	
	@PostMapping("/alta")
    @Operation(summary = "Dar de alta un comercial", description = "registra un nuevo comercial")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Comercial registrado con exito"),
        @ApiResponse(responseCode = "500", description = "Error al registrar el comercial")
    })
    public ResponseEntity<CategoriaDto> alta(@RequestBody CategoriaDto categoriaDto) {
        return ResponseEntity.ok(CategoriaMapper.toDto(categoriaService.alta(CategoriaMapper.toEntity(categoriaDto))));
    }

    @PutMapping("/modificar")
    @Operation(summary = "Modificar un comercial", description = "Actualiza los datos de un comercial existente.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Comercial modificado con ezito"),
        @ApiResponse(responseCode = "404", description = "Comercial no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error al modificar el comercial")
    })
    public ResponseEntity<CategoriaDto> modificar(@RequestBody CategoriaDto comercialDto) {
        return ResponseEntity.ok(CategoriaMapper.toDto(categoriaService.modificar(CategoriaMapper.toEntity(comercialDto))));
    }

    @DeleteMapping("/eliminar/{idComercial}")
    @Operation(summary = "Eliminar un comercial", description = "Borra un comercial por su id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Comercial eliminado con éxito"),
        @ApiResponse(responseCode = "404", description = "Comercial no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error al eliminar el comercial")
    })
    public ResponseEntity<Integer> eliminar(@PathVariable int idComercial) {
        return ResponseEntity.ok(categoriaService.eliminar(idComercial));
    }

    @GetMapping("/uno/{idComercial}")
    @Operation(summary = "Buscar un comercial", description = "obtiene los datos de un comercial por su id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Comercial encontrado"),
        @ApiResponse(responseCode = "404", description = "Comercial no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error al buscar el comercial")
    })
    public ResponseEntity<CategoriaDto> buscarUno(@PathVariable int idCategoria) {
        return ResponseEntity.ok(CategoriaMapper.toDto(categoriaService.buscarUna(idCategoria)));
    }

    @GetMapping("/todos")
    @Operation(summary = "Listar todos los clientes", description = "devuelve una lista con todos los clientes")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "lista obtenida con exito"),
        @ApiResponse(responseCode = "500", description = "Error al obtener la lista de clientes")
    })
    public ResponseEntity<List<CategoriaDto>> buscarTodos() {
        return ResponseEntity.ok(categoriaService.buscarTodos()
                .stream()
                .map(CategoriaMapper::toDto)
                .collect(Collectors.toList()));
    }

  

}
