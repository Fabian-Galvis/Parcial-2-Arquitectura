package com.example.Parcial2.Arquitectura.Java.InterfaceService;

import com.example.Parcial2.Arquitectura.Java.Model.Consultas;

import java.util.List;
import java.util.Optional;

public interface ConsultasInterfaceService {
    List<Consultas> listar();
    void guardar(Consultas consulta);
    Optional<Consultas> editar(int id);
    void eliminar (int id);
}



