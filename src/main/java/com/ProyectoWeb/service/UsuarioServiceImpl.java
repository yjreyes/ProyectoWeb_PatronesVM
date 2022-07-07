package com.ProyectoWeb.service;

import com.ProyectoWeb.dao.UsuarioDao;
import com.ProyectoWeb.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> getUsuarios() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    @Transactional
    public Usuario getUsuario(Usuario usuario) {
       return usuarioDao.findById(usuario.getIdusuario()).orElse(null);
    }

}
