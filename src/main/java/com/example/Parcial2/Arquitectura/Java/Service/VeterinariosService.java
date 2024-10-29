package com.example.Parcial2.Arquitectura.Java.Service;

import com.example.Parcial2.Arquitectura.Java.InterfaceService.VeterinariosInterfaceService;
import com.example.Parcial2.Arquitectura.Java.Model.Veterinarios;
import com.example.Parcial2.Arquitectura.Java.Repository.VeterinariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VeterinariosService implements VeterinariosInterfaceService {

    @Autowired
    private VeterinariosRepository repositorio;

    @Override
    public List<Veterinarios> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Veterinarios veterinario) {
        repositorio.save(veterinario);
    }

    @Override
    public Optional<Veterinarios> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }
}



