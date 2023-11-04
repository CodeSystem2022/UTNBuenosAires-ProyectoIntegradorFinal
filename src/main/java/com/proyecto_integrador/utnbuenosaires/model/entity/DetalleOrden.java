package com.proyecto_integrador.utnbuenosaires.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "detalles_ordenes")
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Orden orden;

    private Long idProducto; // Cambio el tipo a Long para almacenar el ID del producto.

    public DetalleOrden(String nombre, double cantidad, double precio, Orden orden, Long idProducto) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.orden = orden;
        this.idProducto = idProducto;
    }

    public double calcularTotal() {
        return cantidad * precio;
    }
}
