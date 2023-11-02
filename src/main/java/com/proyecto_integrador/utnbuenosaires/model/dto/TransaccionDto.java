package com.proyecto_integrador.utnbuenosaires.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TransaccionDto {
    @Size(max = 5, message = "El campo 'idTransaccion' debe tener como máximo 5 caracteres")
    private String idTransaccion;

    @NotBlank(message = "El campo 'estado' no puede estar vacío")
    private String estado;

    @NotBlank(message = "El campo 'pagoId' no puede ser nulo")
    private Long pagoId;
}
