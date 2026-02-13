package uce.edu.web.api.auth.application;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.web.api.auth.domain.Usuario;
import uce.edu.web.api.auth.infraestructure.UsuarioRepository;
import uce.edu.web.api.auth.representation.UsuarioRepresentation;

@ApplicationScoped
public class UsuarioService {
    
     @Inject
    private UsuarioRepository usuarioRepository;

    public String validarUsuario(String usuario, String password){
        Usuario user = this.usuarioRepository.buscarUsuario(usuario);
        if(user == null || !user.getPassword().equals(password)){
            return null;
        }
        return user.getRole();
    }

    public List<UsuarioRepresentation> listarTodos(){
        List<UsuarioRepresentation> list = new ArrayList();
        for(Usuario us : this.usuarioRepository.listAll()){
            list.add(this.mapperToUR(us));
        }
        return list;
    }


    public UsuarioRepresentation buscarPorId(Integer id){
        return mapperToUR(this.usuarioRepository.findById(id.longValue()));
    }

    @Transactional
    public void crear(UsuarioRepresentation us){
        this.usuarioRepository.persist(this.mapperToU(us));
    }

    @Transactional
    public void actualizar(Integer id, UsuarioRepresentation us){
        Usuario usuario = this.usuarioRepository.findById(id.longValue());

        usuario.setPassword(us.getPassword());
        usuario.setUsuario(us.getPassword());
        usuario.setRole(us.getRole());
    }

    @Transactional
    public void actualizarParcial(Integer id, UsuarioRepresentation us){
        Usuario usuario = this.usuarioRepository.findById(id.longValue());

        if(us.getPassword() != null){
            usuario.setPassword(us.getPassword());
        }
        if(us.getRole() != null){
            usuario.setRole(us.getRole());
        }
        if(us.getUsuario() != null){
            usuario.setUsuario(us.getUsuario());
        }
    }

    @Transactional
    public void eliminar(Integer id){
        this.usuarioRepository.deleteById(id.longValue());
    }


    public UsuarioRepresentation mapperToUR(Usuario us){
        UsuarioRepresentation usuarioR = new UsuarioRepresentation();
        usuarioR.setPassword(us.getPassword());
        usuarioR.setRole(us.getRole());
        usuarioR.setUsuario(us.getUsuario());

        return usuarioR;
    }

    public Usuario mapperToU(UsuarioRepresentation usr){
        Usuario usuario = new Usuario();

        usuario.setPassword(usr.getPassword());
        usuario.setRole(usr.getRole());
        usuario.setUsuario(usr.getUsuario());

        return usuario;
    }
}
