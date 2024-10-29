package com.example.Parcial2.Arquitectura.Java.Service;

import com.example.Parcial2.Arquitectura.Java.InterfaceService.MascotasInterfaceService;
import com.example.Parcial2.Arquitectura.Java.Model.Mascotas;
import com.example.Parcial2.Arquitectura.Java.Repository.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MacotasService implements MascotasInterfaceService {

    @Autowired
    private MascotasRepository repositorio;

    @Override
    public List<Mascotas> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Mascotas mascota) {
        repositorio.save(mascota);
    }

    @Override
    public Optional<Mascotas> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }
}


