package br.com.compasso.caixa.modelo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import br.com.compasso.caixa.form.SaqueForm;

public class CaixaEletronico {

	private Map<String, Integer> notasDoSaque;
	private Notas[] notas;

	public CaixaEletronico() {
		notas=Notas.values();
		notasDoSaque = new LinkedHashMap<String, Integer>();
	}

	public Map<String, Integer> calculaNotasDoSaque(SaqueForm formularioDeSaque) {
		Integer removerFilter = 0, quantidadeDeNotas=0;
		int valorDeSaque = formularioDeSaque.getValorDeSaque().intValue();
		
		for (Notas nota : notas) {
			int valorNota = nota.getValue().intValue();
			while(valorNota<=valorDeSaque){
				quantidadeDeNotas++;
				valorDeSaque-=valorNota;
			}
			notasDoSaque.put(nota.toString(), quantidadeDeNotas);
			quantidadeDeNotas=0;
		}
		notasDoSaque.values().removeIf(removerFilter::equals);

		return notasDoSaque;
	}

}
