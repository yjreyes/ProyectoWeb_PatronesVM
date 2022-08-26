package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Item;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public List<Item> getItems() {
        return listaItems;
    }

    @Override
    public void save(Item item) {
        boolean existe = false;
        for (Item c : listaItems) {
            if (Objects.equals(c.getIdVehiculo(), item.getIdVehiculo())) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            listaItems.add(item);
        }
    }

    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        for (Item c : listaItems) {
            ++posicion;
            if (Objects.equals(c.getIdVehiculo(), item.getIdVehiculo())) {
                existe = true;
                break;
            }
        }
        if (existe) {
            listaItems.remove(posicion);
        }
    }

    @Override
    public Item getItem(Item item) {
        for (Item c : listaItems) {
            if (Objects.equals(c.getIdVehiculo(), item.getIdVehiculo())) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void facturar() {
        for (Item c : listaItems) {

        }
        listaItems.clear();
    }

}
