package com.ProyectoWeb.service;

import com.ProyectoWeb.dao.Roles_usuariosDao;
import com.ProyectoWeb.dao.UsuarioDao;
import com.ProyectoWeb.domain.Roles;
import com.ProyectoWeb.domain.Roles_usuarios;
import com.ProyectoWeb.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private Roles_usuariosDao roles_usuariosDao;
    
    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuario.setContraseña(encoder.encode(usuario.getContraseña()));
        usuarioDao.save(usuario);
        Roles_usuarios roles = new Roles_usuarios();
        int i = 0;
        roles.setIdusuario(i = Math.toIntExact(usuario.getIdusuario()));
        roles.setId_rol(2);
        roles_usuariosDao.save(roles);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdusuario()).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findBycorreo(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
        List roles = new ArrayList();
        for (Roles rol : usuario.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rol.getNombre());
            roles.add(grantedAuthority);
        }
        UserDetails userDet = new User(usuario.getCorreo(), usuario.getContraseña(), roles);
        return userDet;
    }

}
