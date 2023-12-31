package com.proyecto_integrador.utnbuenosaires.controller;

import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.UsuarioDto;
import com.proyecto_integrador.utnbuenosaires.model.service.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("/getUsers")
    public List<UsuarioDto> getUsers(){
        return usuarioService.getUsers();
    }

    @GetMapping("/getUser/{id}")
    public UsuarioDto getUserById(@PathVariable Integer id){
        return usuarioService.getUserById(id);
    }

    @GetMapping("/obtenerUsuario/{username}")
    public UsuarioDto getUserByUsername(@PathVariable String username){
        return usuarioService.getUserByUsername(username);
    }



    @PostMapping("/createUser")
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody UsuarioDto usuarioDto){
        return new ResponseEntity<>(usuarioService.createUser(usuarioDto), HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public Optional<ResponseEntity<UsuarioDto>> updateUser(@PathVariable Integer id, @Valid @RequestBody UsuarioDto usuarioDto){
        return usuarioService.updateUser(id,usuarioDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable Integer id){
        return new ResponseEntity<>(usuarioService.deleteUser(id),HttpStatus.OK);
    }

}
