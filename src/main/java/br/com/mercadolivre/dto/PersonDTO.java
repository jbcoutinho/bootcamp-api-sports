package br.com.mercadolivre.dto;

import java.util.List;

import lombok.Data;

@Data
public class PersonDTO {
	private String age;
	private String name;
	private String surname;
	private List<String> sports;
}
