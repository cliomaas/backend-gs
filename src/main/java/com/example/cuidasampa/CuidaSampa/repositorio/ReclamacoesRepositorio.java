package com.example.cuidasampa.CuidaSampa.repositorio;

import com.example.cuidasampa.CuidaSampa.beans.Reclamacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamacoesRepositorio extends JpaRepository<Reclamacoes, Integer> {

    Reclamacoes findByCodigo (int id);
    <ReclamacoesMod extends Reclamacoes>  ReclamacoesMod save(ReclamacoesMod reclamacoes);

}
