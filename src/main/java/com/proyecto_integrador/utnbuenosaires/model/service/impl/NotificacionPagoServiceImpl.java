package com.proyecto_integrador.utnbuenosaires.model.service.impl;

import com.proyecto_integrador.utnbuenosaires.model.dto.NotificacionPagoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.NotificacionPago;
import com.proyecto_integrador.utnbuenosaires.model.repository.INotificacionPagoRepository;
import com.proyecto_integrador.utnbuenosaires.model.service.INotificacionPagoService;
import com.proyecto_integrador.utnbuenosaires.utils.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacionPagoServiceImpl implements INotificacionPagoService {
    private final INotificacionPagoRepository notificacionPagoRepository;
    private final EntityDtoMapper entityDtoMapper;

    @Autowired
    public NotificacionPagoServiceImpl(INotificacionPagoRepository notificacionPagoRepository, EntityDtoMapper entityDtoMapper) {
        this.notificacionPagoRepository = notificacionPagoRepository;
        this.entityDtoMapper = entityDtoMapper;
    }

    @Override
    public List<NotificacionPagoDto> getNotificacionesPago() {
        return notificacionPagoRepository.findAll().stream()
                .map(notificacion -> entityDtoMapper.mapEntityToDto(notificacion, NotificacionPagoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public NotificacionPagoDto getNotificacionPagoById(Long id) {
        return notificacionPagoRepository.findById(id)
                .map(notificacion -> entityDtoMapper.mapEntityToDto(notificacion, NotificacionPagoDto.class))
                .orElse(null);
    }

    @Override
    public ResponseDto createNotificacionPago(NotificacionPagoDto notificacionDto) {
        NotificacionPago notificacion = entityDtoMapper.mapDtoToEntity(notificacionDto, NotificacionPago.class);
        notificacionPagoRepository.save(notificacion);
        return new ResponseDto("Notificación de pago creada exitosamente!");
    }

    @Override
    public Optional<ResponseEntity<NotificacionPagoDto>> updateNotificacionPago(Long id, NotificacionPagoDto notificacionDto) {
        return notificacionPagoRepository.findById(id)
                .map(notificacion -> {
//                    entityDtoMapper.mapDtoToEntity(notificacionDto, notificacion);
                    NotificacionPago updatedNotificacion = notificacionPagoRepository.save(notificacion);
                    NotificacionPagoDto updatedNotificacionDto = entityDtoMapper.mapEntityToDto(updatedNotificacion, NotificacionPagoDto.class);
                    return ResponseEntity.ok(updatedNotificacionDto);
                });
    }

    @Override
    public ResponseDto deleteNotificacionPago(Long id) {
        notificacionPagoRepository.deleteById(id);
        return new ResponseDto("Notificación de pago eliminada exitosamente!");
    }
}
