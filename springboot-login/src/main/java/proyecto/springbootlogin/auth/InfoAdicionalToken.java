package proyecto.springbootlogin.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;
import proyecto.springbootlogin.Service.IUsuarioService;
import proyecto.springbootlogin.entity.Usuario;

import java.util.HashMap;
import java.util.Map;

//17 creacion de esta clase para potenciar al token añadiendo info adicional

//20 Luego solo faltaria registrar este componente en el servidor de autorizacion, vamos a la clase authorizationServerConfig
@Component //decorando con el componente
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private IUsuarioService usuarioService; //19 implementando la clase personalizada para la consulta

    //18
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        Usuario usuario = usuarioService.findByUsername(authentication.getName());
        Map<String ,Object> info = new HashMap<>();
        info.put("info_adicional","Hola que tal!".concat(authentication.getName()));

        info.put("nombre",usuario.getNombre());
        info.put("apellido",usuario.getApellido());
        info.put("email",usuario.getEmail());

        info.put("nombre_usuario",usuario.getId() + " : " + usuario.getUsername());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken; // retormarnos este accestoken con la info adicional que queremos agregar al token
    }
}
