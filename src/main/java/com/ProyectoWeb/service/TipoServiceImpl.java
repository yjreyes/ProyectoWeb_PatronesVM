package com.ProyectoWeb.service;

import com.ProyectoWeb.dao.TipoDao;
import com.ProyectoWeb.domain.Tipo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoServiceImpl implements TipoService {

    @Autowired
    private TipoDao tipoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tipo> getTipos() {
        return (List<Tipo>) tipoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Tipo tipo) {
        tipoDao.save(tipo);
    }

    @Override
    @Transactional
    public void delete(Tipo tipo) {
        tipoDao.delete(tipo);
    }

    @Override
    @Transactional(readOnly = true)
    public Tipo getTipo(Tipo tipo) {
        return tipoDao.findById(tipo.getIdTipo()).orElse(null);
    }
    
}
