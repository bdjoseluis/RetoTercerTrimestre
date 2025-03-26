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
    private CategoriaService categoriaService;

    @PostMapping("/alta")
    @Operation(summary = "Dar de alta una categoría", description = "Registra una nueva categoría")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Categoría registrada con éxito"),
        @ApiResponse(responseCode = "500", description = "Error al registrar la categoría")
    })
    public ResponseEntity<CategoriaDto> alta(@RequestBody CategoriaDto categoriaDto) {
        return ResponseEntity.ok(CategoriaMapper.toDto(categoriaService.alta(CategoriaMapper.toEntity(categoriaDto))));
    }

    @PutMapping("/modificar")
    @Operation(summary = "Modificar una categoría", description = "Actualiza los datos de una categoría existente.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Categoría modificada con éxito"),
        @ApiResponse(responseCode = "404", description = "Categoría no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error al modificar la categoría")
    })
    public ResponseEntity<CategoriaDto> modificar(@RequestBody CategoriaDto categoriaDto) {
        return ResponseEntity.ok(CategoriaMapper.toDto(categoriaService.modificar(CategoriaMapper.toEntity(categoriaDto))));
    }

    @DeleteMapping("/eliminar/{idCategoria}")
    @Operation(summary = "Eliminar una categoría", description = "Elimina una categoría por su id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Categoría eliminada con éxito"),
        @ApiResponse(responseCode = "404", description = "Categoría no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error al eliminar la categoría")
    })
    public ResponseEntity<Integer> eliminar(@PathVariable int idCategoria) {
        return ResponseEntity.ok(categoriaService.eliminar(idCategoria));
    }

    @GetMapping("/uno/{idCategoria}")
    @Operation(summary = "Buscar una categoría", description = "Obtiene los datos de una categoría por su id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Categoría encontrada"),
        @ApiResponse(responseCode = "404", description = "Categoría no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error al buscar la categoría")
    })
    public ResponseEntity<CategoriaDto> buscarUno(@PathVariable int idCategoria) {
        return ResponseEntity.ok(CategoriaMapper.toDto(categoriaService.buscarUna(idCategoria)));
    }

    @GetMapping("/todos")
    @Operation(summary = "Listar todas las categorías", description = "Devuelve una lista con todas las categorías")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito"),
        @ApiResponse(responseCode = "500", description = "Error al obtener la lista de categorías")
    })
    public ResponseEntity<List<CategoriaDto>> buscarTodos() {
        return ResponseEntity.ok(categoriaService.buscarTodos()
                .stream()
                .map(CategoriaMapper::toDto)
                .collect(Collectors.toList()));
    }
}
