package com.example.cuidasampa.CuidaSampa.controller;


import com.example.cuidasampa.CuidaSampa.beans.Reclamacoes;
import com.example.cuidasampa.CuidaSampa.beans.Usuario;
import com.example.cuidasampa.CuidaSampa.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio repositorio;

    @CrossOrigin
    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public @ResponseBody
    Usuario cadastrar(@RequestBody Usuario usuario) {
        return repositorio.save(usuario);
    }

    @CrossOrigin
    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public @ResponseBody
    List<Usuario> listar() {
        return repositorio.findAll();
    }

}
