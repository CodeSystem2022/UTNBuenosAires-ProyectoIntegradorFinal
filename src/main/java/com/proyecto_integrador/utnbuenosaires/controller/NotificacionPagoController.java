package com.proyecto_integrador.utnbuenosaires.controller;

import com.proyecto_integrador.utnbuenosaires.model.dto.NotificacionPagoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.service.INotificacionPagoService;
import com.proyecto_integrador.utnbuenosaires.utils.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/notificacion-pago")
public class NotificacionPagoController {

    private final INotificacionPagoService notificacionPagoService;
    private final EntityDtoMapper entityDtoMapper;

    @Autowired
    public NotificacionPagoController(INotificacionPagoService notificacionPagoService, EntityDtoMapper entityDtoMapper) {
        this.notificacionPagoService = notificacionPagoService;
        this.entityDtoMapper = entityDtoMapper;
    }

    @GetMapping("/notificaciones")
    public List<NotificacionPagoDto> getNotificacionesPago() {
        return notificacionPagoService.getNotificacionesPago();
    }

    @GetMapping("/notificacion/{id}")
    public NotificacionPagoDto getNotificacionPagoById(@PathVariable Long id) {
        return notificacionPagoService.getNotificacionPagoById(id);
    }

    @PostMapping("/crearNotificacion")
    public ResponseDto createNotificacionPago(@Valid @RequestBody NotificacionPagoDto notificacionDto) {
        return notificacionPagoService.createNotificacionPago(notificacionDto);
    }

    @PutMapping("/actualizarNotificacion/{id}")
    public ResponseEntity<NotificacionPagoDto> updateNotificacionPago(@PathVariable Long id, @Valid @RequestBody NotificacionPagoDto notificacionDto) {
        return notificacionPagoService.updateNotificacionPago(id, notificacionDto)
                .map(updatedNotificacion -> ResponseEntity.ok(updatedNotificacion))
                .orElse(ResponseEntity.notFound().build()).getBody();
    }

    @DeleteMapping("/eliminarNotificacion/{id}")
    public ResponseDto deleteNotificacionPago(@PathVariable Long id) {
        return notificacionPagoService.deleteNotificacionPago(id);
    }
}
