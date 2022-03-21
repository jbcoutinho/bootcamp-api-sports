package br.com.mercadolivre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercadolivre.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	Optional<Person> findByName(String name);

}
