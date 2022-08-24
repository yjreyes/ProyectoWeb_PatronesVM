package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Vehiculo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface VehiculoDao extends CrudRepository<Vehiculo, Long> {

    public List<Vehiculo> findByIdTipo(Long idTipo);

}
