package com.proyecto_integrador.utnbuenosaires.model.entity;

import com.proyecto_integrador.utnbuenosaires.model.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Un producto disponible para la compra.
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    private List<CartItem> products = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<OrderItem> orderItems = new ArrayList<>();

}
