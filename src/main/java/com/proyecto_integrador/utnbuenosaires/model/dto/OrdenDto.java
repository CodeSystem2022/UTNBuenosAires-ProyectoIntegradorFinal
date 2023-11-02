package com.proyecto_integrador.utnbuenosaires.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyecto_integrador.utnbuenosaires.model.entity.Orden;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrdenDto {

    @Size(max = 5, message = "El campo 'numero' no puede tener más de 5 caracteres")
    private String numero;

    @PastOrPresent(message = "La fecha de creación debe ser en el pasado o presente")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaCreacion;

    @PastOrPresent(message = "La fecha recibida debe ser en el pasado o presente")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaRecibida;

    @Positive(message = "El total debe ser un número positivo")
    private double total;

}