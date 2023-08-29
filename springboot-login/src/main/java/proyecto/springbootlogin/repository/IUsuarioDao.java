package proyecto.springbootlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import proyecto.springbootlogin.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario,Long> {

    public Usuario findByUsername(String username);

}
