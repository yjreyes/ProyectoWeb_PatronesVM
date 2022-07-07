package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Usuario;
import com.ProyectoWeb.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String inicio(Model model) {
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "index";
    }

    @GetMapping("/nuevoUsuario")
    public String nuevoUsuario(Usuario usuario) {
        return "registrarUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/";
    }

}
