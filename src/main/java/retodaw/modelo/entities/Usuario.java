package retodaw.modelo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Usuarios")
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

    public Usuario(String email, String nombre, String apellidos, String password, int enabled, Date fechaRegistro, String rol) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.enabled = enabled;
        this.fechaRegistro = fechaRegistro;
        this.rol = rol;
    }
}
