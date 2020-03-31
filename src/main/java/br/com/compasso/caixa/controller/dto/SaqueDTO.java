package br.com.compasso.caixa.controller.dto;

import java.util.Map;

public class SaqueDTO {

	private Map<String, Integer> notas;
	
	public SaqueDTO() {
		
	}

	public SaqueDTO(Map<String, Integer> notas) {
		if (notas!= null) {
			this.notas = notas;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notas == null) ? 0 : notas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaqueDTO other = (SaqueDTO) obj;
		if (notas == null) {
			if (other.notas != null)
				return false;
		} else if (!notas.equals(other.notas))
			return false;
		return true;
	}

	public Map<String, Integer> getNotas() {
		return notas;
	}

}
