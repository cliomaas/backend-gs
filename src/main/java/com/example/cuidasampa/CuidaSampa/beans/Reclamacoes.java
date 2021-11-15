package com.example.cuidasampa.CuidaSampa.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name = "reclamacoes")
public class Reclamacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoria;
    private LocalDate data;
    private String cep;
    private String obs;

    @ManyToOne
    private Usuario usuario;


    public Reclamacoes() {
    }

    public Reclamacoes(Integer id, String categoria, LocalDate data, String cep, String obs) {
        this.id = id;
        this.categoria = categoria;
        this.data = data;
        this.cep = cep;
        this.obs = obs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getUsuario() {
        return usuario.getNome();
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
