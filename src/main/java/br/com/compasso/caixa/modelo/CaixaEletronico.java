package br.com.compasso.caixa.modelo;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.compasso.caixa.form.SaqueForm;

public class CaixaEletronico {

	private List<Integer> listaDeNotas;
	private Map<String, Integer> notasDoSaque;
	private String[] nomeNotas;

	public CaixaEletronico() {
		nomeNotas = new String[] { "CEM", "CINQUENTA", "VINTE", "DEZ" };

		listaDeNotas = Arrays.asList(100, 50, 20, 10);

		notasDoSaque = new LinkedHashMap<String, Integer>();
	}

	public Map<String, Integer> CalculaNotasDoSaque(SaqueForm formularioDeSaque) {
		Integer removerFilter = 0, indexCounter = 0, quantidadeDaNota = 0;

		Integer valorDoSaque = formularioDeSaque.getValorDeSaque().intValue();

		do {
			if (valorDoSaque >= listaDeNotas.get(indexCounter)) {
				valorDoSaque -= listaDeNotas.get(indexCounter);
				quantidadeDaNota++;
			} else {
				notasDoSaque.put(nomeNotas[indexCounter], quantidadeDaNota);
				indexCounter++;
				quantidadeDaNota = 0;
			}
		} while (indexCounter < 4);

		notasDoSaque.values().removeIf(removerFilter::equals);

		return notasDoSaque;
	}

}
