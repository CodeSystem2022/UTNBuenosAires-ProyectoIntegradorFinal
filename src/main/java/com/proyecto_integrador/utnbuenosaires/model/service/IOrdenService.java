package com.proyecto_integrador.utnbuenosaires.model.service;

import com.proyecto_integrador.utnbuenosaires.model.dto.OrdenDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IOrdenService {

    List<OrdenDto> getOrdenes();

    OrdenDto getOrdenById(Long id);

    ResponseDto createOrden(OrdenDto ordenDto);

    Optional<ResponseEntity<OrdenDto>> updateOrden(Long id, @Valid OrdenDto OrdenDto);

    ResponseDto deleteOrden(Long id);

}
