package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Roles_usuarios;
import java.util.List;

public interface Roles_usuariosService {

    public List<Roles_usuarios> getRoles_usuarioss();

    public void save(Roles_usuarios roles_usuario);

    public void delete(Roles_usuarios roles_usuario);

    public Roles_usuarios getRoles_usuarios(Roles_usuarios roles_usuario);

}
