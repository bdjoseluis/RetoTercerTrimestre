package retodaw.modelo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retodaw.modelo.entities.Solicitud;
import retodaw.modelo.entities.Usuario;
import retodaw.modelo.entities.Vacante;
import retodaw.modelo.repository.SolicitudRepository;
import retodaw.modelo.repository.UsuarioRepository;
import retodaw.modelo.repository.VacanteRepository;
@Service
public class SolicitudServiceImpl implements SolicitudService{
	@Autowired
    private SolicitudRepository solicitudRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private VacanteRepository vacanteRepository;

    @Override
    public Solicitud alta(Solicitud solicitud) {
        try {
            if (solicitudRepository.existsById(solicitud.getIdSolicitud()))
                return null;
            else  
                return solicitudRepository.save(solicitud);
        } catch (Exception e) {
        	//e.getMessage();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Solicitud modificar(Solicitud solicitud) {
        try {
            if (solicitudRepository.existsById(solicitud.getIdSolicitud()))
                return solicitudRepository.save(solicitud);
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
            if (solicitudRepository.existsById(id)) {
            	solicitudRepository.deleteById(id);
                return 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Solicitud buscarUna(int id) {
        return solicitudRepository.findById(id).orElse(null);
    }

    @Override
    public List<Solicitud> buscarTodos() {
        return solicitudRepository.findAll();
    }

	@Override
	public List<Solicitud> obtenerSolicitudesPorUsuario(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario == null) {
			return new ArrayList<>();
		}
		return solicitudRepository.findByUsuario(usuario);
	}

	@Override
	public List<Solicitud> obtenerSolicitudesPorVacante(int idVacante) {
		Vacante vacante = vacanteRepository.findById(idVacante).orElse(null);
		if (vacante == null) {
			return new ArrayList<>();
		}
		return solicitudRepository.findByVacante(vacante);
	}

}
