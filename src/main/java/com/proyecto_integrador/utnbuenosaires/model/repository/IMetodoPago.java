package com.proyecto_integrador.utnbuenosaires.model.repository;

import com.proyecto_integrador.utnbuenosaires.model.entity.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IMetodoPago extends JpaRepository<MetodoPago,Long> {

}