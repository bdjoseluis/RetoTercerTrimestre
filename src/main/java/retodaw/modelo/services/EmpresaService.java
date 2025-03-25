package retodaw.modelo.services;

import java.util.List;

import retodaw.modelo.entities.Empresa;

public interface EmpresaService {

	Empresa alta(Empresa vacante);
	Empresa modificar(Empresa vacante);
    int eliminar(int id);
    Empresa buscarUna(int id);
    List<Empresa> buscarTodos();
}
