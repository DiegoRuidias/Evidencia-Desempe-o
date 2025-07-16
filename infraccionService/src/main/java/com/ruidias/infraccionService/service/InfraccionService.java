package com.ruidias.infraccionService.service;

import com.ruidias.infraccionService.entity.Infraccion;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InfraccionService {
    List<Infraccion> getAll(Pageable page);
    Infraccion getById(int id);
    List<Infraccion> getByDni(String dni);
    Infraccion create(Infraccion infraccion);
    Infraccion update(Infraccion infraccion);
    void inactive(int id);
}
