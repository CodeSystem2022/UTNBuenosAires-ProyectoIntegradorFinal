package com.proyecto_integrador.utnbuenosaires.model.entity;

import com.proyecto_integrador.utnbuenosaires.model.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Un producto disponible para la compra.
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "productos")
public class Producto {

    /** Id único para el producto. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Nombre del producto. */
    @Column(name ="nombre", nullable = false)
    private String nombre;

    /** Descripción del producto. */
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    /** Dirección de la imagen del producto. */
    @Column(name = "imagen", nullable = false)
    private String imagen;

    /** Precio del producto. */
    @Column(name = "precio", nullable = false)
    private double precio;

    /** Lista de categorias. */
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private Categoria categoria;

    private int cantidad;

    @ManyToOne
    private Usuario usuario;

    public Producto(String nombre, String descripcion, String imagen, double precio, int cantidad, Usuario usuario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.cantidad = cantidad;
        this.usuario = usuario;
    }

}
