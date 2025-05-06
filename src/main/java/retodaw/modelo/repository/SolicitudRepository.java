package retodaw.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.v3.oas.annotations.Hidden;
import retodaw.modelo.entities.Solicitud;
import retodaw.modelo.entities.Usuario;
import retodaw.modelo.entities.Vacante;

@Repository
public interface SolicitudRepository extends JpaRepository <Solicitud, Integer>{

	List<Solicitud> findByUsuario(Usuario usuario);

	List<Solicitud> findByVacante(Vacante vacante);

}
