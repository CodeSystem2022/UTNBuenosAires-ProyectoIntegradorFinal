package com.proyecto_integrador.utnbuenosaires.model.service.impl;

import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ProductoDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.Producto;
import com.proyecto_integrador.utnbuenosaires.model.repository.IProductoRepository;
import com.proyecto_integrador.utnbuenosaires.model.service.IProductoService;
import com.proyecto_integrador.utnbuenosaires.utils.EntityDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    private final IProductoRepository productoRepository;
    private final EntityDtoMapper entityDtoMapper;

    public ProductoServiceImpl(IProductoRepository productoRepository, EntityDtoMapper entityDtoMapper) {
        this.productoRepository = productoRepository;
        this.entityDtoMapper = entityDtoMapper;
    }

    @Override
    public List<ProductoDto> getProductos() {
        List<Producto> productos = productoRepository.findAll();

        return productos.stream()
                .map(producto -> entityDtoMapper.mapEntityToDto(producto, ProductoDto.class))
                .toList();
    }

    @Override
    public ProductoDto getProductoById(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);

        return entityDtoMapper.mapEntityToDto(producto, ProductoDto.class);
    }

    @Override
    public ResponseDto createProducto(ProductoDto productoDto) {
        Producto producto = entityDtoMapper.mapDtoToEntity(productoDto, Producto.class);
        productoRepository.save(producto);

        return new ResponseDto("Product Successfully Created!!!");
    }


    @Override
    public Optional<ResponseEntity<ProductoDto>> updateProducto(Long id, ProductoDto productoDto) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(productoDto.getNombre());
            producto.setDescripcion(productoDto.getDescripcion());
            producto.setImagen(productoDto.getImagen());
            producto.setPrecio(productoDto.getPrecio());
            producto.setCantidad(productoDto.getCantidad());

            Producto updatedProducto = productoRepository.save(producto);
            ProductoDto updatedProductoDto = entityDtoMapper.mapEntityToDto(updatedProducto, ProductoDto.class);
            return new ResponseEntity<>(updatedProductoDto, HttpStatus.OK);
        });
    }

    @Override
    public ResponseDto deleteProducto(Long id) {
        productoRepository.deleteById(id);
        return new ResponseDto("Product Successfully Deleted!!!");
    }
}
