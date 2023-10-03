package com.proyecto_integrador.utnbuenosaires.model.service.impl;

import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ProductoDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.Producto;
import com.proyecto_integrador.utnbuenosaires.model.repository.IProductoRepository;
import com.proyecto_integrador.utnbuenosaires.model.service.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    private final IProductoRepository productoRepository;

    public ProductoServiceImpl(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    @Override
    public List<ProductoDto> getProductos() {
        ModelMapper mapper = new ModelMapper();
        List<Producto> usuarios = productoRepository.findAll();
        List<ProductoDto> usuariosDto = new ArrayList<>();

        usuarios.stream()
                .forEach(u-> usuariosDto.add(mapper.map(u,ProductoDto.class)));

        return usuariosDto;
    }

    public ProductoDto getProductoById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Optional<Producto> user = productoRepository.findById(id);
        return mapper.map(user, ProductoDto.class);
    }


    @Override
    public ResponseDto createProducto(ProductoDto usuarioDto) {
        ModelMapper mapper = new ModelMapper();
        Producto usuario = mapper.map(usuarioDto,Producto.class);

        productoRepository.save(usuario);

        return new ResponseDto("Product Succesfully Created!!!");
    }


    @Override
    public Optional<ResponseEntity<ProductoDto>> updateProducto(Long id, ProductoDto productoDto) {
        ModelMapper mapper = new ModelMapper();
        return productoRepository.findById(id)
                .map(u->{
                    u.setNombre(productoDto.getNombre());
                    u.setDescripcion(productoDto.getDescripcion());
                    u.setImagen(productoDto.getImagen());
                    u.setPrecio(productoDto.getPrecio());
                    u.setCantidad(productoDto.getCantidad());
                    u.setUsuario(productoDto.getUsuario());

                    Producto updatedProducto = productoRepository.save(u);
                    ProductoDto updatedProductoDto = mapper.map(updatedProducto,ProductoDto.class);
                    return new ResponseEntity<>(updatedProductoDto, HttpStatus.OK);
                });
    }


    @Override
    public ResponseDto deleteProducto(Long id) {
        productoRepository.deleteById(id);
        return new ResponseDto("Product Succesfully Deleted!!!");
    }
}
