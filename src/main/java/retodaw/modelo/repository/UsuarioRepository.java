package retodaw.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.v3.oas.annotations.Hidden;
import retodaw.modelo.entities.Usuario;
@Hidden
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	Usuario findByEmail(String email);

	void eliminarPorEmail(Usuario usuario);

}
