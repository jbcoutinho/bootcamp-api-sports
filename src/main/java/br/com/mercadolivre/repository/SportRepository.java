package br.com.mercadolivre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mercadolivre.model.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {

	Optional<Sport> findByName(String name);

}
