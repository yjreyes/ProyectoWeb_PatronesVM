package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Vehiculo;
import com.ProyectoWeb.service.TipoService;
import com.ProyectoWeb.service.VehiculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private TipoService tipoService;

    @GetMapping("/vehiculo/listado")
    public String incio(Vehiculo vehiculo, Model model) {
        var vehiculos = vehiculoService.getVehiculos();
        model.addAttribute("vehiculoTotal", vehiculos.size());
        model.addAttribute("vehiculos", vehiculos);
        var tipos = tipoService.getTipos();
        model.addAttribute("tipos", tipos);
        return "vehiculo/listado";
    }

    @PostMapping("/vehiculo/guardar")
    public String guardarVehiculo(Vehiculo vehiculo) {
        vehiculoService.save(vehiculo);
        return "redirect:/vehiculo/listado";
    }

    @GetMapping("/vehiculo/modificar/{idVehiculo}")
    public String modificarVehiculo(Vehiculo vehiculo, Model model) {
        vehiculo = vehiculoService.getVehiculo(vehiculo);
        model.addAttribute("vehiculo", vehiculo);
        var tipos = tipoService.getTipos();
        model.addAttribute("tipos", tipos);
        return "vehiculo/modificar";
    }

    @GetMapping("/vehiculo/eliminar/{idVehiculo}")
    public String eliminarVehiculo(Vehiculo vehiculo) {
        vehiculoService.delete(vehiculo);
        return "redirect:/vehiculo/listado";
    }

    @GetMapping("/vehiculo/alquila")
    public String alquila(Vehiculo vehiculo, Model model) {
        var tipos = tipoService.getTipos();
        model.addAttribute("tipos", tipos);
        return "vehiculo/alquila";
    }

    @GetMapping("/vehiculo/detalleArticulo")
    public String detalleArticulo(Vehiculo vehiculo, Model model) {
        var tipos = tipoService.getTipos();
        model.addAttribute("tipos", tipos);
        return "vehiculo/detalleArticulo";
    }

}
