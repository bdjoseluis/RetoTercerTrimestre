package retodaw.modelo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "solicitudes")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
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
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_vacante", referencedColumnName = "id_vacante", nullable = false)
    private Vacante vacante;

}
