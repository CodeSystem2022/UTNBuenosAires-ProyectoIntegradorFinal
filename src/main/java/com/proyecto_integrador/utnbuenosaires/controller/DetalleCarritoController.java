package com.proyecto_integrador.utnbuenosaires.controller;

import com.proyecto_integrador.utnbuenosaires.model.entity.Carrito;
import com.proyecto_integrador.utnbuenosaires.model.entity.DetalleCarrito;
import com.proyecto_integrador.utnbuenosaires.model.entity.Producto;
import com.proyecto_integrador.utnbuenosaires.model.service.IDetalleCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-carrito")
public class DetalleCarritoController {

    private final IDetalleCarritoService detalleCarritoService;

    @Autowired
    public DetalleCarritoController(IDetalleCarritoService detalleCarritoService) {
        this.detalleCarritoService = detalleCarritoService;
    }

    @PostMapping("/crearDetalleCarrito")
    public DetalleCarrito crearDetalleCarrito(@RequestBody Carrito carrito, @RequestParam int cantidad, @RequestBody Producto producto) {
        return detalleCarritoService.crearDetalleCarrito(producto, cantidad, carrito);
    }

    @PostMapping("/actualizarDetalleCarrito")
    public DetalleCarrito actualizarDetalleCarrito(@RequestBody DetalleCarrito detalleCarrito) {
        return detalleCarritoService.actualizarDetalleCarrito(detalleCarrito);
    }

    @DeleteMapping("/eliminarDetalleCarrito/{detalleCarritoId}")
    public void eliminarDetalleCarrito(@PathVariable Long detalleCarritoId) {
        detalleCarritoService.eliminarDetalleCarrito(detalleCarritoId);
    }

    @GetMapping("/detallesCarrito/{carritoId}")
    public List<DetalleCarrito> obtenerDetallesCarritoPorCarrito(@PathVariable Long carritoId) {
        Carrito carrito = new Carrito(); // Obtener el carrito desde el ID, si es necesario
        return detalleCarritoService.obtenerDetallesCarritoPorCarrito(carrito);
    }

    @GetMapping("/calcularTotalCarrito/{carritoId}")
    public double calcularTotalCarrito(@PathVariable Long carritoId) {
        Carrito carrito = new Carrito(); // Obtener el carrito desde el ID, si es necesario
        return detalleCarritoService.calcularTotalCarrito(carrito);
    }
}
