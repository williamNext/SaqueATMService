package br.com.compasso.caixa.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.compasso.caixa.controller.dto.SaqueDTO;
import br.com.compasso.caixa.form.SaqueForm;
import br.com.compasso.caixa.modelo.CaixaEletronico;

@Service
public class SaqueCaixaEletronicoService {

	private CaixaEletronico caixaEletronico;
	
	public SaqueCaixaEletronicoService() {
		caixaEletronico = new CaixaEletronico();
	}

	public Optional<SaqueDTO> getMapaDeNotas(SaqueForm saqueForm) {
		Map<String, Integer> notas = caixaEletronico.calculaNotasDoSaque(saqueForm);
		
		SaqueDTO saqueDTO = new SaqueDTO(notas);

		return Optional.ofNullable(saqueDTO);
	}

}
