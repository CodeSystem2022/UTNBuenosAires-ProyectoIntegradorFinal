package com.proyecto_integrador.utnbuenosaires.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MetodoPagoDto {
    @Size(min = 2, max = 100)
    @NotBlank
    private String nombre;

    @Size(min = 2, max = 150)
    @NotBlank
    private String icono;
}
