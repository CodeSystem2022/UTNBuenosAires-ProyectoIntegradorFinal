package com.proyecto_integrador.utnbuenosaires.model.service.impl;

import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.UsuarioDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.Usuario;
import com.proyecto_integrador.utnbuenosaires.model.repository.IUsuarioRepository;
import com.proyecto_integrador.utnbuenosaires.model.service.IUsuarioService;
import com.proyecto_integrador.utnbuenosaires.utils.EntityDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;
    private final EntityDtoMapper entityDtoMapper;

    public UsuarioServiceImpl(IUsuarioRepository usuarioRepository, EntityDtoMapper entityDtoMapper) {
        this.usuarioRepository = usuarioRepository;
        this.entityDtoMapper = entityDtoMapper;
    }

    @Override
    public List<UsuarioDto> getUsers() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.stream()
                .map(usuario -> entityDtoMapper.mapEntityToDto(usuario, UsuarioDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDto getUserById(Long id) {
        Optional<Usuario> user = usuarioRepository.findById(id);
        return entityDtoMapper.mapEntityToDto(user, UsuarioDto.class);
    }

    @Override
    public ResponseDto createUser(UsuarioDto usuarioDto) {
        Usuario usuario = entityDtoMapper.mapDtoToEntity(usuarioDto, Usuario.class);
        usuarioRepository.save(usuario);
        return new ResponseDto("User Successfully Created!!!");
    }

    @Override
    public Optional<ResponseEntity<UsuarioDto>> updateUser(Long id, UsuarioDto usuarioDto) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setDni(usuarioDto.getDni());
            usuario.setCuil(usuarioDto.getCuil());
            usuario.setName(usuarioDto.getName());
            usuario.setLastName(usuarioDto.getLastName());
            usuario.setTelephone(usuarioDto.getTelephone());
            usuario.setEmail(usuarioDto.getEmail());
            usuario.setNeighborhood(usuarioDto.getNeighborhood());
            usuario.setProvince(usuarioDto.getProvince());
            usuario.setCountry(usuarioDto.getCountry());

            Usuario updatedUsuario = usuarioRepository.save(usuario);
            UsuarioDto updatedUsuarioDto = entityDtoMapper.mapEntityToDto(updatedUsuario, UsuarioDto.class);
            return new ResponseEntity<>(updatedUsuarioDto, HttpStatus.OK);
        });
    }

    @Override
    public ResponseDto deleteUser(Long id) {
        usuarioRepository.deleteById(id);
        return new ResponseDto("User Successfully Deleted!!!");
    }
}
