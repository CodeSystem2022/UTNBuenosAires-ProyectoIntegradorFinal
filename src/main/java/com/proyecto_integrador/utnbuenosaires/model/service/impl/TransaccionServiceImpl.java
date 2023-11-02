package com.proyecto_integrador.utnbuenosaires.model.service.impl;

import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.TransaccionDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.Transaccion;
import com.proyecto_integrador.utnbuenosaires.model.repository.ITransaccionRepository;
import com.proyecto_integrador.utnbuenosaires.model.service.ITransaccionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionServiceImpl implements ITransaccionService {
    private final ITransaccionRepository transaccionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TransaccionServiceImpl(ITransaccionRepository transaccionRepository, ModelMapper modelMapper) {
        this.transaccionRepository = transaccionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TransaccionDto> getTransacciones() {
        return null;
    }

    @Override
    public TransaccionDto getTransaccionById(Long id) {
        return null;
    }

    @Override
    public ResponseDto createTransaccion(TransaccionDto transaccionDto) {
        return null;
    }

    @Override
    public Optional<ResponseEntity<TransaccionDto>> updateTransaccion(Long id, TransaccionDto transaccionDto) {
        return Optional.empty();
    }

    @Override
    public ResponseDto deleteTransaccion(Long id) {
        return null;
    }

}
