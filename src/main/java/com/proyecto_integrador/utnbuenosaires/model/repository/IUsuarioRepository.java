package com.proyecto_integrador.utnbuenosaires.model.repository;

import com.proyecto_integrador.utnbuenosaires.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {

}