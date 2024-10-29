package com.example.Parcial2.Arquitectura.Java.InterfaceService;

import com.example.Parcial2.Arquitectura.Java.Model.Propietarios;
import java.util.List;
import java.util.Optional;

public interface PropietariosInterfaceService {
    List<Propietarios> listar();
    void guardar(Propietarios propietario);
    Optional<Propietarios> editar(int id);
    void eliminar (int id);
}

