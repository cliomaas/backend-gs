package com.example.cuidasampa.CuidaSampa.repositorio;

import com.example.cuidasampa.CuidaSampa.beans.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {


    <UsuarioMod extends Usuario>  UsuarioMod save(UsuarioMod usuario);
}
