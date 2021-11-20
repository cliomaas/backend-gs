package com.example.cuidasampa.CuidaSampa.controller;

import com.example.cuidasampa.CuidaSampa.beans.Reclamacoes;
import com.example.cuidasampa.CuidaSampa.repositorio.ReclamacoesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
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


    @PutMapping(value="/reclamacao-{id}")
    public ResponseEntity update(@PathVariable("id") int id,
                                 @RequestBody Reclamacoes reclamReq) {
        return repositorio.findById(id)
                .map(record -> {
                    record.setCategoria(reclamReq.getCategoria());
                    record.setObs(reclamReq.getObs());
                    record.setCep(reclamReq.getCep());
                    Reclamacoes reclNova = repositorio.save(record);
                    return ResponseEntity.ok().body(reclNova);
                }).orElse(ResponseEntity.notFound().build());
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
//        Optional<Reclamacoes> reclamacoes = filtrar(id);
        repositorio.deleteById(id);
    }


    @CrossOrigin
    @RequestMapping(value = "/{cep}/reclamacoes", method = RequestMethod.GET)
    public @ResponseBody
    List<Reclamacoes> getReclamacoesPorCEP(@PathVariable("cep") String cep){
        return repositorio.getReclamacoesPorCEP(cep);
    }

    @CrossOrigin
    @RequestMapping(value= "/reclamacoes", method= RequestMethod.PUT)
    public @ResponseBody
    Reclamacoes alterar(@RequestBody Reclamacoes reclamacoes)
    { return repositorio.save(reclamacoes);}


    @RequestMapping(value = "/status-reclamacao-{id}", method = RequestMethod.GET)
    @Cacheable("status")
    public String status(@PathVariable Integer id) {
        Optional<Reclamacoes> reclamacoes = filtrar(id);
        System.out.println("Clio Maas");
        return "Reclamação número" +  " " + reclamacoes.get().getId() + ": Em andamento";
    }

    @RequestMapping( value = "/cancel")
    @CacheEvict(value= "status", allEntries = true)
    public String cancel() {
        System.out.println("Limpando o cache.");
        return "Cache cancelado";
    }



}
