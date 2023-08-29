package proyecto.springbootlogin.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
//12 se encarga de dar acceso a los clientes a nuestra app siempre y cuando el token enviaod en las cabeceras sea valido
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    @Override //13 autorizando rutas por el lado de OAUTH
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/home").permitAll()
                .anyRequest().authenticated();

    }
}
