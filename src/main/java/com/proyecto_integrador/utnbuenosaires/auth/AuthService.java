package com.proyecto_integrador.utnbuenosaires.auth;

import com.proyecto_integrador.utnbuenosaires.jwt.JwtService;
import com.proyecto_integrador.utnbuenosaires.model.entity.Rol;
import com.proyecto_integrador.utnbuenosaires.model.entity.Usuario;
import com.proyecto_integrador.utnbuenosaires.model.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        /**
         * Al realizar el login, autentica que los parametros username y password
         * sean válidos
         */
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username, request.password));
        UserDetails usuario = usuarioRepository.findByUsername(request.username).orElseThrow();
        String token = jwtService.getToken(usuario);
        System.out.println(token);
        return AuthResponse.builder()
                .token(token)
                .build();

    }



    public AuthResponse register(RegisterRequest request) {
        Usuario usuario = Usuario.builder()
                .username(request.getUsername())
                .nombre(request.nombre)
                .apellido(request.apellido)
                .password(passwordEncoder.encode(request.password))
                .email(request.email)
                .direccion(request.direccion)
                .telefono(request.telefono)
                .rol(Rol.USUARIO)
                .build();
        usuarioRepository.save(usuario);

        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }

}
