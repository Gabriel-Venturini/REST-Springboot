package br.com.venturini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.venturini.model.Person;

// No Spring Data, um repositório é uma camada de um projeto 
// que interage diretamente com o banco de dados por meio de queries.
// define essa interface como um repository de Person com Id do tipo Long.

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
