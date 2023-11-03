package com.proyecto_integrador.utnbuenosaires.controller;

import com.proyecto_integrador.utnbuenosaires.model.dto.ClienteMercadoPagoDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.service.IClienteMercadoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente-mercadopago")
public class ClienteMercadoPagoController {

    private final IClienteMercadoPagoService clienteMercadoPagoService;

    @Autowired
    public ClienteMercadoPagoController(IClienteMercadoPagoService clienteMercadoPagoService) {
        this.clienteMercadoPagoService = clienteMercadoPagoService;
    }

    @GetMapping("/clientes")
    public List<ClienteMercadoPagoDto> getClientesMercadoPago() {
        return clienteMercadoPagoService.getClientesMercadoPago();
    }

    @GetMapping("/cliente/{id}")
    public ClienteMercadoPagoDto getClienteMercadoPagoById(@PathVariable Long id) {
        return clienteMercadoPagoService.getClienteMercadoPagoById(id);
    }

    @PostMapping("/crearCliente")
    public ClienteMercadoPagoDto createClienteMercadoPago(@RequestBody ClienteMercadoPagoDto clienteDto) {
        return clienteMercadoPagoService.createClienteMercadoPago(clienteDto);
    }

    @PutMapping("/actualizarCliente/{id}")
    public ClienteMercadoPagoDto updateClienteMercadoPago(@PathVariable Long id, @RequestBody ClienteMercadoPagoDto clienteDto) {
        return clienteMercadoPagoService.updateClienteMercadoPago(id, clienteDto);
    }

    @DeleteMapping("/eliminarCliente/{id}")
    public ResponseDto deleteClienteMercadoPago(@PathVariable Long id) {
        return clienteMercadoPagoService.deleteClienteMercadoPago(id);
    }
}
