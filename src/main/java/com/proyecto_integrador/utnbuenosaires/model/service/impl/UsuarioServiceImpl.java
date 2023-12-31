package com.proyecto_integrador.utnbuenosaires.model.service.impl;

import com.proyecto_integrador.utnbuenosaires.model.dto.ResponseDto;
import com.proyecto_integrador.utnbuenosaires.model.dto.UsuarioDto;
import com.proyecto_integrador.utnbuenosaires.model.entity.Usuario;
import com.proyecto_integrador.utnbuenosaires.model.repository.IUsuarioRepository;
import com.proyecto_integrador.utnbuenosaires.model.service.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public List<UsuarioDto> getUsers() {
        ModelMapper mapper = new ModelMapper();
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDto> usuariosDto = new ArrayList<>();

        usuarios.stream()
                .forEach(u-> usuariosDto.add(mapper.map(u,UsuarioDto.class)));

        return usuariosDto;
    }

    public UsuarioDto getUserById(Integer id) {
        ModelMapper mapper = new ModelMapper();
        Optional<Usuario> user = usuarioRepository.findById(id);
        return mapper.map(user, UsuarioDto.class);
    }




    @Override
    public ResponseDto createUser(UsuarioDto usuarioDto) {
        ModelMapper mapper = new ModelMapper();
        Usuario usuario = mapper.map(usuarioDto,Usuario.class);

        usuarioRepository.save(usuario);

        return new ResponseDto("User Succesfully Created!!!");
    }

    @Override
    public Optional<ResponseEntity<UsuarioDto>> updateUser(Integer id, UsuarioDto usuarioDto) {
        return Optional.empty();
    }

//
//    @Override
//    public Optional<ResponseEntity<UsuarioDto>> updateUser(Integer id, UsuarioDto usuarioDto) {
//        ModelMapper mapper = new ModelMapper();
//        return usuarioRepository.findById(id)
//                .map(u->{
//                    u.setDni(usuarioDto.getDni());
//                    u.setCuil(usuarioDto.getCuil());
//                    u.setName(usuarioDto.getName());
//                    u.setLastName(usuarioDto.getLastName());
//                    u.setTelephone(usuarioDto.getTelephone());
//                    u.setEmail(usuarioDto.getEmail());
//                    u.setNeighborhood(usuarioDto.getNeighborhood());
//                    u.setProvince(usuarioDto.getProvince());
//                    u.setCountry(usuarioDto.getCountry());
//
//                    Usuario updatedUsuario = usuarioRepository.save(u);
//                    UsuarioDto updatedUsuarioDto = mapper.map(updatedUsuario,UsuarioDto.class);
//                    return new ResponseEntity<>(updatedUsuarioDto, HttpStatus.OK);
//                });
//    }


    public ResponseDto deleteUser(Integer id) {
        usuarioRepository.deleteById(id);
        return new ResponseDto("User Succesfully Deleted!!!");
    }
    public UsuarioDto getUserByUsername(String username) {
        ModelMapper mapper = new ModelMapper();
        Optional<Usuario> user = usuarioRepository.findByUsername(username);
        System.out.println(user);
        return mapper.map(user, UsuarioDto.class);

    }
}
