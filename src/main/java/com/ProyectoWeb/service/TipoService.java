package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Tipo;
import java.util.List;

public interface TipoService {

    public List<Tipo> getTipos();

    public void save(Tipo tipo);

    public void delete(Tipo tipo);

    public Tipo getTipo(Tipo tipo);

}
