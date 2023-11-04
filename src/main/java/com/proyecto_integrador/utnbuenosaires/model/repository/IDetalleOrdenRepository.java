package com.proyecto_integrador.utnbuenosaires.model.repository;

import com.proyecto_integrador.utnbuenosaires.model.entity.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleOrdenRepository extends JpaRepository<DetalleOrden, Long> {

}
