package com.example.Parcial2.Arquitectura.Java.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "Veterinarios")
public class Veterinarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int veterinario_id;

    private String nombre;
    private String especialidad;
    private String telefono;

    // Relación uno-a-muchos con Consultas
    @OneToMany(mappedBy = "veterinario")
    private Set<Consultas> consultas;
}
