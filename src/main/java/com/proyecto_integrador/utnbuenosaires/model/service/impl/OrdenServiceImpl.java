package com.proyecto_integrador.utnbuenosaires.model.service.impl;

import com.proyecto_integrador.utnbuenosaires.model.dto.OrdenDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.Orden;
import com.proyecto_integrador.utnbuenosaires.model.service.IOrdenService;
import com.proyecto_integrador.utnbuenosaires.model.repository.IOrdenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenServiceImpl implements IOrdenService {

    private final IOrdenRepository ordenRepository;

    public OrdenServiceImpl(IOrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }


    @Override
    public List<OrdenDto> getOrdenes() {
        ModelMapper mapper = new ModelMapper();
        List<Orden> usuarios = ordenRepository.findAll();
        List<OrdenDto> usuariosDto = new ArrayList<>();

        usuarios.stream()
                .forEach(u-> usuariosDto.add(mapper.map(u,OrdenDto.class)));

        return usuariosDto;
    }


    public OrdenDto getOrdenById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Optional<Orden> orden = ordenRepository.findById(id);
        return mapper.map(orden, OrdenDto.class);
    }


    @Override
    public ResponseDto createOrden(OrdenDto usuarioDto) {
        ModelMapper mapper = new ModelMapper();
        Orden usuario = mapper.map(usuarioDto,Orden.class);

        ordenRepository.save(usuario);

        return new ResponseDto("Product Succesfully Created!!!");
    }


    @Override
    public Optional<ResponseEntity<OrdenDto>> updateOrden(Long id, OrdenDto ordenDto) {
        ModelMapper mapper = new ModelMapper();
        return ordenRepository.findById(id)
                .map(o->{
                    o.setNumero(ordenDto.getNumero());
                    o.setFechaCreacion(ordenDto.getFechaCreacion());
                    o.setFechaRecibida(ordenDto.getFechaRecibida());
                    o.setTotal(ordenDto.getTotal());

                    Orden updatedOrden = ordenRepository.save(o);
                    OrdenDto updatedOrdenDto = mapper.map(updatedOrden,OrdenDto.class);
                    return new ResponseEntity<>(updatedOrdenDto, HttpStatus.OK);
                });
    }

    @Override
    public ResponseDto deleteOrden(Long id) {
        ordenRepository.deleteById(id);
        return new ResponseDto("Orden eliminada exitosamente!");
    }


}
