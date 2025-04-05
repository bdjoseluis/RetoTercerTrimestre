package retodaw.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.swagger.v3.oas.annotations.Hidden;
import retodaw.modelo.entities.Empresa;
import retodaw.modelo.entities.Vacante;

@Hidden
@Repository
public interface VacanteRepository extends JpaRepository<Vacante, Integer>{


	@Query("select v from Vacante v where v.empresa.id_empresa = ?1")
    List<Vacante> findByEmpresaId(int id_empresa);

	List<Vacante> findByEmpresa(Empresa empresa);
}
