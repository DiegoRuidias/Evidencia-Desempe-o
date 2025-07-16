package com.ruidias.infraccionService.service.Impl;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruidias.infraccionService.entity.Infraccion;
import com.ruidias.infraccionService.repository.InfraccionRepository;
import com.ruidias.infraccionService.service.InfraccionService;

@AllArgsConstructor
@Service
public class InfraccionServiceImpl implements InfraccionService {
    private final InfraccionRepository infraccionRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Infraccion> getAll(Pageable page) {
        return infraccionRepository.findAll(page).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Infraccion getById(int id) {
        return infraccionRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Infraccion> getByDni(String dni) {
        return infraccionRepository.findAllByDni(dni);
    }

    @Override
    @Transactional
    public Infraccion create(Infraccion infraccion) {
        return infraccionRepository.save(infraccion);
    }

    @Override
    @Transactional
    public Infraccion update(Infraccion infraccion) {
        Infraccion registro = infraccionRepository.findById(infraccion.getId()).orElseThrow();
        registro.setDni(infraccion.getDni());
        registro.setFecha(infraccion.getFecha());
        registro.setTipoInfraccion(infraccion.getTipoInfraccion());
        registro.setUbicacion(infraccion.getUbicacion());
        registro.setDescripcion(infraccion.getDescripcion());
        registro.setMontoMulta(infraccion.getMontoMulta());
        registro.setEstado(infraccion.getEstado());
        infraccionRepository.save(registro);
        return registro;
    }

    @Override
    @Transactional
    public void inactive(int id) {
        Infraccion registro = infraccionRepository.findById(id).orElseThrow();
        registro.setEstado("Anulada");
    }
}
