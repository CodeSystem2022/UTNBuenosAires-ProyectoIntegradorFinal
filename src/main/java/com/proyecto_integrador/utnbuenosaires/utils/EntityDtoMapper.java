package com.proyecto_integrador.utnbuenosaires.utils;

import com.proyecto_integrador.utnbuenosaires.model.dto.TransaccionDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoMapper {

    private final ModelMapper modelMapper;

    public EntityDtoMapper() {
        this.modelMapper = new ModelMapper();
    }

    public <E, D> D mapEntityToDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <D, E> E mapDtoToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public List<TransaccionDto> mapEntityListToDtoList(List<TransaccionDto> transacciones, Class<TransaccionDto> transaccionDtoClass) {
        return transacciones.stream()
                .map(transaccion -> mapEntityToDto(transaccion, transaccionDtoClass))
                .collect(Collectors.toList());
    }
}
