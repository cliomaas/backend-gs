package com.example.cuidasampa.CuidaSampa.controller;

import com.example.cuidasampa.CuidaSampa.beans.Empresa;
import com.example.cuidasampa.CuidaSampa.beans.Usuario;
import com.example.cuidasampa.CuidaSampa.repositorio.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmpresaController {

    @Autowired
    private EmpresaRepositorio repositorio;


    @CrossOrigin
    @RequestMapping(value = "/empresas", method = RequestMethod.POST)
    public @ResponseBody
    Empresa cadastrar(@RequestBody Empresa empresa) {
        return repositorio.save(empresa);
    }

    @CrossOrigin
    @RequestMapping(value = "/empresas", method = RequestMethod.GET)
    public @ResponseBody
    List<Empresa> listar() {
        return repositorio.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/empresas/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Empresa> filtrar(@PathVariable int id){
        return repositorio.findById(id);
    }



}
