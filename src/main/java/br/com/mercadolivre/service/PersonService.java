package br.com.mercadolivre.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.dto.PersonDTO;
import br.com.mercadolivre.dto.SportsPersonDTO;
import br.com.mercadolivre.model.Person;
import br.com.mercadolivre.model.Sport;
import br.com.mercadolivre.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	@Autowired
	private SportService sportService;

	@Autowired
	private ModelMapper mapper;

	public List<PersonDTO> findAll() {

		List<Person> persons = repository.findAll();

		return persons.stream().map(e -> mapper.map(e, PersonDTO.class)).collect(Collectors.toList());
	}

	public List<SportsPersonDTO> findSportsPersons() {
		ArrayList<SportsPersonDTO> dtos = new ArrayList<>();
		List<Person> p = repository.findAll();
		p.forEach(person -> {
			SportsPersonDTO dto = new SportsPersonDTO();
			dto.setAge(person.getAge());
			dto.setName(person.getName());
			dto.setSports(person.getSports().stream().map(e->e.getName()).collect(Collectors.toList()));
			dtos.add(dto);
		});
		return dtos;
	}

	public Person register(PersonDTO dto) throws Exception {
		Person entity = mapper.map(dto, Person.class);
		List<Sport> sports = sportService.findManyByName(dto.getSports());
		entity.setSports(sports);
		return repository.save(entity);
	}

	public Person findByName(String name) throws Exception {
		Optional<Person> opt = repository.findByName(name);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new Exception("Pessoa não cadastrada!");
		}

	}

}
