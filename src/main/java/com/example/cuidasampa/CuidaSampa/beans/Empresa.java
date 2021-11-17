package com.example.cuidasampa.CuidaSampa.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(scope = Empresa.class ,generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String nome;
    private String cnpj;
    private String email;
    private String site;
    @Column(name = "numero_funcionarios")
    private String numeroFuncionarios;
    private String telefone;
    private String cep;
    private String cidade;
    private String estado;
    private String senha;

    @OneToMany(mappedBy = "empresa")
    private List<Reclamacoes> reclamacoes;

    public Empresa() {
    }

    public Empresa(
            Integer id,
            String nome,
            String cnpj,
            String email,
            String site,
            String numeroFuncionarios,
            String telefone,
            String cep,
            String cidade,
            String estado,
            String senha
    ) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.site = site;
        this.numeroFuncionarios = numeroFuncionarios;
        this.telefone = telefone;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(String numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Reclamacoes> getReclamacoes() {
        return reclamacoes;
    }

    public void setReclamacoes(List<Reclamacoes> reclamacoes) {
        this.reclamacoes = reclamacoes;
    }
}