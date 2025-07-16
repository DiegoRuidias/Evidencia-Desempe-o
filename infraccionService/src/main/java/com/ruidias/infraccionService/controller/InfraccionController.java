package com.ruidias.infraccionService.controller;

import com.ruidias.infraccionService.entity.Infraccion;
import com.ruidias.infraccionService.service.InfraccionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/infracciones")
public class InfraccionController {
    private final InfraccionService service;

    @GetMapping
    public ResponseEntity<List<Infraccion>> getAll(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
    ) {
        Pageable page = PageRequest.of(pageNumber, pageSize);

        List<Infraccion> registros = service.getAll(page);
        return ResponseEntity.ok(registros);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Infraccion> get(@PathVariable("id") int id) {
        Infraccion producto = service.getById(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    @GetMapping(value = "usuario/{dni}")
    public ResponseEntity<List<Infraccion>> getUser(@PathVariable("dni") String dni) {
        List<Infraccion> infraccion = service.getByDni(dni);
        if (infraccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(infraccion);
    }

    @PostMapping
    public ResponseEntity<Infraccion> create(@RequestBody Infraccion producto){
        Infraccion registro = service.create(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Infraccion> inactive(@PathVariable("id") int id){
        service.inactive(id);
        return ResponseEntity.ok(null);
    }
}
