package com.projeto.videoaula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/* Data Access Object - DAO, criação de uma interface que extende da interface JpaRepository
primeiro parametro é a entidade JPA que irá representa a tabela, e o segundo é o tipo da chave primária da tabela */
@RepositoryRestResource(collectionResourceRel = "contatos", path = "contatos")
public interface RepositorioAgenda extends JpaRepository<Pessoa, Long> {
    
}
