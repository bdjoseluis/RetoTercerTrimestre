package retodaw.modelo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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

    public Usuario(String email, String nombre, String apellidos, String password, int enabled, Date fechaRegistro, String rol, List<Solicitud> solicitudes) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.enabled = enabled;
        this.fechaRegistro = fechaRegistro;
        this.rol = rol;
        this.solicitudes = solicitudes;
    }

    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }
}
