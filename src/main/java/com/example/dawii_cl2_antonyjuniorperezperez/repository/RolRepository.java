package com.example.dawii_cl2_antonyjuniorperezperez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.dawii_cl2_antonyjuniorperezperez.model.bd.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,
        Integer> {

    Rol findByNomrol(String nomrol);

}
