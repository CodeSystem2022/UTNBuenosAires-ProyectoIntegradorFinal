package com.proyecto_integrador.utnbuenosaires.model.service.impl;

import com.proyecto_integrador.utnbuenosaires.model.entity.Pago;
import com.proyecto_integrador.utnbuenosaires.model.entity.Orden;
import com.proyecto_integrador.utnbuenosaires.model.entity.MetodoPago;
import com.proyecto_integrador.utnbuenosaires.model.repository.IPagoRepository;
import com.proyecto_integrador.utnbuenosaires.model.service.IPagoService;
//import com.mercadopago.MP; // Biblioteca de Mercado Pago

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImpl implements IPagoService {

    private final IPagoRepository pagoRepository;

//    @Value("${mercadopago.client_id}")
    private String mercadopagoClientId;

//    @Value("${mercadopago.client_secret}")
    private String mercadopagoClientSecret;

    public PagoServiceImpl(IPagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public Pago crearPago(Orden orden, MetodoPago metodoPago, double monto) {
//        // Inicializar Mercado Pago con tus credenciales
//        MP mp = new MP(mercadopagoClientId, mercadopagoClientSecret);
//
//        // Crear un pago en Mercado Pago
//        // Aquí debes utilizar las funciones proporcionadas por la biblioteca de Mercado Pago
//        // para crear un pago y obtener su ID
//
//        String idPago = ""; // Obtén el ID del pago creado en Mercado Pago
//
//        Pago nuevoPago = new Pago();
//        nuevoPago.setOrden(orden);
//        nuevoPago.setMetodoPago(metodoPago);
//        nuevoPago.setMonto(monto);
//        nuevoPago.setIdPago(idPago);
//        nuevoPago.setEstado("Pendiente"); // Puedes establecer un estado inicial
//
//        return pagoRepository.save(nuevoPago);
        return null;
    }

    @Override
    public boolean confirmarPago(String idPago) {
        // Confirmar el pago en Mercado Pago
        // Aquí debes utilizar las funciones proporcionadas por la biblioteca de Mercado Pago
        // para confirmar el pago con el ID proporcionado

        // Si la confirmación es exitosa, actualiza el estado del pago
//        Pago pago = pagoRepository.findByIdPago(idPago);
//        if (pago != null) {
//            pago.setEstado("Confirmado");
//            pagoRepository.save(pago);
//            return true;
//        }

        return false;
    }

    @Override
    public Pago obtenerPagoPorId(String idPago) {

//        return pagoRepository.findByIdPago(idPago);
        return null;
    }
}
