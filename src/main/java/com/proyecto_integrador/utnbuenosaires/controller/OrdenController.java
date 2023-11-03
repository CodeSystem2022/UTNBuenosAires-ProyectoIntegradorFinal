package com.proyecto_integrador.utnbuenosaires.controller;

import com.proyecto_integrador.utnbuenosaires.model.dto.DetalleOrdenDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.OrdenDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.service.IDetalleOrdenService;
import com.proyecto_integrador.utnbuenosaires.model.service.IOrdenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orden")
public class OrdenController {
    private final IOrdenService ordenService;

    public OrdenController(IOrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @GetMapping("/getOrdenes")
    public List<OrdenDto> getOrdenes() {
        return ordenService.getOrdenes();
    }

    @GetMapping("/getOrden/{id}")
    public OrdenDto getOrdenById(@PathVariable Long id) {
        return ordenService.getOrdenById(id);
    }

    // Modifica el método para permitir la creación de órdenes con detalles al mismo tiempo
    @PostMapping("/createOrden")
    public ResponseEntity<ResponseDto> createOrden(@Valid @RequestBody OrdenDto ordenDto) {
        return new ResponseEntity<>(ordenService.createOrden(ordenDto), HttpStatus.OK);
    }

    @PutMapping("/updateOrden/{id}")
    public Optional<ResponseEntity<OrdenDto>> updateOrden(@PathVariable Long id, @Valid @RequestBody OrdenDto ordenDto) {
        return ordenService.updateOrden(id, ordenDto);
    }

    @DeleteMapping("/deleteOrden/{id}")
    public ResponseEntity<ResponseDto> deleteOrden(@PathVariable Long id) {
        return new ResponseEntity<>(ordenService.deleteOrden(id), HttpStatus.OK);
    }
}
