package com.ruidias.infraccionService.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
@Table(name = "infraccion")
public class Infraccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 8, nullable = false)
    @NotBlank
    @Size(min = 8, max = 8)
    private String dni;

    @Column(nullable = false)
    @NotNull
    private LocalDateTime fecha;

    @Column(name = "tipo_infraccion", length = 20, nullable = false)
    @NotBlank
    private String tipoInfraccion;

    @Column(length = 200, nullable = false)
    @NotBlank
    private String ubicacion;

    @Column
    private String descripcion;

    @Column(name = "monto_multa", precision = 8, scale = 2, nullable = false)
    @NotNull
    private BigDecimal montoMulta;

    @Column(length = 20, nullable = false)
    @NotBlank
    private String estado;
}
