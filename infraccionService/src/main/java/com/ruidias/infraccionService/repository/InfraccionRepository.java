package com.ruidias.infraccionService.repository;

import com.ruidias.infraccionService.entity.Infraccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfraccionRepository extends JpaRepository<Infraccion, Integer> {
    List<Infraccion> findAllByDni(String dni);
}
