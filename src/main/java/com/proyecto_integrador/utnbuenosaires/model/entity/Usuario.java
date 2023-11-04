package com.proyecto_integrador.utnbuenosaires.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 8, unique = true, nullable = false)
    private String dni;

    @Column(length = 11, unique = true, nullable = false)
    private String cuil;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 150, nullable = false)
    private String lastName;

    @Column(length = 20, nullable = false)
    private String telephone;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 150, nullable = false)
    private String neighborhood;

    @Column(length = 150, nullable = false)
    private String province;

    @Column(length = 150, nullable = false)
    private String country;

    @Column(length = 150, nullable = false)
    private String nameUser;

    @Column(length = 150, nullable = false)
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos;

    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes;

    public Usuario(String dni, String cuil, String name, String lastName, String telephone, String email, String neighborhood, String province, String country, String nameUser, String password) {
        this.dni = dni;
        this.cuil = cuil;
        this.name = name;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.neighborhood = neighborhood;
        this.province = province;
        this.country = country;
        this.nameUser = nameUser;
        this.password = password;
    }
}
