package com.proyecto_integrador.utnbuenosaires.controller;

import com.proyecto_integrador.utnbuenosaires.model.dto.DetalleCarritoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ProductoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.UsuarioDto;
import com.proyecto_integrador.utnbuenosaires.model.service.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito") // Define la ruta base para este controlador
public class CarritoController {

    private final ICarritoService carritoService;

    @Autowired
    public CarritoController(ICarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @PostMapping("/agregarProducto")
    public void agregarProductoAlCarrito(@RequestBody ProductoDto productoDto, @RequestParam int cantidad, @RequestBody UsuarioDto usuarioDto) {
        carritoService.agregarProductoAlCarrito(productoDto, cantidad, usuarioDto);
    }

    @PostMapping("/eliminarProducto")
    public void eliminarProductoDelCarrito(@RequestBody ProductoDto productoDto, @RequestBody UsuarioDto usuarioDto) {
        carritoService.eliminarProductoDelCarrito(productoDto, usuarioDto);
    }

    @GetMapping("/detalles")
    public List<DetalleCarritoDto> obtenerDetallesDelCarrito(@RequestBody UsuarioDto usuarioDto) {
        return carritoService.obtenerDetallesDelCarrito(usuarioDto);
    }

    @GetMapping("/total")
    public double calcularTotalCarrito(@RequestBody UsuarioDto usuarioDto) {
        return carritoService.calcularTotalCarrito(usuarioDto);
    }
}
