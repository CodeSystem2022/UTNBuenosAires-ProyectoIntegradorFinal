package com.proyecto_integrador.utnbuenosaires.controller;

import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ProductoDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.Categoria;
import com.proyecto_integrador.utnbuenosaires.model.service.IProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }


    @GetMapping("/getProductos")
    public List<ProductoDto> getProductos(){
        return productoService.getProductos();
    }

    @GetMapping("/getCategorias")
    public List<Categoria> getCategorias () {
        return productoService.getCategorias();
    }

    @GetMapping("/getProducto/{id}")
    public ProductoDto getProductoById(@PathVariable Long id){
        return productoService.getProductoById(id);
    }

    @PostMapping("/createProducto")
    public ResponseEntity<ResponseDto> createProducto(@Valid @RequestBody ProductoDto productoDto){
        return new ResponseEntity<>(productoService.createProducto(productoDto), HttpStatus.OK);
    }

    @PutMapping("/updateProducto/{id}")
    public Optional<ResponseEntity<ProductoDto>> updateProducto(@PathVariable Long id, @Valid @RequestBody ProductoDto productoDto){
        return productoService.updateProducto(id,productoDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteProducto(@PathVariable Long id){
        return new ResponseEntity<>(productoService.deleteProducto(id),HttpStatus.OK);
    }

}
