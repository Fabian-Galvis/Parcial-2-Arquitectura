package com.example.Parcial2.Arquitectura.Java.Controller;

import com.example.Parcial2.Arquitectura.Java.InterfaceService.ConsultasInterfaceService;
import com.example.Parcial2.Arquitectura.Java.InterfaceService.MascotasInterfaceService;
import com.example.Parcial2.Arquitectura.Java.InterfaceService.VeterinariosInterfaceService;
import com.example.Parcial2.Arquitectura.Java.Model.Consultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class ConsultasController {

    @Autowired
    private ConsultasInterfaceService service;

    @Autowired
    private VeterinariosInterfaceService serviceVet;

    @Autowired
    private MascotasInterfaceService serviceMac;

    @GetMapping("/listarConsultas")
    public String listarConsultas(Model model) {
        model.addAttribute("titulo", "Spring DB");
        model.addAttribute("cuerpo", "Lista de consultas");
        model.addAttribute("datos", service.listar());
        return "consultasList";
    }

    @GetMapping("/nuevaConsulta")
    public String formAgregarConsultas(Model model) {
        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "CONSULTA NUEVA");
        model.addAttribute("consulta", new Consultas());
        model.addAttribute("veterinarios", serviceVet.listar()); // Lista de veterinarios
        model.addAttribute("mascotas", serviceMac.listar()); // Lista de mascotas
        return "consultasForm";
    }

    @PostMapping("/guardarConsulta")
    public String guardarConsultas(@ModelAttribute Consultas consulta) {
        service.guardar(consulta);
        return "redirect:/listarConsultas";
    }

    @GetMapping("/editarConsulta/{id}")
    public String editarConsultas(@PathVariable("id") int id, Model model) {
        model.addAttribute("consulta", service.editar(id));
        return "consultasForm";
    }

    @GetMapping("/eliminarConsulta/{id}")
    public String eliminarConsultas(@PathVariable("id") int id) {
        service.eliminar(id);
        return "redirect:/listarConsultas";
    }
}
