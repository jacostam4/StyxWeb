package com.contacto.contacto.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitir solicitudes CORS desde el cliente
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:54173")  // Cambia esta URL si es necesario
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowedHeaders("*");  // Permite todos los encabezados
    }
}
