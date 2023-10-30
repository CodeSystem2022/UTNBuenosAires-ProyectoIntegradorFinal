package com.proyecto_integrador.utnbuenosaires.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double monto;
    private String estado;

    @ManyToOne
    private Orden orden;

    @ManyToOne
    private MetodoPago metodoPago;

    @OneToOne
    private Transaccion transaccion;
}
