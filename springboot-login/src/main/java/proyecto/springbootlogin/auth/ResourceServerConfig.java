package proyecto.springbootlogin.auth;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableResourceServer
//12 se encarga de dar acceso a los clientes a nuestra app siempre y cuando el token enviaod en las cabeceras sea valido
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    @Override //13 autorizando rutas por el lado de OAUTH
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/home","/api/uploads/img/**","/images/**").permitAll() //CUALQUIERA PUEDA ACCEDER AUTENTICADO O NO
                //colocamos images, por mas que pueda tener acceso a la ruta, no tiene a esta carpeta que tenemos nuestros archivos, por ese inconvenitnete mejor habilitarlo
                /*

               .antMatchers(HttpMethod.GET,"api/usuarios/{id}").hasAnyRole("USER","ADMIN")//POR DEFECTO ESTE METODO LE COLOCAR EL PREFIJO ROLE_
                .antMatchers(HttpMethod.POST,"api/usuarios/upload").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.POST,"api/usuarios/{id}").hasRole("ADMIN")
                .antMatchers("api/usuarios/**").hasRole("ADMIN")
                 */ //HAREMOS MEDIANTE ANOTACIONES NE CADA CONTROLADOR
                .anyRequest().authenticated() //LAS RUTS QUE NOE STAN DEFINIDAS SERAN TODAS AUTENTICADAS INDEPENDIENTEMENTE DEL ROL
                .and().cors().configurationSource(corsConfigurationSource()); //despeus de añadir el cors configuratio va aesta linea
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){ //paso final, configuracion de cors y aañdimos esto que devuelve en el metodo que se envarga de autorizar las rutas y permisos
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type","Authorization"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",config); //para todas nuestras rutas del backed
        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter(){ //luego de haber hecho el cors configuration lo registramos dentro del stack del conjunto de filtros de spring
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
