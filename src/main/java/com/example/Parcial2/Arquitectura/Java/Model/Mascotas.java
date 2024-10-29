package com.example.Parcial2.Arquitectura.Java.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "Mascotas")
public class Mascotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mascota_id;

    private String nombre;
    private String especie;
    private String raza;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_nacimiento;

    // Relación muchos-a-uno con Propietarios
    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietarios propietario;

    // Relación uno-a-muchos con Consultas
    @OneToMany(mappedBy = "mascota")
    private Set<Consultas> consultas;
}

