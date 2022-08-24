package com.ProyectoWeb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idUsuario;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellidos;
    
    @NotEmpty
    private String correo;
    
    private String telefono;

    @NotEmpty
    private String contraseña;
    
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Roles> roles;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String correo, String telefono, String contraseña, List<Roles> roles) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.roles = roles;
    }
}
