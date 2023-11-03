package com.proyecto_integrador.utnbuenosaires.controller;

import com.proyecto_integrador.utnbuenosaires.model.dto.MetodoPagoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.service.IMetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/metodo-pago")
public class MetodoPagoController {

    private final IMetodoPagoService metodoPagoService;

    @Autowired
    public MetodoPagoController(IMetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    @GetMapping("/metodos")
    public List<MetodoPagoDto> getMetodosPago() {
        return metodoPagoService.getMetodosPago();
    }

    @GetMapping("/metodo/{id}")
    public MetodoPagoDto getMetodoPagoById(@PathVariable Long id) {
        return metodoPagoService.getMetodoPagoById(id);
    }

    @PostMapping("/crearMetodoPago")
    public ResponseDto createMetodoPago(@Valid @RequestBody MetodoPagoDto metodoDto) {
        return metodoPagoService.createMetodoPago(metodoDto);
    }

    @PutMapping("/actualizarMetodoPago/{id}")
    public ResponseEntity<MetodoPagoDto> updateMetodoPago(@PathVariable Long id, @Valid @RequestBody MetodoPagoDto metodoDto) {
        return metodoPagoService.updateMetodoPago(id, metodoDto)
                .map(updatedMetodoPago -> ResponseEntity.ok(updatedMetodoPago))
                .orElse(ResponseEntity.notFound().build()).getBody();
    }

    @DeleteMapping("/eliminarMetodoPago/{id}")
    public ResponseDto deleteMetodoPago(@PathVariable Long id) {
        return metodoPagoService.deleteMetodoPago(id);
    }
}
