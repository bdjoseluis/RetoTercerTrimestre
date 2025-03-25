package retodaw.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retodaw.modelo.entities.Vacante;
import retodaw.modelo.repository.VacanteRepository;

@Service
public class VacanteServiceImpl implements VacanteService{
	@Autowired
    private VacanteRepository vacanteRepository;
    
    @Override
    public Vacante alta(Vacante vacante) {
        try {
            if (vacanteRepository.existsById(vacante.getIdVacante()))
                return null;
            else  
                return vacanteRepository.save(vacante);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Vacante modificar(Vacante vacante) {
        try {
            if (vacanteRepository.existsById(vacante.getIdVacante()))
                return vacanteRepository.save(vacante);
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
            if (vacanteRepository.existsById(id)) {
            	vacanteRepository.deleteById(id);
                return 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Vacante buscarUna(int id) {
        return vacanteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vacante> buscarTodos() {
        return vacanteRepository.findAll();
    }

}
