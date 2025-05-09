package retodaw.modelo.services;

import java.util.Collection;
import java.util.List;

import retodaw.modelo.entities.Empresa;
import retodaw.modelo.entities.Vacante;

public interface VacanteService {
	
	Vacante alta(Vacante vacante);
	Vacante modificar(Vacante vacante);
    int eliminar(int id);
    Vacante buscarUna(int id);
    List<Vacante> buscarTodos();
    List<Vacante> vacantesPorEmpresa(int id_empresa);
}
