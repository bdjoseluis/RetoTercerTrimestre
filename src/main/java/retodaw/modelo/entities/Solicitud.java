package retodaw.modelo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Solicitudes")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSolicitud;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(nullable = false)
    private String archivo;

    private String comentarios;

    @Column(nullable = false)
    private Byte estado;


    private String curriculum;

    @ManyToOne
    @JoinColumn(name = "id_vacante", referencedColumnName = "id_vacante", nullable = false)
    private Vacante vacante;
    
    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private Usuario usuario;

    public Solicitud(int idSolicitud, Date fecha, String archivo, String comentarios, Byte estado, 
                     String curriculum, Usuario usuario, Vacante vacante) {
        this.idSolicitud = idSolicitud;
        this.fecha = fecha;
        this.archivo = archivo;
        this.comentarios = comentarios;
        this.estado = estado;
        this.curriculum = curriculum;
        this.usuario = usuario;
        this.vacante = vacante;
    }
}
