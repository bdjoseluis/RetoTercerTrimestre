package retodaw.modelo.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retodaw.modelo.entities.Empresa;
import retodaw.modelo.repository.EmpresaRepository;


@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
    private EmpresaRepository empresaRepository;
    
    @Override
    public Empresa alta(Empresa empresa) {
        try {
            if (empresaRepository.existsById(empresa.getId_empresa()))
                return null;
            else  
                return empresaRepository.save(empresa);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Empresa modificar(Empresa empresa) {
        try {
            if (empresaRepository.existsById(empresa.getId_empresa()))
                return empresaRepository.save(empresa);
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
            if (empresaRepository.existsById(id)) {
            	empresaRepository.deleteById(id);
                return 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Empresa buscarUna(int id) {
        return empresaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Empresa> buscarTodos() {
        return empresaRepository.findAll();
    }

}