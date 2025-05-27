package com.devsuperior.dslist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class Webconfig {

    @Value("${cors.origins}")
    private String corsOrigins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*").allowedOrigins(corsOrigins);
            }
        };
    }

}
//Configuração de restrição de acesso apenas por um endereço/url
// onde acesso por outra url ele o cors irá bloquear
//Essa parte e para implantação na nuvem e não foi possivel a realização
//devido o railway não ser mais free onde terá que ter acesso e inclusão de
//cartão de crédito, porém na aula3 ele informou que fica apenas para exemplo futuros
//não precisar realizar!
