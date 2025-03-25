package retodaw.modelo.services;

import java.util.List;

import retodaw.modelo.entities.Solicitud;

public interface SolicitudService {
	Solicitud alta(Solicitud vacante);
	Solicitud modificar(Solicitud vacante);
    int eliminar(int id);
    Solicitud buscarUna(int id);
    List<Solicitud> buscarTodos();
}
