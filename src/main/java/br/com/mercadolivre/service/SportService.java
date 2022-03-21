package br.com.mercadolivre.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.dto.SportDTO;
import br.com.mercadolivre.model.Sport;
import br.com.mercadolivre.repository.SportRepository;

@Service
public class SportService {

	@Autowired
	private SportRepository repository;

	@Autowired
	private ModelMapper mapper;

	public List<Sport> findAll() {
		return repository.findAll();
	}

	public List<Sport> findManyByName(List<String> sportsName) throws Exception {
		ArrayList<Sport> sports = new ArrayList<Sport>();
		for (String sportName : sportsName) {
			sports.add(this.findByName(sportName));
		}
		return sports;
	}

	public Sport register(SportDTO dto) {
		Sport entity = mapper.map(dto, Sport.class);
		return repository.save(entity);
	}

	public Sport findByName(String name) throws Exception {
		Optional<Sport> opt = repository.findByName(name);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new Exception("Esporte não encontrado!");
		}

	}

}
