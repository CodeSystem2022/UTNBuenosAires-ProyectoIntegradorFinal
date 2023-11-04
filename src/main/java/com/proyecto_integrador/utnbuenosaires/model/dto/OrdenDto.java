package com.proyecto_integrador.utnbuenosaires.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrdenDto {
    @Size(max = 10, message = "El campo 'numero' no puede tener más de 10 caracteres")
    private String numero;

    @PastOrPresent(message = "La fecha de creación debe ser en el pasado o presente")
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "UTC")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaCreacion;

    @PastOrPresent(message = "La fecha recibida debe ser en el pasado o presente")
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "UTC")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaRecibida;

    // Agrega una lista de DetalleOrdenDto para manejar los detalles en la misma solicitud
    private List<DetalleOrdenDto> detalles;

    // Agrega un campo para representar el usuario mediante su identificador único
    @NotNull(message = "El campo 'usuarioId' no puede ser nulo")
    private Long usuarioId; // Cambio a Long para representar el ID del usuario.
}
