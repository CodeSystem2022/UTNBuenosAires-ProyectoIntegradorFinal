package com.proyecto_integrador.utnbuenosaires.model.repository;

import com.proyecto_integrador.utnbuenosaires.model.dto.DetalleCarritoDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.Carrito;
import com.proyecto_integrador.utnbuenosaires.model.entity.DetalleCarrito;
import com.proyecto_integrador.utnbuenosaires.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IDetalleCarritoRepository extends JpaRepository<DetalleCarrito,Long> {
    Optional<DetalleCarrito> findByCarritoAndProducto(Carrito carrito, Producto producto);
    List<DetalleCarrito> findByCarrito(Carrito carrito);

}