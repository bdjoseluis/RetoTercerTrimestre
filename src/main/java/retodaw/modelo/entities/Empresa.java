package retodaw.modelo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Empresas")
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
