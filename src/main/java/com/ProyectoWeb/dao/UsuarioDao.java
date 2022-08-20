package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Usuario;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {
    public Optional<Usuario> findBycorreo(String correo);
}
