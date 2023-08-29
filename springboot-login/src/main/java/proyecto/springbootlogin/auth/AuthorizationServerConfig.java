package proyecto.springbootlogin.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter { //1 creacion de esta clase

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; //2 inyectar el metodo bean

    @Autowired
    @Qualifier("authenticationManager") //5 por si acaso existen mas clases con este nombre
    private AuthenticationManager authenticationManager; //4 inyectar la el metodo bean


    @Override //11 aca se configura el acceso anuestros endpoints o rutas de acceso
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception { //10 sobrescribir este metodo para que nuestra aplicacion en angular peuda acceder
        clients.inMemory().withClient("angularapp")
                .secret(passwordEncoder.encode("12345"))
                .scopes("read","write") //permisos que tendra el cliente
                .authorizedGrantTypes("password","refresh_token") //como obtendremos el token, utilizamos aca password cuando es con credenciales cuando nuestros usuarios exsiten en nuestro backend, para autenticar requieren username y password
                //de esta manera basicamente tendremos que agregar dos credenciales PRIMERO UNA DE LA APLLICACION DEL CLIENTE ANGULAR 12345 Y ADEMAS DE LAS CREDENCIALES DEL USUARIO VIA LOGIN
        //refresh_token a traves de esto obtendremos un token de acceso renovado de esta forma seguir interactuando con la app sion necesidad de iniciar sesion nuevamente, simplemente obtneemos el nuevo token antes que caduque
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(3600);
    }

    //metodo que se encarga de el proceso de autenticacion y de validar el token
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception { //6 sobrescribir este metodo
        endpoints.authenticationManager(authenticationManager) //7 usar el endpointes con la inyeccion que hacimos arriba
                .accessTokenConverter(accessTokenConverter());//8 registrar el accesetokenConverter, es el encargado de manjear el jwt almancena los datos en el token cualquier informacion extra que querramos agregar los claims
        super.configure(endpoints);
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() { //9 creamos el metodo
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(JwtConfig.LLAVE_SECRETA); //16 agregando firma MAC
        return jwtAccessTokenConverter;
    }
}