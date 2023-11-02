package com.proyecto_integrador.utnbuenosaires.model.service;

import com.proyecto_integrador.utnbuenosaires.model.dto.TransaccionDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ITransaccionService {

    List<TransaccionDto> getTransacciones();

    TransaccionDto getTransaccionById(Long id);

    ResponseDto createTransaccion(TransaccionDto transaccionDto);

    Optional<ResponseEntity<TransaccionDto>> updateTransaccion(Long id, @Valid TransaccionDto transaccionDto);

    ResponseDto deleteTransaccion(Long id);
}
