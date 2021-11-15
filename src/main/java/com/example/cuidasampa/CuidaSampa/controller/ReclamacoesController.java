package com.example.cuidasampa.CuidaSampa.controller;

import com.example.cuidasampa.CuidaSampa.beans.Reclamacoes;
import com.example.cuidasampa.CuidaSampa.repositorio.ReclamacoesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    Optional<Reclamacoes> filtrar(@PathVariable Integer id) {
        return repositorio.findById(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/reclamacoes/{id}", method = RequestMethod.POST)
    public void deletar(@PathVariable Integer id) {
        Optional<Reclamacoes> reclamacoes = filtrar(id);
        repositorio.deleteById(id);
    }

    @CrossOrigin
    @Cacheable("reclamacoesUsuario")
    @RequestMapping(value = "/usuarios/{id}/reclamacoes", method = RequestMethod.GET)
    public @ResponseBody
    List<Reclamacoes> getReclamacoesPorUsuario(@PathVariable("id") Integer id){
        System.out.println("Clio");
        return repositorio.getReclamacoesPorUsuario(id);
    }

    @CrossOrigin
    @Cacheable("reclamacoesEmpresa")
    @RequestMapping(value = "/empresas/{id}/reclamacoes", method = RequestMethod.GET)
    public @ResponseBody
    List<Reclamacoes> getReclamacoesPorEmpresa(@PathVariable("id") Integer id){
        System.out.println("Clio");
        return repositorio.getReclamacoesPorUsuario(id);
    }

}
