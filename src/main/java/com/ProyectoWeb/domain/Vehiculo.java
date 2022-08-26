package com.ProyectoWeb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehiculo;
    private Long idTipo;
    private String modelo;
    private String marca;
    private int anno;
    private int kilometraje;
    private double precio;
    @Column(name="ruta_imagen")
    private String rutaImagen;

    public Vehiculo() {
    }

    public Vehiculo(String modelo, String marca, int anno, int kilometraje, double precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.anno = anno;
        this.kilometraje = kilometraje;
        this.precio = precio;
    }
}
