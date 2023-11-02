package com.proyecto_integrador.utnbuenosaires.model.service;

import com.proyecto_integrador.utnbuenosaires.model.entity.Carrito;
import com.proyecto_integrador.utnbuenosaires.model.entity.DetalleCarrito;
import com.proyecto_integrador.utnbuenosaires.model.entity.Producto;

import java.util.List;

public interface IDetalleCarritoService {

    DetalleCarrito crearDetalleCarrito(Producto producto, int cantidad, Carrito carrito);

    DetalleCarrito actualizarDetalleCarrito(DetalleCarrito detalleCarrito);

    void eliminarDetalleCarrito(Long detalleCarritoId);

    List<DetalleCarrito> obtenerDetallesCarritoPorCarrito(Carrito carrito);

    double calcularTotalCarrito(Carrito carrito);

}
