package com.example.Parcial2.Arquitectura.Java.Repository;

import com.example.Parcial2.Arquitectura.Java.Model.Propietarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietariosRepository extends JpaRepository<Propietarios, Integer> {
}