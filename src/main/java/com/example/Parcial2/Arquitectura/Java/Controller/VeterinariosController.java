package com.example.Parcial2.Arquitectura.Java.Controller;

import com.example.Parcial2.Arquitectura.Java.InterfaceService.VeterinariosInterfaceService;
import com.example.Parcial2.Arquitectura.Java.Model.Veterinarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class VeterinariosController {
    @Autowired
    private VeterinariosInterfaceService service;


    @GetMapping("/listarVeterinarios")
    public String listarVeterinarios(Model model) {

        model.addAttribute("titulo", "Spring DB");
        model.addAttribute("cuerpo", "Lista de Veterinarios");

        model.addAttribute("datos", service.listar());
        return "veterinariosList";
    }

    @GetMapping("/nuevoVeterinario")
    public String formAgregarVeterinarios(Model model) {

        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "VETERINARIO NUEVO");

        model.addAttribute("veterinario", new Veterinarios());
        return "veterinariosForm";
    }

    @PostMapping("/guardarVeterinario")
    public String guardarVeterinarios (@ModelAttribute Veterinarios veterinario) {

        service.guardar(veterinario);

        return "redirect:/listarVeterinarios";
    }


    @GetMapping("/editarVeterinario/{id}")
    public String editarVeterinarios(@PathVariable("id") int id, Model model) {

        model.addAttribute("veterinario", service.editar(id));

        return "veterinariosForm";

    }

    @GetMapping("/eliminarVeterinario/{id}")
    public String eliminarVeterinarios(@PathVariable("id") int id) {

        service.eliminar(id);

        return "redirect:/listarVeterinarios";

    }
}



