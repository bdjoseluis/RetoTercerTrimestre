package retodaw.modelo.services;

import java.util.Collection;
import java.util.List;

import retodaw.modelo.entities.Empresa;
import retodaw.modelo.entities.Solicitud;
import retodaw.modelo.entities.Vacante;

public interface EmpresaService {

	Empresa alta(Empresa vacante);
	Empresa modificar(Empresa vacante);
    int eliminar(int id);
    Empresa buscarUna(int id);
    List<Empresa> buscarTodos();
	List<Solicitud> obtenerSolicitudesDeEmpresa(int idEmpresa);
}
