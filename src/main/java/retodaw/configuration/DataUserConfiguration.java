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


@Configuration
@EnableWebSecurity
public class DataUserConfiguration {

    @Bean
    UserDetailsManager usersCustom(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

        // Consultas para obtener datos del usuario (email = username)
        users.setUsersByUsernameQuery(
            "SELECT email, password, enabled FROM usuarios WHERE email = ?"
        );

        // Consulta para obtener roles
        users.setAuthoritiesByUsernameQuery(
            "SELECT email, rol FROM usuarios WHERE email = ?"
        );

        return users;
    }

    // Configuración de PasswordEncoder (BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // añadido SuppressWarnings("removal") ya que httpBasic fue suprimido pero aún funciona, para evitar error de deprecated
    @SuppressWarnings("removal") 
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF (para permitir peticiones desde el frontend)
            .authorizeHttpRequests(auth -> auth
            	// Permitir acceso sin autenticación a rutas públicas
            	// faltaba el /auth antes de /signup!!! y añadimos swagger (q necesita v3/api-docs para funcionar)
            	.requestMatchers("/auth/signup", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
            	.requestMatchers("/signup/**").permitAll() // Permitir acceso sin autenticación a la ruta de registro
            	.requestMatchers("/auth/**").permitAll() // Permitir acceso sin autenticación a la ruta de registro
            	.requestMatchers("/auth/login").permitAll() // Permitir acceso sin autenticación a la ruta de registro

            	/*Comentado porque era contradictorio
                //.requestMatchers("/**").permitAll()  // Permitir acceso sin autenticación a todas las rutas
                */
            	
            	// Solo usuarios con rol USUARIO o ADMON pueden acceder a /vacantes/**
                .requestMatchers("/vacantes/**").hasAnyAuthority("USUARIO", "ADMON")  // Solo usuarios con rol USUARIO o ADMON pueden acceder
                
                // Solo usuarios con rol EMPRESA o ADMON pueden acceder a /empresas/**
                .requestMatchers("/empresas/**").hasAnyAuthority("EMPRESA", "ADMON")  // Solo usuarios con rol EMPRESA o ADMON pueden acceder

                .requestMatchers("/categorias/**").hasAnyAuthority("EMPRESA", "ADMON")
                .requestMatchers("/solicitudes/**").hasAnyAuthority("EMPRESA", "ADMON")
                .requestMatchers("/usuarios/solicitudes/:id").hasAnyAuthority("EMPRESA", "ADMON", "Cliente")
                
                /* linea conflictiva: .requestMatchers("/**").hasAuthority("ADMON") // Los usuarios con rol ADMON pueden acceder a todo lo demás
                (Significa que todo el sistema está restringido a usuarios con el rol ADMON)
                */
                
                .anyRequest().authenticated()
            )
            
            /*
            .formLogin(form -> form
                .defaultSuccessUrl("/login")
                .failureUrl("/login-error")
                .permitAll()
            )
            Esto ha sido comentado porque nos daba error y no permitía hacer las peticiones desde Angular. 
            En su lugar utilizaremmos httpBasic()
            */
            
            //Activar autenticación básica (envío de usuario-contraseña en cabecera HTTP)
            // Como está deprecated añadimos withDefaults para completar lo que le falte
            .httpBasic(withDefaults())

            //Configuramos por último logout
            .logout(logout -> logout.permitAll());

        return http.build();
    }
}
