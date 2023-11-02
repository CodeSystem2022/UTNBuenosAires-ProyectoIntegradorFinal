package com.proyecto_integrador.utnbuenosaires.model.service.impl;

import com.proyecto_integrador.utnbuenosaires.model.dto.ClienteMercadoPagoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.ClienteMercadoPago;
import com.proyecto_integrador.utnbuenosaires.model.repository.IClienteMercadoPagoRepository;
import com.proyecto_integrador.utnbuenosaires.model.service.IClienteMercadoPagoService;
import com.proyecto_integrador.utnbuenosaires.utils.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClienteMercadoPagoServiceImpl implements IClienteMercadoPagoService {
    private final IClienteMercadoPagoRepository clienteMercadoPagoRepository;
    private final EntityDtoMapper entityDtoMapper;

    @Autowired
    public ClienteMercadoPagoServiceImpl(IClienteMercadoPagoRepository clienteMercadoPagoRepository, EntityDtoMapper entityDtoMapper) {
        this.clienteMercadoPagoRepository = clienteMercadoPagoRepository;
        this.entityDtoMapper = entityDtoMapper;
    }

    @Override
    public List<ClienteMercadoPagoDto> getClientesMercadoPago() {
        List<ClienteMercadoPago> clientesMercadoPago = clienteMercadoPagoRepository.findAll();
        return clientesMercadoPago.stream()
                .map(cliente -> entityDtoMapper.mapEntityToDto(cliente, ClienteMercadoPagoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteMercadoPagoDto getClienteMercadoPagoById(Long id) {
        Optional<ClienteMercadoPago> clienteMercadoPago = clienteMercadoPagoRepository.findById(id);
        return clienteMercadoPago.map(cliente -> entityDtoMapper.mapEntityToDto(cliente, ClienteMercadoPagoDto.class)).orElse(null);
    }

    @Override
    public ClienteMercadoPagoDto createClienteMercadoPago(ClienteMercadoPagoDto clienteDto) {
        ClienteMercadoPago cliente = entityDtoMapper.mapDtoToEntity(clienteDto, ClienteMercadoPago.class);
        ClienteMercadoPago savedCliente = clienteMercadoPagoRepository.save(cliente);
        return entityDtoMapper.mapEntityToDto(savedCliente, ClienteMercadoPagoDto.class);
    }

    @Override
    public ClienteMercadoPagoDto updateClienteMercadoPago(Long id, ClienteMercadoPagoDto clienteDto) {
        Optional<ClienteMercadoPago> existingCliente = clienteMercadoPagoRepository.findById(id);
        if (existingCliente.isPresent()) {
            ClienteMercadoPago updatedCliente = entityDtoMapper.mapDtoToEntity(clienteDto, ClienteMercadoPago.class);
            updatedCliente.setId(id);
            ClienteMercadoPago savedCliente = clienteMercadoPagoRepository.save(updatedCliente);
            return entityDtoMapper.mapEntityToDto(savedCliente, ClienteMercadoPagoDto.class);
        }
        return null; // Manejar error o devolver un objeto de respuesta específico si no se encuentra el cliente
    }

    @Override
    public ResponseDto deleteClienteMercadoPago(Long id) {
        clienteMercadoPagoRepository.deleteById(id);
        return null;
    }
}


