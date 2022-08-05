package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Usuario;
import com.ProyectoWeb.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario/nuevo")
    public String nuevoUsuario(Usuario usuario) {
        return "usuario/modificar";
    }

    @GetMapping("/usuario/login")
    public String login() {
        return "usuario/login";
    }

    @PostMapping("/usuario/guardar")
    public String guardarUsuario(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuario/login";
    }
    @GetMapping("/usuario/perfilUsuario")
    public String perfilUsuario() {
        return "usuario/perfilUsuario";
    }
    @GetMapping("/mensajes/exitoCompra")
    public String exitoCompra() {
        return "/mensajes/exitoCompra";
    }
    @GetMapping("/mensajes/exitoAlquila")
    public String exitoAlquila() {
        return "/mensajes/exitoAlquila";
    }

}
