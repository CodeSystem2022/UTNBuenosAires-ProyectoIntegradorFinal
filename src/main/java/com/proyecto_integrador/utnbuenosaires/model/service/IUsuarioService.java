package com.proyecto_integrador.utnbuenosaires.model.service;

import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.UsuarioDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<UsuarioDto> getUsers();

    UsuarioDto getUserById(Integer id);

    ResponseDto createUser(UsuarioDto usuarioDto);

    Optional<ResponseEntity<UsuarioDto>> updateUser(Integer id, @Valid UsuarioDto userDto);

    ResponseDto deleteUser(Integer id);

    UsuarioDto getUserByUsername(String username);
}
