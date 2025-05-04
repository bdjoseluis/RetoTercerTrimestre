package retodaw.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

//Configuración principal de seguridad con Spring Security.
//Define políticas de autenticación, autorización y CORS.
@Configuration
@EnableWebSecurity
public class DataUserConfiguration {

	@Bean
	UserDetailsManager usersCustom(DataSource dataSource) {
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

		// Consultas para obtener datos del usuario (email = username)
		users.setUsersByUsernameQuery("SELECT email, password, enabled FROM usuarios WHERE email = ?");

		// Consulta para obtener roles
		users.setAuthoritiesByUsernameQuery("SELECT email, rol FROM usuarios WHERE email = ?");

		return users;
	}

	// Bean para codificar contraseñas usando BCrypt.
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // Deshabilitar CSRF (para permitir peticiones desde el frontend)
				.authorizeHttpRequests(auth -> auth
						// SWAGGER - Permitir acceso a documentación pública
						.requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()

						// AUTH
						.requestMatchers("/auth/**").permitAll()

						// USUARIOS - Rutas protegidas
						.requestMatchers("/vacantes/**").hasAnyAuthority("CLIENTE", "ADMON")
						.requestMatchers("/empresas/**").hasAnyAuthority("EMPRESA", "ADMON")
						.requestMatchers("/categorias/**").hasAnyAuthority("EMPRESA", "ADMON")
						.requestMatchers("/solicitudes/**").hasAnyAuthority("EMPRESA", "ADMON")
						.requestMatchers("/usuarios/solicitudes/**").hasAnyAuthority("EMPRESA", "ADMON", "CLIENTE")

						// Por defecto, cualquier otra ruta requiere autenticación
						.anyRequest().authenticated())

				// Activar autenticación básica (envío de usuario-contraseña en cabecera HTTP)
				// Como está deprecated añadimos withDefaults para completar lo que le falte
				.httpBasic(withDefaults())

				// Configuramos por último logout
				.logout(logout -> logout.permitAll());

		return http.build();
	}

}
