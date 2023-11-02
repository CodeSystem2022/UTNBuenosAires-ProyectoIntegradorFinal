package com.proyecto_integrador.utnbuenosaires.model.dto;

import com.proyecto_integrador.utnbuenosaires.model.entity.DetalleCarrito;
import com.proyecto_integrador.utnbuenosaires.model.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CarritoDto {

    @NotBlank(message = "El campo 'usuario' no puede estar en blanco")
    private String usuario;

    @NotNull(message = "La lista de detalles no puede ser nula")
    private List<DetalleCarritoDto> detalles;

}
