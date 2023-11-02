package com.proyecto_integrador.utnbuenosaires.model.service;

import com.proyecto_integrador.utnbuenosaires.model.dto.MetodoPagoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IMetodoPagoService {

    List<MetodoPagoDto> getMetodosPago();

    MetodoPagoDto getMetodoPagoById(Long id);

    ResponseDto createMetodoPago(MetodoPagoDto metodoDto);

    Optional<ResponseEntity<MetodoPagoDto>> updateMetodoPago(Long id, @Valid MetodoPagoDto metodoDto);

    ResponseDto deleteMetodoPago(Long id);
}
