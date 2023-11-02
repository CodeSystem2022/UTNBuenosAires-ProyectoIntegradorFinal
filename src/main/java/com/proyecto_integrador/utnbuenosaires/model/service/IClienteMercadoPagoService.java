package com.proyecto_integrador.utnbuenosaires.model.service;

import com.proyecto_integrador.utnbuenosaires.model.dto.ClienteMercadoPagoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface IClienteMercadoPagoService {

    List<ClienteMercadoPagoDto> getClientesMercadoPago();

    ClienteMercadoPagoDto getClienteMercadoPagoById(Long id);

    ClienteMercadoPagoDto createClienteMercadoPago(ClienteMercadoPagoDto clienteDto);

    ClienteMercadoPagoDto updateClienteMercadoPago(Long id, @Valid ClienteMercadoPagoDto clienteDto);

    ResponseDto deleteClienteMercadoPago(Long id);
}
