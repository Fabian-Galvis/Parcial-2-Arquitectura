package com.example.Parcial2.Arquitectura.Java.Service;

import com.example.Parcial2.Arquitectura.Java.InterfaceService.PropietariosInterfaceService;
import com.example.Parcial2.Arquitectura.Java.Model.Propietarios;
import com.example.Parcial2.Arquitectura.Java.Repository.PropietariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PropietariosService implements PropietariosInterfaceService {

    @Autowired
    private PropietariosRepository repositorio;

    @Override
    public List<Propietarios> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Propietarios propietario) {
        repositorio.save(propietario);
    }

    @Override
    public Optional<Propietarios> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }
}

