package com.proyecto_integrador.utnbuenosaires.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;


/**
 * Configurando conectividad, al tener en dos lugares distintos tanto front como el back,
 * se realiza tratamiento de CORS
 */

@Configuration
@EnableWebMvc
public class WebConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
      
        // Permitir la solicitud, no importa desde donde
        config.setAllowCredentials(false);
        config.addAllowedOriginPattern("*");

        // Algunos encabezados que puede recibir la api
        config.setAllowedHeaders(Arrays.asList(
                HttpHeaders.AUTHORIZATION,
                HttpHeaders.CONTENT_TYPE,
                HttpHeaders.ACCEPT
        ));
        // Metodos que puede recibir la api
        config.setAllowedMethods(Arrays.asList(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.DELETE.name()
        ));
        // Tiempo de vida, 30 min
        config.setMaxAge(3600L);

        // Aplica la configuracion a todas las rutas
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        // Para que se ejecute antes q cualquier bean
        bean.setOrder(-102);
        return bean;
    }

}
