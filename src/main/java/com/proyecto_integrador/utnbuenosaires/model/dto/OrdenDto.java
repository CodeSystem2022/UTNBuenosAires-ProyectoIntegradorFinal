package com.proyecto_integrador.utnbuenosaires.model.dto;

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

    @Size(max = 5)
    private String numero;

    @PastOrPresent
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaCreacion;

    @PastOrPresent
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaRecibida;

    private double total;

}