package com.proyecto_integrador.utnbuenosaires.model.service.impl;

import com.proyecto_integrador.utnbuenosaires.model.dto.DetalleOrdenDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.DetalleOrden;
import com.proyecto_integrador.utnbuenosaires.model.repository.IDetalleOrdenRepository;
import com.proyecto_integrador.utnbuenosaires.model.service.IDetalleOrdenService;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleOrdenServiceImpl implements IDetalleOrdenService {

    private final IDetalleOrdenRepository detalleOrdenRepository;

    public DetalleOrdenServiceImpl(IDetalleOrdenRepository detalleOrdenRepository) {
        this.detalleOrdenRepository = detalleOrdenRepository;
    }


    @Override
    public List<DetalleOrdenDto> getDetallesOrdenes() {
        ModelMapper mapper = new ModelMapper();
        List<DetalleOrden> detallesOrdenes = detalleOrdenRepository.findAll();
        List<DetalleOrdenDto> detallesOrdenesDto = new ArrayList<>();

        detallesOrdenes.stream()
                .forEach(d-> detallesOrdenesDto.add(mapper.map(d,DetalleOrdenDto.class)));

        return detallesOrdenesDto;
    }

    @Override
    public DetalleOrdenDto getDetalleOrdenById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Optional<DetalleOrden> detalleOrden = detalleOrdenRepository.findById(id);
        return mapper.map(detalleOrden, DetalleOrdenDto.class);
    }

    @Override
    public ResponseDto createDetalleOrden(DetalleOrdenDto detalleOrdenDto) {
        ModelMapper mapper = new ModelMapper();

        DetalleOrden detalleOrden = mapper.map(detalleOrdenDto,DetalleOrden.class);

        detalleOrdenRepository.save(detalleOrden);

        return new ResponseDto("Orden creada exitosamente!");
    }

    @Override
    public Optional<ResponseEntity<DetalleOrdenDto>> updateDetalleOrden(Long id, DetalleOrdenDto detalleOrdenDto) {
        ModelMapper mapper = new ModelMapper();
        return detalleOrdenRepository.findById(id)
                .map(d->{
                    d.setNombre(detalleOrdenDto.getNombre());
                    d.setCantidad(detalleOrdenDto.getCantidad());
                    d.setPrecio(detalleOrdenDto.getPrecio());
                    d.setTotal(detalleOrdenDto.getTotal());

                    DetalleOrden updatedDetalleOrden = detalleOrdenRepository.save(d);
                    DetalleOrdenDto updatedDetalleOrdenDto = mapper.map(updatedDetalleOrden,DetalleOrdenDto.class);
                    return new ResponseEntity<>(updatedDetalleOrdenDto, HttpStatus.OK);
                });
    }

    @Override
    public ResponseDto deleteDetalleOrden(Long id) {
        detalleOrdenRepository.deleteById(id);
        return new ResponseDto("Detalle Orden eliminado exitosamente!");
    }
}
