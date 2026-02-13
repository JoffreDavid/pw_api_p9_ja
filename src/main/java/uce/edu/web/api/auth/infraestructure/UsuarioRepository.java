package uce.edu.web.api.auth.infraestructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import uce.edu.web.api.auth.domain.Usuario;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>{

     public Usuario buscarUsuario(String usuario) {
        // "usuario" se refiere al nombre del atributo en tu clase Entity
        return find("usuario", usuario).firstResult();
    }
}