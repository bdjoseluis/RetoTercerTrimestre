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

@Configuration
@EnableWebSecurity
public class DataUserConfiguration {

    @Bean
    UserDetailsManager usersCustom(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

        // Consultas para usuarios y roles
        users.setUsersByUsernameQuery(
            "SELECT email, password, enabled FROM Usuarios WHERE email = ?"
        );

        // Consulta para obtener roles
        users.setAuthoritiesByUsernameQuery(
            "SELECT email, rol FROM Usuarios WHERE email = ?"
        );

        return users;
    }

    // Configuración de PasswordEncoder (BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/**").permitAll()  // Permitir acceso sin autenticación a todas las rutas
                .requestMatchers("/vacantes/**").hasAnyAuthority("USUARIO", "ADMON")  // Solo usuarios con rol USUARIO o ADMON pueden acceder
                .requestMatchers("/empresas/**").hasAnyAuthority("EMPRESA", "ADMON")  // Solo usuarios con rol EMPRESA o ADMON pueden acceder
                .requestMatchers("/categorias/**").hasAnyAuthority("EMPRESA", "ADMON")
                .requestMatchers("/solicitudes/**").hasAnyAuthority("EMPRESA", "ADMON")
                .requestMatchers("/usuarios/solicitudes/:id").hasAnyAuthority("EMPRESA", "ADMON", "Cliente")
                .requestMatchers("/signup/**").permitAll() // Permitir acceso sin autenticación a la ruta de registro
                .requestMatchers("/**").hasAuthority("ADMON") // Los usuarios con rol ADMON pueden acceder a todo lo demás
            )
            .formLogin(form -> form
                .defaultSuccessUrl("/login")
                .failureUrl("/login-error")
                .permitAll()
            )
            .logout(logout -> logout.permitAll());

        return http.build();
    }
}
