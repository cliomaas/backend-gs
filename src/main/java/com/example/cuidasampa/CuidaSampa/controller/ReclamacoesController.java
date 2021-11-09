package com.example.cuidasampa.CuidaSampa.controller;

import com.example.cuidasampa.CuidaSampa.beans.Reclamacoes;
import com.example.cuidasampa.CuidaSampa.repositorio.ReclamacoesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/api")
public class ReclamacoesController {

    @Autowired
    private ReclamacoesRepositorio repositorio;

    @CrossOrigin
    @RequestMapping(value = "/reclamacoes", method = RequestMethod.GET)
    public @ResponseBody
    List<Reclamacoes> listar() {
        return repositorio.findAll();

    }

    @CrossOrigin
    @RequestMapping(value = "/reclamacoes", method = RequestMethod.POST)
    public @ResponseBody
    Reclamacoes cadastrar(@RequestBody Reclamacoes reclamacoes) {
        return repositorio.save(reclamacoes);
    }


    @CrossOrigin
    @RequestMapping(value = "/reclamacoes", method = RequestMethod.PUT)
    public @ResponseBody
    Reclamacoes alterar(@RequestBody Reclamacoes reclamacoes) {
        return repositorio.save(reclamacoes);
    }

    @CrossOrigin
    @RequestMapping(value = "/reclamacoes/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Reclamacoes filtrar(@PathVariable Integer id) {
        return repositorio.findByCodigo(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/reclamacoes/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void remover(@PathVariable Integer id) {
        Reclamacoes reclamacoes = filtrar(id);
        this.repositorio.delete(reclamacoes);
    }

}