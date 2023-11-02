package com.proyecto_integrador.utnbuenosaires.model.service.impl;

import com.proyecto_integrador.utnbuenosaires.model.entity.Carrito;
import com.proyecto_integrador.utnbuenosaires.model.entity.DetalleCarrito;
import com.proyecto_integrador.utnbuenosaires.model.entity.Producto;
import com.proyecto_integrador.utnbuenosaires.model.dto.CarritoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.DetalleCarritoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ProductoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.UsuarioDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.Usuario;
import com.proyecto_integrador.utnbuenosaires.model.repository.ICarritoRepository;
import com.proyecto_integrador.utnbuenosaires.model.repository.IDetalleCarritoRepository;
import com.proyecto_integrador.utnbuenosaires.model.service.ICarritoService;
import com.proyecto_integrador.utnbuenosaires.model.service.IDetalleOrdenService;
import com.proyecto_integrador.utnbuenosaires.utils.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarritoServiceImpl implements ICarritoService {

    private final ICarritoRepository carritoRepository;
    private final IDetalleCarritoRepository detalleCarritoRepository;
    private final IDetalleOrdenService detalleOrdenService;
    private final EntityDtoMapper entityDtoMapper;

    @Autowired
    public CarritoServiceImpl(ICarritoRepository carritoRepository, IDetalleCarritoRepository detalleCarritoRepository, IDetalleOrdenService detalleOrdenService, EntityDtoMapper entityDtoMapper) {
        this.carritoRepository = carritoRepository;
        this.detalleCarritoRepository = detalleCarritoRepository;
        this.detalleOrdenService = detalleOrdenService;
        this.entityDtoMapper = entityDtoMapper;
    }

    @Override
    public void agregarProductoAlCarrito(ProductoDto productoDto, int cantidad, UsuarioDto usuarioDto) {
        // Obtener el carrito actual del usuario como CarritoDto
        CarritoDto carritoDto = entityDtoMapper.mapEntityToDto(carritoRepository.findByUsuario(entityDtoMapper.mapDtoToEntity(usuarioDto, Usuario.class)), CarritoDto.class);

        // Verificar si el producto ya está en el carrito
        Optional<DetalleCarrito> detalleExistente = detalleCarritoRepository.findByCarritoAndProducto(
                entityDtoMapper.mapDtoToEntity(carritoDto, Carrito.class),
                entityDtoMapper.mapDtoToEntity(productoDto, Producto.class)
        );

        if (detalleExistente.isPresent()) {
            // Si el producto ya está en el carrito, actualizar la cantidad
            DetalleCarrito detalleCarritoDto = detalleExistente.get();
            detalleCarritoDto.setCantidad(detalleCarritoDto.getCantidad() + cantidad);
            detalleCarritoRepository.save(entityDtoMapper.mapDtoToEntity(detalleCarritoDto, DetalleCarrito.class));
        } else {
            // Si el producto no está en el carrito, crear un nuevo detalle como DetalleCarritoDto
            DetalleCarritoDto nuevoDetalle = new DetalleCarritoDto(cantidad, carritoDto, productoDto);
            detalleCarritoRepository.save(entityDtoMapper.mapDtoToEntity(nuevoDetalle, DetalleCarrito.class));
        }
    }


    @Override
    public void eliminarProductoDelCarrito(ProductoDto productoDto, UsuarioDto usuarioDto) {
        // Obtener el carrito actual del usuario como CarritoDto
        Carrito carrito = carritoRepository.findByUsuario(entityDtoMapper.mapDtoToEntity(usuarioDto, Usuario.class));

        // Obtener el producto desde el DTO y convertirlo a entidad
        Producto producto = entityDtoMapper.mapDtoToEntity(productoDto, Producto.class);

        // Buscar y eliminar el detalle del producto en el carrito
        Optional<DetalleCarrito> detalleExistente = detalleCarritoRepository.findByCarritoAndProducto(carrito, producto);
        detalleExistente.ifPresent(detalleCarritoRepository::delete);
    }


    @Override
    public List<DetalleCarritoDto> obtenerDetallesDelCarrito(UsuarioDto usuarioDto) {
        // Obtener el carrito actual del usuario como CarritoDto
        Carrito carrito = carritoRepository.findByUsuario(entityDtoMapper.mapDtoToEntity(usuarioDto, Usuario.class));

        // Obtener todos los detalles del carrito como entidades
        List<DetalleCarrito> detallesCarrito = detalleCarritoRepository.findByCarrito(carrito);

        // Convertir las entidades a DetalleCarritoDto
        List<DetalleCarritoDto> detallesCarritoDto = detallesCarrito.stream()
                .map(detail -> entityDtoMapper.mapEntityToDto(detail, DetalleCarritoDto.class))
                .collect(Collectors.toList());

        return detallesCarritoDto;
    }

    @Override
    public double calcularTotalCarrito(UsuarioDto usuarioDto) {
        // Obtener el carrito actual del usuario como CarritoDto
        Carrito carrito = carritoRepository.findByUsuario(entityDtoMapper.mapDtoToEntity(usuarioDto, Usuario.class));

        // Obtener todos los detalles del carrito como entidades
        List<DetalleCarrito> detallesCarrito = detalleCarritoRepository.findByCarrito(carrito);

        // Calcular el total sumando los subtotales de los detalles
        double total = detallesCarrito.stream()
                .mapToDouble(DetalleCarrito::getSubTotal)
                .sum();

        return total;
    }

}
