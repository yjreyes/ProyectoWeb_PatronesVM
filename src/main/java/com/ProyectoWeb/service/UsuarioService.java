package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Usuario;
import java.util.List;

public interface UsuarioService {

    public List<Usuario> getUsuarios();

    public void save(Usuario usuario);

    public void delete(Usuario usuario);

    public Usuario getUsuario(Usuario usuario);
}
