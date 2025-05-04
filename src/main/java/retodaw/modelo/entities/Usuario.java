package retodaw.modelo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int enabled;

    @Column(name = "fecha_Registro", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @Column(nullable = false)
    private String rol;

    @OneToMany(mappedBy = "usuario")
    private List<Solicitud> solicitudes;

}
