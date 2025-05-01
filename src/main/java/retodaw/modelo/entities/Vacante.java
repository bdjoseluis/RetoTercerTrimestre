package retodaw.modelo.entities;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vacantes")
@Schema(description = "vacantes")
public class Vacante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacante")
    private int idVacante;

    private String nombre;
    private String descripcion;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private double salario;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estatus estatus;

    @Column(nullable = false)
    private Byte destacado;

    private String imagen;
    private String detalles;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", nullable = false)
    private Empresa empresa;
}
