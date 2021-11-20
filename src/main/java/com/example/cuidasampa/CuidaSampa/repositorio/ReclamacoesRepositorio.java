package com.example.cuidasampa.CuidaSampa.repositorio;

import com.example.cuidasampa.CuidaSampa.beans.Reclamacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReclamacoesRepositorio extends JpaRepository<Reclamacoes, Integer> {

    @Query(value = "SELECT * FROM Reclamacoes r WHERE r.usuario_id = ?1", nativeQuery = true)
    List<Reclamacoes> getReclamacoesPorUsuario(Integer id);

    @Query(value = "SELECT * FROM Reclamacoes r WHERE r.cep = ?1", nativeQuery = true)
    List<Reclamacoes> getReclamacoesPorCEP(String cep);


    <ReclamacoesMod extends Reclamacoes>  ReclamacoesMod save(ReclamacoesMod reclamacoes);

}
