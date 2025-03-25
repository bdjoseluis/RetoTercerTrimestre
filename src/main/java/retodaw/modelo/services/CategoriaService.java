package retodaw.modelo.services;

import java.util.List;

import retodaw.modelo.entities.Categoria;

public interface CategoriaService {
	Categoria alta(Categoria vacante);
	Categoria modificar(Categoria vacante);
    int eliminar(int id);
    Categoria buscarUna(int id);
    List<Categoria> buscarTodos();
}
