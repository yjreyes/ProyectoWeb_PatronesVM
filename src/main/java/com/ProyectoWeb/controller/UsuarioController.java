package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Usuario;
import com.ProyectoWeb.domain.Vehiculo;
import com.ProyectoWeb.service.TipoService;
import com.ProyectoWeb.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UsuarioController {

    @Autowired
    private TipoService tipoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario/nuevo")
    public String nuevoUsuario(Usuario usuario) {
        return "usuario/modificar";
    }

    @PostMapping("/usuario/guardar")
    public String guardarUsuario(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/login";
    }

    @GetMapping("/usuario/ayuda")
    public String ayudaUsuario(Vehiculo vehiculo, Model model) {
        var tipos = tipoService.getTipos();
        model.addAttribute("tipos", tipos);
        return "usuario/ayuda";
    }
}
