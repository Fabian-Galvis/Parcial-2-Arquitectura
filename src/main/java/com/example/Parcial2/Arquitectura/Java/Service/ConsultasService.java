package com.example.Parcial2.Arquitectura.Java.Service;

import com.example.Parcial2.Arquitectura.Java.InterfaceService.ConsultasInterfaceService;
import com.example.Parcial2.Arquitectura.Java.Model.Consultas;
import com.example.Parcial2.Arquitectura.Java.Repository.ConsultasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultasService implements ConsultasInterfaceService {

    @Autowired
    private ConsultasRepository repositorio;

    @Override
    public List<Consultas> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Consultas consulta) {
        repositorio.save(consulta);
    }

    @Override
    public Optional<Consultas> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }
}

