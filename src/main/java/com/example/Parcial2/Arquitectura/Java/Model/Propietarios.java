package com.example.Parcial2.Arquitectura.Java.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "Propietarios")
public class Propietarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propietario_id;

    private String nombre;
    private String direccion;
    private String telefono;

    // Relación uno-a-muchos con Mascotas
    @OneToMany(mappedBy = "propietario")
    private Set<Mascotas> mascotas;
}


