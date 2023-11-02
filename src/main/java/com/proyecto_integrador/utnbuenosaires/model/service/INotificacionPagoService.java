package com.proyecto_integrador.utnbuenosaires.model.service;

import com.proyecto_integrador.utnbuenosaires.model.dto.NotificacionPagoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface INotificacionPagoService {

    List<NotificacionPagoDto> getNotificacionesPago();

    NotificacionPagoDto getNotificacionPagoById(Long id);

    ResponseDto createNotificacionPago(NotificacionPagoDto notificacionDto);

    Optional<ResponseEntity<NotificacionPagoDto>> updateNotificacionPago(Long id, @Valid NotificacionPagoDto notificacionDto);

    ResponseDto deleteNotificacionPago(Long id);
}
