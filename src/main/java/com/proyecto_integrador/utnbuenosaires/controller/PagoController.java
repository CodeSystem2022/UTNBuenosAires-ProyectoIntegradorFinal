package com.proyecto_integrador.utnbuenosaires.controller;

import com.proyecto_integrador.utnbuenosaires.model.dto.PagoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.Pago;
import com.proyecto_integrador.utnbuenosaires.model.service.IPagoService;
import com.proyecto_integrador.utnbuenosaires.utils.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final IPagoService pagoService;
    private final EntityDtoMapper entityDtoMapper;

    @Autowired
    public PagoController(IPagoService pagoService, EntityDtoMapper entityDtoMapper) {
        this.pagoService = pagoService;
        this.entityDtoMapper = entityDtoMapper;
    }

    @PostMapping("/crearPago")
    public ResponseDto createPago(@Valid @RequestBody PagoDto pagoDto) {
        Pago pago = entityDtoMapper.mapDtoToEntity(pagoDto, Pago.class);
        // Llamar al método de creación del servicio
        // Pago nuevoPago = pagoService.crearPago(orden, metodoPago, monto); // Descomenta esta línea y pasa los parámetros necesarios
        // return entityDtoMapper.mapEntityToDto(nuevoPago, PagoDto.class);
        return null;
    }

    @GetMapping("/confirmarPago/{idPago}")
    public ResponseEntity<ResponseDto> confirmarPago(@PathVariable String idPago) {
        boolean confirmado = pagoService.confirmarPago(idPago);
        if (confirmado) {
            return ResponseEntity.ok(new ResponseDto("Pago confirmado exitosamente."));
        } else {
            return ResponseEntity.badRequest().body(new ResponseDto("No se pudo confirmar el pago."));
        }
    }

    @GetMapping("/obtenerPago/{idPago}")
    public PagoDto obtenerPagoPorId(@PathVariable String idPago) {
        Pago pago = pagoService.obtenerPagoPorId(idPago);
        return entityDtoMapper.mapEntityToDto(pago, PagoDto.class);
    }
}
