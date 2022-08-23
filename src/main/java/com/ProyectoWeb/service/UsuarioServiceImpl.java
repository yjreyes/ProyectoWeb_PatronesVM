package com.ProyectoWeb.service;

import com.ProyectoWeb.dao.UsuarioDao;
import com.ProyectoWeb.domain.Roles;
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
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioDao.findBycorreo(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }

        var roles = new ArrayList<GrantedAuthority>();

        for (Roles rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        return new User(usuario.getCorreo(), usuario.getContraseña(), roles);

    }

}
