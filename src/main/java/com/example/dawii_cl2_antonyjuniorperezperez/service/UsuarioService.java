package com.example.dawii_cl2_antonyjuniorperezperez.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.dawii_cl2_antonyjuniorperezperez.model.bd.Rol;
import com.example.dawii_cl2_antonyjuniorperezperez.model.bd.Usuario;
import com.example.dawii_cl2_antonyjuniorperezperez.repository.RolRepository;
import com.example.dawii_cl2_antonyjuniorperezperez.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder =
            new BCryptPasswordEncoder();

    public Usuario buscarUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public Usuario buscarUsuarioPorNombreUsuario(String username){
        return usuarioRepository.findByNomusuario(username);
    }

    public Usuario guardarUsuario(Usuario usuario){
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }

    public Usuario cambiarClave(Usuario usuario, String nuevaClave) {
        usuario.setPassword(bCryptPasswordEncoder.encode(nuevaClave));
        return usuarioRepository.save(usuario);
    }

}
