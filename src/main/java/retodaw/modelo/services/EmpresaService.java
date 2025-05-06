package retodaw.modelo.services;

import java.util.List;

import retodaw.modelo.entities.Empresa;
import retodaw.modelo.entities.Solicitud;

public interface EmpresaService {

    Empresa alta(Empresa vacante);
    Empresa modificar(Empresa vacante);
    int eliminar(int id);
    Empresa buscarUna(int id);
    List<Empresa> buscarTodos();
    List<Solicitud> obtenerSolicitudesDeEmpresa(int idEmpresa);

    //método nuevo
    Empresa buscarPorEmail(String email);

}