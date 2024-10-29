package com.example.Parcial2.Arquitectura.Java.InterfaceService;

import com.example.Parcial2.Arquitectura.Java.Model.Mascotas;
import java.util.List;
import java.util.Optional;

public interface MascotasInterfaceService {
    List<Mascotas> listar();
    void guardar(Mascotas mascota);
    Optional<Mascotas> editar(int id);
    void eliminar (int id);
}
