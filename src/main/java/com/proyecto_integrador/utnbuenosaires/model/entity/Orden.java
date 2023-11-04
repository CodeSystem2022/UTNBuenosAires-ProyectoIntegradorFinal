package com.proyecto_integrador.utnbuenosaires.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleOrden> detalles = new ArrayList<>();

    @ManyToOne
    private Usuario usuario;

    @Column(columnDefinition = "DOUBLE DEFAULT 0.0")
    @Formula("COALESCE((SELECT SUM(d.cantidad * d.precio) FROM detalles d WHERE d.orden_id = id), 0)")
    private double total;
}
