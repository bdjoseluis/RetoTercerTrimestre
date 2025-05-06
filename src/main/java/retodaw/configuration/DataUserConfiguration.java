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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.List;

// Configuración principal de seguridad con Spring Security (políticas de autenticación, autorización y CORS)
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

	// Configuración de PasswordEncoder (BCrypt)
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Configuracion de seguridad (filtros y permisos)
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // Deshabilitar CSRF (para permitir peticiones desde el frontend)
				.cors(withDefaults())

				.authorizeHttpRequests(auth -> auth
						// Rutas publicas
						.requestMatchers("/auth/signup", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
						.requestMatchers("/signup/**").permitAll()

						// Rutas privadas
						.requestMatchers("/vacantes/**").hasAnyAuthority("CLIENTE", "ADMON")
						.requestMatchers("/empresas/**").hasAnyAuthority("EMPRESA", "ADMON")
						.requestMatchers("/categorias/**").hasAnyAuthority("EMPRESA", "ADMON")
						.requestMatchers("/solicitudes/**").hasAnyAuthority("EMPRESA", "ADMON")
						.requestMatchers("/usuarios/solicitudes/**").hasAnyAuthority("EMPRESA", "ADMON", "CLIENTE")

						// Cualquier otra solicitud requiere autenticacion
						.anyRequest().authenticated())

				// Activar autenticación básica (envío de usuario-contraseña en cabecera HTTP)
				// Como está deprecated añadimos withDefaults para completar lo que le falte
				.httpBasic(withDefaults())

				// Configuramos por último logout
				.logout(logout -> logout.permitAll());

		return http.build();
	}

	// Configuración de CORS para permitir las peticiones del frontend
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(List.of("http://localhost:4200"));
		configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		configuration.setAllowedHeaders(List.of("*", "Authorization", "Content-Type"));
		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
