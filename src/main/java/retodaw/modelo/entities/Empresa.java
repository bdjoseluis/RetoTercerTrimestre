package retodaw.modelo.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private int id_empresa;

    @Column(name = "cif", nullable = false, unique = true)
    private String cif;

    @Column(name = "nombre_empresa", nullable = false)
    private String nombre_empresa;

    @Column(name = "direccion_fiscal", nullable = false)
    private String direccion_fiscal;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

}
