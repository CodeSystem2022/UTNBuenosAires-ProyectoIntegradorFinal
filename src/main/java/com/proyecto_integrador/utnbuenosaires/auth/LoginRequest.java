package com.proyecto_integrador.utnbuenosaires.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    /**
     * Modelado de estructura para Login
     */
    String username;
    String password;
}
