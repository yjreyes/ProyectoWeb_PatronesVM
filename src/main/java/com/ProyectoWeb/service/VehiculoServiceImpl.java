package com.ProyectoWeb.service;

import com.ProyectoWeb.dao.VehiculoDao;
import com.ProyectoWeb.domain.Vehiculo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoDao vehiculoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> getVehiculos() {
        return (List<Vehiculo>) vehiculoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Vehiculo vehiculo) {
        vehiculoDao.save(vehiculo);
    }

    @Override
    @Transactional
    public void delete(Vehiculo vehiculo) {
        vehiculoDao.delete(vehiculo);
    }

    @Override
    @Transactional
    public Vehiculo getVehiculo(Vehiculo vehiculo) {
        return vehiculoDao.findById(vehiculo.getIdVehiculo()).orElse(null);
    }

    @Override
    public List<Vehiculo> getfindByIdTipo(Long idTipo) {
       return ((List<Vehiculo>) vehiculoDao.findByIdTipo(idTipo));
    }

}
