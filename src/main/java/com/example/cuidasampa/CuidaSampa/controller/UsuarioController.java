package com.example.cuidasampa.CuidaSampa.controller;


import com.example.cuidasampa.CuidaSampa.beans.Reclamacoes;
import com.example.cuidasampa.CuidaSampa.beans.Usuario;
import com.example.cuidasampa.CuidaSampa.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio repositorio;

    @CrossOrigin
    @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public @ResponseBody
    Usuario cadastrar(@RequestBody Usuario usuario) {
        return repositorio.save(usuario);
    }

    @CrossOrigin
    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public @ResponseBody
    List<Usuario> listar() {
        return repositorio.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Usuario> filtrar(@PathVariable int id){
        return repositorio.findById(id);
    }

}
