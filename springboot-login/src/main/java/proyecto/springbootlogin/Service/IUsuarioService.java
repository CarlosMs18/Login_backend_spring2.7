package proyecto.springbootlogin.Service;

import proyecto.springbootlogin.entity.Usuario;

//Creamos una clase perzonalidada para realizar consultas, puesto que la otra interfaz de usuarioService implmenta el detaulsservice
//para la autenticacion
public interface IUsuarioService {
    public Usuario findByUsername(String username);
}
