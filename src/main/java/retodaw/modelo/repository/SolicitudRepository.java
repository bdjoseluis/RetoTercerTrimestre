package retodaw.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.v3.oas.annotations.Hidden;
import retodaw.modelo.entities.Solicitud;
@Hidden
@Repository
public interface SolicitudRepository extends JpaRepository <Solicitud, Integer>{

}
