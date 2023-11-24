package com.example.dawii_cl2_antonyjuniorperezperez.controller.backoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dawii_cl2_antonyjuniorperezperez.model.bd.Usuario;
import com.example.dawii_cl2_antonyjuniorperezperez.service.UsuarioService;

@Controller
public class CambioController {
    


    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cambio")
    public String mostrarFormularioCambioClave(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String nombreUsuario = authentication.getName();
        Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(nombreUsuario);

        model.addAttribute("usuario", usuario);

        return "cambiopass";
    }

    @PostMapping("/cambiarclave")
    public String cambiarClave(String nuevaClave) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String nombreUsuario = authentication.getName();
        Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(nombreUsuario);

        usuarioService.cambiarClave(usuario, nuevaClave);

        return "redirect:/auth/login";
    }
}

