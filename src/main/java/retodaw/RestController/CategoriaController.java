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
@RequestMapping("/categorias")
@Tag(name = "Categorias", description = "Operaciones sobre las categorías")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	CategoriaDto categoriaDto;
	
	@PostMapping("/alta")
    @Operation(summary = "Dar de alta una categoría", description = "registra una nueva categoría")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Comercial registrado con exito"),
        @ApiResponse(responseCode = "500", description = "Error al registrar el comercial")
    })
    public ResponseEntity<CategoriaDto> alta(@RequestBody CategoriaDto categoriaDto) {
        return ResponseEntity.ok(CategoriaMapper.toDto(categoriaService.alta(CategoriaMapper.toEntity(categoriaDto))));
    }

    @PutMapping("/modificar")
    @Operation(summary = "Modificar una categoría", description = "Actualiza los datos de una categoría existente.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Categoría modificado con éxito"),
        @ApiResponse(responseCode = "404", description = "Categoría no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error al modificar la categoría")
    })
    public ResponseEntity<CategoriaDto> modificar(@RequestBody CategoriaDto categoriaDto) {
        return ResponseEntity.ok(CategoriaMapper.toDto(categoriaService.modificar(CategoriaMapper.toEntity(categoriaDto))));
    }

    @DeleteMapping("/eliminar/{idCategoria}")
    @Operation(summary = "Eliminar una categoría", description = "Borra una categoría por su id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Categoría eliminada con éxito"),
        @ApiResponse(responseCode = "404", description = "Categoría no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error al eliminar la categoría")
    })
    public ResponseEntity<Integer> eliminar(@PathVariable int idCategoria) {
        return ResponseEntity.ok(categoriaService.eliminar(idCategoria));
    }

    @GetMapping("/uno/{idCategoria}")
    @Operation(summary = "Buscar una categoría", description = "obtiene los datos de un categoría por su id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Categoría encontrada"),
        @ApiResponse(responseCode = "404", description = "Ccategoría no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error al buscar la categoría")
    })
    public ResponseEntity<CategoriaDto> buscarUno(@PathVariable int idCategoria) {
        return ResponseEntity.ok(CategoriaMapper.toDto(categoriaService.buscarUna(idCategoria)));
    }

    @GetMapping("/todos")
    @Operation(summary = "Listar todos las categorías", description = "devuelve una lista con todas las categorías")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "lista obtenida con exito"),
        @ApiResponse(responseCode = "500", description = "Error al obtener la lista de categorías")
    })
    public ResponseEntity<List<CategoriaDto>> buscarTodos() {
        return ResponseEntity.ok(categoriaService.buscarTodos()
                .stream()
                .map(CategoriaMapper::toDto)
                .collect(Collectors.toList()));
    }

  

}
