package com.proyecto_integrador.utnbuenosaires.model.service;

import com.proyecto_integrador.utnbuenosaires.model.entity.Pago;
import com.proyecto_integrador.utnbuenosaires.model.entity.Orden;
import com.proyecto_integrador.utnbuenosaires.model.entity.MetodoPago;

public interface IPagoService {
    Pago crearPago(Orden orden, MetodoPago metodoPago, double monto);

    boolean confirmarPago(String idPago);

    Pago obtenerPagoPorId(String idPago);
}
