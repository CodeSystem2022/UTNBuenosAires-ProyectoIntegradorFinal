package com.proyecto_integrador.utnbuenosaires.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "detalles_carrito")
public class DetalleCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;

    @ManyToOne
    private Carrito carrito;

    @ManyToOne
    private Producto producto;

    public DetalleCarrito(int cantidad, Carrito carrito, Producto producto) {
        this.cantidad = cantidad;
        this.carrito = carrito;
        this.producto = producto;
    }
}
