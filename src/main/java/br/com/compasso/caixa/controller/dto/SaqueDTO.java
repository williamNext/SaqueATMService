package br.com.compasso.caixa.controller.dto;

import java.util.Map;

public class SaqueDTO {

	private Map<String, Integer> notas;
	
	

	public SaqueDTO() {
		
	}

	public SaqueDTO(Map<String, Integer> notas) {
		this.notas = notas;
	}

	public Map<String, Integer> getNotas() {
		return notas;
	}

}
