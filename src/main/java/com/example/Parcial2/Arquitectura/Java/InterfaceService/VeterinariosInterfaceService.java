package com.example.Parcial2.Arquitectura.Java.InterfaceService;

import com.example.Parcial2.Arquitectura.Java.Model.Veterinarios;
import java.util.List;
import java.util.Optional;

public interface VeterinariosInterfaceService {
    List<Veterinarios> listar();
    void guardar(Veterinarios veterinario);
    Optional<Veterinarios> editar(int id);
    void eliminar (int id);
}
