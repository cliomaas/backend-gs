package com.example.cuidasampa.CuidaSampa.repositorio;

import com.example.cuidasampa.CuidaSampa.beans.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepositorio extends JpaRepository<Empresa, Integer> {
    <EmpresaMod extends Empresa>  EmpresaMod save(EmpresaMod empresa);
}
