package es.instituto.orientacion.seguimiento_casos.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", unique = true)
    private String nombre;

    @Column(name = "contraseña")
    private  String contraseña;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Role role;

    public Usuarios() {
    }
}
