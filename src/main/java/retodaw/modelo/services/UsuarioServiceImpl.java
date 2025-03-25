package retodaw.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import retodaw.modelo.entities.Empresa;
import retodaw.modelo.entities.Usuario;
import retodaw.modelo.repository.EmpresaRepository;
import retodaw.modelo.repository.UsuarioRepository;

public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
    private UsuarioRepository empresaRepository;
    
    @Override
    public Usuario alta(Usuario usuario) {
        try {
            if (empresaRepository.existsById(usuario.getEmail()))
                return null;
            else  
                return empresaRepository.save(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuario modificar(Usuario empresa) {
        try {
            if (empresaRepository.existsById(empresa.getEmail()))
                return empresaRepository.save(empresa);
            else  
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int eliminar(String email) {
        try {
            if (empresaRepository.findByEmail(email) != null) {
            	empresaRepository.eliminarPorEmail(empresaRepository.findByEmail(email));
                return 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Usuario buscarUno(String email) {
        return empresaRepository.findByEmail(email);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return empresaRepository.findAll();
    }

}
