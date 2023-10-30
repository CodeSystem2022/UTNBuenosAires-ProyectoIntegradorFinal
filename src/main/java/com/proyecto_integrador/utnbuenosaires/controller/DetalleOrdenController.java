package com.proyecto_integrador.utnbuenosaires.controller;

import com.proyecto_integrador.utnbuenosaires.model.dto.DetalleOrdenDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.service.IDetalleOrdenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalleOrden")
public class DetalleOrdenController {

    private final IDetalleOrdenService detalleOrdenService;

    public DetalleOrdenController(IDetalleOrdenService detalleOrdenService) {
        this.detalleOrdenService = detalleOrdenService;
    }

    @GetMapping("/getDetallesOrdenes")
    public List<DetalleOrdenDto> getDetallesOrdenes(){
        return detalleOrdenService.getDetallesOrdenes();
    }

    @GetMapping("/getDetalleOrden/{id}")
    public DetalleOrdenDto getDetalleOrdenById(@PathVariable Long id){
        return detalleOrdenService.getDetalleOrdenById(id);
    }

    @PostMapping("/createDetalleOrden")
    public ResponseEntity<ResponseDto> createDetalleOrden(@Valid @RequestBody DetalleOrdenDto detalleOrdenDto) {
        return new ResponseEntity<>(detalleOrdenService.createDetalleOrden(detalleOrdenDto), HttpStatus.OK);
    }


    @PutMapping("/updateDetalleOrden/{id}")
    public Optional<ResponseEntity<DetalleOrdenDto>> updateDetalleOrden(@PathVariable Long id, @Valid @RequestBody DetalleOrdenDto detalleOrdenDto){
        return detalleOrdenService.updateDetalleOrden(id,detalleOrdenDto);
    }

    @DeleteMapping("/deleteDetalleOrden/{id}")
    public ResponseEntity<ResponseDto> deleteDetalleOrden(@PathVariable Long id){
        return new ResponseEntity<>(detalleOrdenService.deleteDetalleOrden(id),HttpStatus.OK);
    }

}
