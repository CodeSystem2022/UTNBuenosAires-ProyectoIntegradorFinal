package com.proyecto_integrador.utnbuenosaires.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NotificacionPagoDto {
    @NotBlank(message = "El campo 'idNotificacion' no puede estar en blanco")
    private String idNotificacion;

    @NotBlank(message = "El campo 'estado' no puede estar en blanco")
    private String estado;

    @Positive(message = "El pagoId debe ser un número positivo")
    private Long pagoId;
}
