package com.example.cuidasampa.CuidaSampa.beans;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reclamacoes")
public class Reclamacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String categoria;
    private LocalDate data;
    private String cep;
    private String obs;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public Reclamacoes() {
    }

    public Reclamacoes(Integer codigo, String categoria, LocalDate data, String cep, String obs, Usuario usuario) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.data = data;
        this.cep = cep;
        this.obs = obs;
        this.usuario = usuario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setId(Integer codigo) {
        this.codigo = codigo;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
