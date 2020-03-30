package br.com.compasso.caixa.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.compasso.caixa.controller.dto.SaqueDTO;
import br.com.compasso.caixa.form.SaqueForm;
import br.com.compasso.caixa.modelo.CaixaEletronico;

@Service
public class SaqueCaixaEletronicoService {

	public Optional<SaqueDTO> getMapaDeNotas(SaqueForm saqueForm) {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		Map<String, Integer> notas = caixaEletronico.CalculaNotasDoSaque(saqueForm);
		
		SaqueDTO saqueDTO = new SaqueDTO(notas);

		return Optional.ofNullable(saqueDTO);
	}

}
