package br.com.mercadolivre.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.mercadolivre.model.Level;
import lombok.Data;

@Data
public class SportDTO {

	private String name;
	@Enumerated(EnumType.STRING)
	private Level level;
	
}
