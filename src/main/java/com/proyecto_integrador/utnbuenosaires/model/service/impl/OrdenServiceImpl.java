package com.proyecto_integrador.utnbuenosaires.model.service.impl;

import com.proyecto_integrador.utnbuenosaires.model.dto.DetalleOrdenDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.OrdenDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.DetalleOrden;
import com.proyecto_integrador.utnbuenosaires.model.entity.Orden;
import com.proyecto_integrador.utnbuenosaires.model.service.IDetalleOrdenService;
import com.proyecto_integrador.utnbuenosaires.model.service.IOrdenService;
import com.proyecto_integrador.utnbuenosaires.model.repository.IOrdenRepository;
import com.proyecto_integrador.utnbuenosaires.utils.EntityDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdenServiceImpl implements IOrdenService {

    private final IOrdenRepository ordenRepository;
    private final EntityDtoMapper entityDtoMapper;
    private final IDetalleOrdenService detalleOrdenService; // Agregamos el servicio de DetalleOrden

    public OrdenServiceImpl(IOrdenRepository ordenRepository, EntityDtoMapper entityDtoMapper, IDetalleOrdenService detalleOrdenService) {
        this.ordenRepository = ordenRepository;
        this.entityDtoMapper = entityDtoMapper;
        this.detalleOrdenService = detalleOrdenService;
    }

    @Override
    public List<OrdenDto> getOrdenes() {
        return ordenRepository.findAll().stream()
                .map(orden -> entityDtoMapper.mapEntityToDto(orden, OrdenDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrdenDto getOrdenById(Long id) {
        Optional<Orden> orden = ordenRepository.findById(id);
        return entityDtoMapper.mapEntityToDto(orden, OrdenDto.class);
    }

    @Override
    public ResponseDto createOrden(OrdenDto ordenDto) {
        Orden orden = entityDtoMapper.mapDtoToEntity(ordenDto, Orden.class);

        // Antes de guardar la orden, asociamos los detalles si los hay
        if (ordenDto.getDetalles() != null && !ordenDto.getDetalles().isEmpty()) {
            for (DetalleOrdenDto detalleOrdenDto : ordenDto.getDetalles()) {
                DetalleOrden detalleOrden = entityDtoMapper.mapDtoToEntity(detalleOrdenDto, DetalleOrden.class);
                detalleOrden.setOrden(orden);
                // Guardamos el detalle en la base de datos
                detalleOrdenService.createDetalleOrden(detalleOrdenDto);
            }
        }

        ordenRepository.save(orden);
        return new ResponseDto("Orden creada exitosamente!");
    }

    @Override
    public Optional<ResponseEntity<OrdenDto>> updateOrden(Long id, OrdenDto ordenDto) {
        return ordenRepository.findById(id).map(orden -> {
            orden.setNumero(ordenDto.getNumero());
            orden.setFechaCreacion(ordenDto.getFechaCreacion());
            orden.setFechaRecibida(ordenDto.getFechaRecibida());
            orden.setTotal(ordenDto.getTotal());

            Orden updatedOrden = ordenRepository.save(orden);
            OrdenDto updatedOrdenDto = entityDtoMapper.mapEntityToDto(updatedOrden, OrdenDto.class);
            return new ResponseEntity<>(updatedOrdenDto, HttpStatus.OK);
        });
    }

    @Override
    public ResponseDto deleteOrden(Long id) {
        ordenRepository.deleteById(id);
        return new ResponseDto("Orden eliminada exitosamente!");
    }
}

