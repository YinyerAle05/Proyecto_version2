package pe.edu.utp.proyect.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cliente")
    private String cliente;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "estado")
    private String estado; // "A" = Activo, "I" = Inactivo, por ejemplo

    @Column(name = "total")
    private Double total;
}
