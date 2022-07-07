package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

}

