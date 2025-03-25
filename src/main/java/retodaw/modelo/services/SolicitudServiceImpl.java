package retodaw.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retodaw.modelo.entities.Solicitud;
import retodaw.modelo.repository.SolicitudRepository;
@Service
public class SolicitudServiceImpl implements SolicitudService{
	@Autowired
    private SolicitudRepository solicitudRepository;
    
    @Override
    public Solicitud alta(Solicitud solicitud) {
        try {
            if (solicitudRepository.existsById(solicitud.getId_solicitud()))
                return null;
            else  
                return solicitudRepository.save(solicitud);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Solicitud modificar(Solicitud solicitud) {
        try {
            if (solicitudRepository.existsById(solicitud.getId_solicitud()))
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

}
