package com.ProyectoWeb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "roles_usuarios")
public class Roles_usuarios implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idusuario;
    private int id_rol;

    public Roles_usuarios() {
    }

    public Roles_usuarios(int idusuario, int id_rol) {
        this.idusuario = idusuario;
        this.id_rol = id_rol;
    }
}
