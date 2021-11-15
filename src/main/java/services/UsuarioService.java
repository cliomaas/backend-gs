package services;

import com.example.cuidasampa.CuidaSampa.beans.Reclamacoes;
import com.example.cuidasampa.CuidaSampa.beans.Usuario;
import com.example.cuidasampa.CuidaSampa.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepositorio repositorio;

    public List<Usuario> findAll(){
        return (List<Usuario>) repositorio.findAll();
    }

    public Optional<Usuario> findById(Integer id){
        return repositorio.findById(id);
    }


}
