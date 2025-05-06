package retodaw.modelo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.v3.oas.annotations.Hidden;
import retodaw.modelo.entities.Empresa;

@Hidden
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
	
	Empresa findByEmail(String email);

}
