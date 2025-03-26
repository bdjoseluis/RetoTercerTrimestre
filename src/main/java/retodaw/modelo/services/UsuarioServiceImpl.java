package retodaw.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retodaw.modelo.entities.Empresa;
import retodaw.modelo.entities.Usuario;
import retodaw.modelo.repository.EmpresaRepository;
import retodaw.modelo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public Usuario alta(Usuario usuario) {
        try {
            if (usuarioRepository.existsById(usuario.getEmail()))
                return null;
            else  
                return usuarioRepository.save(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuario modificar(Usuario empresa) {
        try {
            if (usuarioRepository.existsById(empresa.getEmail()))
                return usuarioRepository.save(empresa);
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
            if (usuarioRepository.findByEmail(email) != null) {
            	usuarioRepository.deleteByEmail(email);
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
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

}
