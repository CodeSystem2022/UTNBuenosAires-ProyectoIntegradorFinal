package com.proyecto_integrador.utnbuenosaires.model.dto;

import com.proyecto_integrador.utnbuenosaires.model.entity.Orden;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrdenDto {


    private Long id;

    @Size(min = 1, max = 10)
    @NotBlank
    private String numero;

    @PastOrPresent
    @NotBlank
    private Date fechaCreacion;

    @PastOrPresent
    @NotBlank
    private Date fechaRecibida;

   @NotBlank
    private double total;

}