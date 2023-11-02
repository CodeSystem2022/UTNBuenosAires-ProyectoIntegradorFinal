package com.proyecto_integrador.utnbuenosaires.model.service.impl;

import com.proyecto_integrador.utnbuenosaires.model.dto.MetodoPagoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.MetodoPago;
import com.proyecto_integrador.utnbuenosaires.model.repository.IMetodoPagoRepository;
import com.proyecto_integrador.utnbuenosaires.model.service.IMetodoPagoService;
import com.proyecto_integrador.utnbuenosaires.utils.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MetodoPagoServiceImpl implements IMetodoPagoService {
    private final IMetodoPagoRepository metodoPagoRepository;
    private final EntityDtoMapper entityDtoMapper;

    @Autowired
    public MetodoPagoServiceImpl(IMetodoPagoRepository metodoPagoRepository, EntityDtoMapper entityDtoMapper) {
        this.metodoPagoRepository = metodoPagoRepository;
        this.entityDtoMapper = entityDtoMapper;
    }

    @Override
    public List<MetodoPagoDto> getMetodosPago() {
        List<MetodoPago> metodosPago = metodoPagoRepository.findAll();
        return convertToDtoList(metodosPago);
    }

    @Override
    public MetodoPagoDto getMetodoPagoById(Long id) {
        Optional<MetodoPago> metodoPago = metodoPagoRepository.findById(id);
        return metodoPago.map(m -> entityDtoMapper.mapEntityToDto(m, MetodoPagoDto.class)).orElse(null);
    }

    @Override
    public ResponseDto createMetodoPago(@Valid MetodoPagoDto metodoDto) {
        MetodoPago metodoPago = entityDtoMapper.mapDtoToEntity(metodoDto, MetodoPago.class);
        MetodoPago savedMetodoPago = metodoPagoRepository.save(metodoPago);
        return new ResponseDto("Metodo de Pago creado exitosamente!");
    }

    @Override
    public Optional<ResponseEntity<MetodoPagoDto>> updateMetodoPago(Long id, @Valid MetodoPagoDto metodoDto) {
//        return metodoPagoRepository.findById(id)
//                .map(metodo -> {
//                    entityDtoMapper.mapDtoToEntity(metodoDto, metodo); // Actualiza las propiedades desde el DTO
//                    metodo = metodoPagoRepository.save(metodo);
//                    MetodoPagoDto updatedMetodoPagoDto = entityDtoMapper.mapEntityToDto(metodo, MetodoPagoDto.class);
//                    return Optional.of(new ResponseEntity<>(updatedMetodoPagoDto, HttpStatus.OK));
//                });
        return null;
    }



    @Override
    public ResponseDto deleteMetodoPago(Long id) {
        metodoPagoRepository.deleteById(id);
        return new ResponseDto("Metodo de Pago eliminado exitosamente!");
    }

    private List<MetodoPagoDto> convertToDtoList(List<MetodoPago> metodosPago) {
        return metodosPago.stream()
                .map(metodo -> entityDtoMapper.mapEntityToDto(metodo, MetodoPagoDto.class))
                .collect(Collectors.toList());
    }
}


