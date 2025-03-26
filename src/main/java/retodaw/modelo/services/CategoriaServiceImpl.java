package retodaw.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retodaw.modelo.entities.Categoria;
import retodaw.modelo.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
    private CategoriaRepository categoriaRepository;
    
    @Override
    public Categoria alta(Categoria categoria) {
        try {
            if (categoriaRepository.existsById(categoria.getId_categoria()))
                return null;
            else  
                return categoriaRepository.save(categoria);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Categoria modificar(Categoria categoria) {
        try {
            if (categoriaRepository.existsById(categoria.getId_categoria()))
                return categoriaRepository.save(categoria);
            else  
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int eliminar(int id) {
    	try {
            if (categoriaRepository.existsById(id)) {
            	categoriaRepository.deleteById(id);
                return 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Categoria buscarUna(int id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

}