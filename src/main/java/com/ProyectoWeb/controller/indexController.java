package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Vehiculo;
import com.ProyectoWeb.service.TipoService;
import com.ProyectoWeb.service.VehiculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class indexController {

    @Autowired
    private TipoService tipoService;

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/")
    public String inicio(Vehiculo vehiculo, Model model) {
        var tipos = tipoService.getTipos();
        model.addAttribute("tipos", tipos);
        var vehiculosVenta = vehiculoService.getfindByIdTipo(Long.valueOf(2));
        model.addAttribute("vehiculosVenta", vehiculosVenta);
        var vehiculosRenta = vehiculoService.getfindByIdTipo(Long.valueOf(1));
        model.addAttribute("vehiculosRenta", vehiculosRenta);
        return "index";
    }

    @GetMapping("/login")
    public String Login() {
        return "login";
    }
}
