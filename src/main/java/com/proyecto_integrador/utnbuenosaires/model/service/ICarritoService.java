package com.proyecto_integrador.utnbuenosaires.model.service;

import com.proyecto_integrador.utnbuenosaires.model.dto.DetalleCarritoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ProductoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.UsuarioDto;

import java.util.List;

public interface ICarritoService {

    void agregarProductoAlCarrito(ProductoDto productoDto, int cantidad, UsuarioDto usuarioDto);

    void eliminarProductoDelCarrito(ProductoDto productoDto, UsuarioDto usuarioDto);

    List<DetalleCarritoDto> obtenerDetallesDelCarrito(UsuarioDto usuarioDto);

    double calcularTotalCarrito(UsuarioDto usuarioDto);
}

