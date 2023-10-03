package com.proyecto_integrador.utnbuenosaires.model.repository;

import com.proyecto_integrador.utnbuenosaires.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long> {

}