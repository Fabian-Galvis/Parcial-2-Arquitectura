package com.example.Parcial2.Arquitectura.Java.Controller;

import com.example.Parcial2.Arquitectura.Java.InterfaceService.PropietariosInterfaceService;
import com.example.Parcial2.Arquitectura.Java.Model.Propietarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class PropietariosController {
    @Autowired
    private PropietariosInterfaceService service;


    @GetMapping("/listarPropietarios")
    public String listarPropietarios(Model model) {

        model.addAttribute("titulo", "Spring DB");
        model.addAttribute("cuerpo", "Lista de veterinarios");

        model.addAttribute("datos", service.listar());
        return "propietariosList";
    }

    @GetMapping("/nuevoPropietario")
    public String formAgregarPropietarios(Model model) {

        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "PROPIETARIO NUEVO");

        model.addAttribute("propietario", new Propietarios());
        return "propietariosForm";
    }

    @PostMapping("/guardarPropietario")
    public String guardarPropietario(@ModelAttribute Propietarios propietario) {

        service.guardar(propietario);

        return "redirect:/listarPropietarios";
    }


    @GetMapping("/editarPropietario/{id}")
    public String editarPropietario(@PathVariable("id") int id, Model model) {

        model.addAttribute("propietario", service.editar(id));

        return "propietariosForm";

    }

    @GetMapping("/eliminarPropietario/{id}")
    public String eliminarPropietario(@PathVariable("id") int id) {

        service.eliminar(id);

        return "redirect:/listarPropietarios";

    }
}



