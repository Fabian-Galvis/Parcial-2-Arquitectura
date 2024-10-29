package com.example.Parcial2.Arquitectura.Java.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name = "Consultas")
public class Consultas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int consulta_id;

    private String motivo;
    private String diagnostico;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_consulta;

    // Relación muchos-a-uno con Mascotas
    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascotas mascota;

    // Relación muchos-a-uno con Veterinarios
    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinarios veterinario;
}
