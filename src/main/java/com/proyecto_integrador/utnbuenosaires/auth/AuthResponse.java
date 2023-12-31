package com.proyecto_integrador.utnbuenosaires.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    /**
     * Para nuestra validación, guardamos el token de la response
     */
    String token;
}
