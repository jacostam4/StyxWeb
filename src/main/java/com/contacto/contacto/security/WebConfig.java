package com.contacto.contacto.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitir solicitudes CORS desde el cliente
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:54870")  // Cambia esta URL si es necesario
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowedHeaders("*");  // Permite todos los encabezados
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Configura un handler para servir imágenes desde el directorio "Imagenes" en src/main/resources
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/Imagenes/");
    }
}
