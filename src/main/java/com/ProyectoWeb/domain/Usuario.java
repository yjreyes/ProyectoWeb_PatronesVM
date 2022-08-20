package com.ProyectoWeb.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idusuario;
    
    @Column
    private String nombre;
    @Column
    private String apellidos;
    @Column
    private String correo;
    @Column
    private String cedula;
    @Column
    private String telefono;
    @Column
    private String contraseña;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="roles_usuarios",
    joinColumns=@JoinColumn(name="idusuario"),
    inverseJoinColumns=@JoinColumn(name="id_rol"))
    private Set<Roles> roles;
     
    public Usuario() {
    }

    public Usuario(Long idusuario, String nombre, String apellidos, String correo, String cedula, String telefono, String contraseña, Set<Roles> roles) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.cedula = cedula;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.roles = roles;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idusuario == null) ? 0 : idusuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idusuario == null) {
			if (other.idusuario != null)
				return false;
		} else if (!idusuario.equals(other.idusuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + idusuario + ", username=" + correo + ", password=" + contraseña + "]";
	}
 

}
