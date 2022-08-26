package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Item;
import com.ProyectoWeb.domain.Vehiculo;
import com.ProyectoWeb.service.ItemService;
import com.ProyectoWeb.service.TipoService;
import com.ProyectoWeb.service.VehiculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class CarritoController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private VehiculoService vehiculoService;
    @Autowired
    private TipoService tipoService;

    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var items = itemService.getItems();
        var tipos = tipoService.getTipos();
        model.addAttribute("tipos", tipos);
        model.addAttribute("items", items);
        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getPrecio());
        }
        model.addAttribute("carritoTotalVenta", carritoTotalVenta);
        return "carrito/listado";
    }

    @GetMapping("/carrito/agregar/{idVehiculo}")
    public ModelAndView agregarArticulo(Model model, Item item) {
        Item item2 = itemService.getItem(item);
        if (item2 == null) {
            Vehiculo vehiculo = vehiculoService.getVehiculo(item);
            item2 = new Item(vehiculo);
        }
        itemService.save(item2);
        var lista = itemService.getItems();
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            carritoTotalVenta += (i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentosCarrito :: verCarrito");
    }

    @GetMapping("/carrito/eliminar/{idVehiculo}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }

    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        itemService.facturar();
        return "redirect:/mensajes/exitoCompra";
    }

    @GetMapping("/mensajes/exitoCompra")
    public String Compra() {
        return "mensajes/exitoCompra";
    }
    
    
}
