package com.example.dawii_cl2_antonyjuniorperezperez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.dawii_cl2_antonyjuniorperezperez.model.bd.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,
        Integer> {

    Usuario findByEmail(String email);

    Usuario findByNomusuario(String nomusuario);

}
