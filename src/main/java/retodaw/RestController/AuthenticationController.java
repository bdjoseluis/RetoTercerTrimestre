package retodaw.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import retodaw.dtos.UsuarioDto;
import retodaw.dtos.UsuarioMapper;
import retodaw.dtos.UsuarioRegistroDTO;
import retodaw.modelo.services.UsuarioService;
import retodaw.modelo.entities.Usuario;

import java.security.Principal;

@Tag(name = "Auth Controller", description = "Autenticación y registro de usuarios")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private UsuarioService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Registro de usuario
	 */
	@PostMapping("/signup")
	public ResponseEntity<String> register(@RequestBody UsuarioDto usuarioDto) {
		try {
			Usuario user = UsuarioMapper.toEntity(usuarioDto);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userService.alta(user);

			return ResponseEntity.ok("Usuario registrado correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error: No se pudo registrar el usuario.");
		}
	}

	/**
	 * Login con autenticación básica (Spring Security lo maneja automáticamente)
	 */
	@GetMapping("/login")
	public ResponseEntity<?> authenticate(Principal principal) {
		if (principal != null) {
			Usuario user = userService.buscarUno(principal. getName());
			if (user != null) {
				UsuarioRegistroDTO dto = new UsuarioRegistroDTO(user.getEmail(), null); // password null para mayor seguridad
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
			}
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
		}
	}

	/**
	 * Obtener usuario por email
	 */
	@GetMapping("/userByEmail/{email}")
	public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
		Usuario user = userService.buscarUno(email); // Devuelve un Usuario o null

		if (user != null) {
			return ResponseEntity.ok(user); // Si existe, devolver usuario
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario con email " + email + " no encontrado.");
		}
	}

}