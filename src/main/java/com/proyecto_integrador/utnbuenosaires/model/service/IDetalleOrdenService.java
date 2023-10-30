package com.proyecto_integrador.utnbuenosaires.model.service;

import com.proyecto_integrador.utnbuenosaires.model.dto.DetalleOrdenDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.OrdenDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IDetalleOrdenService {

    List<DetalleOrdenDto> getDetallesOrdenes();

    DetalleOrdenDto getDetalleOrdenById(Long id);

    ResponseDto createDetalleOrden(DetalleOrdenDto detalleOrdenDto);

    Optional<ResponseEntity<DetalleOrdenDto>> updateDetalleOrden(Long id, @Valid DetalleOrdenDto detalleOrdenDto);

    ResponseDto deleteDetalleOrden(Long id);

}
