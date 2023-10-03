package com.proyecto_integrador.utnbuenosaires.model.service;

import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ProductoDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    List<ProductoDto> getProductos();

    ProductoDto getProductoById(Long id);

    ResponseDto createProducto(ProductoDto productoDto);

    Optional<ResponseEntity<ProductoDto>> updateProducto(Long id, @Valid ProductoDto productoDto);

    ResponseDto deleteProducto(Long id);

}
