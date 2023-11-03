package com.proyecto_integrador.utnbuenosaires.controller;

import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.TransaccionDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.Transaccion;
import com.proyecto_integrador.utnbuenosaires.model.service.ITransaccionService;
import com.proyecto_integrador.utnbuenosaires.utils.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {

    private final ITransaccionService transaccionService;
    private final EntityDtoMapper entityDtoMapper;

    @Autowired
    public TransaccionController(ITransaccionService transaccionService, EntityDtoMapper entityDtoMapper) {
        this.transaccionService = transaccionService;
        this.entityDtoMapper = entityDtoMapper;
    }

    @GetMapping("/getTransacciones")
    public List<TransaccionDto> getTransacciones() {
        List<TransaccionDto> transacciones = transaccionService.getTransacciones();
        return entityDtoMapper.mapEntityListToDtoList(transacciones, TransaccionDto.class);
    }

    @GetMapping("/getTransaccion/{id}")
    public TransaccionDto getTransaccionById(@PathVariable Long id) {
        TransaccionDto transaccion = transaccionService.getTransaccionById(id);
        return entityDtoMapper.mapEntityToDto(transaccion, TransaccionDto.class);
    }

    @PostMapping("/createTransaccion")
    public ResponseDto createTransaccion(@Valid @RequestBody TransaccionDto transaccionDto) {
        Transaccion transaccion = entityDtoMapper.mapDtoToEntity(transaccionDto, Transaccion.class);
        ResponseDto response = transaccionService.createTransaccion(transaccionDto);
        // Puedes realizar alguna lógica adicional si es necesario
        return response;
    }

    @PutMapping("/updateTransaccion/{id}")
    public ResponseEntity<TransaccionDto> updateTransaccion(@PathVariable Long id, @Valid @RequestBody TransaccionDto transaccionDto) {
        Optional<ResponseEntity<TransaccionDto>> response = transaccionService.updateTransaccion(id, transaccionDto);
        return response.orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteTransaccion/{id}")
    public ResponseDto deleteTransaccion(@PathVariable Long id) {
        ResponseDto response = transaccionService.deleteTransaccion(id);
        // Puedes realizar alguna lógica adicional si es necesario
        return response;
    }
}
