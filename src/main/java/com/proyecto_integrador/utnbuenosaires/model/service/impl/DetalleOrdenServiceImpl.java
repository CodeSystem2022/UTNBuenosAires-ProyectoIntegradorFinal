package com.proyecto_integrador.utnbuenosaires.model.service.impl;

import com.proyecto_integrador.utnbuenosaires.model.dto.DetalleOrdenDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.DetalleOrden;
import com.proyecto_integrador.utnbuenosaires.model.repository.IDetalleOrdenRepository;
import com.proyecto_integrador.utnbuenosaires.model.service.IDetalleOrdenService;
import com.proyecto_integrador.utnbuenosaires.utils.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetalleOrdenServiceImpl implements IDetalleOrdenService {

    private final IDetalleOrdenRepository detalleOrdenRepository;
    private final EntityDtoMapper entityDtoMapper;

    @Autowired
    public DetalleOrdenServiceImpl(IDetalleOrdenRepository detalleOrdenRepository, EntityDtoMapper entityDtoMapper) {
        this.detalleOrdenRepository = detalleOrdenRepository;
        this.entityDtoMapper = entityDtoMapper;
    }

    @Override
    public List<DetalleOrdenDto> getDetallesOrdenes() {
        List<DetalleOrden> detallesOrdenes = detalleOrdenRepository.findAll();
        return detallesOrdenes.stream()
                .map(detalleOrden -> entityDtoMapper.mapEntityToDto(detalleOrden, DetalleOrdenDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DetalleOrdenDto getDetalleOrdenById(Long id) {
        Optional<DetalleOrden> detalleOrden = detalleOrdenRepository.findById(id);
        return entityDtoMapper.mapEntityToDto(detalleOrden.orElse(null), DetalleOrdenDto.class);
    }

    @Override
    public ResponseDto createDetalleOrden(DetalleOrdenDto detalleOrdenDto) {
        DetalleOrden detalleOrden = entityDtoMapper.mapEntityToDto(detalleOrdenDto, DetalleOrden.class);
        detalleOrdenRepository.save(detalleOrden);
        return new ResponseDto("Orden creada exitosamente!");
    }

    @Override
    public Optional<ResponseEntity<DetalleOrdenDto>> updateDetalleOrden(Long id, DetalleOrdenDto detalleOrdenDto) {
        return detalleOrdenRepository.findById(id)
                .map(d -> {
                    DetalleOrden detalleOrden = entityDtoMapper.mapEntityToDto(detalleOrdenDto, DetalleOrden.class);
                    detalleOrden.setId(id);
                    detalleOrden = detalleOrdenRepository.save(detalleOrden);
                    DetalleOrdenDto updatedDetalleOrdenDto = entityDtoMapper.mapEntityToDto(detalleOrden, DetalleOrdenDto.class);
                    return new ResponseEntity<>(updatedDetalleOrdenDto, HttpStatus.OK);
                });
    }

    @Override
    public ResponseDto deleteDetalleOrden(Long id) {
        detalleOrdenRepository.deleteById(id);
        return new ResponseDto("Detalle Orden eliminado exitosamente!");
    }
}
