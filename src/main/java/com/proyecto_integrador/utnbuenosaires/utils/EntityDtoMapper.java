package com.proyecto_integrador.utnbuenosaires.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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
}
