package com.example.Parcial2.Arquitectura.Java.Controller;

import com.example.Parcial2.Arquitectura.Java.InterfaceService.MascotasInterfaceService;
import com.example.Parcial2.Arquitectura.Java.InterfaceService.PropietariosInterfaceService;
import com.example.Parcial2.Arquitectura.Java.Model.Mascotas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class MascotasController {

    @Autowired
    private MascotasInterfaceService service;

    @Autowired
    private PropietariosInterfaceService servicePropietarios; // Agregamos el servicio de propietarios

    @GetMapping("/listarMascotas")
    public String listarMascotas(Model model) {
        model.addAttribute("titulo", "Spring DB");
        model.addAttribute("cuerpo", "Lista de Mascotas");
        model.addAttribute("datos", service.listar());
        return "mascotasList";
    }

    @GetMapping("/nuevaMascota")
    public String formAgregarMascotas(Model model) {
        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "MASCOTA NUEVA");
        model.addAttribute("mascota", new Mascotas());

        // Añadimos la lista de propietarios al modelo para que esté disponible en la vista
        model.addAttribute("propietarios", servicePropietarios.listar());

        return "mascotasForm";
    }

    @PostMapping("/guardarMascota")
    public String guardarMascotas(@ModelAttribute Mascotas mascota) {
        service.guardar(mascota);
        return "redirect:/listarMascotas";
    }

    @GetMapping("/editarMascota/{id}")
    public String editarMascotas(@PathVariable("id") int id, Model model) {
        model.addAttribute("mascota", service.editar(id));

        // Añadimos la lista de propietarios en caso de que el usuario desee editar el propietario de la mascota
        model.addAttribute("propietarios", servicePropietarios.listar());

        return "mascotasForm";
    }

    @GetMapping("/eliminarMascota/{id}")
    public String eliminarMascotas(@PathVariable("id") int id) {
        service.eliminar(id);
        return "redirect:/listarMascotas";
    }
}
