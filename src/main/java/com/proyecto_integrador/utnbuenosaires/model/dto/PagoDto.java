package com.proyecto_integrador.utnbuenosaires.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PagoDto {
    @NotNull(message = "El campo 'monto' no puede estar vacío")
    @DecimalMin(value = "0.01", message = "El monto debe ser mayor que 0")
    private Double monto;

    @NotBlank(message = "El campo 'estado' no puede estar vacío")
    private String estado;

    @NotNull(message = "El campo 'ordenId' no puede estar vacío")
    @Min(value = 1, message = "El ID de la orden debe ser mayor que 0")
    private Long ordenId;

    @NotNull(message = "El campo 'metodoPagoId' no puede estar vacío")
    @Min(value = 1, message = "El ID del método de pago debe ser mayor que 0")
    private Long metodoPagoId;
}
