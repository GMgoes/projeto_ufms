package com.projeto.videoaula;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PaginaController {
    
    RepositorioAgenda repositorio;

    @GetMapping("/pessoa")
    public List<Pessoa> getAllPessoas(){
        return repositorio.findAll();
    }

    @GetMapping("/pessoa/{id}")
    public Pessoa getPessoaById(@PathVariable Long id){
        return repositorio.findById(id).get();
    }

    @PostMapping("/pessoa")
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa){
        return repositorio.save(pessoa);
    }

    @DeleteMapping("/pessoa/{id}")
    public void deleteContato(@PathVariable Long id){
        repositorio.deleteById(id);
    }
}
