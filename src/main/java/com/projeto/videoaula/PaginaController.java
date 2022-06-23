package com.projeto.videoaula;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//A anotação RestController omite as anotações Controller e ResponseBody
// ->> Controller representa uma classe com endpoints (URIs)
// ->> ResponseBody resposta ao corpo da aplicação
@RestController
@RequestMapping("/pessoas")
public class PaginaController {
    
    // Acesso direto ao repositório utilizado
    RepositorioAgenda repositorio;

    // Método para retornar todos os contatos
    @GetMapping
    public List<Pessoa> listar_todos(){
        return repositorio.findAll(); // ->> Faz algo semelhante à um SELECT * FROM ---
    }

    @GetMapping(path = {"/{id}"})
    public Pessoa listar_por_id(@PathVariable long id){ // ->>PathVariable vincula o ID que for passado por parametro com o path
        return repositorio.findById(id).get(); // ->> Faz algo semelhante à um SELECT * FROM --- WHERE id = ? E retorna um Optional
    }

    @PostMapping("/pessoa")
    public Pessoa salvar_pessoa(@RequestBody Pessoa pessoa){ // ->> Significa que o parametro passado será vinculado à requisição
        return repositorio.save(pessoa); // ->> Retorna o registro criado pelo usuário
    }

    @DeleteMapping("/pessoa/{id}")
    public ResponseEntity deleteContato(@PathVariable Long id){
        return repositorio.findById(id).map(record -> {
            repositorio.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Pessoa pessoa) {
        return repositorio.findById(id)
        .map( record -> {
               record.setNome(pessoa.getNome());
               Pessoa atualizado = repositorio.save(record);
               return ResponseEntity.ok().body(atualizado);
           }).orElse(ResponseEntity.notFound().build());
}
}
