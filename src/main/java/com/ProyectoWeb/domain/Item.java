package com.ProyectoWeb.domain;

import lombok.Data;

@Data
public class Item extends Vehiculo{

    public Item() {
    }
    
    public Item(Vehiculo vehiculo) {
        super.setIdVehiculo(vehiculo.getIdVehiculo());
        super.setIdTipo(vehiculo.getIdTipo());
        super.setModelo(vehiculo.getModelo());
        super.setMarca(vehiculo.getMarca());
        super.setAnno(vehiculo.getAnno());
        super.setKilometraje(vehiculo.getKilometraje());
        super.setPrecio(vehiculo.getPrecio());
        super.setRutaImagen(vehiculo.getRutaImagen());
    }
    
}
