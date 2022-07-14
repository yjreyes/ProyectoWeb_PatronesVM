package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Vehiculo;
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

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/vehiculo/listado")
    public String incio(Model model) {
        var vehiculos = vehiculoService.getVehiculos();
        model.addAttribute("vehiculos", vehiculos);
        return "vehiculo/listado";
    }

    @GetMapping("/vehiculo/nuevo")
    public String nuevoVehiculo(Vehiculo vehiculo) {
        return "vehiculo/modificar";
    }

    @PostMapping("/vehiculo/guardar")
    public String guardarVehiculo(Vehiculo vehiculo) {
        vehiculoService.save(vehiculo);
        return "redirect:/menu";
    }

    @GetMapping("/vehiculo/modificar/{idVehiculo}")
    public String modificarVehiculo(Vehiculo vehiculo, Model model) {
        vehiculo = vehiculoService.getVehiculo(vehiculo);
        model.addAttribute("vehiculo", vehiculo);
        return "vehiculo/modificar";
    }

    @GetMapping("/vehiculo/eliminar/{idVehiculo}")
    public String eliminarVehiculo(Vehiculo vehiculo) {
        vehiculoService.delete(vehiculo);
        return "redirect:/menu";
    }
    @GetMapping("/vehiculo/alquila")
    public String alquila(){
        return "vehiculo/alquila";
    }
    
    @GetMapping("/loginAdmin")
    public String Admin(){
        return "loginAdmin";
    }

}
