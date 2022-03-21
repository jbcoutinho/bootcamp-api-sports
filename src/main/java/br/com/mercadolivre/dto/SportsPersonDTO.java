package br.com.mercadolivre.dto;

import java.util.List;

import lombok.Data;

@Data
public class SportsPersonDTO {
	private Integer age;
	private String name;
	private List<String> sports;
}
